/**
 * Parcial - Práctica de Programación Orientada a Objetos en Kotlin
 * Descripción: La clase QuestionViewModel gestiona el estado del juego de preguntas y respuestas.
 *              Mantiene el control sobre la lista de preguntas, la respuesta seleccionada por
 *              el usuario, el puntaje acumulado, y el índice de la pregunta actual. Proporciona
 *              funciones para validar las respuestas y avanzar a la siguiente pregunta.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 20/10/2024
 * Fecha última modificación: 20/10/2024
 */
package com.example.luiguialexanderparcial

import androidx.lifecycle.ViewModel

class QuestionViewModel : ViewModel() {

    private val questions: List<Question> = listOf(
        Question("¿Cuál es el primer videojuego de la historia?", listOf("Pong", "Tetris", "Mario", "Pacman"), 0, "El primer videojuego es Pong."),
        Question("¿En qué año se lanzó la consola PlayStation?", listOf("1994", "2000", "1985", "1990"), 0, "La PlayStation fue lanzada en 1994."),
        Question("¿Qué lenguaje de programación es usado para el desarrollo de Android?", listOf("Python", "Java", "C++", "Ruby"), 1, "El lenguaje principal para el desarrollo de Android es Java."),
        Question("¿Cuál es la capital de Francia?", listOf("Berlín", "Madrid", "París", "Lisboa"), 2, "La capital de Francia es París."),
        Question("¿Quién pintó la Mona Lisa?", listOf("Vincent Van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"), 2, "La Mona Lisa fue pintada por Leonardo da Vinci."),
        Question("¿Cuál es el planeta más cercano al sol?", listOf("Tierra", "Marte", "Mercurio", "Venus"), 2, "El planeta más cercano al sol es Mercurio."),
        Question("¿En qué año se descubrió América?", listOf("1492", "1500", "1600", "1700"), 0, "América fue descubierta en 1492."),
        Question("¿Cuál es el océano más grande del mundo?", listOf("Atlántico", "Índico", "Ártico", "Pacífico"), 3, "El océano más grande del mundo es el Pacífico."),
        Question("¿Quién es el autor de 'Cien años de soledad'?", listOf("Gabriel García Márquez", "Mario Vargas Llosa", "Julio Cortázar", "Jorge Luis Borges"), 0, "El autor de 'Cien años de soledad' es Gabriel García Márquez."),
        Question("¿Cuál es el elemento químico con símbolo 'O'?", listOf("Oro", "Oxígeno", "Osmio", "Ozono"), 1, "El elemento químico con símbolo 'O' es el Oxígeno.")
    )

    private var currentQuestionIndex = 0
    private var score = 0

    fun getCurrentQuestion(): Question {
        return questions[currentQuestionIndex]
    }

    fun isCurrentAnswerCorrect(selectedAnswer: Int): Boolean {
        val correct = selectedAnswer == questions[currentQuestionIndex].correctAnswer
        if (correct) score++
        return correct
    }

    fun getCurrentQuestionExplanation(): String {
        return questions[currentQuestionIndex].explanation
    }

    fun getCurrentQuestionIndex(): Int {
        return currentQuestionIndex
    }

    fun hasMoreQuestions(): Boolean {
        return currentQuestionIndex < questions.size - 1
    }

    fun moveToNextQuestion() {
        if (hasMoreQuestions()) {
            currentQuestionIndex++
        }
    }

    fun resetGame() {
        currentQuestionIndex = 0
        score = 0
    }

    fun getScore(): Int {
        return score
    }
}
