package sc.dinero.webfunds.talisman.listeners

import android.support.v4.app.Fragment


/**
 * Created by Ruslan Ivakhnenko on 14.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface FragmentInterceptor {

    fun setContainerId(containerId : Int)

    fun showFragment(fragment : Fragment, isBackStack : Boolean)
}