package sc.dinero.webfunds.talisman.activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_group_detail.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.ActivityGroupDetailBinding
import sc.dinero.webfunds.talisman.fragments.GroupMembersFragment
import sc.dinero.webfunds.talisman.fragments.GroupPlansFragment
import sc.dinero.webfunds.talisman.listeners.GroupInterceptListener
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.utils.ChamaConst
import sc.dinero.webfunds.talisman.viewmodel.GroupViewModel

class GroupDetailActivity : AppCompatActivity(), GroupInterceptListener {

    private lateinit var selectedGroup : ChamaGroup

    private lateinit var mBinding : ActivityGroupDetailBinding

    private lateinit var viewModel : GroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        selectedGroup = intent.getParcelableExtra(ChamaConst.ARG_GROUP)
        viewModel = ViewModelProviders.of(this).get(GroupViewModel::class.java)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_group_detail)
        mBinding.setLifecycleOwner(this)
        mBinding.viewModel = viewModel
        mBinding.tabLayoutGroup.setupWithViewPager(mBinding.viewPagerGroup)
        viewPagerGroup.adapter = object:FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int) = arrayOf(GroupMembersFragment(), GroupPlansFragment())[position]

            override fun getPageTitle(position: Int) = arrayOf("Members", "Chama Plans")[position]

            override fun getCount()  = 2
        }
    }

    override fun getGroup() = selectedGroup
}
