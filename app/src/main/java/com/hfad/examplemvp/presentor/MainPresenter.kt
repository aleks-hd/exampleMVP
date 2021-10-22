package com.hfad.examplemvp.presentor

import com.github.terrakok.cicerone.Router
import com.hfad.examplemvp.view.IScreens
import com.hfad.examplemvp.view.MainView
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screen: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.users())
    }



    fun backClicked() {
        router.exit()
    }
}
