package sc.dinero.webfunds.talisman.listeners

import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.model.ChamaRole


/**
 * Created by Ruslan Ivakhnenko on 07.09.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface ContributionInterceptListener {

    fun getGroup() : ChamaGroup

    fun getRole() : ChamaRole

    fun getPlan() : ChamaPlan
}