package sc.dinero.webfunds.talisman.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import sc.dinero.webfunds.talisman.model.*
import sc.dinero.webfunds.talisman.model.repository.*


/**
 * Created by Ruslan Ivakhnenko on 22.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private var groupRepository : GroupRepository = GroupRepositoryImpl(getApplication())

    private var memberRepository : MemberRepository = MemberRepositoryImpl(getApplication())

    private var roleRepository : RoleRepository = RoleRepositoryImpl(getApplication())

    private var planRepository : PlanRepository = PlanRepositoryImpl(getApplication())

    private var contributionRepository : ContributionRepository = ContributionRepositoryImpl(getApplication())

    private var currentMember : LiveData<List<ChamaMember>> = MutableLiveData()

    var selectedGroup : ChamaGroup? = null
        set(value) {
            field = value
            isConnectEnabled.postValue(value != null && selectedRole != null && selectedCategory != null)
        }

    var selectedRole : ChamaRole? = null
        set(value) {
            field = value
            isConnectEnabled.postValue(value != null && selectedCategory != null && selectedGroup != null)
        }

    var selectedCategory : ChamaCategory? = null
        set(value) {
            field = value
            isConnectEnabled.postValue(value != null && selectedRole != null && selectedGroup != null)
        }


    val isConnectEnabled : MutableLiveData<Boolean> = MutableLiveData()


    fun setMobilePhone(mobilePhone: String) {
        currentMember = memberRepository.findMemberByPhone(mobilePhone)
    }

    fun getGroupsAll() : LiveData<List<ChamaGroup>>{
        return groupRepository.getGroupsAll()
    }

    fun getGroupByMember(memberId : Long) : LiveData<List<ChamaGroup>>{
        return groupRepository.getGroupByMember(memberId)
    }

    fun getMember() = currentMember

    fun getRoles() : LiveData<List<ChamaRole>> {
        return roleRepository.getAllRoles()
    }

    fun getCategoties() : LiveData<List<ChamaCategory>> = planRepository.getAllCategories()

    fun getContributionByGroupId(groupId : Int) = contributionRepository.getContributionsByGroupId(groupId)

}