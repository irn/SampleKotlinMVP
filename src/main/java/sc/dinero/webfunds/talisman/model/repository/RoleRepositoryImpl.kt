package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import sc.dinero.webfunds.talisman.model.ChamaRole


/**
 * Created by Ruslan Ivakhnenko on 03.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class RoleRepositoryImpl(context : Context) : BaseRepositoryImpl(context), RoleRepository {

    override fun getAllRoles(): LiveData<List<ChamaRole>> {
        return getRoleDao().getAllRoles()
    }
}