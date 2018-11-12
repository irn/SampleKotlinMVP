package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import io.reactivex.*
import io.reactivex.schedulers.Schedulers
import sc.dinero.webfunds.talisman.model.*

class GroupRepositoryImpl(context: Context): BaseRepositoryImpl(context), GroupRepository {


    override fun createGroup(group: ChamaGroup, memberId : Long) : Flowable<Long> {
        return Flowable.fromCallable { getDao().createGroup(group) }.
                subscribeOn(Schedulers.io()).
                flatMap {
                    val groupMember = GroupMember(null, memberId, it.toInt(), false, null)
                    getDao().createMemberOfGroup(groupMember)
                    Flowable.just(it)
                }
    }

    override fun getGroupsAll(): LiveData<List<ChamaGroup>> {
        return getDao().getGroupsAll()
    }

    override fun getGroupByMember(memberId: Long): LiveData<List<ChamaGroup>> {
        return getDao().getGroupByMemberId(memberId)
    }

    override fun getLocationAll(): LiveData<List<ChamaLocation>> {
        return getDao().getLocationAll()
    }

    override fun getSectorAll(): LiveData<List<ChamaSector>> {
        return getDao().getSectorAll()
    }

    override fun addMemberToGroup(group: ChamaGroup, member: ChamaMember): Flowable<Long> {
        return Flowable.fromCallable { getDao().createMember(member) }.
                subscribeOn(Schedulers.io()).
                flatMap{
                    val groupMember =  GroupMember(null, it, group.groupId, false, null)
                    Flowable.fromCallable {  getDao().createMemberOfGroup(groupMember)}
                }
    }

    override fun editMember(member: ChamaMember): Flowable<Int> {
        return Flowable.fromCallable { getDao().updateMember(member)}.
                subscribeOn(Schedulers.io())
    }

    override fun getMembersOfGroup(groupId: Int): LiveData<List<ChamaMember>> {
        return getDao().getMembersByGroupId(groupId)
    }
}