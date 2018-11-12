package sc.dinero.webfunds.talisman.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sc.dinero.webfunds.talisman.adapters.viewHolder.BaseViewHolder


/**
 * Created by Ruslan Ivakhnenko on 17.09.2018.
 *
 * T - type of item data
 *
 * e-mail: ruslan1910@gmail.com
 */
class BaseRecycleViewAdapter<T>(
        private val dataList: List<T>,
        val variableId: Int,
        private val layoutId: Int,
        val listener: ((T) -> Unit)? = null) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val itemValue = dataList[position]
        holder.binding.setVariable(variableId, itemValue)
        holder.binding.root.setOnClickListener {
            listener?.invoke(itemValue)
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size
    }


}