# 🌳 Reto: Recorridos Recursivos en un Árbol Binario de Búsqueda (ABB)

<div align="center">

[![Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com/)
[![FISEI - UTA](https://img.shields.io/badge/Universidad-Técnica%20de%20Ambato-blue.svg)](https://www.uta.edu.ec/)
[![Status](https://img.shields.io/badge/Status-Completado-success.svg)]()

</div>

Proyecto desarrollado en **Java** para la asignatura de **Estructura de Datos** de la Carrera de Software en la **Universidad Técnica de Ambato (FISEI)**.

---

## 📋 Descripción del Reto
El objetivo principal de este proyecto es implementar los recorridos recursivos fundamentales sobre un **Árbol Binario de Búsqueda (ABB)** que administra matrículas de estudiantes. El programa genera una traza detallada utilizando una sangría basada en la profundidad de la pila de llamadas recursivas para los siguientes recorridos:
* **Preorden** (Raíz ➔ Izquierda ➔ Derecha)
* **Inorden** (Izquierda ➔ Raíz ➔ Derecha)
* **Posorden** (Izquierda ➔ Derecha ➔ Raíz)

---

## 🗂️ Estructura del Proyecto

```text
RetoRecorridos/
│
└── src/
    └── reto/
        ├── Estudiante.java      # Clase modelo (matrícula, cédula, nombre, ciclo)[cite: 1, 5]
        ├── NodoEstudiante.java  # Estructura del nodo con punteros izq/der[cite: 1, 4]
        └── RetoRecorridos.java  # Algoritmos recursivos, trazas y casos de prueba[cite: 1, 3]