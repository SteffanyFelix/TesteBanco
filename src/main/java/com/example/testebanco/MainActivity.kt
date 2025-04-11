package com.example.testebanco

import android.os.Bundle
import android.util.Log
import android.widget.TextView // <-- esse import estava faltando!
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textViewDados = findViewById<TextView>(R.id.textViewDados)

        val call = RetrofitClient.instance.getUsuarios()
        call.enqueue(object : Callback<List<Usuario>> {
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                if (response.isSuccessful) {
                    val lista = response.body()
                    val resultado = StringBuilder()
                    lista?.forEach {
                        resultado.append("Nome: ${it.nome}\nEmail: ${it.email}\n\n")
                    }
                    textViewDados.text = resultado.toString()
                } else {
                    textViewDados.text = "Erro na resposta"
                }
            }

            override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                textViewDados.text = "Erro na conexão: ${t.message}"
            }
        })
    }
}
