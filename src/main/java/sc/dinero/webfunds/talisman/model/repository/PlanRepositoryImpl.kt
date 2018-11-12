package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaCategory
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.model.ChamaPlanWithCategory


/**
 * Created by Ruslan Ivakhnenko on 29.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class PlanRepositoryImpl(context : Context) : BaseRepositoryImpl(context), PlanRepository {

    override fun createPlan(plan: ChamaPlan): Flowable<Long> {
        return Flowable.fromCallable { getPlanDao().createPlan(plan) }
    }

    override fun getPlansByGroupId(groupId: Int): LiveData<List<ChamaPlanWithCategory>> {
        return getPlanDao().getPlanByGroupId(groupId)
    }

    override fun getAllCategories(): LiveData<List<ChamaCategory>> {
        return getPlanDao().getAllCategories()
    }

}