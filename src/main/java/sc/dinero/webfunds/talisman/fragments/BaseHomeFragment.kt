package sc.dinero.webfunds.talisman.fragments


import android.content.Context
import android.support.v4.app.Fragment
import sc.dinero.webfunds.talisman.listeners.HomeInterceptListener

/**
 * A simple [Fragment] subclass.
 *
 */
open class BaseHomeFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context !is HomeInterceptListener){
            throw IllegalArgumentException("Your activity must implement HomeInterceptListener")
        }
    }

    protected fun getHomeActivity() = activity as HomeInterceptListener
}
