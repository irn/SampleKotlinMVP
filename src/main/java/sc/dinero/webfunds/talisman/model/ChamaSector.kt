package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "ChamaSector")
data class ChamaSector(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "sid") var sectorId: Int?,
        @ColumnInfo(name = "name") var name: String
){
        constructor(): this(null, "")
}