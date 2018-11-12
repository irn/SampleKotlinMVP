package sc.dinero.webfunds.talisman.activities

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_new_member.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.ChamaRole
import sc.dinero.webfunds.talisman.utils.ChamaConst
import sc.dinero.webfunds.talisman.viewmodel.GroupViewModel

class NewMemberActivity : AppCompatActivity() {

    private lateinit var viewModel : GroupViewModel

    private lateinit var currentGroup : ChamaGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(GroupViewModel::class.java)
        currentGroup = intent.getParcelableExtra<ChamaGroup>(ChamaConst.ARG_GROUP)
        setContentView(R.layout.activity_new_member)
        setSupportActionBar(toolbar)
        supportActionBar?.title = currentGroup.name
        supportActionBar?.subtitle = "Add new member"

        buttonActionAddMember.setOnClickListener {
            val member = ChamaMember(textInputFullName.text.toString(), textInputPhone.text.toString(), null, ChamaRole.ROLE_GROUP_MEMBER)
            viewModel.addMemberToGroup(currentGroup, member).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(
                    {result -> finish()},
                    {error -> Toast.makeText(NewMemberActivity@this, "Cannot create user for group ${currentGroup.name}", Toast.LENGTH_LONG).show()}
            )
        }

    }
}
