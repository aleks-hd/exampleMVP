package com.hfad.examplemvp.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.hfad.examplemvp.R
import com.hfad.examplemvp.databinding.ActivityMainBinding
import com.hfad.examplemvp.model.Numb
import com.hfad.examplemvp.presentor.Presentor
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity(), IMainPresentor {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    val presentor = Presentor(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
            val type = when (it.id) {
                R.id.btn_counter1 -> Numb.ONE
                R.id.btn_counter2 -> Numb.TWO
                R.id.btn_counter3 -> Numb.THEE
                else -> throw IllegalStateException("error btn")
            }
            presentor.counterClick(type)
        }
        initBtn(listener)
    }

    private fun initBtn(listener: View.OnClickListener) {
        binding.btnCounter1.setOnClickListener(listener)
        binding.btnCounter2.setOnClickListener(listener)
        binding.btnCounter3.setOnClickListener(listener)
    }


    override fun setButtonTextOne(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setButtonTextTwo(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setButtonTextTree(text: String) {
        binding.btnCounter3.text = text
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
