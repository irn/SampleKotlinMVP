package sc.dinero.webfunds.talisman.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.FragmentGroupPlansBinding
import sc.dinero.webfunds.talisman.activities.NewPlanActivity
import sc.dinero.webfunds.talisman.adapters.PlanAdapter
import sc.dinero.webfunds.talisman.utils.ChamaConst
import sc.dinero.webfunds.talisman.viewmodel.PlanViewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class GroupPlansFragment : BaseGroupDetailFragment() {

    private lateinit var mBinding: FragmentGroupPlansBinding

    private lateinit var planViewModel : PlanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        planViewModel = ViewModelProviders.of(this).get(PlanViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_group_plans, container, false)
        mBinding.setLifecycleOwner(this)
        mBinding.viewModel = getViewModel()
        mBinding.currentGroup = getDetailActivity().getGroup()
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.actionAddPlan.setOnClickListener {
            val intent = Intent(it.context, NewPlanActivity::class.java)
            intent.putExtra(ChamaConst.ARG_GROUP, getDetailActivity().getGroup())
            startActivity(intent)
        }

        planViewModel.getPlanByGroupId(getDetailActivity().getGroup().groupId!!).observe(this, Observer {
            mBinding.recycleViewGroupPlans.adapter = PlanAdapter(it)
        })

    }
}
