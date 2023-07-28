package com.diana.ec3simpsons.UI.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.FragmentFavoritoBinding
import com.diana.ec3simpsons.databinding.FragmentInicioBinding
import com.diana.ec3simpsons.model.Personaje


class FavoritoFragment : Fragment() {
    private lateinit var binding: FragmentFavoritoBinding
    private lateinit var viewModel: FavoritoViewModel
//+++++++++++++
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FavoritoViewModel::class.java]
    }
//+++++++++++++++++++++++
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[FavoritoViewModel::class.java]

        viewModel.personaje.observe(viewLifecycleOwner) { personaje ->
            // Mostrar los datos del personaje directamente en las vistas
            binding.txtnompersona.text = personaje.nombre
            binding.txthistoria.text = personaje.historia
            binding.txtgenero.text = personaje.genero
            binding.txtestado.text = personaje.estado
            binding.txtocupacion.text = personaje.ocupacion
            if (personaje.imagen.isNotEmpty()) {
                binding.imgPersonaje.load(personaje.imagen)
            } else {
                binding.imgPersonaje.setImageResource(R.drawable.defect)
            }
        }

        viewModel.getPersonFromService()
    }


}