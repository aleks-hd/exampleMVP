package com.hfad.examplemvp.presentor

import com.github.terrakok.cicerone.Router
import com.hfad.examplemvp.App
import com.hfad.examplemvp.model.GithubUser
import com.hfad.examplemvp.model.GithubUsersRepo
import com.hfad.examplemvp.model.IUserListPresenter
import com.hfad.examplemvp.model.UserItemView
import com.hfad.examplemvp.view.AndroidScreens
import com.hfad.examplemvp.view.UserView
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) : MvpPresenter<UserView>() {


    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() =
            users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
        val adrScreens = AndroidScreens()
            App.instance.router.navigateTo(adrScreens.userItem())
        }
    }

    fun loadData() {
        val users =
            usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList ()
    }

    fun backPressed():Boolean{
        router.exit()
        return true
    }

}