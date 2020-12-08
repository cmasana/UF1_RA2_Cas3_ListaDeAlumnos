import java.util.Locale;
import java.util.Scanner;

/**
 * Volem implementar una llista per guardar els cognoms dels alumnes de classe.
 * Hem de tenir un menú per poder provar les diverses operacions sobre la llista.
 *
 * @author Carlos Masana
 * @version 2.0
 * @since 25-11-2020
 */
public class Main {
    public static void main(String[] args) {
        /*
        Número máximo de apellidos en la lista
         */
        final int MAX = 15;

        /*
        Array con la lista de apellidos de los alumnos de clase
         */
        String[] listaAlumnos = new String[MAX];

        /*
        Controla el nº de elementos que se encuentran dentro del array
        */
        int contadorElementos = 0; // El 0 no hace falta si la parte de PRUEBAS está activa


        // PRUEBAS
        listaAlumnos[0] = "schwarzenegger";
        listaAlumnos[1] = "norris";
        listaAlumnos[2] = "stallone";
        listaAlumnos[3] = "lundgren";
        listaAlumnos[4] = "statham";
        listaAlumnos[5] = "rourke";
        listaAlumnos[6] = "willis";
        listaAlumnos[7] = "van damme";
        listaAlumnos[8] = "crews";
        listaAlumnos[9] = "masana";
        contadorElementos = 10;


        /*
        Almacena la opción seleccionada en el menú Principal
         */
        int opcion;

        /*
        Variable que permite salir de la aplicación
         */
        boolean exit = false;

        /*
        Permite ejecutar todas las sentencias mientras el valor de exit sea FALSE
         */
        while (!exit) {
            /*
            Muestra menú Principal y asigna la opción seleccionada
             */
            opcion = menuPrincipal();

            /*
            Permite ejecutar diferentes instrucciones según la opción seleccionada
             */
            switch (opcion) {
                case 1: // Insertar
                    /*
                    Asignamos un nuevo valor a contadorElementos para poder utilizarlo durante la ejecución del programa
                     */
                    contadorElementos = insertar(listaAlumnos, contadorElementos, MAX);
                    break;
                case 2: // Localizar posición
                    localizar(listaAlumnos, contadorElementos);
                    break;
                case 3: // localizar elemento
                    recuperar(listaAlumnos, contadorElementos);
                    break;
                case 4: // Eliminar con posición
                    contadorElementos = suprimir(listaAlumnos, contadorElementos, MAX);
                    break;
                case 5: // Eliminar todos los elementos iguales
                    contadorElementos = suprimirDato(listaAlumnos, contadorElementos, MAX);
                    break;
                case 6: // Vaciar lista
                    contadorElementos = anular(contadorElementos);
                    break;
                case 7: // Mostrar primero o último
                    primeroUltimo(listaAlumnos, contadorElementos);
                    break;
                case 8: // Listar todos los elementos con su posición
                    imprimir(listaAlumnos, contadorElementos);
                    break;
                case 9: // Ordenar lexicográficamente
                    contadorElementos = ordenar(listaAlumnos, contadorElementos, MAX);
                    break;
                case 10:
                    /*
                    Cambiamos el valor a TRUE para Romper la ejecución del bucle y así salir de la aplicación
                     */
                    exit = true;
                    break;
                default: // Opción incorrecta
                    printText("Opción incorrecta!!");
                    break;
            }
        }
    }


    /**
     * Permite introducir un elemento en una determinada posición, ambos introducidos por el usuario
     *
     * @param lista             array de Strings
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     * @param longitudArray     entero que almacena la longitud máxima del array listaAlumnos
     * @return devuelve el valor actualizado de contadorElementos
     */
    public static int insertar(String[] lista, int contadorElementos, int longitudArray) {
        /*
        Almacena un apellido
         */
        String elemento;

        /*
        Almacena la posición (índice) de un determinado elemento
         */
        int posicion;

        /*
        Comprobación: Si la lista de alumnos está llena
         */
        if (contadorElementos == longitudArray) {
            printText("Error: La lista de apellidos está llena. \n");
        }
        /*
        Si hay hueco en la lista de apellidos
         */
        else {

            /*
            Mostramos mensaje y Asignamos el valor a la variable elemento
             */
            elemento = enterString("Introduce un apellido");

            /*
            Mostramos mensaje y Asignamos el valor a la variable posicion
             */
            posicion = enterInt("Introduce una posición");

            if (posicion < 0) {
                printText("Error: La posición tiene que ser mayor que 0. \n");

            } else if (posicion > contadorElementos) {
                printText("Error: La posición indicada es incorrecta. El valor indicado no puede sobrepasar " + contadorElementos + ". \n");
            /*
            Si lo anterior no se cumple, introducimos el elemento
             */
            } else {
                /*
                Desplazamos los elementos hacia la derecha desde la posición que hemos indicado
                 */
                for (int i = (longitudArray - 1); i > posicion; i--) {
                    lista[i] = lista[i - 1];
                }
                /*
                Finalmente, añadimos el elemento a la lista
                 */
                contadorElementos = addElemento(lista, elemento, posicion, contadorElementos);

                /*
                Mostramos lista actualizada
                 */
                imprimir(lista, contadorElementos);
            }
        }

        /*
        Devolvemos el valor de contadorElementos
         */
        return contadorElementos;
    }

