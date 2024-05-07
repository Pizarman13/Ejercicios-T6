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

        // Lista utilizando la clase ArrayList
        ArrayList<Double> listaArrayList = crearListaArrayList();
        System.out.println("Lista con ArrayList:");
        mostrarListaA(listaArrayList);

        // Lista utilizando la clase array primitivo
        double[] listaArray = crearListaArray();
        System.out.println("\nLista con array:");
        mostrarLista(listaArray);

        while (true) {
            System.out.println("1. Clase Pareja");
            System.out.println("2. Lista de 100 valores reales");
            System.out.println("3. Lista de 100 valores Pareja enteros");
            System.out.println("0. Salir");

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
                    System.out.println("Lista con ArrayList:");
                    mostrarListaA(listaArrayList);
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
}