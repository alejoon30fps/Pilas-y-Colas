# Pilas y Colas en Java

Este proyecto implementa estructuras de datos **Pila (Stack)** y **Cola (Queue)** en Java utilizando dos enfoques distintos:

1. **Arreglos dinámicos**
2. **Listas enlazadas**

Además, incluye un estudio empírico de rendimiento mediante un **benchmark** y la generación de **gráficas comparativas** para analizar la eficiencia de cada implementación.

---

## Estructura del proyecto

Pilas-y-Colas/
├── Ejercicios/
├── src/
│   └── main/
│       └── java/
│           ├── Array/         ← Implementaciones con arreglos dinámicos
│           ├── LinkedList/    ← Implementaciones con listas enlazadas
│           ├── Interfaces/    ← Definiciones de MyStack y MyQueue
│           └── Main/          ← Clase Benchmark y programa principal
├── results.csv               ← Resultados generados por el benchmark
├── stack_benchmark.png       ← Gráfica comparativa de pilas (ejemplo)
├── queue_benchmark.png       ← Gráfica comparativa de colas (ejemplo)
├── graficas_benchmark.py     ← Script Python para graficar los resultados
├── pom.xml                   ← Proyecto Maven (opcional)
├── README.md
└── LICENSE
