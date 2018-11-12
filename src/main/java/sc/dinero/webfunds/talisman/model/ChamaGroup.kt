package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.*
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "ChamaGroup",
        foreignKeys = arrayOf(
                ForeignKey(entity = ChamaLocation::class, parentColumns = arrayOf("lid"), childColumns = arrayOf("location_id")),
                ForeignKey(entity = ChamaSector::class, parentColumns = arrayOf("sid"), childColumns = arrayOf("sector_id"))
        ),
        indices = [Index(value = arrayOf("name"), unique = true)])
@Parcelize
data class ChamaGroup(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "group_id") var groupId: Int?,
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "location_id") var location: Int?,
        @ColumnInfo(name = "sector_id") var sector: Int?,
        @ColumnInfo(name = "description") var description: String
) : Parcelable {
        constructor() : this(null,"", null, null, "")

        override fun toString(): String {
                return name
        }
}