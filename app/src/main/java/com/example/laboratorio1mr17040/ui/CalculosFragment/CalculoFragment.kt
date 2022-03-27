package com.example.laboratorio1mr17040.ui.CalculosFragment

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
import org.w3c.dom.Text

class CalculoFragment : Fragment() {

    companion object {
        fun newInstance() = CalculoFragment()
    }

    private lateinit var viewModel: CalculoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista : View = inflater.inflate(R.layout.perfil_fragment, container, false)
        val boton1 : Button = vista.findViewById(R.id.btnCalcular)
        val salario : TextView = vista.findViewById(R.id.editSalario)
        val isss : TextView = vista.findViewById(R.id.varIsss)
        val afp : TextView = vista.findViewById(R.id.varAfp)
        val seguro : TextView = vista.findViewById(R.id.varSeguroVida)
        val renta : TextView = vista.findViewById(R.id.varRenta)
        boton1.setOnClickListener()
        {
            if(salario.getText().toString().isEmpty())
            {
                Toast.makeText(vista.context, "Rellene su sueldo", Toast.LENGTH_SHORT).show();
            }
            else
            {
                isss.text = "ISSS: "+calcularIsss(salario).toString()
                seguro.text = "Seguro de Salud: "+calcularSeguro(salario).toString()
                afp.text = "AFP: "+ calcularAfp(salario).toString()
                renta.text = "Renta: "+ calcularRenta(salario).toString()

            }
        }
        return vista
    }
    fun calcularAfp(salario : TextView) : Double
    {
        val salario : Double = convertirSalario(salario)
        var resultado : Double = salario * 0.075
        return resultado
    }
    fun calcularIsss(salario : TextView) : Double
    {
        val salario : Double = convertirSalario(salario)
        var resultado : Double = salario * 0.03
        return resultado
    }
    fun calcularSeguro(salario : TextView) : Double
    {
        val salario : Double = convertirSalario(salario)
        var resultado : Double = salario
        if(salario > 900)
        {
            resultado = salario * 0.03
        }
        return resultado
    }
    fun calcularRenta (salario : TextView) : Double
    {
        val salario : Double = convertirSalario(salario)
        var resultado : Double = 0.00
        if(salario >= 0.1 && salario <= 550 )
        {
            var resultado : Double = salario
        }
        else
        {
            if(salario > 500 && salario <= 800 )
            {
                var resultado : Double = salario * 0.10
            }
            else
            {
                if(salario > 800 && salario <= 2500 )
                {
                    var resultado : Double = salario * 0.20
                }
                else
                {
                    if(salario > 2500 )
                    {
                        var resultado : Double = salario * 0.30
                    }
                    else
                    {
                        var resultado : Double = 0.00
                    }
                }
            }
        }
        return resultado
    }
    fun convertirSalario(salario : TextView) : Double
    {
        val resultado = salario.getText().toString().toDouble()
        return resultado
    }
    fun calcularSalNeto(num1: Double, num2: Double, num3: Double, num4: Double, salario : Double ) : Double
    {
        val resultado = salario - (num1+num2+num3+num4)
        return resultado
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CalculoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}