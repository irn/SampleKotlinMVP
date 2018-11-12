package sc.dinero.webfunds.talisman.fragments.quorum


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_quorum_pending.*
import sc.dinero.webfunds.talisman.BR

import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.adapters.BaseRecycleViewAdapter
import sc.dinero.webfunds.talisman.fragments.BaseContributionFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class QuorumPendingFragment : BaseContributionFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_quorum_pending, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleViewPendingQuorum.adapter = BaseRecycleViewAdapter(listOf("123", "124"), BR.quorumPendingItem, R.layout.item_quorum) {
            getActivityInterceptor().showFragment(QuorumDetailFragment(), true)
        }
    }
}
