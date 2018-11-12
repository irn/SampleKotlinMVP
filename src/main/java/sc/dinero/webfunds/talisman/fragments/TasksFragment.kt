package sc.dinero.webfunds.talisman.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_tasks.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.adapters.BaseRecycleViewAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class TasksFragment : BaseContributionFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleViewTasks.adapter = BaseRecycleViewAdapter(listOf("123", "123", "124", "56856"), 0, R.layout.item_tasks)
    }
}
