# Sistema de Agenda Telefónica

## Descripción
Crea un sistema que permita gestionar una agenda telefónica con las siguientes funcionalidades.

## Estructura del Contacto
Un contacto está definido por:
- Nombre (no puede estar vacío)
- Apellido (no puede estar vacío)
- Teléfono (no se valida formato)

**Nota:** Dos contactos se consideran iguales si tienen el mismo nombre y apellido (case insensitive).

## Estructura de la Agenda
- Compuesta por un conjunto de contactos
- Se puede crear de dos formas:
   1. Indicando tamaño máximo
   2. Usando tamaño por defecto (10 contactos)

## Validaciones Importantes
- Nombres y apellidos no pueden estar vacíos
- No se permiten contactos duplicados (mismo nombre y apellido)

## Funcionalidades

### `añadirContacto(Contacto c)`
- Añade un contacto a la agenda
- Validaciones:
   - Si no hay espacio: mostrar "Agenda llena"
   - Verificar que no exista contacto duplicado
   - Nombre/apellido no vacíos

### `existeContacto(Contacto c)`
- Verifica si un contacto ya existe en la agenda
- Comparación por nombre y apellido (ignorando teléfono)

### `listarContactos()`
- Muestra todos los contactos en formato:
- Ordenados alfabéticamente por nombre y apellido

### `buscaContacto(String nombre)`
- Busca contacto por nombre y apellido
- Si existe: muestra teléfono
- Si no existe: muestra "Contacto no encontrado"

### `eliminarContacto(Contacto c)`
- Elimina un contacto
- Muestra mensaje de éxito/fracaso
- Si no existe: indica al usuario

### `modificarTelefono(String nombre, String apellido, String nuevoTelefono)`
- Modifica teléfono de contacto existente
- Si no existe: muestra mensaje

### `agendaLlena()`
- Indica si la agenda está llena
- Muestra "No hay espacio disponible" si es el caso

### `espacioLibres()`
- Muestra cantidad de contactos que aún se pueden agregar
- Basado en el tamaño máximo definido

## Menú de Consola
Implementar un menú interactivo que permita probar todas estas funcionalidades.