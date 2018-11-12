package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import sc.dinero.webfunds.talisman.model.ChamaRole


/**
 * Created by Ruslan Ivakhnenko on 03.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface RoleRepository {

    fun getAllRoles() : LiveData<List<ChamaRole>>
}