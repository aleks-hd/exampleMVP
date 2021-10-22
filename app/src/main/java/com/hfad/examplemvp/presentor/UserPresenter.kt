package com.hfad.examplemvp.presentor

import com.github.terrakok.cicerone.Router
import com.hfad.examplemvp.model.GithubUser
import com.hfad.examplemvp.view.AndroidScreens
import com.hfad.examplemvp.view.UserView
import moxy.MvpPresenter

class UserPresenter(val user: String, val router: Router) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backItem(): Boolean {
        router.exit()
        return true
    }
}