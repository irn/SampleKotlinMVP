package sc.dinero.webfunds.talisman.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.ItemInvitationBinding


/**
 * Created by Ruslan Ivakhnenko on 23.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class InvitationAdapter(private val invitationList: List<String>) : RecyclerView.Adapter<InvitationAdapter.InvitationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvitationViewHolder {
        val binding = DataBindingUtil.inflate<ItemInvitationBinding>(LayoutInflater.from(parent.context), R.layout.item_invitation, parent, false)
        return InvitationViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return invitationList?.size
    }

    override fun onBindViewHolder(holder: InvitationViewHolder, position: Int) {

    }


    class InvitationViewHolder(val binding : ItemInvitationBinding ) : RecyclerView.ViewHolder(binding.root)
}