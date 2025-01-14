# Biblioteca Atena 

### Problemática
En muchas bibliotecas, la gestión de libros físicos y los procesos asociados, como el préstamo y la devolución, se realizan de manera manual o con sistemas obsoletos, lo que genera ineficiencias operativas, falta de control sobre el inventario, acceso limitado a la información y riesgos de seguridad en la protección de datos. Estos problemas se traducen en errores frecuentes, dificultades para localizar libros, pérdida de recursos y una gestión ineficaz del personal y los materiales. Para solucionar estas deficiencias, se propone desarrollar un sistema de gestión bibliotecaria móvil, diseñado exclusivamente para dispositivos Android, que automatice los procesos de registro y control de libros, proporcionando a los trabajadores y administradores una plataforma eficiente.

### Solución
Para abordar estos problemas, se propone el desarrollo de un sistema de gestión bibliotecaria móvil, diseñado específicamente para ser utilizado en dispositivos Android. Este sistema proporcionará las siguientes soluciones:

* Automatización y Eficiencia: El sistema permitirá a los trabajadores registrar la entrada y salida de libros, así como los préstamos y devoluciones, de manera digital y automatizada, eliminando la necesidad de procesos manuales y reduciendo significativamente los errores.

* Control Centralizado y Transparencia: El sistema ofrecerá a los administradores una visión centralizada del inventario de libros.

* Acceso Móvil y Flexibilidad: Diseñado para dispositivos móviles, el sistema permitirá a los trabajadores y administradores realizar sus tareas desde cualquier lugar dentro de la biblioteca, proporcionando acceso en tiempo real a la información del inventario y permitiendo una gestión más ágil y flexible.

### Objetivo del Proyecto

El objetivo principal es optimizar y automatizar los procesos bibliotecarios, desde la catalogación y gestión de recursos hasta los préstamos y devoluciones, al centralizar la información y automatizar tareas repetitivas, estos sistemas liberan al personal bibliotecario para que se concentre en tareas de mayor valor añadido, como la atención al usuario y la promoción de la lectura. Además, ofrecen a los usuarios una experiencia más eficiente y satisfactoria, permitiéndoles buscar y encontrar los recursos que necesitan de forma rápida y sencilla.


## Análisis: Definición de requerimientos. 

### Requisitos Funcionales

#### RF1: Registro de Clientes: 
+ Descripción: El sistema ofrecer a los trabajadores la capacidad de crear nuevos usuarios para entrega de libros.
+ Entrada: Datos de nuevo usuario (Nombre, documento de identificación, teléfono, correo electrónico).
+ Procesamiento: Ingreso de Información de las personas
+ Salida: Creación de nuevo usuario

#### RF2: Registro de Entrada de Libros:
+ Descripción: Permitir el registro de nuevos libros en la biblioteca.
+ Entrada: Detalles del libro (título, autor y categoría del libro).
+ Procesamiento: Almacenamiento de la información en la base de datos.
+ Salida: Confirmación del registro exitoso.

#### RF3: Gestión de Inventario:
+ Descripción: Permitir la consulta y actualización de la información de los libros disponibles.
+ Entrada: Consulta o actualización de datos.
+ Procesamiento: Búsqueda y modificación de registros en la base de datos.
+ Salida: Información actualizada sobre los libros.

#### RF4: Registro de Prestamos de Libros:
+ Descripción: Registrar la salida de libros prestados.
+ Entrada: Detalles del préstamo (libro, cantidad, cliente y fecha de préstamo).
+ Procesamiento: Almacenamiento de la información en la base de datos.
+ Salida: Confirmación del registro de salida.

#### RF5: Devolución de Libros:
+ Descripción: Registrar la devolución de libros.
+ Entrada: Detalles de la devolución (libro, cantidad, cliente, fecha de préstamo, fecha devolución).
+ Procesamiento: Actualización de la información en la base de datos.
+ Salida: Confirmación de la devolución.


### Requisitos No Funcionales

#### RNF1: Rendimiento:
+ El sistema debe ser capaz de procesar y responder a las solicitudes de los usuarios en un tiempo máximo de 2 segundos bajo condiciones normales de operación.
+ El sistema debe soportar al menos 10 usuarios concurrentes y transacciones sin degradación significativa en el rendimiento. 

#### RNF2: Seguridad:
+ Protección de la información almacenada.
+ Mecanismos de autenticación y autorización para usuarios del sistema.

#### RNF3: Compatibilidad:
+ La aplicación debe ser compatible con dispositivos Android, soportando versiones del sistema operativo desde Android 8.0 (Oreo) en adelante.
+ El sistema debe adaptarse correctamente a diferentes tamaños de pantalla de dispositivos móviles 

