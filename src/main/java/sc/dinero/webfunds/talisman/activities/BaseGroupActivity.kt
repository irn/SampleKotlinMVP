package sc.dinero.webfunds.talisman.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sc.dinero.webfunds.talisman.listeners.GroupInterceptListener
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.utils.ChamaConst


/**
 * Created by Ruslan Ivakhnenko on 29.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
open class BaseGroupActivity : AppCompatActivity(), GroupInterceptListener {

    private lateinit var currentGroup : ChamaGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentGroup = intent.getParcelableExtra<ChamaGroup>(ChamaConst.ARG_GROUP)
    }

    override fun getGroup(): ChamaGroup {
        return currentGroup
    }
}