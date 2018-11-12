package sc.dinero.webfunds.talisman.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaCategory
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.model.ChamaPlanWithCategory
import sc.dinero.webfunds.talisman.model.repository.PlanRepository
import sc.dinero.webfunds.talisman.model.repository.PlanRepositoryImpl


/**
 * Created by Ruslan Ivakhnenko on 29.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class PlanViewModel(application : Application) : AndroidViewModel(application) {

    private var repository : PlanRepository = PlanRepositoryImpl(application)

    fun getAllCategories() : LiveData<List<ChamaCategory>> {
        return repository.getAllCategories()
    }

    fun createPlan(plan : ChamaPlan) : Flowable<Long> {
        return repository.createPlan(plan)
    }

    fun getPlanByGroupId(groupId : Int) : LiveData<List<ChamaPlanWithCategory>>{
        return repository.getPlansByGroupId(groupId)
    }
}