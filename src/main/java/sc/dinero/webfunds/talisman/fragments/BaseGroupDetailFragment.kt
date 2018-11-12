package sc.dinero.webfunds.talisman.fragments


import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import sc.dinero.webfunds.talisman.listeners.GroupInterceptListener
import sc.dinero.webfunds.talisman.viewmodel.GroupViewModel


/**
 * A simple [Fragment] subclass.
 *
 */
open class BaseGroupDetailFragment : Fragment() {

    private lateinit var viewModel : GroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(GroupViewModel::class.java)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context !is GroupInterceptListener){
            throw IllegalArgumentException("The Activity must implements GroupDetaiInterceptListener")
        }
    }

    protected fun getViewModel() = viewModel

    protected fun getDetailActivity() : GroupInterceptListener = activity as GroupInterceptListener
}
