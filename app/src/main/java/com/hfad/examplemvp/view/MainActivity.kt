package com.hfad.examplemvp.view


import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hfad.examplemvp.App
import com.hfad.examplemvp.R
import com.hfad.examplemvp.databinding.ActivityMainBinding
import com.hfad.examplemvp.presentor.MainPresenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens()) }

    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }



    /*override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }*/


    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }
}
