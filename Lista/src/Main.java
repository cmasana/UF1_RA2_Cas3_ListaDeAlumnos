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
        Número máximo de apellidos en la lista
         */
        final int MAX = 5;

        /*
        Array con la lista de apellidos de los alumnos de clase
         */
        String [] listaAlumnos = new String[MAX];

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
            String [] menu = {
                    "(1) Insertar un apellido en la lista",
                    "(2) Localizar la posición de un apellido",
                    "(3) Localizar un apellido",
                    "(4) Eliminar un apellido",
                    "(5) Eliminar todos los apellidos iguales",
                    "(6) Vaciar la lista de apellidos",
                    "(7) Mostrar primer/último apellido",
                    "(8) Listar apellidos con su posición",
                    "(9) Ordenar la lista de apellidos",
                    "(0) Salir"
            };

            /*
            Imprime las opciones del menú principal
             */
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }

            /*
            Opción seleccionada por el usuario
             */
            System.out.println("Escoge una opción:");
            opcion = consola.nextInt();

            /*
            Menú con las opciones a realizarse
             */
            switch (opcion) {
                case 1: // Insertar
                    System.out.println("Insertar un apellido en la lista");
                    break;
                case 2: // Localizar posición
                    System.out.println("Localizar la posición de un apellido");
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
                                "(1) Muestra primer apellido de la lista",
                                "(2) Muestra último apellido de la lista",
                                "(3) Atrás"
                        };

                        /*
                        Bucle que muestra las opciones del menú por pantalla
                         */
                        for (int i = 0; i < menuPrimeroUltimo.length; i++) {
                            System.out.println(menuPrimeroUltimo[i]);
                        }

                        /*
                        Muestra mensaje al usuario
                         */
                        System.out.println("Escoge una opción: ");
                        opcion = consola.nextInt();

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
                                opcion = consola.nextInt();
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
                                "(1) Busqueda en lista ordenada de apellidos",
                                "(2) Eliminar apellidos desde lista ordenada",
                                "(3) Atrás"
                        };

                        /*
                        Bucle que muestra las opciones del menú
                         */
                        for (int i = 0; i < menuOrdenar.length; i++) {
                            System.out.println(menuOrdenar[i]);
                        }

                        /*
                        Mostrar mensaje al usuario para introducir una nueva opción
                         */
                        System.out.println("Escoge una opción: ");
                        opcion = consola.nextInt();

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
                                opcion = consola.nextInt();
                                break;
                        }
                    }
                    while (opcion != 3);
                    break;
                case 0: // Salir
                    System.out.println("Salir");
                    System.exit(0);
                    break;
                default: // opción incorrecta
                    System.out.println("Opción incorrecta!!");
                    opcion = consola.nextInt();
                    break;
            }
        }

        while (opcion != 0);
    }
}
