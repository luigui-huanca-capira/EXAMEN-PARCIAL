/**
 * Parcial - Práctica de Programación Orientada a Objetos en Kotlin
 * Descripción: Este fragmento maneja la lógica de retroalimentación después de que el usuario
 *              responde una pregunta en un juego de preguntas y respuestas. Muestra si la
 *              respuesta es correcta o incorrecta y proporciona una explicación.
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
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController



class AnswerFragment : Fragment() {

    private lateinit var questionViewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.answer_fragment, container, false)

        questionViewModel = ViewModelProvider(requireActivity()).get(QuestionViewModel::class.java)

        val resultTextView: TextView = view.findViewById(R.id.tv_result)
        val explanationTextView: TextView = view.findViewById(R.id.tv_explanation)
        val nextButton: Button = view.findViewById(R.id.btn_next)

        // Obtén la respuesta seleccionada desde el Bundle
        val selectedAnswer = arguments?.getInt("selectedAnswer") ?: -1

        // Mostrar si la respuesta fue correcta o incorrecta
        val isCorrect = questionViewModel.isCurrentAnswerCorrect(selectedAnswer)
        resultTextView.text = if (isCorrect) "¡Correcto!" else "Incorrecto"
        explanationTextView.text = questionViewModel.getCurrentQuestionExplanation()

        nextButton.setOnClickListener {
            // Navegar a la siguiente pregunta o mostrar resultados finales
            if (questionViewModel.hasMoreQuestions()) {
                findNavController().navigate(R.id.action_answerFragment_to_questionFragment)
            } else {
                findNavController().navigate(R.id.action_answerFragment_to_resultsFragment)
            }
        }

        return view
    }
}

