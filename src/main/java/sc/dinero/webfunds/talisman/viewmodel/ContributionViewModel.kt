package sc.dinero.webfunds.talisman.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import sc.dinero.webfunds.talisman.model.*
import sc.dinero.webfunds.talisman.model.repository.ContributionRepository
import sc.dinero.webfunds.talisman.model.repository.ContributionRepositoryImpl
import sc.dinero.webfunds.talisman.model.repository.GroupRepository
import sc.dinero.webfunds.talisman.model.repository.GroupRepositoryImpl


/**
 * Created by Ruslan Ivakhnenko on 07.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class ContributionViewModel(application : Application) : GroupViewModel(application) {

    private val groupRepository : GroupRepository = GroupRepositoryImpl(application)

    private val contributionRepository : ContributionRepository = ContributionRepositoryImpl(application)

    lateinit var currentPlan : ChamaPlan


    fun getContributionsByGroupId(groupId : Int) : LiveData<List<ChamaContributionWithRelations>> = contributionRepository.getContributionsByGroupId(groupId)

    fun createContribution(contribution : ChamaContribution) = contributionRepository.createContribution(contribution)
}