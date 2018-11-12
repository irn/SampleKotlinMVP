package sc.dinero.webfunds.talisman.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.FragmentInvitationsBinding
import sc.dinero.webfunds.talisman.adapters.InvitationAdapter

/**
 * A simple [Fragment] subclass.
 */
class InvitationsFragment : BaseTabFragment() {

    private lateinit var mBinding : FragmentInvitationsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_invitations, container, false)
        mBinding.setLifecycleOwner(this)
        mBinding.viewModel = getViewModel()
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recycleViewInvitations.adapter  = InvitationAdapter(listOf("Inviration 1", "Invitation 2"))

    }
}
