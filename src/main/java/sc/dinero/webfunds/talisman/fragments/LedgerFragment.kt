package sc.dinero.webfunds.talisman.fragments


import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ledger.*
import sc.dinero.webfunds.talisman.BR

import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.FragmentLedgerBinding
import sc.dinero.webfunds.talisman.adapters.BaseRecycleViewAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class LedgerFragment : BaseContributionFragment() {

    lateinit var mBinding : FragmentLedgerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_ledger, container, false)
        mBinding.setLifecycleOwner(this)
        mBinding.viewModel = viewModel
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getContributionsByGroupId(getGroup()?.groupId!!).observe(this, Observer {
            val inContribution = it?.filter { contribution -> contribution.contribution?.isIncoming!! }?.toList()
            val outContribution = it?.filter { contribution -> contribution.contribution?.isIncoming?.not()!! }?.toList()
            mBinding.contribution = it
            mBinding.contributed = it?.sumBy { c -> c.contribution?.amount ?: 0}
            if (it != null) {
                recycleViewLedgerContributions.adapter = BaseRecycleViewAdapter(it, BR.itemContribution, R.layout.item_ledger)
            }
        })

        viewModel.getMembersOfGroup(getGroup()?.groupId!!).observe(this, Observer {
            mBinding.members = it
        })
    }
}
