package sc.dinero.webfunds.talisman.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import sc.dinero.webfunds.talisman.model.*

@Dao
interface ChamapesaDao {

    // These functions are for getting member(s)

    /**
     * Get all existing members
     */
    @Query("select * from ChamaMember")
    fun getMembersAll(): LiveData<List<ChamaMember>>

    /**
     * Get members which are belong to some group
     */
    @Query("select * from ChamaMember member inner join GroupMember gm on member.member_id = gm.member_id where gm.group_id = :groupId")
    fun getMembersByGroupId(groupId : Int) : LiveData<List<ChamaMember>>


    /**
     * Find one member by mobile phone and password
     */
    @Query("select * from ChamaMember where mobile_phone like :phone and password like :password limit 1")
    fun findMember(phone: String, password: String): LiveData<List<ChamaMember>>

    /**
     * Find one member by mobile phone
     */
    @Query("select * from ChamaMember where mobile_phone like :phone")
    fun findMemberByPhone(phone: String) : LiveData<List<ChamaMember>>

    // These functions are for getting group(s)


    @Query("select * from ChamaGroup")
    fun getGroupsAll() : LiveData<List<ChamaGroup>>

    @Query("select * from ChamaGroup grp inner join groupmember gm on gm.group_id = grp.group_id where gm.member_id = :memberId")
    fun getGroupByMemberId(memberId : Long) : LiveData<List<ChamaGroup>>

    @Query("select * from ChamaLocation")
    fun getLocationAll() : LiveData<List<ChamaLocation>>

    @Query("select * from ChamaSector")
    fun getSectorAll() : LiveData<List<ChamaSector>>

    @Insert
    fun createMember(member: ChamaMember) : Long

    @Insert
    fun createMemberOfGroup(memberGroup : GroupMember) : Long

    @Update
    fun updateMember(vararg member: ChamaMember) : Int


    @Insert
    fun createGroup(group: ChamaGroup) : Long


    @Insert
    fun createSector(sectorList : List<ChamaSector>)

    @Insert
    fun createLocation(locationList : List<ChamaLocation>)

}