# About documentation

## Tecnologías Utilizadas

En el desarrollo de la API dedicada a la gestión de encuestas, se tomaron decisiones fundamentales en cuanto a las tecnologías utilizadas, cada una desempeñando un papel específico para asegurar la eficiencia y la seguridad del sistema.

- *Lenguaje de Programación:* Se optó por utilizar el lenguaje de programación Java debido a su versatilidad y capacidad para construir aplicaciones escalables.

- *Framework:* La elección de Java facilita el desarrollo en conjunto con Spring Boot, un framework que proporciona una estructura ágil y modular para la construcción de aplicaciones Java, permitiendo una implementación rápida y eficiente de la API de encuestas.

- *Base de Datos Relacional:* Se seleccionó MySQL con el objetivo de mantener la integridad de los datos y la consistencia en un entorno donde la relación entre diferentes entidades es fundamental. MySQL ha demostrado ser una opción confiable y ampliamente utilizada en el ámbito de bases de datos relacionales.

- *Seguridad:* Para garantizar la seguridad, se implementó JSON Web Tokens (JWT) junto con Spring Security. JWT proporciona un mecanismo eficaz para la autenticación y autorización, permitiendo el intercambio seguro de información entre partes confiables. Spring Security, por su parte, es un marco de trabajo ampliamente utilizado que facilita la implementación de medidas de seguridad robustas en aplicaciones Java.

- *Migrador de Base de Datos:* Flyway se incorporó para gestionar los cambios en el esquema de la base de datos de manera controlada y coherente. Esto asegura que las actualizaciones de la base de datos sean manejadas de manera eficiente y sin interrupciones en el funcionamiento del sistema.

- *Documentación:* Swagger se utilizó para la documentación de la API debido a su capacidad para generar documentación interactiva y legible. Esto no solo facilita la comprensión de la API para desarrolladores, sino que también simplifica el proceso de consumo de los servicios, mejorando la interoperabilidad y la adopción del sistema en diferentes entornos. En conjunto, estas decisiones tecnológicas han sido clave para construir una API de encuestas sólida y fácil de mantener.

## Configuración y Requisitos del Entorno

Para implementar y ejecutar la API, se deben seguir ciertos pasos de configuración y asegurarse de contar con los requisitos del entorno necesarios.

1. *SDK de Java y Servidor MySQL:* Se necesita la instalación del SDK de Java junto a un servidor MySQL que ejecute este servicio para acceder a la base de datos.

2. *Postman:* Se usará Postman para probar el entorno.

3. *Configuración de Variables de Entorno:* Una vez dentro del proyecto, se requiere la configuración de variables de entorno con la URL de la base de datos, el usuario, la contraseña y el esquema.

## Instrucciones de Implementación

1. Inicie el servicio MySQL y cree una base de datos con el nombre 'survey_api'.

2. Ejecute el programa después de establecer las variables de entorno, las cuales son obligatorias para la ejecución correcta del proyecto.

3. Después de completar estos pasos, debería ver las tablas creadas en la base de datos y puede ejecutar la API con normalidad.