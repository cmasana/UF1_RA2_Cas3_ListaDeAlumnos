# UF1 RA2 Cas3 ListaDeAlumnos

**Curso: ASIX1B**
**Autor: Carlos Masana Martínez**
**Fecha: 23/11/2020**

------



## 1. Descripción

Queremos implementar una lista para guardar los apellidos de los alumnos de clase. Tenemos que implementar la estructura de datos 'lista' en Java con arrays (no se puede utilizar la clase ArrayList). A mayores, necesitamos un menú para poder probar las diversas operaciones sobre la lista.

Dichas operaciones son:

- **Insertar:** Inserta un elemento x, en una posición p, de la lista, pasando los elementos de la posición p y siguientes a la posición inmediatamente posterior.
- **Localizar:** Localiza la primera posición p, en la que se encuentra un elemento x.
- **Recuperar:** Encuentra el elemento x que está en la posición p.
- **Suprimir:** Elimina de la lista el elemento de la posición p.
- **SuprimirDato:** Elimina de la lista cualquier ocurrencia del elemento x.
- **Anular:** Vaciar la lista.
- **PrimeroÚltimo:** Proporciona el primer o el último elemento de la lista.
- **Imprimir:** Imprime todos los elementos de la lista, del primero al último con su posición.

También añadiremos otra operación llamada:

- **Ordenar:** Ordena lexicográficamente los elementos de la lista.

Si conseguimos programar la operación Ordenar, podemos mejorar la implementación de las operaciones Localizar y SuprimirDato. Así que añadiremos las siguientes operaciones:

- **LocalizarEnOrdenada:** Localiza la primera posición p, en la que se encuentra un elemento x.
- **SuprimirDatoOrdenada:** Elimina de la lista cualquier ocurrencia del elemento x.



## 2. Funcionalidades aplicación

### 2.1 Menú

Para organizar cada una de las operaciones por separado he creado un menú mediante la sentencia **switch**. Esto proporciona una manera sencilla de estructurar nuestro código y probar las diferentes partes de nuestro código. Dependiendo del número introducido en nuestro terminal podremos ejecutar las diferentes partes del código individualmente.

Esta es su sintaxis básica:

```java
switch ( expresión ) {
 case constante1:
      // Sentencias a ejecutar
      break;
 case constanteN:
      // Sentencias a ejecutar
      break;
 default:
      // Sentencias a ejecutar
      break;
 }
```



### 2.2 Insertar

Esta operación permite introducir un elemento en una determinada posición, ambos introducidos por el usuario.

### 2.3 Localizar

### 2.4 Recuperar

### 2.5 Suprimir

### 2.6 SuprimirDato

### 2.7 Anular

### 2.8 PrimeroÚltimo

- ### 2.8.1 Primero

- ### 2.8.2 Último

### 2.9 Imprimir

### 2.10 Ordenar

- ### 2.10.1 LocalizarEnOrdenada

- ### 2.10.2 SuprimirDatoOrdenada