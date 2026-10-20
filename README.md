# Proyecto Final Desarrollo de Interfaces: Gestión SmartOcupation

## Descripción del Proyecto

Aplicación de escritorio desarrollada como proyecto final para la asignatura **Desarrollo de Interfaces** (Técnico Superior en Desarrollo de Aplicaciones Multiplataforma, DAM).

El objetivo fue construir una herramienta **usable** para los empleados de la empresa inmobiliaria **SmartOcupation**, permitiendo la gestión y consulta eficiente del histórico de alquileres y la generación de informes a demanda.

---

## Funcionalidades Clave Implementadas

* **Arquitectura MVC y DAO:** Separación estricta de la lógica de negocio (`AlquilerDAO`) de la interfaz de usuario (`VentanaPrincipal`).
* **Visualización Centralizada:** Uso de un único `JFrame` con una tabla `JTable` para mostrar el listado de alquileres, poblado mediante consultas **`INNER JOIN`** para asegurar la legibilidad de los datos (mostrando nombres y códigos de referencia en lugar de IDs).
* **Filtro Dinámico (Usabilidad):** Búsqueda avanzada de alquileres por rango de fechas, utilizando el componente externo **`JDateChooser`** (JCalendar) para facilitar la entrada de fechas.
* **Reporting (RA 5. CE h):** Generación de informes en PDF a demanda, imprimiendo el listado filtrado de la tabla mediante `JTable.print()`.
* **Calidad del Software:** Validación de la lógica de acceso a datos (métodos de consulta) mediante **Pruebas Unitarias (JUnit 5)**.

---

## Tecnologías y Requisitos

| Categoría | Tecnología | Versión/Patrón |
| :--- | :--- | :--- |
| **Frontend/UI** | Java Swing | `JFrame`, `JTable`, `DefaultTableModel`. |
| **Backend/Persistencia** | MySQL | 8.0+ (Utilizando `DECIMAL` y `utf8mb4_spanish_ci`). |
| **Conectividad** | JDBC | `mysql-connector-j`. |
| **Componente Externo** | JCalendar | `JDateChooser` (Integración de JavaBean). |
| **IDE** | Apache NetBeans | Uso de GUI Builder. |

## Guía de Ejecución Local (Setup)

Para clonar y ejecutar el proyecto en su entorno local:

### 1. Configuración de la Base de Datos

1.  Asegúrese de que el servidor **MySQL** esté en ejecución.
2.  Cree el esquema (base de datos) con el nombre: **`smart_ocupation_db`**.
3.  Ejecute el script SQL con los comandos `CREATE TABLE` y los comandos **`INSERT`** (seed data) para poblar las tablas (`Cliente`, `Vivienda`, `Alquiler`).

### 2. Configuración de Dependencias

1.  Descargue las librerías **`mysql-connector-j-X.X.X.jar`** y **`jcalendar-X.X.X.jar`**.
2.  En Apache NetBeans, añada ambos archivos `.jar` a las **Libraries** (Classpath) del proyecto.
3.  Copie `db.properties.example` como `db.properties` (en la raíz del proyecto) y ponga sus credenciales de MySQL. Este archivo está en `.gitignore`, así que las credenciales nunca se suben al repositorio. También puede usar las variables de entorno `DB_URL`, `DB_USER` y `DB_PASSWORD`.

### 3. Ejecución

* Ejecute la clase principal: **`vista.VentanaPrincipal.java`**.
* La aplicación intentará conectarse y cargar el histórico de alquileres automáticamente.

---
