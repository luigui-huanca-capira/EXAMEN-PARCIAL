/**
 * Parcial - Práctica de Programación Orientada a Objetos en Kotlin
 * Descripción: La clase Question representa una pregunta dentro del juego. Esta clase
 *              utiliza un data class de Kotlin para almacenar el texto de la pregunta,
 *              una lista de opciones de respuesta, el índice de la respuesta correcta
 *              y una explicación de dicha respuesta.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 20/10/2024
 * Fecha última modificación: 20/10/2024
 */
package com.example.luiguialexanderparcial

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int,
    val explanation: String
)
