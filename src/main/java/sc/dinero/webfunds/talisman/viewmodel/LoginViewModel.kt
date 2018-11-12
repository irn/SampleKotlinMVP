package sc.dinero.webfunds.talisman.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.repository.GroupRepository
import sc.dinero.webfunds.talisman.model.repository.GroupRepositoryImpl
import sc.dinero.webfunds.talisman.model.repository.MemberRepository
import sc.dinero.webfunds.talisman.model.repository.MemberRepositoryImpl

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: MemberRepository = MemberRepositoryImpl(getApplication())

    fun createMember(member: ChamaMember) : Flowable<Long> {
        return repository.createMember(member)
    }

    fun getMember(phone: String, password: String) : LiveData<List<ChamaMember>> {
        return repository.findMember(phone, password)
    }

    fun getMembers(): LiveData<List<ChamaMember>> {
        return repository.getMembersAll()
    }
}