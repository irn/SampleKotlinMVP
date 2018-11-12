package sc.dinero.webfunds.talisman.fragments.quorum


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import sc.dinero.webfunds.talisman.R

/**
 * A simple [Fragment] subclass.
 *
 */
class QuorumDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_quorum_detail, container, false)
    }


}
