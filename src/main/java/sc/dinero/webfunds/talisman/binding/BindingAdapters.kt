package sc.dinero.webfunds.talisman.binding

import android.R
import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.Spinner
import sc.dinero.webfunds.talisman.adapters.BaseRecycleViewAdapter
import sc.dinero.webfunds.talisman.adapters.LocationAdapter
import sc.dinero.webfunds.talisman.adapters.SectorAdapter
import sc.dinero.webfunds.talisman.model.ChamaLocation
import sc.dinero.webfunds.talisman.model.ChamaSector


/**
 * Created by Ruslan Ivakhnenko on 18.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
object BindingAdapters {
    @BindingAdapter("app:sectorAdapter")
    @JvmStatic
    fun getSectorAdapter(view: Spinner, sectorList: LiveData<List<ChamaSector>>) {
        sectorList.observeForever {
            view.adapter = SectorAdapter(view.context, R.layout.simple_spinner_item, it)
        }
    }

    @BindingAdapter("app:locationAdapter")
    @JvmStatic
    fun getLocationAdapter(view: Spinner, locationList: List<ChamaLocation>?) {
        if (locationList != null)
            view.adapter = LocationAdapter(view.context, R.layout.simple_spinner_item, locationList)
    }

    @BindingAdapter("app:recycleViewAdapter")
    @JvmStatic
    fun setRecycleViewAdapter(recycleView : RecyclerView, itemList : List<Any>){
//        val adapter = BaseRecycleViewAdapter(itemList, R.layout.)
    }
}