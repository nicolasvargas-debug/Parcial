# 🚲 RuedaCampus · Examen práctico

**Objetos y Estructuras de Datos · Programación Orientada a Objetos en Java**

| Datos de la evaluación | Detalle |
| --- | --- |
| Evaluación | Primer corte |
| Caso | Alquiler de bicicletas y patinetas en el campus |
| Duración | **60 minutos** |
| Modalidad | Parejas de dos estudiantes |
| Lenguaje y entorno | **Java 17 · Eclipse · Consola** |
| Pruebas | **JUnit 5 · Ocho pruebas obligatorias** |
| Recursos autorizados | Este enunciado y el proyecto base suministrado |
| Condición | **Sin ayudas externas:** no consultar apuntes, proyectos anteriores, Internet ni herramientas de IA. Pueden trabajar con su pareja. |
| Docente | Celso Javier Rodríguez Pizza |

### Datos de la pareja

| Integrante | Nombre completo | Código |
| --- | --- | --- |
| 1 | ______________________________ | __________________ |
| 2 | ______________________________ | __________________ |

**Fecha:** ____________________  
**Grupo:** ____________________

---

## 1. Contexto del problema

La universidad necesita un programa de consola para administrar el alquiler de una bicicleta y una patineta. El encargado debe poder cotizar un alquiler, registrar su inicio, registrar la devolución y guardar un comprobante en un archivo de texto. El programa debe impedir que se alquile un vehículo que ya está ocupado y que una operación rechazada modifique su disponibilidad.

Completen el proyecto **RuedaCampus**. Las tarifas y reglas son ficticias. La duración se ingresa como una cantidad entera de horas; no se utilizan fechas, relojes ni cálculo automático del tiempo transcurrido.

El programa tendrá **cuatro requerimientos funcionales**, un método `menu()` y un método `main()` que invoque al menú. El **RF1 tiene dos implementaciones del mismo método**, una en `Bicicleta` y otra en `Patineta`, porque se evalúa polimorfismo. Los constructores, getters y métodos de apoyo suministrados no constituyen requerimientos adicionales.

## 2. Proyecto base y trabajo pendiente

| Ubicación | Contenido suministrado | Trabajo de la pareja |
| --- | --- | --- |
| `src/mundo/Vehiculo.java` | Clase abstracta, código, disponibilidad, constructor, getters, setter y contrato de cotización. | Utilizarla sin modificarla. |
| `src/mundo/Bicicleta.java` | Herencia, constructor y tipo de vehículo. | Implementar y documentar RF1. |
| `src/mundo/Patineta.java` | Herencia, constructor y tipo de vehículo. | Implementar y documentar RF1. |
| `src/mundo/Comprobante.java` | Constructor, getters y `toString()` de un objeto con código, tipo, horas y total. | Utilizarla sin modificarla. |
| `src/mundo/GestorAlquileres.java` | `ArrayList<Vehiculo>`, catálogo inicial y método de búsqueda. | Implementar y documentar RF2, RF3 y RF4. |
| `src/interfaz/Principal.java` | Variables del menú, `Scanner`, `do-while`, `switch-case`, salida y captura de errores. | Completar las opciones 1 a 4 y el cuerpo de `main()`. |
| `test/pruebas/RuedaCampusTest.java` | Importaciones, `@BeforeEach`, ocho métodos de prueba pendientes y un lector de archivos auxiliar. | Implementar las ocho pruebas. |
| `lib` y `data` | JUnit y carpeta para los comprobantes. | Conservar ambas carpetas. |

El catálogo contiene **B01: Bicicleta** y **P01: Patineta**, inicialmente disponibles. `buscarVehiculo(codigo)` recorre el `ArrayList`, retorna la referencia al objeto encontrado y lanza `IllegalArgumentException` cuando el código no existe, incluido `null`. Los códigos se comparan exactamente, respetando mayúsculas y sin quitar espacios.

El esqueleto compila. Los métodos funcionales pendientes lanzan `UnsupportedOperationException` y las pruebas pendientes usan `fail(...)`. **Sustituyan esos marcadores por su implementación.**

## 3. Condiciones de implementación y documentación

- Conserven los paquetes, las clases, las firmas y el catálogo suministrados. Utilicen el `ArrayList` y el método de búsqueda existente; trabajen sobre los objetos que ya contiene.
- Implementen la lógica de cada RF en el método indicado de `mundo`. Las solicitudes de datos y los mensajes por consola pertenecen a `menu()`.
- Utilicen referencias de tipo `Vehiculo` para cotizar. El costo debe obtenerse mediante `calcularCosto(horas)`, aprovechando la implementación del objeto correspondiente.
- Las entradas de opciones y horas serán enteros. Sí deben manejar las opciones inexistentes y las situaciones de error expresamente descritas. No se exige manejar letras ingresadas en un campo numérico.
- En RF4, la ruta recibida será una cadena no nula. Para una escritura válida su carpeta existe. Los comprobantes no nulos recibidos contienen datos válidos.
- **Javadoc obligatorio:** completen la documentación de las cinco implementaciones: RF1 en ambas subclases y RF2 a RF4 en el gestor. Expliquen propósito, parámetros con sus tipos y unidades, retorno y excepciones aplicables. En los métodos `void`, describan el efecto y no utilicen `@return`.
- No se exige generar páginas HTML de Javadoc ni documentar adicionalmente el menú, `main()` o las pruebas.

