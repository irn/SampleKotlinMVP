package sc.dinero.webfunds.talisman.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import sc.dinero.webfunds.talisman.activities.HomeActivity
import sc.dinero.webfunds.talisman.listeners.HomeInterceptListener
import sc.dinero.webfunds.talisman.viewmodel.HomeViewModel


/**
 * Created by Ruslan Ivakhnenko on 03.10.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
open class BaseTabFragment : BaseHomeFragment() {

    private lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
    }

    protected fun getViewModel() = viewModel
}