# Parcial ARSW

## Descripción

Este proyecto tiene como objetivo implementar una solución práctica en la que se aplican principios de arquitectura de software, utilizando herramientas modernas y buenas prácticas de desarrollo. El proyecto incluye:

- Lógica de negocio distribuida
- Uso de patrones de diseño
- Integración de servicios web y APIs
- Persistencia de datos

## Tecnologías

- **Java** (Spring Boot)
- **Maven** para gestión de dependencias
- **Docker** (opcional para despliegue)
- **Git** para control de versiones

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Enigmus12/Parcial-Arsw.git
   ```

2. Ingresa al directorio del proyecto:
   ```bash
   cd Parcial-Arsw
   ```

3. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```

4. (Opcional) Corre la aplicación usando Docker:
   ```bash
   docker-compose up
   ```

## Uso

1. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```
2. Accede a la interfaz o endpoints desde tu navegador o cliente REST en: 
   ```
   http://localhost:8080/
   ```

## Estructura del Proyecto

```
Parcial-Arsw/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── pom.xml
├── README.md
└── ...
```

## Autores

- **Enigmus12** - [GitHub](https://github.com/Enigmus12)