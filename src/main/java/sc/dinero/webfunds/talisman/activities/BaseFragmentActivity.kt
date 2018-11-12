package sc.dinero.webfunds.talisman.activities

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import sc.dinero.webfunds.talisman.listeners.FragmentInterceptor
import java.lang.IllegalArgumentException


/**
 * Created by Ruslan Ivakhnenko on 14.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
abstract class BaseFragmentActivity : AppCompatActivity(), FragmentInterceptor {

    private var containerId : Int = 0

    /**
     * This method is using to setup container when new fragments being added
     */
    override fun setContainerId(id : Int) {
        containerId = id
    }

    override fun showFragment(fragment : Fragment, isBackStack : Boolean){
        if (containerId == 0){
            throw IllegalArgumentException("You should call setContainerId() method before using this method")
        }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        if (isBackStack) {
            transaction.addToBackStack(fragment.toString())
        }
        transaction.commit()
    }

}