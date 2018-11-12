package sc.dinero.webfunds.talisman.listeners

import sc.dinero.webfunds.talisman.model.ChamaGroup


/**
 * Created by Ruslan Ivakhnenko on 23.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
interface GroupClickListener {
    fun onItemClick(group : ChamaGroup)
}