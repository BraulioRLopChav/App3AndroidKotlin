package com.example.practica003kotlin

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculadorActivity : AppCompatActivity() {
    private lateinit var inputNum1: EditText
    private lateinit var inputNum2: EditText
    private lateinit var lblResultado: TextView
    private lateinit var lblMostrarNombreUser: TextView
    private var num1: Int = 0
    private var num2: Int = 0
    private lateinit var calculadora: Calculadora



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculador)

        // Obtener una referencia al EditText
        inputNum1 = findViewById(R.id.inputNum1)
        inputNum2 = findViewById(R.id.inputNum2)

        lblResultado = findViewById(R.id.lblResultado)
        lblMostrarNombreUser = findViewById(R.id.lblMostrarNombreUser)


        // Obtener una referencia al botón
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)


        // Obtener los datos del Bundle
        val bundle = intent.extras
        if (bundle != null) {
            val usuario = bundle.getString("Usuario")
            // Haz algo con el valor del usuario
            // Por ejemplo, muestra el usuario en un TextView
            val txtUsuario = findViewById<TextView>(R.id.lblMostrarNombreUser)
            txtUsuario.text = "Usuario: $usuario"
        }

        btnSumar.setOnClickListener {
            val stringNum1 = inputNum1.text.toString()
            val stringNum2 = inputNum2.text.toString()

            if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                val num1 = stringNum1.toDouble()
                val num2 = stringNum2.toDouble()

                calculadora = Calculadora(num1, num2)

                // Realiza otras operaciones con la calculadora si es necesario
                val resultado = calculadora.sumar()
                val resultadoTexto = resultado.toString()

                // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
                lblResultado.setText("Resultado: $resultadoTexto")
            } else {
                Toast.makeText(applicationContext, "Llene todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }

        btnRestar.setOnClickListener {
            val stringNum1 = inputNum1.text.toString()
            val stringNum2 = inputNum2.text.toString()

            if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                val num1 = stringNum1.toDouble()
                val num2 = stringNum2.toDouble()

                calculadora = Calculadora(num1, num2)

                // Realiza otras operaciones con la calculadora si es necesario
                val resultado = calculadora.restar()
                val resultadoTexto = resultado.toString()
                lblResultado.setText("Resultado: $resultadoTexto")
            } else {
                Toast.makeText(applicationContext, "Llene todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }

        btnMultiplicar.setOnClickListener {
            val stringNum1 = inputNum1.text.toString()
            val stringNum2 = inputNum2.text.toString()

            if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                val num1 = stringNum1.toDouble()
                val num2 = stringNum2.toDouble()

                calculadora = Calculadora(num1, num2)

                // Realiza otras operaciones con la calculadora si es necesario
                val resultado = calculadora.multiplicar()
                val resultadoTexto = resultado.toString()
                lblResultado.setText("Resultado: $resultadoTexto")
            } else {
                Toast.makeText(applicationContext, "Llene todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }

        btnDividir.setOnClickListener {
            val stringNum1 = inputNum1.text.toString()
            val stringNum2 = inputNum2.text.toString()

            if (!TextUtils.isEmpty(stringNum1) && !TextUtils.isEmpty(stringNum2)) {
                val num1 = stringNum1.toDouble()
                val num2 = stringNum2.toDouble()

                if (num2 <= 0) {
                    Toast.makeText(applicationContext, "No se puede dividir entre $num2.", Toast.LENGTH_SHORT).show()
                } else {
                    calculadora = Calculadora(num1, num2)

                    // Realiza otras operaciones con la calculadora si es necesario
                    val resultado = calculadora.dividir()
                    val resultadoTexto = resultado.toString()
                    lblResultado.setText("Resultado: $resultadoTexto")
                }

            } else {
                Toast.makeText(applicationContext, "Llene todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }

        btnLimpiar.setOnClickListener {
            inputNum1.setText("")
            inputNum2.setText("")
            lblResultado.setText("")
        }


        //Boton para salir al login
        btnCerrarSesion.setOnClickListener(View.OnClickListener { finish() })


    }

    class Calculadora(private val numero1: Double, private val numero2: Double) {

        // Resto de métodos de la clase Calculadora

        fun sumar(): Double {
            return numero1 + numero2
        }

        fun restar(): Double {
            return numero1 - numero2
        }

        fun multiplicar(): Double {
            return numero1 * numero2
        }

        fun dividir(): Double {
            if (numero2 != 0.0) {
                return numero1 / numero2
            } else {
                throw ArithmeticException("Error: No se puede dividir entre cero")
            }
        }
    }

}