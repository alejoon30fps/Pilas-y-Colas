# Pilas y Colas en Java

Este proyecto implementa estructuras de datos **Pila (Stack)** y **Cola (Queue)** en Java utilizando dos enfoques distintos:

1. **Arreglos dinámicos**
2. **Listas enlazadas**

Además, incluye un estudio empírico de rendimiento mediante un **benchmark** y la generación de **gráficas comparativas** para analizar la eficiencia de cada implementación.

---

## Estructura del proyecto

Pilas-y-Colas/
├── src/
│ └── main/
│ └── java/
│ ├── Array/ ← Implementaciones con arreglos dinámicos
│ ├── LinkedList/ ← Implementaciones con listas enlazadas
│ ├── Interfaces/ ← Definiciones de MyStack y MyQueue
│ └── Main/ ← Clase Benchmark y programa principal
├── results.csv ← Resultados generados por el benchmark
├── stack_benchmark.png ← Gráfica comparativa de pilas
├── queue_benchmark.png ← Gráfica comparativa de colas
└── README.md

yaml
Copiar código

---

## Compilación y ejecución

### Requisitos
- **Java 8 o superior**
- (Opcional) **Python 3** con librerías `pandas` y `matplotlib` para graficar

### 1. Compilar el proyecto
Desde la raíz del repositorio (donde está la carpeta `src/`):

**En PowerShell:**
```bash
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
En Linux/Mac:

bash
Copiar código
find src -name "*.java" > sources.txt
javac -d out @sources.txt
2. Ejecutar el benchmark
bash
Copiar código
java -cp out Main.Benchmark
Al finalizar, el programa genera el archivo results.csv con los tiempos de ejecución de cada estructura.

Generación de gráficas
Para visualizar los resultados del benchmark:

Instala las dependencias necesarias:

bash
Copiar código
pip install pandas matplotlib
Ejecuta el script de graficación (por ejemplo, graficas_benchmark.py):

bash
Copiar código
python graficas_benchmark.py
