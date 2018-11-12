package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by Ruslan Ivakhnenko on 03.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Entity(tableName = "ChamaRole")
@Parcelize
data class ChamaRole(
        @PrimaryKey
        @ColumnInfo(name = "role_id") var roleId : Int,
        @ColumnInfo(name = "name") var name : String
) : Parcelable {
    constructor() : this(0, "")

    companion object {
        var ROLE_GROUP_MANAGER = 1
        var ROLE_GROUP_MEMBER = 2
        var ROLE_MARKET_MAKER = 3
        var ROLE_SERVICE_PROVIDER = 4
        var ROLE_DEVELOPER = 5
    }

    override fun toString(): String {
        return name
    }
}