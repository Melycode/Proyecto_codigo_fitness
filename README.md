# 🏋️‍♂️ Proyecto Código Fitness - Gestión de Gimnasio

## 📝 Descripción del Proyecto
**Código Fitness** es una aplicación diseñada para la gestión integral de un gimansio. El sistema permite administrar de manera eficiente tanto al personal como los servicios ofrecidos, asegurando un flujo de trabajo profesional y realista.

---

## 👥 Equipo de Desarrollo
* **Alba Ruiz de la Vega**
* **Melissa Frida Guerrero Carnero**
* **Brandon David Chusgo Piaco**

---

## 📊 Cumplimiento de la Rúbrica

### 1. Estructura y Modelado
* **Jerarquía de Clases:** Implementación de **11 clases** totales, incluyendo **2 clases padre** (`Persona` y `Servicio`) y **9 clases hijas**.
* **Instanciación en Main:** Se han creado **18 objetos** (2 por cada clase hija) para validar la lógica del sistema.
* **Encapsulamiento:** Todas las clases disponen de constructores completos/vacíos, getters, setters y sobrescritura de los métodos `equals`, `hashCode` y `toString`.
* **Tipos de Datos:** Uso exhaustivo de tipos primitivos, y **Enumerados**.

### 2. Estructuras de Control y Colecciones
* **Colecciones Dinámicas:** Uso de **ArrayList** y **HashSet** en clases como `Inscripcion`, `Empleado` y `Clase`.
* **Diccionarios (Mapas):** Implementación de **2 HashMaps** para el control de estados en `Maquina` y el historial de cuotas en `Recepcionista`.
* **Operaciones CRUD:** Métodos específicos en cada clase para **añadir, buscar, borrar y modificar** elementos de las colecciones.
* **Lógica de Flujo:** El `Main` ejecuta **4 bucles** y **4 estructuras condicionales**, incluyendo un bloque `switch`.
### 3. Gestión de Errores y Calidad
* **Excepciones Propias:** Se han definido **4 excepciones personalizadas** lanzadas y capturadas mediante bloques `try-catch`:
    * `CapacidadMaximaException`: Control de aforo.
    * `ClienteNoEncontradoException`: Errores de búsqueda.
    * `PagoYaRealizadoException`: Control de duplicidad en cobros.
    * `SaldoInsuficienteException`: Validación de transacciones.
* **Pruebas Unitarias:** Cobertura de tests JUnit para las clases principales, incluyendo **5 casos negativos** para validar el comportamiento ante errores.

### 4. Interfaz y Persistencia
* **Persistencia JSON:** Uso de la librería **JSON** para la lectura y escritura del historial de inscripciones en el fichero `inscripciones.json`.
* **Interfaz Gráfica (GUI):** Implementación de una **Calculadora de IMC** mediante la librería `javax.swing`, accesible de forma opcional al finalizar la ejecución por consola.

---

> **Nota:** El sistema de entrada por consola utiliza `.toLowerCase()` y `.trim()` para garantizar que la interacción del usuario sea fluida y resistente a errores de escritura 🗿.