    /**
     * Localiza la primera posición en la que se encuentra un determinado elemento introducido por el usuario
     *
     * @param lista             array de Strings con la lista de apellidos
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     */
    public static void localizar(String[] lista, int contadorElementos) {
        /*
        Permite mostrar un mensaje si el elemento no existe dentro del array
         */
        boolean encontrado = false;
        String elemento;

        /*
        Comprobación: Si la lista de apellidos está vacía
         */
        if (listaVacia(contadorElementos)) {
            printText("Error: No se puede buscar ningún elemento. La lista está vacía. \n");
        } else {
            elemento = enterString("Introduce un apellido para buscar");

            /*
            Recorremos el array, si uno de los valores concuerda con el valor que hemos introducido previamente,
            mostramos mensaje con resultado y asignamos a 'encontrado' el valor de TRUE para saltar la última
            comprobación.

            Con break, rompemos la ejecución del bucle, para mostrar únicamente la posición del primer elemento
            encontrado.
             */
            for (int i = 0; i < contadorElementos; i++) {
                if (lista[i].equals(elemento)) {
                    printText("Success: La posición del apellido " + elemento + " es: " + i + " \n");
                    encontrado = true;
                    break; // Rompe ejecución
                }
            }

            /*
            Si el elemento no se encuentra dentro del array se muestra un mensaje de error
             */
            if (!encontrado) {
                printText("Error: No se han encontrado coincidencias. \n");
            }
        }
    }

    /**
     * Muestra el elemento que se encuentra en la posición introducida por el usuario
     *
     * @param lista             array de Strings con la lista de apellidos
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     */
    public static void recuperar(String[] lista, int contadorElementos) {
        String elemento;
        int posicion;

        /*
        Comprobación: Si la lista de apellidos está vacía
         */
        if (listaVacia(contadorElementos)) {
            printText("Error: No se puede buscar ningún elemento. La lista está vacía. \n");
        } else {
            posicion = enterInt("Introduce una posición para buscar");
            elemento = lista[posicion];

            /*
            Comprobación: Si el elemento no es null
             */
            if (elemento != null) {
                printText("Success: El elemento de la posición " + posicion + " es " + elemento + " \n");
            } else {
                printText("Error: No se han econtrado coincidencias. \n");
            }
        }
    }

    /**
     * Elimina de la lista de alumnos el elemento de la posición introducida por el usuario
     *
     * @param lista             array con la lista de elementos
     * @param contadorElementos entero que contabiliza el nº de elementos que contiene el array
     * @param longitudArray     máximo de elementos que puede contener el array
     * @return devuelve el contador de elementos con su nuevo valor
     */
    public static int suprimir(String[] lista, int contadorElementos, int longitudArray) {
        int posicion;

        /*
        Comprobación: Si la lista de apellidos está vacía
         */
        if (listaVacia(contadorElementos)) {
            printText("Error: No se puede suprimir ningún valor. La lista está vacía. \n");
        } else {
            posicion = enterInt("Introduce una posición a eliminar");

            /*
            Comprobación: Si la posición no existe dentro de la lista
             */
            if (!existePosicion(posicion, contadorElementos)) {
                printText("Error: La posición indicada no existe dentro de la lista. \n");
            } else {
                /*
                Cuando se trabaja con arrays no se pueden eliminar valores, para simularlo
                lo que hacemos es mover hacia la izquierda todos los valores posteriores a la posición
                que queremos eliminar y el último valor como aparecerá duplicado le asignamos un NULL

                Inicializamos 'i' con el valor de la 'posicion' para que los valores anteriores no se vean afectados
                La condición tiene que ser 'i' menor que la longitudArray - 1 porque sino al intentar
                eliminar el último valor del array nos tira un ArrayBoundException ya que estaríamos intentando
                asignar un valor de un índice que no existe
                Incrementamos el valor de 'i' de 1 en 1 para ir recorriendo y asignando todos los valores posteriores
                a la posicion indicada por el usuario
                 */
                for (int i = posicion; i < (longitudArray - 1); i++) {
                    lista[i] = lista[i + 1];
                }

                /*
                Como ahora el último valor estaría duplicado, lo que hacemos es reiniciarlo y asignarle el valor de NULL
                 */
                lista[longitudArray - 1] = null;

                /*
                Para finalizar, restamos 1 al contador de elementos
                 */
                contadorElementos--;

                /*
                Mostramos mensaje
                 */
                printText("Success: El elemento de la posición " + posicion + " se ha eliminado correctamente. \n");
            }
        }

        return contadorElementos;
    }

