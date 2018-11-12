package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.*
import java.sql.Date

@Entity(tableName = "GroupMember",
        foreignKeys = arrayOf(
                ForeignKey(entity = ChamaMember::class, parentColumns = arrayOf("member_id"), childColumns = arrayOf("member_id")),
                ForeignKey(entity = ChamaGroup::class, parentColumns = arrayOf("group_id"), childColumns = arrayOf("group_id"))
        ))
@TypeConverters(GroupConverter::class)
data class GroupMember(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "gm_id") var groupMemberId: Int?,
        @ColumnInfo(name = "member_id") var member: Long?,
        @ColumnInfo(name = "group_id") var group: Int?,
        @ColumnInfo(name = "is_accepted") var isAccepted: Boolean?,
        @ColumnInfo(name = "date_accepted") var dateAccepted: Date?
){
        constructor():this(null, null,null, null, null)
}