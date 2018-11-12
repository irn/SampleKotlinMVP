package sc.dinero.webfunds.talisman.fragments


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.FragmentPalaverBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class PalaverFragment : BaseContributionFragment() {

    private lateinit var mBinding : FragmentPalaverBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_palaver, container, false)
        mBinding.viewModel = viewModel
        mBinding.setLifecycleOwner(this)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.cardViewContributions.setOnClickListener {
            getActivityInterceptor().showFragment(ContributionsFragment(), true)
        }

        mBinding.cardViewTasks.setOnClickListener {
            getActivityInterceptor().showFragment(TasksFragment(), true)
        }
    }
}
