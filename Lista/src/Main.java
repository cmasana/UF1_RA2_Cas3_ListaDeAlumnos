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
        Scanner que permite introducir datos desde consola
         */
        Scanner consola = new Scanner(System.in);

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

        /*
        Entero que almacena la posición de un determinado elemento que se encuentra en el array
         */
        int posicion;

        /*
        Cadena de caracteres que almacena el apellido de un dterminado alumno
         */
        String elemento;

        /*
        Almacena la opción seleccionada en el menú
         */
        int opcion;

        /*
        Bucle que ejecuta una serie de sentencias mientras se cumple una determinada condición
         */
        do {
            /*
            Menú principal con opciones
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
            Imprime las opciones del menú principal
             */
            printMenu(menu);

            /*
            Opción seleccionada por el usuario
             */
            printText("Escoge una opción:");
            opcion = enterInt();

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
                    contadorElementos = localizar(listaAlumnos, contadorElementos);
                    break;
                case 3: // localizar elemento
                    System.out.println("Localizar un apellido");
                    break;
                case 4: // Eliminar con posición
                    System.out.println("Eliminar un apellido");
                    break;
                case 5: // Eliminar todos los elementos iguales
                    System.out.println("Eliminar todos los apellidos iguales");
                    break;
                case 6: // Vaciar lista
                    System.out.println("Vaciar la lista");
                    break;
                case 7: // Mostrar primero o último
                    do {
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

                        switch (opcion) {
                            case 1: // Muestra primer elemento
                                System.out.println("Muestra primer apellido de la lista");
                                break;
                            case 2: // Muestra último elemento
                                System.out.println("Muestra último apellido de la lista");
                                break;
                            case 3: // Salir
                                System.out.println("Atrás");
                                break;
                            default: // Opción incorrecta
                                System.out.println("Opción incorrecta");
                                break;
                        }
                    }
                    while (opcion != 3);
                    break;
                case 8: // Listar todos los elemntos con su posición
                    System.out.println("Listar apellidos con su posición");
                    break;
                case 9: // Ordenar lexicográficamente
                    System.out.println("Ordenar lista");
                    // TO-DO: Hay que mostrar lista ordenada

                    // IMPLEMENTAR ENTER PARA CONTINUAR
                    do {
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
                    System.exit(0);
                    break;
                default: // opción incorrecta
                    System.out.println("Opción incorrecta!!");
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
        String elemento;
        int posicion;

        printText("Introduce un apellido");
        elemento = enterString();

        printText("Introduce una posición");
        posicion = enterInt();

        /*
        Comprobación: Si en la posición introducida ya existe un valor almacenado
         */
        if (lista[posicion] != null) {
            printText("Error: La posición introducida está siendo utilizada.");

        /*
        Comprobación: Si el array está completo(lleno)
         */
        } else if (contadorElementos == lista.length) {
            printText("Error: El array está lleno.");

        /*
        Comprobación: Si la posición introducida es mayor que 0, comprobamos que el valor de la posición anterior no sea
        null
         */
        } else if (posicion > 0 && lista[posicion - 1] == null) {
            printText("Error: La posición anterior no contiene valores.");

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
        }

        /*
        Mostramos array por pantalla
         */
        printArrayNum(lista);

        /*
        Devolvemos el valor de contadorElementos
         */
        return contadorElementos;
    }

    /**
     * Localiza la primera posición en la que se encuentra un dterminado elemento introducido por el usuario
     *
     * @param lista array de Strings con la lista de apellidos
     * @param contadorElementos entero que permite contabilizar el nº de elementos introducidos en el array
     * @return devuelve el valor actualizado de contadorElementos
     */
    public static int localizar(String[] lista, int contadorElementos) {
        boolean status = false;
        String elemento;
        int posicion;

        printText("Introduce un apellido para buscar");
        elemento = enterString();

        for (int i = 0; i < contadorElementos; i++) {
            if (lista[i].equals(elemento)){
                posicion = i;
                printText("La posición del apellido " + elemento + " es: " + posicion);
                status = true;
                break; // Rompe la ejecución del bucle cuando encuentra el primer valor
            }
        }

        if (!status) {
            printText("No se han encontrado coincidencias!!");
        }
        return contadorElementos;
    }

    /**
     * Imprime cada elemento de un array (formato con números)
     * @param array array de Strings
     */
    public static void printArrayNum(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(i + ". " + array[i]);
            }
        }
    }

    /**
     * Imprime cada elemento de un array (formato sin números)
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
     * Muestra por pantalla un texto
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
}
