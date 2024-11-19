from flask import Flask, request, jsonify
import joblib

app = Flask(__name__)

# Cargar modelo entrenado
modelo = joblib.load("modelos/random_forest.pkl")

@app.route("/predecir", methods=["POST"])
def predecir():
    data = request.json
    monto = data.get("monto")
    tipo_solicitud = data.get("tipo_solicitud")

    # Realizar predicción
    prediccion = modelo.predict([[monto, tipo_solicitud]])
    return jsonify({"aprobado": bool(prediccion[0])})

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=5000)
