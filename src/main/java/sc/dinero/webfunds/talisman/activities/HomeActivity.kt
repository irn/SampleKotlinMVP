package sc.dinero.webfunds.talisman.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.fragments.GroupsFragment
import sc.dinero.webfunds.talisman.fragments.HomeFragment
import sc.dinero.webfunds.talisman.fragments.InvitationsFragment
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.utils.ChamaConst

class HomeActivity : BaseMemberActivity() {

    companion object {
        /**
         * This function create new Intent for launch HomeActivity with flags to clear previous activity back stack
         * @see Intent.FLAG_ACTIVITY_NEW_TASK
         * @see Intent.FLAG_ACTIVITY_CLEAR_TASK
         */
        fun newInstance (context : Context, member : ChamaMember) : Intent {
            val intent = Intent(context, HomeActivity::class.java).putExtra(ChamaConst.ARG_MEMBER, member)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        userMobilePhone = intent.getStringExtra(ChamaConst.ARG_MOBILE_PHONE)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val beginTransaction = supportFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.homeContainer, HomeFragment())
                beginTransaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_invitations -> {
                val beginTransaction = supportFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.homeContainer, InvitationsFragment())
                beginTransaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_groups -> {
                val beginTransaction = supportFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.homeContainer, GroupsFragment())
                beginTransaction.commit()
//                val intent = Intent(this, GroupsActivity::class.java)
//                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
