package sc.dinero.webfunds.talisman.fragments.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import sc.dinero.webfunds.talisman.fragments.TransactionsFragment
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.utils.ChamaConst


/**
 * Created by Ruslan Ivakhnenko on 20.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
class MembersDialogFragment : DialogFragment(){

    private var membersList : ArrayList<ChamaMember>? = null

    private var checkedMembers : BooleanArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        membersList = arguments?.getParcelableArrayList(ChamaConst.ARG_MEMBERS_LIST)
        checkedMembers = arguments?.getBooleanArray(TransactionsFragment.CHECKED_MEMBERS)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context!!)
        builder.setTitle("Please select members")
        val members = arrayOf("1234", "124", "43643", "45754", "54745", "4576", "546845hdf", "fdgdf", "345634", "346346", "346543")
        if (checkedMembers == null){
            checkedMembers = membersList?.map { m -> m.fullName == "Ruslan" }?.toBooleanArray()
        }
        builder.setMultiChoiceItems(membersList?.map { it.fullName}?.toTypedArray(), checkedMembers, {items, which, isChecked -> checkedMembers?.set(which, isChecked)})
        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            targetFragment?.onActivityResult(TransactionsFragment.SELECTED_MEMBERS_REQUEST_CODE, Activity.RESULT_OK, Intent().putExtra(TransactionsFragment.CHECKED_MEMBERS, checkedMembers))
        }

        builder.setNegativeButton(android.R.string.cancel, { dialogInterface: DialogInterface, i: Int ->

        })
        return builder.create()
    }
}