package com.hfad.examplemvp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.examplemvp.App
import com.hfad.examplemvp.databinding.ItemUserTestBinding
import com.hfad.examplemvp.presentor.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ItemusertestFragment(val loginUser: String = "t") : MvpAppCompatFragment(), MainView {

    companion object {
        fun newInstance() = ItemusertestFragment()
    }

    val presenter: UserPresenter by moxyPresenter {
        UserPresenter(loginUser, App.instance.router)
    }

    private var vb: ItemUserTestBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = ItemUserTestBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vb?.testUser?.text = loginUser
        vb?.btnBack?.setOnClickListener {
            backPressed()
        }
    }

    fun backPressed() = presenter.backItem()

}