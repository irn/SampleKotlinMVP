package sc.dinero.webfunds.talisman.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.model.GroupMember
import sc.dinero.webfunds.talisman.viewmodel.LoginViewModel

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        setContentView(R.layout.activity_login)




        buttonCreateAccount.setOnClickListener {
            val intent = Intent(it.context, CreateAccountActivity::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
            val mobilePhone = field_mobile_phone.text.toString()
            val password = field_password.text.toString()
            if (!TextUtils.isEmpty(mobilePhone) && !TextUtils.isEmpty(password)){
                val member = viewModel.getMember(mobilePhone, password)
                member.observe(this, Observer<List<ChamaMember>> {
                    if (it?.size == 0){
                        Toast.makeText(baseContext, "Login or password incorrect", Toast.LENGTH_LONG).show()
                    } else {
                        val intent = HomeActivity.newInstance(baseContext, it?.get(0)!!)
                        startActivity(intent)
                    }
                })

            }

        }


        val chamaMember = ChamaMember()
        chamaMember.fullName = "Ruslan Ivakhnenko"
        chamaMember.mobilePhone = "0675420068"
        chamaMember.nymId = "234234"
        val members = viewModel.getMembers()
        val group = ChamaGroup();
        val groupMember = GroupMember()
        groupMember.member
        members.observe(this, Observer<List<ChamaMember>> {
            val size = it?.size
        })

//        Executors.newSingleThreadScheduledExecutor().schedule({
//            viewModel.createMember(chamaMember)
//            chamaMember.toString()
//        }, 3, TimeUnit.SECONDS)

    }

}
