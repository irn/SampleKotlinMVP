package sc.dinero.webfunds.talisman.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.simple_cardview_item.view.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.listeners.GroupClickListener
import sc.dinero.webfunds.talisman.model.ChamaMember


/**
 * Created by Ruslan Ivakhnenko on 21.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class MembersAdapter(private val membersList : List<ChamaMember>, val listener : GroupClickListener? = null) : RecyclerView.Adapter<MembersAdapter.GroupViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_cardview_item, parent, false)
        return GroupViewHolder(view)
    }

    override fun getItemCount(): Int {
        return membersList?.size
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.view.textViewItemName.text = membersList.get(position).fullName
        holder.view.itemCardView.setOnClickListener {
//            listener?.onItemClick(membersList.get(position))
        }
    }

    class GroupViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

}