package com.diana.ec3simpsons.data.retrofit

import com.diana.ec3simpsons.data.response.ListaPersonajeResponse
import com.diana.ec3simpsons.data.response.PersonajeResponse
import retrofit2.http.GET

interface SimpsonsInterface {
    @GET("api/personajes")
    suspend fun getAllPersonajes(): ListaPersonajeResponse

    @GET("api/personajes/find/Kirk")
    suspend fun getPerson(): PersonajeResponse


}