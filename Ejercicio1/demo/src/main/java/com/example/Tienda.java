package com.example;

import java.sql.*;
import java.util.*;

public class Tienda {

    public static void insertarCliente(Connection connection, String password, String usuario, String direccion,
            String telefono) {
        String sql = "INSERT INTO clientes (password, usuario, direccion, telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, usuario);
            preparedStatement.setString(3, direccion);
            preparedStatement.setString(4, telefono);
            preparedStatement.executeUpdate();
            System.out.println("Cliente insertado: " + usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarCliente(Connection connection) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Insertar cliente--");
        System.out.println("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        insertarCliente(connection, password, usuario, direccion, telefono);
    }

    public static void actualizarCliente(Connection connection) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Actualizar cliente--");
        System.out.print("Usuario del cliente para actualizar: ");
        String usuario = scanner.nextLine();
        System.out.print("Nueva direccion: ");
        String nuevaDireccion = scanner.nextLine();
        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        String sql = "UPDATE clientes SET direccion = ?, telefono = ? WHERE usuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevaDireccion);
            preparedStatement.setString(2, nuevoTelefono);
            preparedStatement.setString(3, usuario);

            int filas = preparedStatement.executeUpdate();
            if (filas > 0)
                System.out.println("Cliente actualizado");
            else
                System.out.println("No existe el usuario");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrarCliente(Connection connection) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuario del cliente para borrar: ");
        String usuario = scanner.nextLine();

        String sql = "DELETE FROM clientes WHERE usuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario);
            int filas = preparedStatement.executeUpdate();
            if (filas > 0)
                System.out.println("Cliente eliminado");
            else
                System.out.println("No existe el usuario");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarClientes(Connection connection) {
        String sql = "SELECT * FROM clientes";
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CLIENTES:");
            while (resultSet.next()) {
                String usuario = resultSet.getString("usuario");
                String password = resultSet.getString("password");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");

                System.out.println("Usuario: " + usuario);
                System.out.println("Contraseña: " + password);
                System.out.println("Direccion: " + direccion);
                System.out.println("Telefono: " + telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}