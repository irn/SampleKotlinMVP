package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaCategory
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.model.ChamaPlanWithCategory


/**
 * Created by Ruslan Ivakhnenko on 29.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface PlanRepository {

    fun getAllCategories() : LiveData<List<ChamaCategory>>

    fun createPlan(plan : ChamaPlan) : Flowable<Long>

    fun getPlansByGroupId(groupId : Int) : LiveData<List<ChamaPlanWithCategory>>
}