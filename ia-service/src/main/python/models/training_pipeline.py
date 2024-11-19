import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
import joblib

# Cargar datos de ejemplo
def cargar_datos():
    data = pd.read_csv("data/solicitudes.csv")  # Supón un CSV con historial de solicitudes
    return data

# Entrenar modelo
def entrenar_modelo():
    datos = cargar_datos()
    X = datos[["monto", "tipo_solicitud"]]
    y = datos["estado_aprobado"]  # 1 = aprobado, 0 = rechazado

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
    modelo = RandomForestClassifier()
    modelo.fit(X_train, y_train)

    # Guardar modelo
    joblib.dump(modelo, "modelos/random_forest.pkl")
    print("Modelo entrenado y guardado.")

if __name__ == "__main__":
    entrenar_modelo()
