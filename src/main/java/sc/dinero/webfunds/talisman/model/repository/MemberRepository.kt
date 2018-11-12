package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaMember


/**
 * Created by Ruslan Ivakhnenko on 17.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface MemberRepository {

    fun getMembersAll() : LiveData<List<ChamaMember>>

    fun findMember(phone: String, password: String): LiveData<List<ChamaMember>>

    fun findMemberByPhone(phone: String): LiveData<List<ChamaMember>>

    fun createMember(member: ChamaMember) : Flowable<Long>
}