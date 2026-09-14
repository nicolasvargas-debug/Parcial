# 🚲 RuedaCampus · Proyecto base

**Java 17 · Eclipse · JUnit 5 · Examen en parejas de 60 minutos**

Lee **Examen_RuedaCampus.md** antes de completar los pendientes.

## Importar y ejecutar

1. En Eclipse, usa `File > Import > General > Existing Projects into Workspace`.
2. Selecciona `Select archive file` y el ZIP del esqueleto. Importa el proyecto.
3. Comprueba que el proyecto usa JavaSE-17. JUnit está incluido en `lib` y configurado.
4. Ejecuta `src/interfaz/Principal.java` con `Run As > Java Application`.
5. Ejecuta `test/pruebas/RuedaCampusTest.java` con `Run As > JUnit Test`, usando JUnit 5.

El directorio de trabajo de ambas ejecuciones debe ser la raíz de este proyecto.
Conserva la carpeta `data`; no necesitas conexión a Internet ni configurar Maven o Gradle.

## Estado inicial

El esqueleto compila. `main()` todavía no invoca al menú. Los cinco cuerpos pendientes
de los cuatro RF lanzan `UnsupportedOperationException`; los ocho tests contienen
`fail(...)` para recordar que deben implementarse.

## Archivos que debes completar

| Archivo | Pendientes |
| --- | --- |
| `src/mundo/Bicicleta.java` | RF1 y su Javadoc. |
| `src/mundo/Patineta.java` | RF1 y su Javadoc. |
| `src/mundo/GestorAlquileres.java` | RF2, RF3, RF4 y sus Javadocs. |
| `src/interfaz/Principal.java` | Opciones 1 a 4, llamada desde main y nombres de integrantes. |
| `test/pruebas/RuedaCampusTest.java` | Ocho pruebas. |

Los constructores, métodos de acceso, búsqueda y preparación de las pruebas están suministrados.
Completa las pruebas con escenarios propios y resultados esperados indicados en el enunciado.

## Entrega

Comprime el proyecto completo como `RuedaCampus_Apellido1_Apellido2.zip`.
Incluye código, pruebas, configuración de Eclipse, `lib` y `data`.
El enunciado y este proyecto son los únicos materiales autorizados durante la evaluación.
