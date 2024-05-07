package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.example.Ejercicios.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Clase Pareja");
            System.out.println("2. Lista de 100 valores reales");
            System.out.println("3. Lista de 100 valores Pareja enteros");
            System.out.println("4. Introducir cadenas de texto en una lista y borrarlas");
            System.out.println("5. Introducir cadenas de texto por posicion y borrar");
            System.out.println("6. Introducir cadena de texto, ordenar y borrar");
            System.out.println("7. Mapa con clave String y valor entero");
            System.out.println("8. Introducir valores a un mapa y mostrarlo");
            System.out.println("9. Clase Persona uso de TreeSet");
            System.out.println("10. Clase Venta, elegir ordenación");
            System.out.println("11. Ordenar líneas de un fichero");
            System.out.println("0. Salir");
            System.out.print("Introduce una opción: ");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Pareja<Double> pareja = new Pareja<>(3.5, 4.5);
                    System.out.println("Primero: " + pareja.getPrimero());
                    System.out.println("Segundo: " + pareja.getSegundo());

                    Pareja<String> parejaS = new Pareja<>("Hola", "Mundo");
                    System.out.println("Primero: " + parejaS.getPrimero());
                    System.out.println("Segundo: " + parejaS.getSegundo());

                    System.out.println("Pulse :");
                    break;
                case 2:
                    ArrayList<Double> listaArrayList = crearListaArrayList();
                    System.out.println("Lista con ArrayList:");
                    mostrarListaA(listaArrayList);

                    double[] listaArray = crearListaArray();
                    System.out.println("\nLista con array:");
                    mostrarLista(listaArray);
                    break;
                case 3:
                    Pareja<Double>[] listaParejas = new Pareja[100];
                    for (int i = 0; i < 100; i++) {
                        listaParejas[i] = new Pareja<>(Math.random(), Math.random());
                    }
                    for (Pareja<Double> parejaD : listaParejas) {
                        System.out.println("Primero: " + parejaD.getPrimero() + " Segundo: " + parejaD.getSegundo());
                    }
                    break;
                case 4:
                    ArrayList<String> lista = new ArrayList<>();
                    boolean salir = true;
                    while (salir) {

                        System.out.println("1. Introducir cadena de texto en la lista");
                        System.out.println("2. Borrar cadena de texto de la lista");
                        System.out.println("0. Salir");
                        System.out.print("Introduce una opción: ");
                        String op = sc.nextLine();

                        switch (op) {
                            case "1":
                                System.out.print("Introduce una cadena: ");
                                String cadena = sc.nextLine();
                                lista.add(cadena);
                                mostrarListaT(lista);
                                break;
                            case "2":
                                if (!lista.isEmpty()) {
                                    lista.remove(lista.size() - 1);
                                    mostrarListaT(lista);
                                } else {
                                    System.out.println("La lista está vacía. No se puede eliminar ningún elemento.");
                                }
                                break;
                            case "0":
                                System.out.println("Saliendo del programa...");
                                salir = false;
                                break;
                            default:
                                System.out.println("Opción no válida. Inténtalo de nuevo.");
                        }
                    }
                    break;
                case 5:
                    ArrayList<String> listaT = new ArrayList<>();
                    boolean salirT = true;

                    while (salirT) {
                        System.out.println("1. Insertar cadena");
                        System.out.println("2. Eliminar cadena");
                        System.out.println("3. Salir");
                        System.out.print("Introduce una opción: ");

                        int op = sc.nextInt();

                        switch (op) {
                            case 1:
                                System.out.print("Introduce la cadena a insertar: ");
                                String cadena = sc.nextLine();
                                System.out.print("Introduce la posición donde insertar la cadena (0 - " + listaT.size() + "): ");
                                int posicion = sc.nextInt();
                                anadirCadena(listaT, cadena, posicion);
                                mostrarListaT(listaT);
                                break;
                            case 2:
                                if (listaT.isEmpty()) {
                                    System.out.println("La lista está vacía. No se eliminó ninguna cadena.");
                                    break;
                                }

                                System.out.print("Introduce la posición de la cadena a eliminar (0 - " + (listaT.size() - 1) + "): ");
                                int posicionEliminar = sc.nextInt();
                                eliminarCadena(listaT, posicionEliminar);
                                mostrarListaT(listaT);
                                break;
                            case 3:
                                System.out.println("Saliendo del programa...");
                                System.exit(0);
                            default:
                                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                                break;
                        }
                    }
                    break;
                case 6:
                    ArrayList<String> listaOrdenada = new ArrayList<>();
                    boolean salirOrdenar = true;

                    while (salirOrdenar) {
                        System.out.println("1. Introducir cadena y mostrarla ordenada");
                        System.out.println("2. Eliminar cadena");
                        System.out.println("0. Salir");
                        System.out.print("Introduce una opción: ");
                        int op = sc.nextInt();

                        switch (op) {
                            case 1:
                                System.out.print("Introduce la cadena a insertar: ");
                                String cadena = sc.nextLine();
                                listaOrdenada.add(cadena);
                                listaOrdenada.sort(String::compareTo);
                                mostrarListaT(listaOrdenada);
                                break;
                            case 2:
                                if (listaOrdenada.isEmpty()) {
                                    System.out.println("La lista está vacía. No se eliminó ninguna cadena.");
                                    break;
                                }

                                System.out.print("Introduce la cadena a eliminar: ");
                                String cadenaEliminar = sc.nextLine();

                                eliminarPorCadena(listaOrdenada, cadenaEliminar);
                                break;
                            case 0:
                                System.out.println("Saliendo del programa...");
                                salirOrdenar = false;
                            default:
                                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                                break;
                        }
                    }
                    break;
                case 7:
                    Map<String, Integer> mapaNumeros = new HashMap<>();

                    mapaNumeros.put("cero", 0);
                    mapaNumeros.put("uno", 1);
                    mapaNumeros.put("dos", 2);
                    mapaNumeros.put("tres", 3);
                    mapaNumeros.put("cuatro", 4);
                    mapaNumeros.put("cinco", 5);
                    mapaNumeros.put("seis", 6);
                    mapaNumeros.put("siete", 7);
                    mapaNumeros.put("ocho", 8);
                    mapaNumeros.put("nueve", 9);
                    mapaNumeros.put("diez", 10);

                    System.out.println("Contenido del mapa:");
                    for (Map.Entry<String, Integer> entry : mapaNumeros.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;
                case 8:
                    Map<Integer, String> mapa = new HashMap<>();

                    System.out.println("Introduzca pares de numero/letra. (Para salir introduce -1)");
                    int num;
                    String letra;

                    do {
                        System.out.print("Introduce un número: ");
                        num = sc.nextInt();
                        if (num == -1) {
                            break;
                        }
                        System.out.print("Introduce una letra: ");
                        letra = sc.nextLine();
                        mapa.put(num, letra);
                    } while (num != -1);

                    System.out.println("Contenido del mapa:");
                    for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;
                case 9:
                    TreeSet<Persona> personas = new TreeSet<>();
                    personas.add(new Persona("Juan", "Pérez"));
                    personas.add(new Persona("Ana", "Gómez"));
                    personas.add(new Persona("Pedro", "Martínez"));
                    personas.add(new Persona("María", "García"));

                    System.out.println("Personas ordenadas alfabéticamente:");
                    for (Persona persona : personas) {
                        System.out.println(persona.getNombre() + " " + persona.getApellido());
                    }
                    break;
                case 10:
                    ArrayList<Venta> ventas = new ArrayList<>();

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2024, Calendar.MAY, 7);
                    Date fecha1 = calendar.getTime();
                    calendar.set(2024, Calendar.JUNE, 6);
                    Date fecha2 = calendar.getTime();
                    calendar.set(2022, Calendar.MAY, 5);
                    Date fecha3 = calendar.getTime();

                    ventas.add(new Venta("Coche", "Diego", 100.0, fecha1));
                    ventas.add(new Venta("Xilofono", "Marcos", 200.0, fecha2));
                    ventas.add(new Venta("Hamburgesa", "Abanades", 300.0, fecha3));

                    System.out.println("1. Ordenar por nombre del cliente");
                    System.out.println("2. Ordenar por precio");
                    System.out.println("3. Ordenar por fecha");

                    int orden = sc.nextInt();
                    switch (orden) {
                        case 1:
                            ventas.sort(Comparator.comparing(Venta::getNombreCliente));
                            break;
                        case 2:
                            ventas.sort(Comparator.comparing(Venta::getPrecio));
                            break;
                        case 3:
                            ventas.sort(Comparator.comparing(Venta::getFecha));
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }

                    System.out.println("Ventas ordenadas:");
                    for (Venta venta : ventas) {
                        System.out.println("Producto: " + venta.getNombreProducto() + " Cliente: " + venta.getNombreCliente() + " Precio: " + venta.getPrecio() + " Fecha: " + venta.getFecha());
                    }
                    break;
                case 11:
                    try {
                        String nomArchivo = "ficheros/fichero.txt";
                        ArrayList<String> lineas = new ArrayList<>();
                        Scanner sc = new Scanner(new File(nomArchivo));

                        while (sc.hasNextLine()) {
                            lineas.add(sc.nextLine());
                        }

                        lineas.sort(String::compareTo);
                        for (String linea : lineas) {
                            System.out.println(linea);
                        }

                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
    }

    public static double[] crearListaArray() {
        double[] lista = new double[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            lista[i] = rand.nextDouble();
        }
        return lista;
    }

    public static ArrayList<Double> crearListaArrayList() {
        ArrayList<Double> lista = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            lista.add(rand.nextDouble());
        }
        return lista;
    }

    public static void mostrarListaA(ArrayList<Double> lista) {
        for (Double valor : lista) {
            System.out.println(valor);
        }
    }

    public static void mostrarLista(double[] lista) {
        for (double valor : lista) {
            System.out.println(valor);
        }
    }

    public static void mostrarListaT(ArrayList<String> lista) {
        for (String valor : lista) {
            System.out.println(valor);
        }
    }

    public static void anadirCadena(ArrayList<String> lista, String cadena, int posicion) {
        if (posicion >= 0 && posicion <= lista.size()) {
            lista.add(posicion, cadena);
            System.out.println("Cadena añadida correctamente.");
        } else {
            System.out.println("Posición inválida. No se añadió la cadena.");
        }
    }

    public static void eliminarCadena(ArrayList<String> lista, int posicion) {
        if (posicion >= 0 && posicion < lista.size()) {
            lista.remove(posicion);
            System.out.println("Cadena eliminada correctamente.");
        } else {
            System.out.println("Posición inválida. No se eliminó la cadena.");
        }
    }

    public static void eliminarPorCadena(ArrayList<String> lista, String cadena) {
        if (lista.contains(cadena)) {
            lista.remove(cadena);
            System.out.println("Cadena eliminada correctamente.");
        } else {
            System.out.println("La cadena no existe en la lista. No se eliminó ninguna cadena.");
        }
    }
}