# 🧩 Sudoku Resoluctor & Analyzer

> Aplicación desarrollada en **Java** capaz de resolver tableros de Sudoku y calcular la cantidad total de soluciones posibles mediante algoritmos de Backtracking.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Algorithm](https://img.shields.io/badge/Algorithm-Backtracking-red?style=for-the-badge)
![University Project](https://img.shields.io/badge/Project-UNGS-blue?style=for-the-badge)

## 📋 Descripción

Este proyecto fue desarrollado para la materia **Programación III** de la Licenciatura en Sistemas (UNGS). Su objetivo principal es implementar un motor lógico eficiente que no solo encuentre la solución a un tablero de Sudoku 9x9, sino que también explore el árbol de decisiones completo para determinar si un tablero tiene solución única, múltiples soluciones o ninguna.

La aplicación demuestra el dominio de **algoritmos recursivos** y técnicas de optimización lógica para reducir el tiempo de búsqueda en espacios de estados complejos.

## 🚀 Funcionalidades Principales

* **Resolución Automática:** Completa cualquier tablero válido respetando las reglas del Sudoku (filas, columnas y cuadrantes).
* **Contador de Soluciones:** Característica avanzada que recorre todas las ramas posibles para informar al usuario cuántas soluciones distintas existen para la configuración dada.
* **Validación de Reglas:** Verificación en tiempo real de restricciones lógicas.
* **Interfaz Gráfica:** (Si tu proyecto tiene interfaz, menciona aquí que permite la carga visual. Si es por consola, menciona "Interacción por consola").

## 🧠 Lógica del Algoritmo (Backtracking)

El núcleo del "resoluctor" utiliza **Backtracking** (vuelta atrás), una estrategia algorítmica para encontrar soluciones a problemas de satisfacción de restricciones:

1.  **Exploración:** Selecciona la primera celda vacía.
2.  **Hipótesis:** Prueba un número del 1 al 9.
3.  **Validación:** Verifica si el número es seguro en la posición actual.
4.  **Recursión:** Si es válido, avanza a la siguiente celda.
5.  **Retroceso:** Si llega a un camino sin salida, "deshace" el último movimiento (backtrack) y prueba el siguiente número.

🛠️ Tecnologías Utilizadas
Lenguaje: Java SE (Standard Edition).

Conceptos: Recursividad, Matrices Bidimensionales, Complejidad Algorítmica.

IDE: Eclipse / IntelliJ IDEA.

📸 Capturas de Pantalla

<img width="777" height="688" alt="Captura" src="https://github.com/user-attachments/assets/78de8e1a-0df4-4b97-befc-0caf098bf646" />
<img width="777" height="682" alt="Captura2" src="https://github.com/user-attachments/assets/9a34cf14-d371-4f8f-b1c2-8f5142037a04" />
<img width="780" height="688" alt="Captura3" src="https://github.com/user-attachments/assets/2cf1c65c-2d09-42c7-bc90-fcc0a8ddd9a3" />


👤 Autor
Mateo Damian Smicht

LinkedIn: www.linkedin.com/in/mateosmicht

Email: mateosmicht13@gmail.com

Desarrollado como proyecto académico en la Universidad Nacional de General Sarmiento (UNGS).
