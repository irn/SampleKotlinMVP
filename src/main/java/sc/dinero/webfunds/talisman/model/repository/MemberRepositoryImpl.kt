package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.database.GroupDataBase
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService


/**
 * Created by Ruslan Ivakhnenko on 17.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class MemberRepositoryImpl(context: Context): BaseRepositoryImpl(context), MemberRepository {



    override fun createMember(member: ChamaMember) : Flowable<Long> {
        return Flowable.fromCallable { getDao().createMember(member) }
    }

    override fun getMembersAll(): LiveData<List<ChamaMember>> {
        return getDao().getMembersAll()

    }

    override fun findMember(phone: String, password: String): LiveData<List<ChamaMember>> {
        return getDao().findMember(phone, password)
    }

    override fun findMemberByPhone(phone: String): LiveData<List<ChamaMember>> {
        return getDao().findMemberByPhone(phone)
    }
}