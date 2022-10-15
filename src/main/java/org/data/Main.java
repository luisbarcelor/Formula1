package org.data;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String query, output;

        System.out.println("CONSULTA BASE DE DATOS");
        System.out.print("CONSULTA SQL: ");
        query = scanner.nextLine();

        System.out.println();
        System.out.println("EJECUTA \"" + query + "\"");
        System.out.println();

        output = ConnectionManager.execQuery(query, ConnectionManager.newConnection());
        System.out.println(output);
    }
}