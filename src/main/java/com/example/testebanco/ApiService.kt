package com.example.testebanco
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("listar_usuarios.php")
    fun getUsuarios(): Call<List<Usuario>>
}
