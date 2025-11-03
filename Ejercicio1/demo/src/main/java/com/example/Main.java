package com.example;

import java.sql.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexion establecida");

            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("--Tienda--");
                System.out.println("1. Insertar cliente");
                System.out.println("2. Actualizar cliente");
                System.out.println("3. Borrar cliente");
                System.out.println("4. Mostrar clientes");
                System.out.println("5. Insertar datos del enunciado");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> Tienda.insertarCliente(connection);
                    case 2 -> Tienda.actualizarCliente(connection);
                    case 3 -> Tienda.borrarCliente(connection);
                    case 4 -> Tienda.mostrarClientes(connection);
                    case 5 -> insertarDatosEnunciado(connection);
                    case 0 -> System.out.println("Has salido del programa");
                    default -> System.out.println("Opcion invalida");
                }

            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private static void insertarDatosEnunciado(Connection connection) {
        System.out.println("Insertar datos automaticos");
        Tienda.insertarCliente(connection, "333", "Juan", "Paseo de Roma 34", "333444555");
        Tienda.insertarCliente(connection, "222", "Lola", "Av. Alemania", "222333444");
        Tienda.insertarCliente(connection, "555", "María", "Avda. París, 7", "555666777");
        Tienda.insertarCliente(connection, "444", "Pedro", "Plaza de la Constitución, 1", " ");
        Tienda.insertarCliente(connection, "111", "Pepe", "Av. París", "111222333");
    }
}