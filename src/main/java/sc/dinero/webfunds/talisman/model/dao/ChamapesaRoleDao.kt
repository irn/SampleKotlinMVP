package sc.dinero.webfunds.talisman.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import sc.dinero.webfunds.talisman.model.ChamaRole


/**
 * Created by Ruslan Ivakhnenko on 03.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Dao
interface ChamapesaRoleDao {

    @Query("select * from ChamaRole")
    fun getAllRoles() : LiveData<List<ChamaRole>>
}