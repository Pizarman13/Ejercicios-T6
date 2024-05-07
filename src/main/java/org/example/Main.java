package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import org.example.Ejercicios.Pareja;

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
}