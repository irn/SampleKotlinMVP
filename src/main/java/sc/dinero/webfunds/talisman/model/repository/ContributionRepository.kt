package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import sc.dinero.webfunds.talisman.model.ChamaContribution
import sc.dinero.webfunds.talisman.model.ChamaContributionWithRelations


/**
 * Created by Ruslan Ivakhnenko on 23.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface ContributionRepository {

    fun createContribution(contribution : ChamaContribution) : Flowable<Long>

    fun getContributionsByGroupId(groupId : Int) : LiveData<List<ChamaContributionWithRelations>>
}