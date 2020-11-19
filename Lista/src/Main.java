import java.util.Scanner;

/**
 * Volem implementar una llista per guardar els cognoms dels alumnes de classe.
 * Hem de tenir un menú per poder provar les diverses operacions sobre la llista.
 *
 * @author Carlos Masana
 */
public class Main {
    public static void main(String[] args) {
        /*
        Controla el nº de elementos que se encuentran dentro del array
        */
        int contadorElementos = 0;

        /*
        Número máximo de apellidos en la lista
         */
        final int MAX = 5;

        /*
        Array con la lista de apellidos de los alumnos de clase
         */
        String[] listaAlumnos = new String[MAX];

        listaAlumnos[0] = "masana";
        listaAlumnos[1] = "martinez";
        listaAlumnos[2] = "masana";
        listaAlumnos[3] = "nieto";
        listaAlumnos[4] = "masana";
        contadorElementos = 5;

        /*
        Almacena la opción seleccionada en el menú Principal
         */
        int opcion;

        /*
        Bucle que ejecuta una serie de sentencias mientras se cumple una determinada condición
         */
        do {
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
                    contadorElementos = insertar(listaAlumnos, contadorElementos);
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
                    contadorElementos = anular(listaAlumnos, contadorElementos);
                    break;
                case 7: // Mostrar primero o último
                    primeroUltimo(listaAlumnos,contadorElementos);
                    break;
                case 8: // Listar todos los elementos con su posición
                    imprimir(listaAlumnos);
                    break;
                case 9: // Ordenar lexicográficamente
                    System.out.println("Ordenar lista");
                    // TO-DO: Hay que mostrar lista ordenada

                    // IMPLEMENTAR ENTER PARA CONTINUAR
                    do {
                        /*
                        Muestra menú Ordenar y asigna la opción seleccionada
                         */
                        opcion = menuOrdenar();

                        switch (opcion) {
                            case 1: // Localizar en lista ordenada
                                System.out.println("Busqueda en lista ordenada de apellidos");
                                break;
                            case 2: // Eliminar desde lista ordenada
                                System.out.println("Eliminar apellidos desde lista ordenada");
                                break;
                            case 3: // Salir
                                System.out.println("Atrás");
                                break;
                            default: // Opción incorrecta
                                System.out.println("Opción incorrecta");
                                opcion = enterInt();
                                break;
                        }
                    }
                    while (opcion != 3);
                    break;
                case 10: // Salir
                    printText("Saliendo...");
                    System.exit(0);
                    break;
                default: // opción incorrecta
                    printText("Opción incorrecta!!");
                    break;
            }
        }

