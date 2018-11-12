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
class QuorumValidatedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quorum_validated, container, false)
    }


}
