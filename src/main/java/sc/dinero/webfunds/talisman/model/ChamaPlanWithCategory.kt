package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Relation


/**
 * Created by Ruslan Ivakhnenko on 31.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class ChamaPlanWithCategory(
        @ColumnInfo(name = "pid") var planId : Int?,
        @ColumnInfo(name = "cid") var categoryId : Int,
        @ColumnInfo(name = "name") var name : String,
        @Relation(parentColumn = "cid", entityColumn = "cid") var category : List<ChamaCategory>?
) {
    constructor() : this(null, 0,"", null)
}