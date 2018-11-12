package sc.dinero.webfunds.talisman.fragments.transactions


import android.app.Activity
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_addmember.*
import kotlinx.android.synthetic.main.fragment_transaction_in.*

import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.fragments.BaseContributionFragment
import sc.dinero.webfunds.talisman.fragments.TransactionsFragment
import sc.dinero.webfunds.talisman.fragments.dialogs.MembersDialogFragment
import sc.dinero.webfunds.talisman.model.ChamaContribution
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.utils.ChamaConst
import java.util.*

/**
 * A simple [Fragment] subclass.
 *
 */
class TransactionInFragment : BaseContributionFragment() {

    private lateinit var checkedMembers : BooleanArray

    private lateinit var membersList : ArrayList<ChamaMember>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMembersOfGroup(viewModel.currentPlan.group?.groupId!!).observe(this, Observer {
            membersList = it as ArrayList<ChamaMember>
            checkedMembers = BooleanArray(membersList.size)
            updateTotalAmount(checkedMembers)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transaction_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSelectMembers.setOnClickListener {
            val dialogFragment = MembersDialogFragment()
            dialogFragment.setTargetFragment(this, TransactionsFragment.SELECTED_MEMBERS_REQUEST_CODE)
            val args = Bundle()
            args.putParcelableArrayList(ChamaConst.ARG_MEMBERS_LIST, membersList)
            args.putBooleanArray(TransactionsFragment.CHECKED_MEMBERS, checkedMembers)
            dialogFragment.arguments = args
            dialogFragment.show(fragmentManager, "selectMembers")
        }

        editTextAmount.addTextChangedListener(object:TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                updateTotalAmount(checkedMembers)
            }
        })

        buttonActionTransactionSubmit.setOnClickListener {
            if (!checkedMembers.any { it }){
                Toast.makeText(context, "Please select member(s)",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (editTextAmount.text.toString().isEmpty() || editTextAmount.text.toString().toInt() < 1){
                Toast.makeText(context, "Please input an amount",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val contribution = ChamaContribution()
            with(contribution) {
                amount = editTextAmount.text.toString().toInt()
                members = membersList?.filterIndexed { index, _ -> checkedMembers[index] }?.toList()
                groupId = getGroup()?.groupId!!
                categoryId = getCategory()?.categoryId!!
                description = editTextMeetingDescription.text.toString()
                validated = getHomeActivity().getCurrentMember().memberId!!
                isIncoming = true
                date = Date()
            }

            viewModel.createContribution(contribution).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe {fragmentManager?.popBackStack()}
        }

        checkBoxAllMember.setOnCheckedChangeListener { _, isChecked ->
            checkedMembers.fill(isChecked, 0, checkedMembers.size)
            updateTotalAmount(checkedMembers)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TransactionsFragment.SELECTED_MEMBERS_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            checkedMembers = data?.getBooleanArrayExtra(TransactionsFragment.CHECKED_MEMBERS)!!
            updateTotalAmount(checkedMembers)
        }
    }

    private fun updateTotalAmount(checked : BooleanArray?){
        var amount = 0
        if (!editTextAmount.text.toString().isEmpty()){
            amount = editTextAmount.text.toString().toInt()
        }
        textViewTotalAmount.text = checked?.filter { it }?.size?.times(amount)?.toString()
    }
}
