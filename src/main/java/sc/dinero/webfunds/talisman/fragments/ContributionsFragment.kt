package sc.dinero.webfunds.talisman.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contributors.*
import sc.dinero.webfunds.talisman.BR
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.adapters.BaseRecycleViewAdapter

/**
 * A simple [Fragment] subclass.
 */
class ContributionsFragment : BaseContributionFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity)?.supportActionBar?.title = "Contributors"
        return inflater.inflate(R.layout.fragment_contributors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getContributionsByGroupId(viewModel.currentPlan.group?.groupId!!).observe(this, Observer {
            if (it?.size?.compareTo(0) == 1) {
                recycleViewContributions.adapter = BaseRecycleViewAdapter(it, BR.itemContribution, R.layout.item_contributions)
                textViewEmptyContributions.visibility = View.GONE
                recycleViewContributions.visibility = View.VISIBLE
            } else{
                textViewEmptyContributions.visibility = View.VISIBLE
                recycleViewContributions.visibility = View.GONE
            }
        })

    }
}
