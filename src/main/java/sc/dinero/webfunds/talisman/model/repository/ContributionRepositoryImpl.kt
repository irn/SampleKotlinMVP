package sc.dinero.webfunds.talisman.model.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import sc.dinero.webfunds.talisman.model.ChamaContribution
import sc.dinero.webfunds.talisman.model.ChamaContributionWithRelations
import sc.dinero.webfunds.talisman.model.ContributionMember


/**
 * Created by Ruslan Ivakhnenko on 23.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class ContributionRepositoryImpl(context : Context) : BaseRepositoryImpl(context), ContributionRepository {
    override fun createContribution(contribution: ChamaContribution): Flowable<Long> {
        return Flowable.fromCallable { getContributionDao().createContribution(contribution) }.
                subscribeOn(Schedulers.io()).
                flatMap {
                    contribution.members?.forEach { member ->
                        val cm = ContributionMember(contributionId = it.toInt(), memberId = member.memberId!!)
                        getContributionDao().createContributionMember(cm)
                    }
                    Flowable.just(it)
                     }
    }

    override fun getContributionsByGroupId(groupId: Int): LiveData<List<ChamaContributionWithRelations>> {
        return getContributionDao().getContributionsByGroupId(groupId)
    }
}