---

## 4. Requerimientos funcionales

### RF1 · Cotizar un alquiler según el tipo de vehículo

**Método:** `public double calcularCosto(int horas)`  
**Clases:** `Bicicleta` y `Patineta`.

Recibe una duración entera positiva y retorna el costo total en pesos. Si `horas <= 0`, debe lanzar `IllegalArgumentException`. Cotizar **no modifica la disponibilidad**, incluso cuando el vehículo ya está alquilado.

| Vehículo | Regla de cobro |
| --- | --- |
| Bicicleta | Cada una de las primeras **2 horas** cuesta **$4.000**. Cada hora que exceda esas dos cuesta **$3.000**. Se acumulan los bloques. |
| Patineta | Cada hora cuesta **$6.000**. Si la duración es de **3 horas o más**, se descuenta el **10 % de todo el valor**. |

| Horas | Bicicleta | Patineta |
| --- | ---: | ---: |
| 1 | 4.000 | 6.000 |
| 2 | 8.000 | 12.000 |
| 3 | 11.000 | 16.200 |

**Retorna:** `double` con el total.  
**Javadoc:** documenten en cada subclase su regla de cobro, las horas, el retorno en pesos y la excepción.

### RF2 · Iniciar un alquiler

**Método:** `public void iniciarAlquiler(String codigo)`  
**Clase:** `GestorAlquileres`.

Busquen el vehículo usando el método suministrado. Si está disponible, cambien su disponibilidad a `false`. Si ya está alquilado, lancen `IllegalStateException`. Si el código no existe, dejen que se propague la excepción de la búsqueda.

La operación debe modificar el vehículo almacenado en el catálogo. Los demás vehículos conservan su estado. Si el inicio se rechaza, no cambien ninguna disponibilidad.

**Ejemplo:** iniciar B01 lo deja no disponible; intentar iniciarlo nuevamente produce `IllegalStateException`.

**Retorna:** no retorna un valor.  
**Javadoc:** documenten el código recibido, el cambio de estado y las excepciones por código inexistente o alquiler ya activo.

### RF3 · Finalizar un alquiler y obtener su comprobante

**Método:** `public Comprobante finalizarAlquiler(String codigo, int horas)`  
**Clase:** `GestorAlquileres`.

Busquen el vehículo y comprueben que está alquilado. Si está disponible, lancen `IllegalStateException`. Si el código no existe, propaguen la excepción de la búsqueda.

Obtengan el costo llamando a **`calcularCosto(horas)` sobre una referencia de tipo `Vehiculo`**. Construyan un `Comprobante` con el código y tipo del vehículo, las horas recibidas y el total calculado. Al finalizar correctamente, dejen el vehículo disponible y retornen el comprobante.

Con un vehículo alquilado, si las horas son inválidas, debe propagarse `IllegalArgumentException` y el vehículo **debe permanecer alquilado**. No liberen el vehículo antes de que el cálculo haya terminado correctamente.

**Ejemplo:** finalizar P01, previamente alquilada, con 3 horas retorna un comprobante con `P01`, `Patineta`, `3` y `16200.0`, y deja su disponibilidad en `true`.

**Retorna:** un objeto `Comprobante`.  
**Javadoc:** documenten parámetros, contenido del retorno, cambio de estado y excepciones.

### RF4 · Guardar un comprobante en texto

**Método:** `public void generarComprobante(Comprobante comprobante, String ruta) throws IOException`  
**Clase:** `GestorAlquileres`.

Recibe un comprobante y la ruta de salida. Si el comprobante es `null`, lancen `IllegalArgumentException` **antes de abrir el archivo**, conservando cualquier contenido anterior.

Utilicen `FileWriter` y `BufferedWriter` con **`try-with-resources`**. Escriban una sola línea con los cuatro campos separados por punto y coma, en este orden:

```text
codigo;tipo;horas;total
```

El archivo contiene los valores, sin encabezado. Utilicen la conversión normal de `double` al concatenar el total; por ejemplo:

```text
B01;Bicicleta;3;11000.0
```

