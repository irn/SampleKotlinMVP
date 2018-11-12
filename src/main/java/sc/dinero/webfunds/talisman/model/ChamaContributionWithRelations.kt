package sc.dinero.webfunds.talisman.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation


/**
 * Created by Ruslan Ivakhnenko on 24.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class ChamaContributionWithRelations(
        @Embedded
        var contribution : ChamaContribution?,

        @Relation(parentColumn = "category_id", entityColumn = "cid")
        var category : List<ChamaCategory>? = null,

        @Relation(parentColumn = "group_id", entityColumn = "group_id")
        var group : List<ChamaGroup>? = null,

        @Relation(parentColumn = "validated_by", entityColumn = "member_id")
        var member : List<ChamaMember>? = null
) {
    constructor() : this(null, null, null, null)

}