    /**
     * Elimina de la lista todos los elementos que son iguales al indicado
     *
     * @param lista             array con la lista de apellidos de alumnos
     * @param contadorElementos entero que contabiliza el nº de elementos que contiene el array
     * @param longitudArray     máximo de elementos que puede contener el array
     * @return devuelve el contador de elementos con su nuevo valor
     */
    public static int suprimirDato(String[] lista, int contadorElementos, int longitudArray) {
        String elemento;

        if (listaVacia(contadorElementos)) {
            printText("Error: No se puede suprimir ningún valor. La lista está vacía. \n");
        } else {
            elemento = enterString("Introduce un elemento a eliminar");

            if (!existeElemento(lista, elemento, contadorElementos)) {
                printText("Error: No existe ningún elemento con ese nombre. \n");
            } else {

                /*
                Necesitamos comprobar 1 a 1 todos los elementos que se encuentran dentro del array
                 */
                for (int i = 0; i < contadorElementos; i++) {

                    /*
                    Si alguno de los elementos concuerda con el introducido por el usuario
                    Asignamos el índice a la posición para ubicarlo dentro del array
                     */
                    if (elemento.equals(lista[i])) {
                        /*
                        Vamos reasignando los valores posteriores del array a la posición indicada
                        para simular la eliminación de cada uno de ellos
                         */
                        for (int k = i; k < (longitudArray - 1); k++) {
                            lista[k] = lista[k + 1];
                        }

                        /*
                        Eliminamos el último valor en cada iteración del bucle principal
                         */
                        lista[longitudArray - 1] = null;

                        /*
                        Restamos 1 al contador de elementos en cada iteración del bucle principal
                         */
                        contadorElementos--;

                        /*
                        Restamos 1 a la variable de control del primer bucle. De esta manera se volverá a realizar la
                        iteración sobre la posición introducida
                         */
                        i--;
                    }
                }
                printText("Success: Elemento " + elemento + " eliminado correctamente. \n");
            }
        }

        return contadorElementos;
    }

    /**
     * Permite vaciar la lista de apellidos
     *
     * @param contadorElementos permite contabilizar el nº de apellidos que se encuentran dentro del array
     * @return devuelve el valor actualizado de contadorElementos
     */
    public static int anular(int contadorElementos) {
        if (listaVacia(contadorElementos)) {
            printText("Error: La lista ya se encuentra vacía. \n");
        } else {
            /*
            Para vaciar el array, simplemente cambiamos el valor del contador a 0
             */
            contadorElementos = 0;

            /*
            Mostramos mensaje
             */
            printText("Success: Se han eliminado todos los elementos correctamente. \n");
        }

        return contadorElementos;
    }

    /**
     * Permite visualizar el primer o el último elemento de la lista de apellidos
     *
     * @param lista             array con la lista de apellidos de alumnos
     * @param contadorElementos permite contabilizar el nº de apellidos que se encuentran dentro del array
     */
    public static void primeroUltimo(String[] lista, int contadorElementos) {
        String elemento;
        int opcion;
        boolean exit = false;

        /*
        Comprobación: Si el array no contiene ningún valor
         */
        if (listaVacia(contadorElementos)) {
            printText("Error: No se puede mostrar ningún valor. La lista está vacía. \n");
        } else {
            while (!exit) {
                /*
                Muestra menú Primero/Último y asigna la opción seleccionada
                */
                opcion = menuFirstLast();

                switch (opcion) {
                    case 1: // Muestra primer elemento
                        elemento = lista[0];
                        printText("El primer elemento es: 0. " + elemento);
                        break;
                    case 2: // Muestra último elemento
                        elemento = lista[contadorElementos - 1];
                        printText("El último elemento es: " + (contadorElementos - 1) + ". " + elemento);
                        break;
                    case 3: // Atrás
                        exit = true;
                        break;
                    default: // Opción incorrecta
                        printText("Opción incorrecta");
                        break;
                }
            }
        }
    }


