import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner que permite introducir datos desde consola
         */
        Scanner consola = new Scanner(System.in);

        /*
        Array con la lista de apellidos de los alumnos de clase
         */
        String [] listaAlumnos;

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
            Opción seleccionada por el usuario
             */
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
                    System.out.println("Escoge una opción: ");
                    do {
                        opcion = consola.nextInt();

                        switch (opcion) {
                            case 1: // Muestra primer elemento
                                System.out.println("Muestra primer apellido de la lista");
                                break;
                            case 2: // Muestra último elemento
                                System.out.println("Muestra último apellido de la lista");
                                break;
                            case 3: // Salir
                                System.out.println("Salir");
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
                    System.out.println("Escoge una opción: ");
                    // Después de mostrar la lista
                    do {
                        opcion = consola.nextInt();

                        switch (opcion) {
                            case 1: // Localizar en lista ordenada
                                System.out.println("Busqueda en lista ordenada de apellidos");
                                break;
                            case 2: // Eliminar desde lista ordenada
                                System.out.println("Eliminar apellidos desde lista ordenada");
                                break;
                            case 3: // Salir
                                System.out.println("Salir");
                                System.exit(0);
                                break;
                            default: // Opción incorrecta
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
