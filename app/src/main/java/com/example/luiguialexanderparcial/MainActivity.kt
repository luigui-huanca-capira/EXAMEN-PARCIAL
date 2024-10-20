/**
 * Parcial - Práctica de Programación Orientada a Objetos en Kotlin
 * Descripción: La clase MainActivity es la actividad principal del proyecto. Esta clase
 *              inicializa y gestiona la navegación entre los fragmentos a través del
 *              NavController y NavHostFragment. Se encarga de cargar el layout principal
 *              y de iniciar el controlador de navegación del proyecto.
 * Autor: Luigui Alexander Huanca Capira
 * Fecha creación: 20/10/2024
 * Fecha última modificación: 20/10/2024
 */
package com.example.luiguialexanderparcial

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa el NavController con el NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}
