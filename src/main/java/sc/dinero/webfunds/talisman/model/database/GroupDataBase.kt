package sc.dinero.webfunds.talisman.model.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import sc.dinero.webfunds.talisman.model.*
import sc.dinero.webfunds.talisman.model.dao.ChamapesaDao
import sc.dinero.webfunds.talisman.model.dao.ChamapesaPlanDao
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.model.dao.ChamapesaContributionDao
import sc.dinero.webfunds.talisman.model.dao.ChamapesaRoleDao

@Database(entities =
arrayOf(ChamaMember::class, ChamaGroup::class, ChamaLocation::class, ChamaSector::class,
        GroupMember::class, ChamaCategory::class, ChamaPlan::class, ChamaRole::class,
        ChamaContribution::class, ContributionMember::class), version = 1)
internal abstract class GroupDataBase :RoomDatabase() {

    abstract fun getGroupDao() : ChamapesaDao

    abstract fun getPlanDao() : ChamapesaPlanDao

    abstract fun getRoleDao() : ChamapesaRoleDao

    abstract fun getContributionDao() : ChamapesaContributionDao

    companion object {
        private var INSTANCE : GroupDataBase? = null

        fun getInstance(context: Context): GroupDataBase? {
            if (INSTANCE == null){
                synchronized(GroupDataBase::class){
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            GroupDataBase::class.java,
                            "groups.db").addCallback(object: Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            val values = ContentValues()
                            values.put("name", "Marry-Go-Round")
                            db.insert("ChamaCategory", SQLiteDatabase.CONFLICT_NONE, values)

                            values.clear()
                            values.put("name", "Savings")
                            db.insert("ChamaCategory", SQLiteDatabase.CONFLICT_NONE, values)

                            values.clear()
                            values.put("name", "Investments")
                            db.insert("ChamaCategory", SQLiteDatabase.CONFLICT_NONE, values)
                            for (i in 0..10){
                                val values = ContentValues()
                                values.put("name", "Location ${i+1}")
                                db.insert("ChamaLocation", SQLiteDatabase.CONFLICT_NONE, values)

                                values.clear()
                                values.put("name", "Sector ${i+1}")
                                db.insert("ChamaSector", SQLiteDatabase.CONFLICT_NONE, values)
                            }
                            values.clear()
                            values.put("role_id", ChamaRole.ROLE_GROUP_MANAGER)
                            values.put("name", "Group Manager")
                            db.insert("ChamaRole", SQLiteDatabase.CONFLICT_NONE, values)
                            values.put("role_id", ChamaRole.ROLE_GROUP_MEMBER)
                            values.put("name", "Group Member")
                            db.insert("ChamaRole", SQLiteDatabase.CONFLICT_NONE, values)
                            values.put("role_id", ChamaRole.ROLE_MARKET_MAKER)
                            values.put("name", "Market Maker")
                            db.insert("ChamaRole", SQLiteDatabase.CONFLICT_NONE, values)
                            values.put("role_id", ChamaRole.ROLE_SERVICE_PROVIDER)
                            values.put("name", "Service Provider")
                            db.insert("ChamaRole", SQLiteDatabase.CONFLICT_NONE, values)
                            values.put("role_id", ChamaRole.ROLE_DEVELOPER)
                            values.put("name", "Developer")
                            db.insert("ChamaRole", SQLiteDatabase.CONFLICT_NONE, values)

                        }
                    })
                                .build()
                }
            }
            return INSTANCE
        }
    }
}