#### RNF4: Usabilidad:
+ Interfaz intuitiva y fácil de usar.
+ Capacitación mínima requerida para los operadores.


#### RNF5: Escalabilidad:
+ El sistema debe estar diseñado para soportar un crecimiento en el número de libros y usuarios sin necesidad de cambios significativos en la infraestructura


[Documentación IEEE 830](/Especificación%20de%20requisitos%20de%20software.pdf) 


## Diseño Base de Datos
#### Tabla de Clientes
| Campo      | Tipo              | Clave  | Descripción          |
|------------|-------------------|--------|----------------------|
| id         | INT               |  PK    | Identificador único  |
| nombre     | VARCHAR           |        | Nombre del cliente   |
| cedula     | VARCHAR           |        | Cedula del cliente   |
| telefono   | FLOAT             |        | Telefono del cliente |
| email      | VARCHAR           |        | Correo del cliente   |

#### Tabla de Libros
| Campo     | Tipo              | Clave  | Descripción              |
|-----------|-------------------|--------|--------------------------|
| id        | IN                |  PK    | Identificador único      |
| titulo    | VARCHAR           |        | Titulo del libro         |
| autor     | VARCHAR           |        | Autor del libro          |
| categoria | VARCHAR           |        | Categoria del libro      |



#### Tabla de Prestamos
| Campo           | Tipo       | Clave  | Descripción            |
|-----------------|------------|--------|------------------------|
| id              | INT        |  PK    | Identificador único    |
| estado          | VARCHAR    |        | Estado del Préstamo    |
| libroId         | INT        |  FK    | Llamado libro          |
| cantidad        | INT        |        | Cantidad de Libros     |
| clienteId       | INT        |  FK    | Llamado cliente        |
| fechaPrestamo   | TIMESTAMP  |        | Fecha préstamo libro   |
| fechaDevolucion | TIMESTAMP  |        | Fecha devolución libro |  


> Script de la Base de Datos

```sql
DROP DATABASE IF EXISTS Biblioteca;

    CREATE DATABASE Biblioteca;

    USE Biblioteca;

-- Tabla de Clientes
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL,
    cedula VARCHAR(50) NOT NULL,
    telefono FLOAT NOT NULL,
    email VARCHAR(100) NOT NULL
)

-- Tabla de Libros
CREATE TABLE libros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(200) NOT NULL,
    categoria VARCHAR(200) NOT NULL
);

-- Tabla de Prestamos
CREATE TABLE prestamos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    estado VARCHAR(100) NOT NULL,
    libroId INT NOT NULL,
    cantidad INT NOT NULL,
    clienteId INT NOT NULL,
    fechaPrestamo TIMESTAMP NOT NULL,
    fechaDevolucion TIMESTAMP,
    FOREIGN KEY (libroId) REFERENCES Libros(id),
    FOREIGN KEY (clienteId) REFERENCES Clientes(id)
);


```


## Diagramas UML
Estos diagramas proporcionarán una representación visual y comprensible de los diferentes componentes y flujos del sistema.

### Diagrama de Clases
El diagrama de clases modela la estructura estática del sistema, mostrando las clases, sus atributos, métodos y las relaciones entre ellas.

![Diagrama de Clases](Imagenes/Diagrama_Clases.png)

### Diagrama de Secuencias
El diagrama de secuencia ilustra cómo interactúan los diferentes objetos del sistema a lo largo del tiempo para llevar a cabo un proceso específico.

![Diagrama de Secuenias](Imagenes/Diagrama_Secuencias.png)

### Diagrama de Casos de Uso
El diagrama de casos de uso describe las interacciones entre los actores (Bibliotecario) y el sistema de parqueadero, destacando los principales casos de uso o funcionalidades.

![Diagrama de Casos](Imagenes/Diagrama_Casos.png)

## Mockup
El diseño de modelado se centra en la interfaz gráfica e interactiva desde la perspectiva del Bibliotecario. En él, se incluyen componentes como registros de usuarios y de libros, devoluciones y prestamos a clientes, entre otras cosas. Puedes encontrar la visualización respectiva en el siguiente enlace.

### [Link Modelado](https://temenico.my.canva.site/atena)
![Home](Layout%20Biblioteca%20Atena/HomePage.png)

## Ver Planificacion
La planificación del proyecto en el marco de trabajo para desarrollo ágil de Software Scrum, se puede ver en el siguiente enlace redireccionado a Trello y a las Especificaciones:

### | [Especificaciones](/Especificación%20de%20requisitos%20de%20software.pdf) | [Trello ](https://trello.com/b/TGdOl2lR/atenea) |

