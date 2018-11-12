package sc.dinero.webfunds.talisman.activities

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_contributions_ab.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.fragments.*
import sc.dinero.webfunds.talisman.listeners.HomeInterceptListener
import sc.dinero.webfunds.talisman.model.ChamaRole
import sc.dinero.webfunds.talisman.utils.ChamaConst
import sc.dinero.webfunds.talisman.viewmodel.ContributionViewModel


class ContributionsActivity : BaseMemberActivity() {

    private lateinit var viewModel : ContributionViewModel

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                finish()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_palaver -> {
                showFragment(PalaverFragment(), false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ledger -> {
                showFragment(LedgerFragment(), false)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_quorum -> {
                showFragment(QuorumFragment(), false)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_transaction -> {
                showFragment(TransactionsFragment(), false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onAttachFragment(fragment: android.app.Fragment?) {
        super.onAttachFragment(fragment)
        Log.i("----", "onAttachFragment ${fragment?.javaClass?.simpleName}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contributions_ab)
        setSupportActionBar(toolbar)
        setContainerId(R.id.contributionContainer)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel = ViewModelProviders.of(this).get(ContributionViewModel::class.java)

        viewModel.currentPlan = intent.getParcelableExtra(ChamaConst.ARG_PLAN)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_palaver
        if (viewModel.currentPlan.role?.roleId == ChamaRole.ROLE_GROUP_MANAGER){
            val menuItem = navigation.menu.getItem(2)
            navigation.menu.removeItem(menuItem.itemId)
            val newMenuItem = navigation.menu.add(Menu.NONE, R.id.navigation_transaction, Menu.NONE, "Transactions")
            newMenuItem.icon = menuItem.icon
        }
        supportActionBar?.title = viewModel.currentPlan.group?.name
        supportActionBar?.subtitle = viewModel.currentPlan.category?.name
        removeShiftMode(navigation)
    }

    @SuppressLint("RestrictedApi")
    fun removeShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView

                item.setShiftingMode(false)
                // set once again checked value, so view will be updated

                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BottomNav", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BottomNav", "Unable to change value of shift mode", e)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId){
            android.R.id.home -> {
                if (supportFragmentManager.backStackEntryCount > 0){
                    supportFragmentManager.popBackStack()
                } else {
                    finish()
                }
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }


}
