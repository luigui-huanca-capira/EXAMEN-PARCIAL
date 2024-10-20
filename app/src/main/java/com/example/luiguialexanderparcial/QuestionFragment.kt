/**
 * Parcial - Práctica de Programación Orientada a Objetos en Kotlin
 * Descripción: El fragmento QuestionFragment se encarga de mostrar una pregunta al usuario
 *              con múltiples opciones de respuesta. Permite seleccionar una opción y luego
 *              navegar a la retroalimentación sobre la respuesta, o pasar a la siguiente
 *              pregunta si es necesario.
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
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestionViewModel
    private lateinit var questionTextView: TextView
    private lateinit var optionsGroup: RadioGroup
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.question_fragment, container, false)

        // Inicializa el ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(QuestionViewModel::class.java)

        // Encuentra las vistas
        questionTextView = view.findViewById(R.id.question_text)
        optionsGroup = view.findViewById(R.id.options_group)
        submitButton = view.findViewById(R.id.submit_button)

        // Muestra la primera pregunta
        displayQuestion()

        // Configura el botón para enviar la respuesta
        submitButton.setOnClickListener {
            val selectedId = optionsGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedOptionIndex = optionsGroup.indexOfChild(view.findViewById(selectedId))
                val isCorrect = viewModel.isCurrentAnswerCorrect(selectedOptionIndex)

                // Aquí puedes manejar lo que sucede si la respuesta es correcta o incorrecta.
                // Por ejemplo, mostrar un Toast o cambiar a otro fragmento.
                // Luego, pasa a la siguiente pregunta.
                if (viewModel.hasMoreQuestions()) {
                    viewModel.moveToNextQuestion()
                    displayQuestion()
                } else {
                    // Manejo cuando se han terminado todas las preguntas, como mostrar el puntaje.
                }
            }
        }

        return view
    }

    private fun displayQuestion() {
        val currentQuestion = viewModel.getCurrentQuestion()
        questionTextView.text = currentQuestion.text

        optionsGroup.removeAllViews() // Limpiar las opciones previas

        currentQuestion.options.forEachIndexed { index, option ->
            val radioButton = RadioButton(requireContext()).apply {
                id = index // Asegúrate de dar un ID único
                text = option
            }
            optionsGroup.addView(radioButton)
        }
    }
}