    /**
     * Imprime todos los elementos de la lista de alumnos con su correspondiente posición
     *
     * @param lista             array de Strings con los apellidos de los alumnos
     * @param contadorElementos entero que permite contabilizar el nº de apellidos que se encuentran dentro del array
     */
    public static void imprimir(String[] lista, int contadorElementos) {
        if (listaVacia(contadorElementos)) {
            printText("Error: No se puede imprimir ningún valor. La lista de apellidos está vacía. \n");
        } else {
            for (int i = 0; i < contadorElementos; i++) {
                printText(i + ". " + lista[i]);
            }
            printText("\n");
        }
    }

    /**
     * Permite ordenar lexicográficamente los elementos de la lista
     *
     * @param lista             array de Strings con los apellidos de los alumnos
     * @param contadorElementos entero que permite contabilizar el nº de apellidos que se encuentran dentro del array
     */
    public static int ordenar(String[] lista, int contadorElementos, int longitudArray) {
        int posicion;
        /*
        Almacena el valor del elemento menor cuando se comparan 2 elementos
         */
        String mayor;

        /*
        Cuando su valor cambia a TRUE permite salir del menú secundario
         */
        boolean exit = false;

        /*
        Almacena la opción seleccionada en el menú secundario de Ordenar
         */
        int opcion;

        if (listaVacia(contadorElementos)) {
            printText("Error: No se puede ordenar una lista sin elementos. \n");
        } else {
            /*
            Asignamos a 'i' el valor de 0 para que empiece a recorrer el array desde el primer valor, mientras el valor
            de 'i' sea menor que el nº de elementos dentro del array se ejecutará el bucle, de esta manera podremos
            comparar el primer elemento con el resto.

            En el segundo bucle, asignamos a 'k' el segundo valor del array. La condición del bucle es igual que el del
            primero, de esta manera se van realizando todas las iteraciones hasta que ya no quedan más elementos en el
            array por comparar.

            Si la condición del 'if' es verdadera, quiere decir que el primer valor es mayor, por lo que lo asignamos a
            la variable 'mayor' para así poder hacer uso de ella más tarde. Los valores intercambian su posición y así
            se van comparando unos con otros. Es un poco rollo de explicar, lo documentaré con un dibujo para que sea
            más fácil de entender.
             */
            for (int i = 0; i < contadorElementos; i++) {
                for (int k = i + 1; k < contadorElementos; k++) {
                    /*
                    Al utilizar el metodo compareTo entre un string y otro da como resultado un nº entero
                    Si el resultado es mayor que 0: el primer string es mayor que el segundo
                    Si el resultado es 0: ambas cadenas son iguales
                    Si el resultado es menor que 0: el primer string es menor que el segundo
                     */
                    if (lista[i].compareTo(lista[k]) > 0) {
                        /*
                        Asignamos el string más grande a la variable mayor
                         */
                        mayor = lista[i];

                        /*
                        El valor menor intercambia la posición con el mayor
                         */
                        lista[i] = lista[k];

                        /*
                        Asignamos a la siguiente posición el mayor, para ir ordenando (de menor a mayor)
                         */
                        lista[k] = mayor;
                    }
                }
            }

            /*
            Mostramos mensaje por pantalla
             */
            printText("Success: La lista de alumnos ha sido ordenada exitosamente. \n");

            /*
            Muestra un menú secundario, después de que la lista de apellidos ha sido ordenada lexicográficamente
             */
            while (!exit) {
                /*
                Muestra menú Ordenar y asigna la opción seleccionada
                 */
                opcion = menuOrdenar();

                switch (opcion) {
                    case 1: // Localizar en lista ordenada
                        posicion = localizarOrdenada(lista, contadorElementos);
                        printText(mensajePosicion(posicion));
                        break;
                    case 2: // Eliminar desde lista ordenada
                        contadorElementos = suprimirDato(lista, contadorElementos, longitudArray);
                        break;
                    case 3: // Mostrar lista ordenada
                        imprimir(lista, contadorElementos);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default: // Opción incorrecta
                        printText("Opción incorrecta");
                        break;
                }
            }
        }
        return contadorElementos;
    }

