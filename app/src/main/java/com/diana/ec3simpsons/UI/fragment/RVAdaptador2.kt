package com.diana.ec3simpsons.UI.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.PersonajeItemBinding
import com.diana.ec3simpsons.databinding.PersonajefavItemBinding
import com.diana.ec3simpsons.model.Personaje

class RVAdaptador2(private val personaje: Personaje) : RecyclerView.Adapter<PersonajeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val binding = PersonajefavItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonajeViewHolder(binding)
    }

    // Vincular los datos del Personaje con las vistas en el ViewHolder
    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        holder.bind(personaje)
    }

    // Devolver la cantidad de elementos en la lista (en este caso, siempre será 1)
    override fun getItemCount(): Int {
        return 1
    }
}
class PersonajeViewHolder(private val binding: PersonajefavItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Método para vincular los datos del Personaje con las vistas en el ViewHolder
    fun bind(personaje: Personaje) {

        binding.txtnompersona.text = personaje.nombre
        binding.txthistoria.text = personaje.historia
        binding.txtgenero.text = personaje.genero
        binding.txtestado.text = personaje.estado
        binding.txtocupacion.text = personaje.ocupacion
        if(personaje.imagen.isNotEmpty()){
            binding.imgPersonaje.load(personaje.imagen)
        }
        else{
            binding.imgPersonaje.setImageResource(R.drawable.defect)
        }

        // También puedes configurar otras vistas del ViewHolder si es necesario
    }
}