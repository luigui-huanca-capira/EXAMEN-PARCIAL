Juego de Preguntas y Respuestas
Este proyecto es una aplicación de preguntas y respuestas desarrollada en Kotlin para la plataforma Android. La aplicación permite a los usuarios responder una serie de preguntas sobre temas variados, obtener retroalimentación y visualizar su puntuación final. El proyecto sigue las mejores prácticas de programación orientada a objetos y está diseñado para ofrecer una experiencia de navegación fluida a través de diferentes pantallas (Fragments).

Requisitos del Proyecto
El proyecto está desarrollado utilizando Kotlin.
Se basa en la arquitectura de Android con Fragments para gestionar diferentes pantallas.
Implementa buenas prácticas de programación, tales como:
Modularidad: Cada fragmento y clase tiene una responsabilidad clara.
Cohesión: Las funcionalidades están bien organizadas, separando lógica de interfaz.
Git se utiliza para el control de versiones.
Funcionalidades
1. Pantalla de Bienvenida (WelcomeFragment)
La pantalla de bienvenida introduce al usuario al juego, proporcionando detalles como el tema de las preguntas y la cantidad total de preguntas. La pantalla cuenta con un botón de inicio que navega hacia el fragmento de preguntas.

2. Preguntas (QuestionFragment)
En esta pantalla, el usuario puede ver una pregunta generada dinámicamente desde una lista o arreglo. Cada pregunta tiene varias opciones de respuesta representadas por botones de opción (RadioButton o CheckBox). Una vez seleccionada una respuesta, el juego navega hacia el fragmento de retroalimentación.

3. Retroalimentación (AnswerFragment)
Después de seleccionar una respuesta, este fragmento indica si la respuesta fue correcta o incorrecta y ofrece una explicación detallada para educar al usuario. El usuario puede continuar con la siguiente pregunta o finalizar el juego.

4. Flujo del Juego
El flujo del juego es continuo y sin interrupciones:

Las preguntas se muestran una tras otra.
Al final del juego, se muestra una pantalla de resultados donde se indica la puntuación final obtenida.
El usuario tiene la opción de reiniciar el juego y empezar de nuevo.
5. Pantalla de Resultados (ResultsFragment)
Una vez finalizadas todas las preguntas, se presenta la puntuación final del usuario. El fragmento también ofrece un botón para reiniciar el juego, lo que restablece el puntaje y permite al usuario volver a la pantalla de bienvenida.

6. Aspectos Técnicos
Manejo del ciclo de vida de los Fragments: El juego conserva el estado incluso si se rota la pantalla o se cambia la orientación del dispositivo.
Código estructurado y comentado: Se han aplicado principios de programación orientada a objetos y de diseño limpio. Cada fragmento y clase tiene comentarios claros que describen su función.
Funcionalidad adicional: Se ha implementado una barra de progreso que muestra el avance del usuario a lo largo del juego, lo que mejora la experiencia de usuario.
Configuración del Entorno
1. Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instaladas las siguientes herramientas:

Android Studio
JDK 17
Gradle
2. Ruta del SDK
Debes cambiar la ruta del SDK de Android en el archivo local.properties para que coincida con la ubicación de tu SDK local. Para ello, edita el archivo con la siguiente línea:

properties
Copiar código
sdk.dir=/ruta/a/tu/sdk
3. Ejecución del Proyecto
Sigue estos pasos para ejecutar el proyecto:

Clona el repositorio:

bash
Copiar código
git clone https://github.com/tu_usuario/nombre_del_proyecto.git
Abre el proyecto en Android Studio.

Sincroniza el proyecto con Gradle.

Ejecuta la aplicación en un emulador o dispositivo físico desde Android Studio.

Control de Versiones
Este proyecto utiliza Git para gestionar el control de versiones. Puedes encontrar el repositorio del proyecto en el siguiente enlace: Repositorio en GitHub.
