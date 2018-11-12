package sc.dinero.webfunds.talisman.fragments


import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_group_members.*
import sc.dinero.webfunds.talisman.BR
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.FragmentGroupMembersBinding
import sc.dinero.webfunds.talisman.activities.EditMemberActivity
import sc.dinero.webfunds.talisman.activities.NewMemberActivity
import sc.dinero.webfunds.talisman.adapters.BaseRecycleViewAdapter
import sc.dinero.webfunds.talisman.adapters.GroupsAdapter
import sc.dinero.webfunds.talisman.adapters.MembersAdapter
import sc.dinero.webfunds.talisman.utils.ChamaConst

/**
 * A simple [Fragment] subclass.
 *
 */
class GroupMembersFragment : BaseGroupDetailFragment() {

    private lateinit var mBinding : FragmentGroupMembersBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_group_members, container, false)
        mBinding.setLifecycleOwner(this)
        mBinding.viewModel = getViewModel()
        mBinding.currentGroup = getDetailActivity().getGroup()
        mBinding.membersCount = 0
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().getMembersOfGroup(getDetailActivity().getGroup().groupId!!).observe(this, Observer {
            mBinding.membersCount = it?.size
            if (it != null) {
                recycleViewGroupMembers.adapter = BaseRecycleViewAdapter(it!!, BR.memberItem, R.layout.simple_member_cardview_item) {
                    val intent = Intent (context, EditMemberActivity::class.java)
                    intent.putExtra(ChamaConst.ARG_MEMBER, it)
                    startActivity(intent)
                }
            }
        })

        actionAddMember.setOnClickListener {
            val intent = Intent(it.context, NewMemberActivity::class.java)
            intent.putExtra(ChamaConst.ARG_GROUP, getDetailActivity().getGroup())
            startActivity(intent)
        }
    }
}
