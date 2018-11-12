package sc.dinero.webfunds.talisman.activities

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_edit_member.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.ChamaRole
import sc.dinero.webfunds.talisman.utils.ChamaConst
import sc.dinero.webfunds.talisman.viewmodel.GroupViewModel

class EditMemberActivity : AppCompatActivity() {

    private lateinit var viewModel : GroupViewModel

    private lateinit var member : ChamaMember

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GroupViewModel::class.java)
        member = intent.getParcelableExtra(ChamaConst.ARG_MEMBER)
        setContentView(R.layout.activity_edit_member)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Edit member"
        supportActionBar?.subtitle = member.fullName

        textInputFullName.setText(member.fullName)
        textInputPhone.setText(member.mobilePhone)

        buttonActionEditMember.setOnClickListener {
            member.fullName = textInputFullName.text.toString()
            viewModel.editMemberToGroup(member).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(
                            {_ -> finish()},
                            {error -> Toast.makeText(EditMemberActivity@this, "Cannot edit member ${member.fullName}", Toast.LENGTH_LONG).show()}
                    )
        }

    }
}
