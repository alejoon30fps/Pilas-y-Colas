import pandas as pd
import matplotlib.pyplot as plt

# Cargar los datos
df = pd.read_csv("results.csv")

# Convertir a milisegundos para que sea más legible
df["time_ms"] = df["time_ns"] / 1e6

# === GRAFICAR Y GUARDAR PILAS ===
plt.figure()
stack_data = df[df["operation"] == "pushpop"]
for struct in stack_data["structure"].unique():
    subset = stack_data[stack_data["structure"] == struct]
    plt.plot(subset["N"], subset["time_ms"], marker="o", label=struct)

plt.title("Benchmark de Pilas (push/pop)")
plt.xlabel("Tamaño de entrada (N)")
plt.ylabel("Tiempo (ms)")
plt.legend()
plt.grid(True)
plt.xscale("log")  # Escala logarítmica para N
plt.savefig("stack_benchmark.png", dpi=300)
plt.show()
plt.close()

# === GRAFICAR Y GUARDAR COLAS ===
plt.figure()
queue_data = df[df["operation"] == "enqueuedequeue"]
for struct in queue_data["structure"].unique():
    subset = queue_data[queue_data["structure"] == struct]
    plt.plot(subset["N"], subset["time_ms"], marker="o", label=struct)

plt.title("Benchmark de Colas (enqueue/dequeue)")
plt.xlabel("Tamaño de entrada (N)")
plt.ylabel("Tiempo (ms)")
plt.legend()
plt.grid(True)
plt.xscale("log")
plt.savefig("queue_benchmark.png", dpi=300)
plt.show()
plt.close()
