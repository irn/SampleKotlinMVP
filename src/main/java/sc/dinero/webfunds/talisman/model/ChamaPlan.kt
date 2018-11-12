package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.*
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by Ruslan Ivakhnenko on 29.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Entity(tableName = "ChamaPlan",
        foreignKeys = arrayOf(
                ForeignKey(entity = ChamaGroup::class, parentColumns = arrayOf("group_id"), childColumns = arrayOf("group_id"))
        ))
@Parcelize
data class ChamaPlan (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "pid") var planId : Int?,
        @ColumnInfo(name = "name") var name : String,
        @ColumnInfo(name = "cid") var categoryId : Int,
        @ColumnInfo(name = "group_id") var groupId: Int,
        @ColumnInfo(name = "amount") var amountPerMember : Double,

        @Ignore
        var group : ChamaGroup? = null,

        @Ignore
        var role : ChamaRole? = null,

        @Ignore
        var category : ChamaCategory? = null
) : Parcelable {
        constructor() : this (null, "", 0, 0, 0.0)

        override fun toString() = name
}