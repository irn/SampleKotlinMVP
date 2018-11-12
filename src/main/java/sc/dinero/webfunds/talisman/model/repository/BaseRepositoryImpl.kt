package sc.dinero.webfunds.talisman.model.repository

import android.content.Context
import sc.dinero.webfunds.talisman.model.dao.ChamapesaDao
import sc.dinero.webfunds.talisman.model.dao.ChamapesaPlanDao
import sc.dinero.webfunds.talisman.model.dao.ChamapesaRoleDao
import sc.dinero.webfunds.talisman.model.database.GroupDataBase
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService


/**
 * Created by Ruslan Ivakhnenko on 17.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */

open class BaseRepositoryImpl(context: Context) {

    private val dataBase: GroupDataBase

    private val executor : ScheduledExecutorService

    init {
        this.dataBase = GroupDataBase.getInstance(context)!!
        executor = Executors.newSingleThreadScheduledExecutor()
    }

    protected fun getExecutor(): ScheduledExecutorService = executor

    protected fun getDao(): ChamapesaDao = dataBase.getGroupDao()

    protected fun getPlanDao() : ChamapesaPlanDao = dataBase.getPlanDao()

    protected fun getRoleDao() : ChamapesaRoleDao = dataBase.getRoleDao()

    protected fun getContributionDao() = dataBase.getContributionDao()
}