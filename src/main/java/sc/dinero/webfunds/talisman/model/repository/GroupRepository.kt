package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaLocation
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.ChamaSector

interface GroupRepository {

    fun createGroup(group: ChamaGroup, memberId : Long) : Flowable<Long>

    fun getGroupsAll() : LiveData<List<ChamaGroup>>

    fun getGroupByMember(memberId : Long) : LiveData<List<ChamaGroup>>

    fun getLocationAll() : LiveData<List<ChamaLocation>>

    fun getSectorAll() : LiveData<List<ChamaSector>>

    fun addMemberToGroup(group : ChamaGroup, member : ChamaMember) : Flowable<Long>

    fun editMember(member : ChamaMember) : Flowable<Int>

    fun getMembersOfGroup(groupId : Int) : LiveData<List<ChamaMember>>
}