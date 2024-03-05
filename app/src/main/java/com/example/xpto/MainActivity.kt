package com.example.xpto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalc)
        btnCalcular.setOnClickListener {
            val km = findViewById<EditText>(R.id.edtKm)
            val salario = findViewById<EditText>(R.id.edtSalario)
            val total = findViewById<TextView>(R.id.txtValor)

            val kmValue = km?.text.toString().toDouble()
            val salarioValue = salario?.text.toString().toDouble()

            var comissao = 0.0
            if (kmValue <= 500) {
                comissao = 0.001 * salarioValue * kmValue
            } else if (kmValue >= 501 && kmValue <= 1000) {
                comissao = 0.0015 * salarioValue * kmValue
            } else if (kmValue >= 1001 && kmValue <= 1999) {
                comissao = 0.0025 * salarioValue * kmValue
            } else if (kmValue > 2000) {
                comissao = 0.003 * salarioValue * kmValue
            }
            total.text = "R$ %.2f".format(comissao + salarioValue)
        }
    }
}