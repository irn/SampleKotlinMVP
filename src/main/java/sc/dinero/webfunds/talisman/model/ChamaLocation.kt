package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "ChamaLocation")
data class ChamaLocation(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "lid") var locationId: Int?,
        @ColumnInfo(name = "name") var name: String
){
        constructor():this(null, "")
}