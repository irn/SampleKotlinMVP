package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Ruslan Ivakhnenko on 23.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Entity(tableName = "ChamaContribution",
        foreignKeys = [
            ForeignKey(entity = ChamaGroup::class, parentColumns = arrayOf("group_id"), childColumns = arrayOf("group_id")),
            ForeignKey(entity = ChamaCategory::class, parentColumns = arrayOf("cid"), childColumns = arrayOf("category_id")),
            ForeignKey(entity = ChamaMember::class, parentColumns = arrayOf("member_id"), childColumns = arrayOf("validated_by"))
        ]
        )
@TypeConverters(GroupConverter::class)
data class ChamaContribution(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "contribution_id") var contributionId : Int?,
        @ColumnInfo(name = "direction") var direction : Boolean,
        @ColumnInfo(name = "group_id") var groupId : Int,
        @ColumnInfo(name = "category_id") var categoryId : Int,
        @ColumnInfo(name = "date") var date : Date,
        @ColumnInfo(name = "amount") var amount : Int,
        @ColumnInfo(name = "description") var description : String?,
        @ColumnInfo(name = "validated_by") var validated : Long,
        @ColumnInfo(name = "is_approved") var isApproved : Boolean,
        @ColumnInfo(name = "is_incoming") var isIncoming : Boolean,
        @Ignore var members : List<ChamaMember>? = null

) {
    constructor() : this(null, false, 0, 0, Date(0), 0, null, 0, false, false)

    fun getDateString() : String {
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm")
        return simpleDateFormat.format(date.time)
    }
}