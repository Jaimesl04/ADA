package com.ejercicio3;

import java.sql.*;
import java.util.*;

public class Empresa {

    // I
    public static void consultaI(Connection connection) {
        String sql = "SELECT comision, nombre, salario, num_hijos " +
                "FROM EMPLEADOS " +
                "WHERE num_hijos > ? " +
                "ORDER BY comision, nombre";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Introduce el numero minimo de hijos: ");
            int numHijos = scanner.nextInt();

            preparedStatement.setInt(1, numHijos);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Empleados con mas de " + numHijos + " hijos:");
                while (resultSet.next()) {
                    double comision = resultSet.getDouble("comision");
                    String nombre = resultSet.getString("nombre");
                    double salario = resultSet.getDouble("salario");
                    int hijos = resultSet.getInt("num_hijos");

                    System.out.println("Nombre: " + nombre);
                    System.out.println("Salario: " + salario);
                    System.out.println("Comision: " + comision);
                    System.out.println("Hijos: " + hijos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // II
    public static void consultaII(Connection connection) {
        String sql = "SELECT nombre, salario FROM EMPLEADOS " +
                "WHERE salario BETWEEN ? AND ? " +
                "ORDER BY nombre";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Salario minimo: ");
            double min = scanner.nextDouble();
            System.out.print("Salario maximo: ");
            double max = scanner.nextDouble();

            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Empleados con salario entre " + min + " y " + max + " euros:");
                while (resultSet.next()) {
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Salario: " + resultSet.getDouble("salario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // III
    public static void consultaIII(Connection connection) {
        String sql = "SELECT nombre FROM DEPARTAMENTOS " +
                "WHERE nombre LIKE ? " +
                "ORDER BY nombre";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Palabra a buscar en departamentos: ");
            String palabra = scanner.nextLine();

            preparedStatement.setString(1, "%" + palabra + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Departamentos que contienen " + palabra + ":");
                while (resultSet.next()) {
                    System.out.println("Departamento: " + resultSet.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // IV
    public static void consultaIV(Connection connection) {
        String sql = "SELECT * FROM CENTROS WHERE numero = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Numero del centro: ");
            int numero = scanner.nextInt();

            preparedStatement.setInt(1, numero);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Informacion del cetro " + numero + ":");
                if (resultSet.next()) {
                    System.out.println("Numero: " + resultSet.getInt("numero"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Direccion: " + resultSet.getString("direccion"));
                } else {
                    System.out.println("El centro " + numero + " no existe");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // V
    public static void consultaV(Connection connection) {
        String sql = "SELECT * FROM EMPLEADOS WHERE nombre LIKE ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Nombre del empleado: ");
            String nombre = scanner.nextLine();

            preparedStatement.setString(1, "%" + nombre + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Empleados con el nombre " + nombre + ":");
                while (resultSet.next()) {
                    System.out.println("Codigo: " + resultSet.getInt("cod"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Departamento: " + resultSet.getInt("departamento"));
                    System.out.println("Telefono: " + resultSet.getString("telefono"));
                    System.out.println("Salario: " + resultSet.getDouble("salario"));
                    System.out.println("Comision: " + resultSet.getDouble("comision"));
                    System.out.println("Numero de hijos: " + resultSet.getInt("num_hijos"));
                    System.out.println("Fecha nacimiento: " + resultSet.getDate("fecha_nacimiento"));
                    System.out.println("Fecha ingreso: " + resultSet.getDate("fecha_ingreso"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VI
    public static void consultaVI(Connection connection) {
        String sql = "SELECT nombre, fecha_nacimiento FROM EMPLEADOS " +
                "WHERE MONTH(fecha_nacimiento) = ? " +
                "ORDER BY nombre";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Mes de cumpleaños: ");
            int mes = scanner.nextInt();

            preparedStatement.setInt(1, mes);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Empleados que cumplen años en " + mes + ":");
                while (resultSet.next()) {
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Fecha de nacimiento: " + resultSet.getDate("fecha_nacimiento"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VII
    public static void consultaVII(Connection connection) {
        String sql = "SELECT cod, nombre, salario, comision, " +
                "salario + comision as salario_total " +
                "FROM EMPLEADOS " +
                "WHERE salario + comision > ? " +
                "ORDER BY cod";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Salario total minimo: ");
            double salarioMinimo = scanner.nextDouble();

            preparedStatement.setDouble(1, salarioMinimo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Empleados con salario total de mas de " + salarioMinimo + " euros:");
                while (resultSet.next()) {
                    System.out.println("Codigo: " + resultSet.getInt("cod"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Salario: " + resultSet.getDouble("salario"));
                    System.out.println("Comision: " + resultSet.getDouble("comision"));
                    System.out.println("Total: " + resultSet.getDouble("salario_total"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VIII
    public static void consultaVIII(Connection connection) {
        String sql = "SELECT d.numero, d.nombre, " +
                "COUNT(e.cod) as num_empleados, " +
                "COUNT(DISTINCT e.telefono) as extensiones_distintas " +
                "FROM DEPARTAMENTOS d " +
                "LEFT JOIN EMPLEADOS e ON d.numero = e.departamento " +
                "GROUP BY d.numero, d.nombre " +
                "ORDER BY d.numero";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Info por departamento:");
            while (resultSet.next()) {
                System.out.println("Departamento " + resultSet.getInt("numero") + " - " + resultSet.getString("nombre"));
                System.out.println("Empleados: " + resultSet.getInt("num_empleados"));
                System.out.println("Extensiones: " + resultSet.getInt("extensiones_distintas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // IX
    public static void consultaIX(Connection connection) {
        String sql = "SELECT d.nombre as departamento, e.nombre, e.salario " +
                "FROM EMPLEADOS e " +
                "JOIN DEPARTAMENTOS d ON e.departamento = d.numero " +
                "WHERE e.salario > ? " +
                "ORDER BY d.nombre, e.salario DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Salario minimo: ");
            double salarioMinimo = scanner.nextDouble();

            preparedStatement.setDouble(1, salarioMinimo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Empleados que cobran mas de " + salarioMinimo + " euros");
                while (resultSet.next()) {
                    System.out.println("Departamento: " + resultSet.getString("departamento"));
                    System.out.println("Empleado: " + resultSet.getString("nombre"));
                    System.out.println("Salario: " + resultSet.getDouble("salario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // X
    public static void consultaX(Connection connection) {
        String sql = "SELECT nombre, salario, fecha_nacimiento, fecha_ingreso, " +
                "TIMESTAMPDIFF(YEAR, fecha_nacimiento, fecha_ingreso) as edad_ingreso " +
                "FROM EMPLEADOS " +
                "HAVING edad_ingreso > ? " +
                "ORDER BY nombre";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Edad mínima al ingresar: ");
            int edadMinima = scanner.nextInt();

            preparedStatement.setInt(1, edadMinima);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Empleados con mas de " + edadMinima + " años al entrar");
                while (resultSet.next()) {
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Salario: " + resultSet.getDouble("salario"));
                    System.out.println("Fecha de nacimiento: " + resultSet.getDate("fecha_nacimiento"));
                    System.out.println("Fecha de ingreso: " + resultSet.getDate("fecha_ingreso"));
                    System.out.println("Edad al ingresar: " + resultSet.getInt("edad_ingreso"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // XI
    public static void consultaXI(Connection connection) {
        String sql = "SELECT cod, nombre, salario, fecha_ingreso, " +
                "TIMESTAMPDIFF(YEAR, fecha_ingreso, CURDATE()) as años_empresa " +
                "FROM EMPLEADOS " +
                "HAVING años_empresa > ? AND salario < ? " +
                "ORDER BY cod";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Años mínimos en la empresa: ");
            int añosMin = scanner.nextInt();
            System.out.print("Salario máximo: ");
            double salarioMax = scanner.nextDouble();

            pstmt.setInt(1, añosMin);
            pstmt.setDouble(2, salarioMax);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                System.out
                        .println("Empleados con mas de " + añosMin + " años y salario de menos de " + salarioMax + " euros");
                while (resultSet.next()) {
                    System.out.println("Codigo: " + resultSet.getInt("cod"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Salario: " + resultSet.getDouble("salario"));
                    System.out.println("Fecha de ingreso: " + resultSet.getDate("fecha_ingreso"));
                    System.out.println("Años en la empresa: " + resultSet.getInt("años_empresa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}