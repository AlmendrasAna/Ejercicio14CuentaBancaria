package com.example.ejercicio14cuentabancaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio14cuentabancaria.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var saldo = 10000
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.setB.setOnClickListener { v ->
            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.mostrarSaldoRB ->
                    showToas("Tu saldo es ${saldo.toString()} ")

                R.id.ingresarSaldoRB2 -> {

                    if (binding.montoEditTxt.text.isNotEmpty()) {
                        saldo += binding.montoEditTxt.text.toString().toInt()
                        showToas("Tu nuevo saldo es ${saldo.toString()} ")
                    }else showToas("ingrese monto")
                }

                R.id.retirarRB -> {
                    if (binding.montoEditTxt.text.isNotEmpty()) {
                    if (validarMonto(saldo)) {
                        saldo -= binding.montoEditTxt.text.toString().toInt()
                        showToas("Tu nuevo saldo es ${saldo.toString()} ")
                    }
                    }else showToas("ingrese monto")
                }

            }
        }
    }


    fun showToas(msn: String) {
        Toast.makeText(
            this,
            msn,
            Toast.LENGTH_LONG
        ).show()
    }

    fun validarMonto(saldo: Int): Boolean {

        var boolean = false

        if (binding.montoEditTxt.text.toString()
                .toInt() <= saldo && saldo > 0
        ) {
            boolean = true
        } else showToas("no tiene saldo suficiente")



        return boolean
    }
}