Pueden terminar la línea con un salto de línea. Si el archivo ya existe, **sustituyan su contenido**. Propaguen `IOException` cuando falle una operación de archivo. Este RF no imprime por consola ni modifica vehículos.

**Retorna:** no retorna un valor.  
**Javadoc:** documenten ambos parámetros, formato, sobrescritura, efecto y excepciones.

---

## 5. Menú y punto de arranque

Completen las cuatro opciones pendientes de `menu()`:

| Opción | Interacción esperada |
| --- | --- |
| 1. Cotizar | Solicitar código y horas, buscar el vehículo, llamar a RF1 y mostrar el costo. |
| 2. Iniciar | Solicitar código, llamar a RF2 y confirmar el inicio. |
| 3. Finalizar | Solicitar código y horas, llamar a RF3, conservar el objeto retornado en `ultimoComprobante` y mostrarlo. |
| 4. Guardar | Pasar `ultimoComprobante` a RF4 con la ruta fija `./data/comprobante.txt` y confirmar la escritura. |
| 5. Salir | Terminar el ciclo y finalizar el programa. |

El último comprobante se reemplaza únicamente cuando otra finalización termina correctamente. Un error debe producir un mensaje y permitir continuar. Si todavía no existe un comprobante, la opción 4 debe mostrar el error correspondiente. El menú debe reaparecer después de cada operación y ante opciones inexistentes.

En **`main()` escriban únicamente la llamada a `menu()`**. Conserven el mismo gestor durante toda la interacción para mantener la disponibilidad entre opciones.

## 6. Ocho pruebas obligatorias con JUnit 5

Completen los ocho métodos suministrados. Utilicen aserciones que comprueben resultados observables. Cada prueba debe preparar su propio escenario; `@BeforeEach` ya crea un gestor nuevo. Para comparar costos usen una tolerancia de **0,01 pesos**.

| RF | Prueba válida | Prueba de rechazo |
| --- | --- | --- |
| RF1 | Cotizar B01 y P01 durante 3 horas mediante referencias `Vehiculo`: esperar 11000.0 y 16200.0. | Comprobar `IllegalArgumentException` con 0 horas en ambos tipos y con una duración negativa en al menos uno. |
| RF2 | Iniciar B01 y comprobar `disponible == false`. | Intentar iniciar B01 dos veces: esperar `IllegalStateException` y conservar `false`. |
| RF3 | Iniciar P01 y finalizar con 3 horas: comprobar los cuatro campos del comprobante y disponibilidad `true`. | Iniciar B01 y finalizar con 0 horas: esperar `IllegalArgumentException` y conservar disponibilidad `false`. |
| RF4 | Crear directamente un `Comprobante("B01", "Bicicleta", 3, 11000.0)`, guardarlo en la ruta de prueba y comprobar el texto completo con el lector suministrado. | Enviar `null` como comprobante y esperar `IllegalArgumentException`. |

El lector suministrado normaliza los saltos de línea y devuelve, para el ejemplo de RF4, la cadena **`"B01;Bicicleta;3;11000.0\n"`**. Las pruebas deben llamar a los métodos de `mundo`; no deben ejecutar el menú. No se exige crear pruebas para las clases de apoyo ni para `main()`.

## 7. Entrega

Entreguen un único archivo **`RuedaCampus_Apellido1_Apellido2.zip`** con el proyecto completo de Eclipse: código fuente, pruebas, configuración, `lib` y `data`. Registren los nombres y códigos de ambos integrantes en los comentarios de `Principal`.

En Eclipse, ejecuten `Principal` como **Java Application** y `RuedaCampusTest` como **JUnit Test**. El directorio de trabajo debe ser la raíz del proyecto. No se solicitan informe, capturas, diagrama UML ni evidencias de Git.

## 8. Criterios de calificación

| Componente | Máximo |
| --- | ---: |
| RF1 · Cotización por tipo de vehículo | 0,80 |
| RF2 · Inicio del alquiler | 0,80 |
| RF3 · Finalización y comprobante | 0,80 |
| RF4 · Archivo de texto | 0,80 |
| Menú e integración | 0,60 |
| Punto de arranque `main()` | 0,20 |
| Pruebas JUnit de los cuatro RF | 1,00 |
| **Total** | **5,00** |

Cada RF se distribuye en **0,55 por funcionamiento, 0,10 por implementación en el método indicado y separación de responsabilidades, y 0,15 por Javadoc**. RF1 incluye ambas subclases dentro de sus 0,80 puntos. JUnit asigna 0,25 por cada RF: 0,10 a la prueba válida, 0,10 a la de rechazo y 0,05 a la preparación y autonomía de sus escenarios.

Se reconoce cumplimiento parcial. Una prueba correctamente diseñada no pierde puntos de JUnit por detectar un error real en el RF. La sola presencia del código de apoyo suministrado no demuestra la implementación de los pendientes.
