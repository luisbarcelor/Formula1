package org.data;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String output;
        String nombreEscuderia;
        String query;
        int option;


        System.out.println("CONSULTA BASE DE DATOS");
        System.out.println("QUE QUIERE HACER?");
        System.out.println("1 - CONSULTA DE ESCUDERIA");
        System.out.println("2 - CONSULTA PERSONALIZADA");
        System.out.println("---------------------------");
        option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1 -> {
                System.out.println("INDICA EL NOMBRE DEL PILOTO:");
                System.out.println("----------------------------");
                System.out.println(ConnectionManager.obtenerNombrePilotos());
                System.out.println("----------------------------");
                name = scanner.nextLine();
                query = "SELECT Escuderia_ID FROM Piloto WHERE Nombre='" + name + "';";
                output = ConnectionManager.execQuery(query);
                nombreEscuderia = ConnectionManager.obtenerEscuderia(output);
                System.out.println("ESCUDERIA:" + nombreEscuderia);
            }
            case 2 -> {
                System.out.println("CONSULTA SQL:");
                query = scanner.nextLine();
                output = ConnectionManager.execQuery(query);
                System.out.println();
                System.out.println(output);
            }
            default -> System.out.println("ERROR! OPCION INCORRECTA");
        }
    }
}