/**
 * Parcial - Práctica de Programación Orientada a Objetos en Kotlin
 * Descripción: El fragmento WelcomeFragment es la pantalla de bienvenida del juego.
 *              Muestra un botón que, al ser presionado, lleva al usuario a la primera
 *              pregunta del juego a través de la navegación hacia el QuestionFragment.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 20/10/2024
 * Fecha última modificación: 20/10/2024
 */
package com.example.luiguialexanderparcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.luiguialexanderparcial.R


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.welcome_fragment, container, false)

        val startButton: Button = view.findViewById(R.id.btn_start)
        startButton.setOnClickListener {
            // Navegar al QuestionFragment
            findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment)
        }

        return view
    }
}
