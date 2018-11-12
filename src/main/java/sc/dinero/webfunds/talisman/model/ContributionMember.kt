package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Ruslan Ivakhnenko on 23.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Entity(tableName = "ContributionMember",
        foreignKeys = [
            ForeignKey(entity = ChamaContribution::class, parentColumns = ["contribution_id"], childColumns = ["contribution_id"]),
            ForeignKey(entity = ChamaMember::class, parentColumns = ["member_id"], childColumns = ["member_id"])
        ])
data class ContributionMember(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "cm_id") var id : Int? = null,
        @ColumnInfo(name = "contribution_id") var contributionId : Int,
        @ColumnInfo(name = "member_id") var memberId : Long
) {
    constructor() : this(null, 0, 0)
}