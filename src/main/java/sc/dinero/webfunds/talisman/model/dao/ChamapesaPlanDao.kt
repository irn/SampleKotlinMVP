package sc.dinero.webfunds.talisman.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import sc.dinero.webfunds.talisman.model.ChamaCategory
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.model.ChamaPlanWithCategory


/**
 * Created by Ruslan Ivakhnenko on 29.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Dao
interface ChamapesaPlanDao {


    @Query("select * from ChamaCategory")
    fun getAllCategories() : LiveData<List<ChamaCategory>>

    @Query("select * from ChamaPlan where group_id = :groupId")
    fun getPlanByGroupId(groupId : Int) : LiveData<List<ChamaPlanWithCategory>>

    @Insert
    fun createPlan(plan : ChamaPlan) : Long
}