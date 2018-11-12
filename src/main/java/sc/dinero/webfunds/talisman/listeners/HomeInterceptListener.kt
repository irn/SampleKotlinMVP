package sc.dinero.webfunds.talisman.listeners

import sc.dinero.webfunds.talisman.model.ChamaMember


/**
 * Created by Ruslan Ivakhnenko on 22.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface HomeInterceptListener {

    fun getMobilePhone() : String

    fun getCurrentMember() : ChamaMember
}