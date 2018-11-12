package sc.dinero.webfunds.talisman.fragments

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_groups.*
import kotlinx.android.synthetic.main.fragment_groups.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.activities.GroupDetailActivity
import sc.dinero.webfunds.talisman.activities.ManageGroupActivity
import sc.dinero.webfunds.talisman.adapters.GroupsAdapter
import sc.dinero.webfunds.talisman.listeners.GroupClickListener
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.utils.ChamaConst

/**
 * A simple [Fragment] subclass for managing Chamapesa groups.
 *
 */
class GroupsFragment : BaseTabFragment(), GroupClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_groups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().getGroupByMember(getHomeActivity().getCurrentMember().memberId!!).observe(this, Observer<List<ChamaGroup>> {
            val adapter = GroupsAdapter(it!!, GroupsFragment@this)
            recycleViewGroups.adapter = adapter
        })

        actionAddGroup.setOnClickListener {
            val intent = Intent(it.context, ManageGroupActivity::class.java)
            intent.putExtra(ChamaConst.ARG_MEMBER, getHomeActivity().getCurrentMember())
            startActivity(intent)
        }
    }

    override fun onItemClick(group: ChamaGroup) {
        val intent = Intent(GroupsFragment@this.context, GroupDetailActivity::class.java)
        intent.putExtra(ChamaConst.ARG_GROUP, group)
        startActivity(intent)
    }
}