        while (opcion != 10);
    }


    /**
     * Permite introducir un elemento en una determinada posición, ambos introducidos por el usuario
     *
     * @param lista array de Strings
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     * @return devuelve el valor actualizado de contadorElementos
     */
    public static int insertar(String[] lista, int contadorElementos) {
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
        if (contadorElementos == lista.length) {
            printText("Error: La lista de apellidos está llena. \n");
        }
        /*
        Si hay hueco en la lista de apellidos
         */
        else {

            /*
            Mostramos mensaje
             */
            printText("Introduce un apellido");

            /*
            Asignamos el valor a la variable elemento
             */
            elemento = enterString();

            /*
            Mostramos mensaje
             */
            printText("Introduce una posición");

            /*
            Asignamos el valor a la variable posicion
             */
            posicion = enterInt();

            /*
            Comprobación: Si en la posición introducida ya existe un valor almacenado
             */
            if (lista[posicion] != null) {
                printText("Error: La posición introducida está siendo utilizada. \n");

            /*
            Comprobación: Si la posición introducida es mayor que 0, comprobamos que el valor de la posición anterior no
            sea null (no permitimos espacios vacíos entre cada valor)
             */
            } else if (posicion > 0 && lista[posicion - 1] == null) {
                printText("Error: La posición anterior no contiene valores. \n");

            /*
            Si lo anterior no se cumple, podemos introducir el valor en el array
             */
            } else {
                /*
                Añadimos elemento al array en la posición indicada
                 */
                lista[posicion] = elemento;

                /*
                Incrementamos en 1 el número de elementos del array
                 */
                contadorElementos++;

                /*
                Mostramos array por pantalla
                 */
                imprimir(lista);
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
     * @param lista array de Strings con la lista de apellidos
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     */
    public static void localizar(String[] lista, int contadorElementos) {
        /*
        Permite mostrar un mensaje si el elemento no existe dentro del array
         */
        boolean status = false;
        String elemento;
        int posicion;

        printText("Introduce un apellido para buscar");
        elemento = enterString();

        /*
        Recorremos el array, con contadorElementos tenemos el nº de elementos que han sido introducidos
        Si uno de los valores concuerda con el valor que hemos introducido previamente, asignamos valor de 'i' a
        posición, mostramos mensaje con resultado y asignamos a status el valor de TRUE para saltar la última
        comprobación.

        Con break, rompemos la ejecución del bucle // PREGUNTAR
         */
        for (int i = 0; i < contadorElementos; i++) {
            if (lista[i].equals(elemento)){
                posicion = i;
                printText("La posición del apellido " + elemento + " es: " + posicion + " \n");
                status = true;
                break; // Rompe la ejecución del bucle cuando encuentra el primer valor
            }
        }

        /*
        Si el elemento no se encuentra dentro del array se muestra un mensaje de error
         */
        if (!status) {
            printText("Error: No se han encontrado coincidencias. \n");
        }
    }

    /**
     * Muestra el elemento que se encuentra en la posición introducida por el usuario
     *
     * @param lista array de Strings con la lista de apellidos
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     */
    public static void recuperar(String[] lista, int contadorElementos) {
        /*
        Almacena un estado: TRUE si encuentra un elemento y FALSE si no lo encuentra
         */
        boolean status = false;
        String elemento;
        int posicion;

        printText("Introduce una posición para buscar");
        posicion = enterInt();

        /*
        Recorre el índice del array, si la posición y el índice concuerdan se asigna a elemento el valor correspondiente
        del array, se muestra un mensaje con el resultado y a status le asignamos el valor TRUE para que no muestre el
        mensaje de alerta
         */
        for (int i = 0; i < contadorElementos; i++) {
            if (i == posicion) {
                elemento = lista[i];
                printText("El elemento de la posición " + posicion + " es " + elemento + " \n");
                status = true;
            }
        }

        /*
        Si no encuentra un determinado elemento se muestra un mensaje por pantalla
        avisando de que no se han encontrado coincidencias
         */
        if (!status) {
            printText("Error: No se han encontrado coincidencias. \n");
        }
    }

    /**
     * Elimina de la lista de alumnos el elemento de la posición introducida por el usuario
     *
     * @param lista array con la lista de elementos
     * @param contadorElementos entero que contabiliza el nº de elementos que contiene el array
     * @param longitudArray máximo de elementos que puede contener el array
     * @return devuelve el contador de elementos con su nuevo valor
     */
    public static int suprimir(String[] lista, int contadorElementos, int longitudArray) {
        int posicion;

        /*
        Comprobación: Si la lista de apellidos está vacía
         */
        if (contadorElementos == 0) {
            printText("Error: No se puede suprimir ningún valor. La lista está vacía. \n");
        }
        else {
            printText("Introduce una posición a eliminar");
            posicion = enterInt();

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
        }

        return contadorElementos;
    }

    /**
     * Elimina de la lista todos los elementos que son iguales al indicado
     * @param lista array con la lista de apellidos de alumnos
     * @param contadorElementos entero que contabiliza el nº de elementos que contiene el array
     * @param longitudArray máximo de elementos que puede contener el array
     * @return devuelve el contador de elementos con su nuevo valor
     */
    public static int suprimirDato(String[] lista, int contadorElementos, int longitudArray) {
        String elemento;
        int posicion;

        if (contadorElementos == 0) {
            printText("Error: No se puede suprimir ningún valor. La lista está vacía. \n");
        }
        else {
            printText("Introduce un elemento a eliminar");
            elemento = enterString();

            /*
            Necesitamos comprobar 1 a 1 todos los elementos que se encuentran dentro del array
             */
            for (int i = 0; i < contadorElementos; i++) {

                /*
                Si alguno de los elementos concuerda con el introducido por el usuario
                Asignamos el índice a la posición para ubicarlo dentro del array
                 */
                if (elemento.equals(lista[i])) {
                    posicion = i;

                    /*
                    Vamos reasignando los valores posteriores del array a la posición indicada
                    para simular la eliminación de cada uno de ellos
                     */
                    for (int k = posicion; k < (longitudArray - 1); k++) {
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
                }
            }
        }

        return contadorElementos;
    }

    /**
     * Permite vaciar la lista de apellidos
     *
     * @param lista array con la lista de apellidos de alumnos
     * @param contadorElementos permite contabilizar el nº de apellidos que se encuentran dentro del array
     * @return devuelve el valor actualizado de contadorElementos
     */
    public static int anular(String[] lista, int contadorElementos) {
        if (contadorElementos == 0) {
            printText("Error: La lista ya se encuentra vacía. \n");
        } else {
            /*
            Recorremos cada una de las posiciones del array y vamos asignando el valor NULL a cada una de ellas
            Cada vez que se asigna el valor NULL hay que restar 1 al contador de Elementos
             */
            for (int i = 0; i < contadorElementos; i++) {
                lista[i] = null;
                contadorElementos--;
            }
        }

        return contadorElementos;
    }

    /**
     * Permite visualizar el primer o el último elemento de la lista de apellidos
     *
     * @param lista array con la lista de apellidos de alumnos
     * @param contadorElementos permite contabilizar el nº de apellidos que se encuentran dentro del array
     */
    public static void primeroUltimo(String[] lista, int contadorElementos) {
        String elemento;
        int opcion;

        /*
        Comprobación: Si el array no contiene ningún valor
         */
        if (contadorElementos == 0) {
            printText("Error: El array está vacío. \n");
        }
        else {
            do {
            /*
            Muestra menú Primero/Último y asigna la opción seleccionada
            */
            opcion = menuFirstLast();

            switch (opcion) {
                case 1: // Muestra primer elemento
                    elemento = lista[0];
                    printText("El primer elemento es: " + elemento);
                    break;
                case 2: // Muestra último elemento
                    elemento = lista[contadorElementos - 1];
                    printText("El último elemento es: " + elemento);
                    break;
                default: // Opción incorrecta
                    printText("Opción incorrecta");
                    break;
                }
            }
            while (opcion != 3);
        }
    }


    /**
     * Imprime todos los elementos de la lista de alumnos con su correspondiente posición
     * 
     * @param lista array de Strings
     */
    public static void imprimir(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                printText(i + ". " + lista[i]);
            }
        }
    }



    /*
    MÉTODOS INPUT/OUTPUT
     */

    /**
     * Imprime cada elemento de un Menú y añade un número (desde 1 en adelante)
     *
     * @param array array de Strings
     */
    public static void printMenu(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println((i + 1) + ". " + array[i]);
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
    public static int enterInt() {
        Scanner consola = new Scanner(System.in);
        String digito;
        int numero;

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
    public static String enterString() {
        Scanner consola = new Scanner(System.in);
        String texto;

        do {
            texto = consola.nextLine();
        } while (texto.isEmpty());

        return texto;
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
        Muestra un mensaje indicándole al usuario que introduzca una opción
         */
        printText("Escoge una opción:");

        /*
        Permite al usuario introducir una de las opciones disponibles
         */
        opcion = enterInt();

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
        String [] menuPrimeroUltimo = {
                "Muestra primer apellido de la lista",
                "Muestra último apellido de la lista",
                "Atrás"
        };

        /*
        Muestra las opciones del menú por pantalla
         */
        printMenu(menuPrimeroUltimo);

        /*
        Muestra mensaje al usuario
         */
        printText("Escoge una opción: ");
        opcion = enterInt();

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
        String [] menuOrdenar = {
                "Busqueda en lista ordenada de apellidos",
                "Eliminar apellidos desde lista ordenada",
                "Atrás"
        };

        /*
        Muestra las opciones del menú por pantalla
         */
        printMenu(menuOrdenar);

        /*
        Mostrar mensaje al usuario para introducir una nueva opción
         */
        printText("Escoge una opción: ");
        opcion = enterInt();

        return opcion;
    }
}
