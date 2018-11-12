package sc.dinero.webfunds.talisman.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.databinding.PropertyChangeRegistry
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaLocation
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.ChamaSector
import sc.dinero.webfunds.talisman.model.repository.GroupRepository
import sc.dinero.webfunds.talisman.model.repository.GroupRepositoryImpl


/**
 * Created by Ruslan Ivakhnenko on 17.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
open class GroupViewModel(application: Application) : AndroidViewModel(application) {

    private var repository : GroupRepository = GroupRepositoryImpl(getApplication())

    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    fun createGroup(group: ChamaGroup, memberId : Long) : Flowable<Long> {
        return repository.createGroup(group, memberId)
    }

    fun getGroupsAll() : LiveData<List<ChamaGroup>>{
        return repository.getGroupsAll()
    }

    fun getSectors(): LiveData<List<ChamaSector>> {
        return repository.getSectorAll()
    }

    fun getLocations(): LiveData<List<ChamaLocation>> {
        return repository.getLocationAll()
    }

    fun addMemberToGroup(group: ChamaGroup, member : ChamaMember) : Flowable<Long>{
        return repository.addMemberToGroup(group, member)
    }

    fun editMemberToGroup(member: ChamaMember) = repository.editMember(member)

    fun getMembersOfGroup(groupId : Int) : LiveData<List<ChamaMember>> {
        return repository.getMembersOfGroup(groupId)
    }


}