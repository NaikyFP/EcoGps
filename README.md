EcoGPS es una aplicación Android que ayuda a los usuarios a encontrar puntos de reciclaje y áreas verdes cercanas utilizando el GPS.

Características

- Visualización de puntos de reciclaje cercanos.
- Seguimiento de áreas verdes.
- Funciones de navegación.

Los cambios realizados para la 2 tarea han sido la creacion de funciones
para controlar los logs de del lifecycle de la aplicación.

Añadir las dependencias necesarias rom

Configuracion del AndroidManifest.xml modificando el nombre de la app
Declarar los permisos de acceso a internet de lectura y escritura de almacenamiento
La orientación de la pantalla de manera "portrait" (vertical) de manera fija.

Tarea 3

-Los cambios realizados son crear la base de datos creando una función abstracta con el dao

-Inicializar la base de datos en EcoGpsApplication

-Creamos el ViewModel y lo ponemos como el MainScreen

-Conectamos el ViewModel con el MainActivity