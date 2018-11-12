package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by Ruslan Ivakhnenko on 29.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Entity(tableName = "ChamaCategory")
@Parcelize
data class ChamaCategory(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "cid") var categoryId : Int?,
        @ColumnInfo(name = "name") var name : String
) : Parcelable {
        constructor() : this(null, "")

        override fun toString(): String {
                return name
        }
}