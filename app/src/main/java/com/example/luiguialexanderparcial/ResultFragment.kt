/**
 * Parcial - Práctica de Programación Orientada a Objetos en Kotlin
 * Descripción: El fragmento ResultsFragment muestra el puntaje final al usuario después de
 *              que ha completado todas las preguntas del juego. También proporciona la opción
 *              de reiniciar el juego, lo cual resetea el puntaje y lleva al usuario a la
 *              pantalla de bienvenida.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 20/10/2024
 * Fecha última modificación: 20/10/2024
 */
package com.example.quizgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.luiguialexanderparcial.QuestionViewModel
import com.example.luiguialexanderparcial.R


class ResultsFragment : Fragment() {

    private lateinit var questionViewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)

        questionViewModel = ViewModelProvider(requireActivity()).get(QuestionViewModel::class.java)

        val scoreTextView: TextView = view.findViewById(R.id.tv_score)
        val restartButton: Button = view.findViewById(R.id.btn_restart)

        // Mostrar el puntaje final
        scoreTextView.text = "Tu puntaje final es: ${questionViewModel.getScore()}"

        // Reiniciar el juego
        restartButton.setOnClickListener {
            questionViewModel.resetGame()
            findNavController().navigate(R.id.action_resultsFragment_to_welcomeFragment)
        }

        return view
    }
}
