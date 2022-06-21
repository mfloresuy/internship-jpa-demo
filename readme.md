# Introducción a Spring JPA

## Instalación de docker PostgreSQL

Para instalar un contenedor con una instancia de PostgreSQL ejecutar
```
docker run -p 5432:5432 --name postgress -e POSTGRES_PASSWORD=1234 -e POSTGRES_USER=user -d postgres
```
POSTGRES_USER es el usuario con el que nos vamos a conectar
POSTGRES_PASSWORD es el password