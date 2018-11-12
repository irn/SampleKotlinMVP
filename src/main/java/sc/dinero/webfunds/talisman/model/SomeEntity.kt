package sc.dinero.webfunds.talisman.model


/**
 * Created by Ruslan Ivakhnenko on 31.08.2018.
 *
 * e-mail: ruslan1910@gmail.com
 */
data class SomeEntity(
        override var id : Int?,
        override var name: String,
        var value : String) : BaseChamaEntity(id, name) {

    constructor() : this(null, "", "")
}