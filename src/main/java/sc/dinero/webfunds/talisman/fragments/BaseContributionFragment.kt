package sc.dinero.webfunds.talisman.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import sc.dinero.webfunds.talisman.listeners.FragmentInterceptor
import sc.dinero.webfunds.talisman.viewmodel.ContributionViewModel


/**
 * Created by Ruslan Ivakhnenko on 07.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
open class BaseContributionFragment : BaseHomeFragment() {

    protected lateinit var viewModel : ContributionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(ContributionViewModel::class.java)
    }

    fun getGroup() = viewModel.currentPlan.group

    fun getRole() = viewModel.currentPlan.role

    fun getCategory() = viewModel.currentPlan.category

    fun getActivityInterceptor() = activity as FragmentInterceptor


}