    /**
     * Localiza la primera posición en la que se encuentra un determinado elemento introducido por el usuario
     * en una lista ordenada
     *
     * @param lista             array de Strings con la lista de apellidos
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     * @return devuelve un número, si es negativo el elemento no se encuentra en la lista, en cualquier otro caso
     * devuelve la posición exacta del elemento introducido por el usuario
     */
    public static int localizarOrdenada(String[] lista, int contadorElementos) {
        int izquierda = 0;
        int derecha = contadorElementos - 1;
        String elemento;
        elemento = enterString("Introduce un apellido para buscar");

        /*
        Al utilizar el metodo compareTo entre un string y otro da como resultado un nº entero
        Si el resultado es mayor que 0: el primer string es mayor que el segundo
        Si el resultado es 0: ambas cadenas son iguales
        Si el resultado es menor que 0: el primer string es menor que el segundo
         */
        while (izquierda <= derecha) {
            int mitad = izquierda + (derecha - izquierda) / 2;

                /*
                Compara un elemento con el que se encuentra en la posición indicada
                 */
            int resultado = elemento.compareTo(lista[mitad]);

                /*
                Comprobamos si el elemento se encuentra en el medio
                 */
            if (resultado == 0) {
                return mitad;
            }

                /*
                Si el resultado es mayor que 0, ignoramos la mitad izquierda
                ya que el elemento es mayor que el resto de los primeros valores
                 */
            else if (resultado > 0) {
                izquierda = mitad + 1;
            }
                /*
                Si el resultado es menor que 0, ignoramos la mitad derecha
                ya que el elemento es menor que el resto de valores
                 */
            else {
                derecha = mitad - 1;
            }
        }
        return -1;
    }

    /**
     * Muestra un mensaje en función de si se ha encontrado o no un determinado elemento
     * (Usado SOLO para la función ordenar() y relacionado con localizarOrdenada() )
     *
     * @param posicion entero que almacena la posición de un determinado elemento
     * @return devuelve mensaje de error si la posición es incorrecta o mensaje de éxito si es correcta
     */
    public static String mensajePosicion(int posicion) {
        String mensaje;

        if (posicion < 0) {
            mensaje = "Error: No se han encontrado coincidencias. \n";
        } else {
            mensaje = "Success: Elemento encontrado en la posición " + posicion + ". \n";
        }
        return mensaje;
    }


    /**
     * Permite añadir un elemento dentro de la lista de alumnos
     *
     * @param lista             array con la lista de alumnos
     * @param elemento          string que almacena el apellido de un alumno
     * @param posicion          entero que indica la ubicación de un elemento dentro de la lista
     * @param contadorElementos entero que contabiliza el número de elementos que contiene la lista
     * @return devuelve el valor actualizado de contadorElementos
     */
    public static int addElemento(String[] lista, String elemento, int posicion, int contadorElementos) {
        /*
        Añadimos elemento al array en la posición indicada
         */
        lista[posicion] = elemento;

        /*
        Incrementamos en 1 el número de elementos del array
         */
        contadorElementos++;

        /*
        Mostramos mensaje
         */
        printText("Success: El elemento ha sido insertado correctamente. \n");
        /*
        Devolvemos valor de contador actualizado
         */
        return contadorElementos;
    }


    /*
    MÉTODOS INPUT/OUTPUT
     */

