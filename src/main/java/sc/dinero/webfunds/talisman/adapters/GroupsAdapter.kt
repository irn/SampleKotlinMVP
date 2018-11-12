package sc.dinero.webfunds.talisman.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.simple_cardview_item.view.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.listeners.GroupClickListener
import sc.dinero.webfunds.talisman.model.ChamaGroup


/**
 * Created by Ruslan Ivakhnenko on 21.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class GroupsAdapter(private val groupsList : List<ChamaGroup>, val listener : GroupClickListener) : RecyclerView.Adapter<GroupsAdapter.GroupViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_cardview_item, parent, false)
        return GroupViewHolder(view)
    }

    override fun getItemCount(): Int {
        return groupsList?.size
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.view.textViewItemName.text = groupsList.get(position).name
        holder.view.itemCardView.setOnClickListener {
            listener?.onItemClick(groupsList.get(position))
        }
    }

    class GroupViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

}