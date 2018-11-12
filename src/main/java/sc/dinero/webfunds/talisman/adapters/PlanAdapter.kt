package sc.dinero.webfunds.talisman.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.simple_cardview_item.view.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.model.ChamaPlanWithCategory

/**
 * Created by Ruslan Ivakhnenko on 18.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class PlanAdapter(var planList: List<ChamaPlanWithCategory>?) : RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_cardview_item, parent, false)
        return PlanViewHolder(view)
    }

    override fun getItemCount(): Int {
        return planList?.size!!
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val chamaPlan = planList?.get(position)
        holder.itemView.textViewItemName.text = chamaPlan?.category?.get(0)?.name
    }


    class PlanViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

    }
}

