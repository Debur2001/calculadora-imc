package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
//        altura?.doAfterTextChanged { text ->
//            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
//        }
//
//        peso?.doOnTextChanged { text, _, _, _ ->
//            //imc?.text = text
//        }

        calcular?.setOnClickListener {
            calcularIMC(peso.text.toString(), altura.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            imcId.text = "Seu IMC é:\n%.2f".format(imc)
        }
        else {
            imcId.text = R.string.app_name.toString()
        }
    }
}
