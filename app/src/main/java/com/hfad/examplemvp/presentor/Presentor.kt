package com.hfad.examplemvp.presentor


import com.hfad.examplemvp.model.Data
import com.hfad.examplemvp.model.Numb
import com.hfad.examplemvp.view.IMainPresentor


class Presentor(val view: IMainPresentor) {

    val model = Data()

    fun counterClick(type: Numb) {
        when (type) {
            Numb.ONE -> {
                val nextValue = model.next(0)
                view.setButtonTextOne (nextValue.toString())
            }
            Numb.TWO -> {
                val nextValue = model.next(1)
                view.setButtonTextTwo (nextValue.toString())
            }
            Numb.THEE -> {
                val nextValue = model.next(2)
                view.setButtonTextTree (nextValue.toString())
            }
        }
    }

}