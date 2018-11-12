package sc.dinero.webfunds.talisman.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import sc.dinero.webfunds.talisman.listeners.HomeInterceptListener
import sc.dinero.webfunds.talisman.model.ChamaMember
import sc.dinero.webfunds.talisman.utils.ChamaConst

open class BaseMemberActivity : BaseFragmentActivity(), HomeInterceptListener {

    private lateinit var currentMember : ChamaMember

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentMember = intent.getParcelableExtra(ChamaConst.ARG_MEMBER)
    }

    override fun getMobilePhone(): String {
        return currentMember.mobilePhone
    }

    override fun getCurrentMember(): ChamaMember {
        return currentMember
    }
}
