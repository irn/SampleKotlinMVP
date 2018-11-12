package sc.dinero.webfunds.talisman.fragments


import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.ListPopupWindow
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_home.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.FragmentHomeBinding
import sc.dinero.webfunds.talisman.activities.ContributionsActivity
import sc.dinero.webfunds.talisman.listeners.OnChamaItemSelected
import sc.dinero.webfunds.talisman.model.*
import sc.dinero.webfunds.talisman.utils.ChamaConst

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseTabFragment() {

    private lateinit var mBinding : FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        mBinding.setLifecycleOwner(this)
        getViewModel().setMobilePhone(getHomeActivity().getMobilePhone())
        mBinding.viewModel = getViewModel()

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardViewGroup.setOnClickListener { view ->
            getViewModel().getGroupsAll().observe(this, Observer { setupWindowPopup(view, textViewGroup, it!!, object : OnChamaItemSelected {
                override fun itemSelected(item: Any) {
                    getViewModel().selectedGroup = item as ChamaGroup
                }

            }) })

        }

        cardViewRole.setOnClickListener {
            getViewModel().getRoles().observe(this, Observer {
                setupWindowPopup(cardViewRole, textViewRole, it!!, object : OnChamaItemSelected {
                    override fun itemSelected(item: Any) {
                        getViewModel().selectedRole = item as ChamaRole
                    }

                })
            })

        }

        cardViewCategory.setOnClickListener {
            getViewModel().getCategoties().observe(this, Observer {
                setupWindowPopup(cardViewCategory, textViewPlan, it!!, object : OnChamaItemSelected {
                    override fun itemSelected(item: Any) {
                        getViewModel().selectedCategory = item as ChamaCategory
                    }
                })
            })

        }

        actionButtonConnect.setOnClickListener {
            val intent = Intent(it.context, ContributionsActivity::class.java)
            val plan = ChamaPlan()
            plan.group = getViewModel().selectedGroup
            plan.role = getViewModel().selectedRole
            plan.category = getViewModel().selectedCategory
            intent.putExtra(ChamaConst.ARG_PLAN, plan)
            intent.putExtra(ChamaConst.ARG_MEMBER, getHomeActivity().getCurrentMember())
            startActivity(intent)
        }
    }

    fun setupWindowPopup(anchorView: View, textView: TextView, values: List<Any>, callback: OnChamaItemSelected){
        val popupWindow = ListPopupWindow(anchorView.context)
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, android.R.id.text1, values)
        popupWindow.setAdapter(adapter)
        popupWindow.anchorView = anchorView
        popupWindow.setOnItemClickListener { parent, view, position, id ->
            val item = adapter.getItem(position)
            textView.text = item.toString()
            textView.setTextColor(Color.BLACK)
            popupWindow.dismiss()
            callback.itemSelected(item)
        }
        popupWindow.show()
    }
}
