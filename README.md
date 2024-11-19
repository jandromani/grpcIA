# Gestión de Solicitudes y Aprobaciones

Este proyecto es una aplicación de gestión de solicitudes y aprobaciones diseñada con una arquitectura moderna de microservicios. El sistema incluye funcionalidades avanzadas como auditoría, asignación de aprobadores, priorización, integración con IA, generación de reportes y más. Es altamente escalable, modular y diseñado para ser probado fácilmente con herramientas como Postman o llamadas de consola.

---

## **Arquitectura**

### **1. Microservicios**
La aplicación está dividida en varios microservicios que interactúan entre sí a través de **Spring Cloud Gateway**, **Kafka** y **gRPC**.

#### **1.1. API Gateway**
- Actúa como punto de entrada para todas las peticiones.
- Enruta solicitudes a los microservicios correspondientes.
- Documentación centralizada con **Swagger**.

#### **1.2. Solicitud Service**
- Gestiona la creación, actualización y consulta de solicitudes.
- Maneja lógica de negocio clave como asignación de aprobadores, cancelación de solicitudes y auditoría.

  ![image](https://github.com/user-attachments/assets/169106ed-7912-4728-b2d8-a96ac2356fb8)


#### **1.3. Aprobación Service**
- Gestiona las reglas de aprobación dinámicas.
- Valida solicitudes basándose en reglas configurables.

#### **1.4. IA Service**
- Implementa lógica de IA para validación avanzada y análisis de datos.
- Desarrollado en **Python** con **Flask**.

#### **1.5. Config Server**
- Centraliza la configuración para todos los microservicios.
- Gestionado con **Spring Cloud Config**.

---

### **2. Comunicación**

#### **2.1. Kafka**
- Utilizado para la comunicación asincrónica entre servicios.
- **Tópicos configurados:**
  - `solicitud-events`: Eventos relacionados con cambios en las solicitudes.
  - `notificaciones`: Envío de notificaciones por cambios de estado.
 
    ![image](https://github.com/user-attachments/assets/20b6e3de-ac60-4e49-8723-3ecef30dd92e)


#### **2.2. gRPC**
- Protocolo de comunicación de alto rendimiento entre microservicios.
- Implementado en **Solicitud Service** y **Aprobación Service**.

![image](https://github.com/user-attachments/assets/6e811606-4425-47a3-b793-422b968895b8)


---

### **3. Persistencia**

#### **Base de Datos**
Cada microservicio utiliza una base de datos **PostgreSQL** independiente:
- `solicituddb` para el **Solicitud Service**.
- `aprobaciondb` para el **Aprobación Service**.

#### **Entidades Principales**
- **Solicitud**: Representa una solicitud creada por el usuario.
- **Aprobador**: Almacena información sobre aprobadores asignados.
- **Auditoria**: Registra acciones realizadas sobre una solicitud.
- **Rule**: Reglas dinámicas de aprobación.

---

### **4. Servicios Complementarios**
- **Notificaciones**: Integra Kafka para enviar notificaciones sobre cambios de estado.
- **Auditoría**: Registra todas las acciones realizadas sobre una solicitud.
- **IA y Análisis**: Proporciona inteligencia procesable para priorización, validación y reportes.

![image](https://github.com/user-attachments/assets/469f8981-154e-4e7f-be70-c63804afd8e2)

---

## **Funcionalidades**

1. **Gestión de Solicitudes**
   - Crear, actualizar y eliminar solicitudes.
   - Cambiar el estado de una solicitud: `PENDIENTE`, `APROBADA`, `RECHAZADA`, `CANCELADA`.

2. **Asignación Automática de Aprobadores**
   - Basado en reglas predefinidas como monto y tipo de solicitud.

3. **Auditoría**
   - Historial completo de cambios realizados en cada solicitud.
   - Consultable por ID.

4. **Notificaciones**
   - Notifica automáticamente a los usuarios cuando cambia el estado de una solicitud.

5. **Cancelación de Solicitudes**
   - Permite a los usuarios cancelar solicitudes pendientes.

6. **Priorización de Solicitudes**
   - Etiqueta solicitudes como `ALTA`, `MEDIA` o `BAJA` prioridad según criterios configurables.

7. **Reglas Dinámicas de Aprobación**
   - Los administradores pueden agregar, editar o eliminar reglas de aprobación.

8. **Reportes Automáticos**
   - Generación de reportes diarios con estadísticas clave.

9. **Validación Avanzada con IA**
   - Detecta inconsistencias o riesgos en las solicitudes antes de enviarlas a aprobadores.

10. **Análisis de Datos**
    - Analiza patrones en las solicitudes, como tasas de aprobación y rechazo.
![image](https://github.com/user-attachments/assets/2429b76b-86d6-4a7a-9636-acadbf6b43e8)

---

## **Tecnologías Utilizadas**
- **Java 17**: Lenguaje principal para los microservicios.
- **Spring Boot**: Framework para desarrollo rápido y modular.
- **Spring Cloud Gateway**: Para enrutamiento de APIs.
- **Kafka**: Comunicación asincrónica entre microservicios.
- **gRPC**: Protocolo de comunicación de alto rendimiento.
- **PostgreSQL**: Base de datos relacional para persistencia.
- **Python (Flask)**: Implementación de servicios de IA.
- **Docker**: Contenerización de servicios.
- **Swagger**: Documentación de APIs.

---

## **Pruebas**

### **1. Postman**
Usa los endpoints definidos para probar las funcionalidades principales.

**Ejemplos de endpoints:**
- `POST /api/solicitudes`: Crear una solicitud.
- `PUT /api/solicitudes/{id}/estado`: Cambiar el estado de una solicitud.
- `GET /api/solicitudes/{id}/historial`: Consultar auditoría de una solicitud.

---

### **2. Llamadas desde Consola**
**Ejemplo de prueba con `curl`:**
```bash
curl -X POST http://localhost:8080/api/solicitudes -H "Content-Type: application/json" -d '{
    "solicitante": "Juan Pérez",
    "detalle": "Compra de equipo",
    "monto": 5000
}'

## **Cómo Ejecutar**

### **1. Requisitos**
- Docker y Docker Compose.
- Java 17.
- Python 3.10.

### **2. Pasos**

1. **Clonar el repositorio:**
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd project-root

Construir los servicios:
mvn clean install

Levantar los contenedores:

docker-compose up --build


Acceder al API Gateway:

URL: http://localhost:8080


Contribuciones
Si deseas contribuir, abre un Pull Request (PR) o crea un Issue en el repositorio. ¡Toda colaboración es bienvenida!













