package sc.dinero.webfunds.talisman.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_transactions.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.fragments.transactions.TransactionInFragment
import sc.dinero.webfunds.talisman.fragments.transactions.TransactionOutFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class TransactionsFragment : BaseContributionFragment() {

    companion object {
        const val SELECTED_MEMBERS_REQUEST_CODE = 1000
        const val CHECKED_MEMBERS = "ARG_MEMBERS_CHECKED"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardViewTransactionIn.setOnClickListener { getActivityInterceptor().showFragment(TransactionInFragment(), true) }

        cardViewTransactionOut.setOnClickListener { getActivityInterceptor().showFragment(TransactionOutFragment(), true) }
    }
}
