package sc.dinero.webfunds.talisman.activities

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_create_account.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.ChamaRole
import sc.dinero.webfunds.talisman.utils.ChamaConst
import sc.dinero.webfunds.talisman.viewmodel.LoginViewModel

class CreateAccountActivity : AppCompatActivity() {

    lateinit var viewModel : LoginViewModel

    private lateinit var member : ChamaMember

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        actionCreateAccount.setOnClickListener{
            val fullName = fieldFullName.text.toString()
            val mobilePhone = fieldMobilePhone.text.toString()
            val password = fieldPassword.text.toString()
            val passwordConfirm = fieldPasswordConfirm.text.toString()
            if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(mobilePhone)){
                Toast.makeText(applicationContext, "All fields are mandatory", Toast.LENGTH_LONG).show()
            } else if (TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordConfirm) || !TextUtils.equals(password, passwordConfirm)){
                Toast.makeText(applicationContext, "Passwords are not equals", Toast.LENGTH_LONG).show()
            } else if (!checkBoxAcceptLicense.isChecked) {
                Toast.makeText(applicationContext, "You must accept community terms", Toast.LENGTH_LONG).show()
            } else {
                member = ChamaMember(fullName, mobilePhone, password, ChamaRole.ROLE_GROUP_MANAGER)
                viewModel.createMember(member).
                        subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread()).
                        subscribe(
                                {result -> val intent = Intent(applicationContext, ManageGroupActivity::class.java)
                                    member.memberId = result
                                    intent.putExtra(ChamaConst.ARG_MEMBER, member)
                                    startActivityForResult(intent, ManageGroupActivity.MANAGE_MEMBER_REQUEST_CODE)},
                                { error ->
                                    error.printStackTrace()
                                    Toast.makeText(baseContext, "User exists", Toast.LENGTH_LONG).show()
                                }
                        )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ManageGroupActivity.MANAGE_MEMBER_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val intent = HomeActivity.newInstance(baseContext, member)
            startActivity(intent)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
