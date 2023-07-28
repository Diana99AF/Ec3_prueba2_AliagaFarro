package com.diana.ec3simpsons.UI.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diana.ec3simpsons.data.DatosResults
import com.diana.ec3simpsons.data.repository.PersonajeRepository
import com.diana.ec3simpsons.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritoViewModel:ViewModel() {

    val repository = PersonajeRepository()

    val personaje : MutableLiveData<Personaje> = MutableLiveData<Personaje>()


    //CoRutinas
    fun getPersonFromService(){
        viewModelScope.launch( Dispatchers.IO) {


            val response2 = repository.getPersonaje()

            when(response2){
                is DatosResults.Success -> {
                    personaje.postValue(response2.data.result)
                }
                is DatosResults.Error -> {

                }

            }
            //    productos.postValue(response)
        }
    }
}