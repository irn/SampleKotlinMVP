package sc.dinero.webfunds.talisman.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaContribution
import sc.dinero.webfunds.talisman.model.ChamaContributionWithRelations
import sc.dinero.webfunds.talisman.model.ContributionMember


/**
 * Created by Ruslan Ivakhnenko on 23.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
@Dao
interface ChamapesaContributionDao {

    @Query("select * from ChamaContribution where group_id = :groupId")
    fun getContributionsByGroupId(groupId : Int) : LiveData<List<ChamaContributionWithRelations>>

    @Insert
    fun createContribution(contribution: ChamaContribution) : Long

    @Insert
    fun createContributionMember(member : ContributionMember) : Long
}