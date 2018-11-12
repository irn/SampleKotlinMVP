package sc.dinero.webfunds.talisman.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_quorum.*

import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.fragments.quorum.QuorumPendingFragment
import sc.dinero.webfunds.talisman.fragments.quorum.QuorumValidatedFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class QuorumFragment : BaseContributionFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_quorum, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayoutQuorum.setupWithViewPager(viewPagerQuorum)
        viewPagerQuorum.adapter = object:FragmentPagerAdapter(fragmentManager) {

            override fun getCount() = 2

            override fun getItem(position: Int) = arrayOf(QuorumPendingFragment(), QuorumValidatedFragment())[position]

            override fun getPageTitle(position: Int) = arrayOf("Pending", "Validated")[position]
        }
    }
}
