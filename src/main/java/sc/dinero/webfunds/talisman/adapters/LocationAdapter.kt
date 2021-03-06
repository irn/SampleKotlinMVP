package sc.dinero.webfunds.talisman.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import sc.dinero.webfunds.talisman.model.ChamaLocation
import sc.dinero.webfunds.talisman.model.ChamaSector

/**
 * Created by Ruslan Ivakhnenko on 18.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class LocationAdapter(context: Context?, resource: Int, objects: List<ChamaLocation>?) : ArrayAdapter<ChamaLocation>(context, resource, objects) {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(getContext())

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rootView = layoutInflater.inflate(android.R.layout.simple_spinner_item, parent, false)
        val textView = rootView.findViewById<TextView>(android.R.id.text1)
        val item = getItem(position)
        textView.text = item.name
        return rootView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rootView = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val textView = rootView.findViewById<TextView>(android.R.id.text1)
        val item = getItem(position)
        textView.text = item.name
        return rootView
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).locationId!!.toLong()
    }
}