    /**
     * Imprime cada elemento de un Menú y añade un número (desde 1 en adelante)
     *
     * @param menu array de Strings con los textos de cada menú
     */
    public static void printMenu(String[] menu) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
        }
    }


    /**
     * Muestra por pantalla un determinado mensaje
     *
     * @param mensaje texto que queremos mostrar por pantalla
     */
    public static void printText(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Permite al usuario introducir un número entero desde consola
     *
     * @return un numero entero
     */
    public static int enterInt(String mensaje) {
        Scanner consola = new Scanner(System.in);
        String digito;
        int numero;

        printText(mensaje);

        do {
            digito = consola.next();
        } while (digito.isEmpty());

        numero = Integer.parseInt(digito);

        return numero;
    }

    /**
     * Permite al usuario introducir un String desde consola
     *
     * @return una cadena de caracteres
     */
    public static String enterString(String mensaje) {
        Scanner consola = new Scanner(System.in);
        String texto;

        printText(mensaje);

        do {
            texto = consola.nextLine().toLowerCase(); // Lo pasamos a minúsculas
        } while (texto.isEmpty());

        return texto;
    }

    /*
    COMPROBACIONES
     */

    /**
     * Permite saber si la lista contiene algún elemento o está vacía
     *
     * @param contadorElementos entero que contabiliza el nº de elementos que contiene el array
     * @return devuelve TRUE si la lista está vacía y FALSE si contiene algún elemento
     */
    public static boolean listaVacia(int contadorElementos) {
        boolean vacio;

        /*
        Asigna a variable vacío el resultado de la operación
         */
        vacio = (contadorElementos == 0);

        return vacio;
    }

    /**
     * Permite conocer si un elemento existe dentro de la lista
     *
     * @param lista             array con la lista de apellidos de los alumnos
     * @param busqueda          elemento para realizar la busqueda
     * @param contadorElementos entero que contabiliza el nº de elementos que contiene el array
     * @return devuelve un valor boolean, si el elemento existe devuelve TRUE, si no existe devuelve FALSE
     */
    public static boolean existeElemento(String[] lista, String busqueda, int contadorElementos) {
        boolean existe = false;

        for (int i = 0; i < contadorElementos; i++) {
            if (busqueda.equals(lista[i])) {
                existe = true;
                break;
            }
        }

        return existe;
    }

    /**
     * Permite conocer si una posición existe dentro de la lista
     *
     * @param posicion          elemento para realizar la busqueda
     * @param contadorElementos entero que contabiliza el nº de elementos que contiene el array
     * @return devuelve un valor boolean, si el elemento existe devuelve TRUE, si no existe devuelve FALSE
     */
    public static boolean existePosicion(int posicion, int contadorElementos) {
        boolean existe = false;
        for (int i = 0; i < contadorElementos; i++) {
            if (posicion == i) {
                existe = true;
                break;
            }
        }

        return existe;
    }


    /*
    MENUs DE LA APLICACIÓN
     */

    /**
     * Permite al usuario interactuar con el menú principal de la aplicación
     *
     * @return Devuelve la opción seleccionada por el usuario
     */
    public static int menuPrincipal() {
        /*
        Almacena la opción seleccionada por el usuario
         */
        int opcion;

        /*
        Array que describe cada una de las opciones del menú
         */
        String[] menu = {
                "Insertar un apellido en la lista",
                "Localizar la posición de un apellido",
                "Localizar un apellido",
                "Eliminar un apellido",
                "Eliminar todos los apellidos iguales",
                "Vaciar la lista de apellidos",
                "Mostrar primer/último apellido",
                "Listar apellidos con su posición",
                "Ordenar la lista de apellidos",
                "Salir"
        };

        /*
        Muestra por pantalla las opciones del menú
         */
        printMenu(menu);

        /*
        Permite al usuario introducir una de las opciones disponibles
         */
        opcion = enterInt("Escoge una opción;");

        /*
        Devuelve la opción seleccionada
         */
        return opcion;
    }

    /**
     * Permite al usuario interactuar con el menú secundario Primero/Último de la aplicación
     *
     * @return Devuelve la opción seleccionada por el usuario
     */
    public static int menuFirstLast() {
        int opcion;
        /*
        Menú secundario para primer y último apellido en la lista
        */
        String[] menuPrimeroUltimo = {
                "Muestra primer apellido de la lista",
                "Muestra último apellido de la lista",
                "Atrás"
        };

        /*
        Muestra las opciones del menú por pantalla
         */
        printMenu(menuPrimeroUltimo);

        /*
        Muestra mensaje al usuario y asigna la opcion seleccionada
         */
        opcion = enterInt("Escoge una opción: ");

        return opcion;
    }

    /**
     * Permite al usuario interactuar con el menú secundario Ordenar de la aplicación
     *
     * @return Devuelve la opción seleccionada por el usuario
     */
    public static int menuOrdenar() {
        int opcion;
        /*
        Menú secundario para hacer gestiones en la lista ordenada
         */
        String[] menuOrdenar = {
                "Busqueda en lista ordenada de apellidos",
                "Eliminar apellidos desde lista ordenada",
                "Muestra la lista ordenada de apellidos",
                "Atrás"
        };

        /*
        Muestra las opciones del menú por pantalla
         */
        printMenu(menuOrdenar);

        /*
        Mostrar mensaje al usuario para introducir una nueva opción
         */
        opcion = enterInt("Escoge una opción: ");

        return opcion;
    }
}
