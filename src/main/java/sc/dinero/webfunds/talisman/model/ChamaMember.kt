package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.*
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "ChamaMember",
        indices = [Index(value = ["mobile_phone"], unique = true)],
        foreignKeys = arrayOf(ForeignKey(entity = ChamaRole::class, parentColumns = arrayOf("role_id"), childColumns = arrayOf("role_id"))))
@Parcelize
data class ChamaMember(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "member_id") var memberId : Long?,
        @ColumnInfo(name = "nym_id") var nymId : String,
        @ColumnInfo(name = "role_id") var roleId : Int,
        @ColumnInfo(name = "full_name") var fullName : String,
        @ColumnInfo(name = "mobile_phone") var mobilePhone : String,
        @ColumnInfo(name = "password") var password : String?
        ) : Parcelable {
        constructor(): this(null, "", ChamaRole.ROLE_GROUP_MEMBER, "", "", "")

        constructor (fullName: String, mobilePhone: String, password: String?, roleId : Int) : this(null, "", roleId, fullName, mobilePhone, password)


}
