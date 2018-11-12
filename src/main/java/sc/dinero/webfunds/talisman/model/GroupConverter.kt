package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.TypeConverter
import java.util.*

class GroupConverter {

    @TypeConverter
    fun fromTimestamp(value : Long?) : Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun toTimestamp(value : Date?) : Long? {
        return value?.time
    }

    @TypeConverter
    fun fromIntToBoolean(value : Int?) : Boolean? {
        return value == 1
    }

    @TypeConverter
    fun toIntFromBoolean(value : Boolean?) : Int? {
        return if (value == true) 1 else 0
    }
}