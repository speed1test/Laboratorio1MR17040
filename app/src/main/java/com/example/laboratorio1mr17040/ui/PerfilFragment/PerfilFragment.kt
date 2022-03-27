package com.example.laboratorio1mr17040.ui.PerfilFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.laboratorio1mr17040.R

class PerfilFragment : Fragment() {

    companion object {
        fun newInstance() = PerfilFragment()
    }

    private lateinit var viewModel: PerfilViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //Declaro variables que contendran los datos y de igual forma creo un archivo vista para despues renderizarlo
        val vista : View = inflater.inflate(R.layout.perfil_fragment, container, false)
        val boton1 : Button = vista.findViewById(R.id.btn1)
        val nombre : TextView = vista.findViewById(R.id.editNombre)
        val carnet : TextView = vista.findViewById(R.id.editCarnet)
        boton1.setOnClickListener()
        {
            var texto : String = ""
            if(nombre.text.equals("") || carnet.text.equals(""))
            {
                texto = "Detectamos datos sin rellenar"
            }
            else
            {
                texto = "Su nombre es: "+nombre.text + " y su Carnet es: "+carnet.text
            }
            Toast.makeText(vista.context, texto, Toast.LENGTH_SHORT).show();
        }
        return vista
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)
        // TODO: Use the ViewModel
    }

}