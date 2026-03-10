# GUÍA DEL EQUIPO

## 1. Descripción del proyecto

Este proyecto consiste en desarrollar un sistema de reservación de habitaciones de hotel en Java, por consola y sin dependencias externas.

El sistema debe permitir:

- crear reservas
- verificar disponibilidad de habitaciones
- mostrar habitaciones existentes
- validar conflictos entre reservas

El proyecto debe estar organizado aplicando principios SOLID y preparado para trabajo en equipo con GitHub.

---

## 2. Restricciones del proyecto

- No usar Maven
- No usar Gradle
- No usar frameworks
- No usar dependencias externas
- Todo debe estar en español, excepto la clase `Main`
- El sistema debe funcionar en memoria

---

## 3. Arquitectura resumida

El proyecto se organizará por paquetes:

- `hotel`: punto de entrada
- `hotel.modelo`: entidades y enums del sistema
- `hotel.repositorio`: almacenamiento en memoria
- `hotel.servicio`: lógica del negocio
- `hotel.controlador`: interacción por consola
- `hotel.utilidad`: utilidades de apoyo

### Estructura general

```text
sistema-reservas-hotel/
├── README.md
├── .gitignore
├── GUIA_EQUIPO.md
├── GUIA_GITHUB.md
└── src/
    └── hotel/
        ├── Main.java
        ├── controlador/
        ├── modelo/
        ├── repositorio/
        ├── servicio/
        └── utilidad/