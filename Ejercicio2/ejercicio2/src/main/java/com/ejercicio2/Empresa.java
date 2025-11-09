package com.ejercicio2;

import java.sql.*;

public class Empresa {
    // a
    public static void consultaA(Connection connection) {
        String sql = "SELECT comision, nombre, salario " +
                "FROM EMPLEADOS " +
                "WHERE num_hijos > 3 " +
                "ORDER BY comision, nombre";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA A");
            while (resultSet.next()) {
                double comision = resultSet.getDouble("comision");
                String nombre = resultSet.getString("nombre");
                double salario = resultSet.getDouble("salario");

                System.out.println("Nombre: " + nombre);
                System.out.println("Salario: " + salario);
                System.out.println("Comision: " + comision);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // b
    public static void consultaB(Connection connection) {
        String sql = "SELECT nombre FROM DEPARTAMENTOS WHERE depto_jefe IS NULL";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA B");
            while (resultSet.next()) {
                System.out.println("Departamento: " + resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // c
    public static void consultaC(Connection connection) {
        String sql = "SELECT nombre, salario FROM EMPLEADOS " +
                "WHERE salario BETWEEN 1250 AND 1300 " +
                "ORDER BY nombre";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA C");
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Salario: " + resultSet.getDouble("salario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // d
    public static void consultaD(Connection connection) {
        String sql = "SELECT cod, nombre, salario, num_hijos FROM EMPLEADOS " +
                "WHERE salario BETWEEN 1250 AND 1300 OR num_hijos >= 1 " +
                "ORDER BY nombre";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA D");
            while (resultSet.next()) {
                System.out.println("Codigo: " + resultSet.getInt("cod"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Salario: " + resultSet.getDouble("salario"));
                System.out.println("Hijos: " + resultSet.getInt("num_hijos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // e
    public static void consultaE(Connection connection) {
        String sql = "SELECT nombre FROM DEPARTAMENTOS " +
                "WHERE nombre NOT LIKE '%Dirección%' AND nombre NOT LIKE '%Sector%' " +
                "ORDER BY nombre";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA E");
            while (resultSet.next()) {
                System.out.println("Departamento: " + resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // f
    public static void consultaF(Connection connection) {
        String sql = "SELECT nombre FROM DEPARTAMENTOS " +
                "WHERE (tipo_dir = 'F' AND presupuesto <= 5) OR depto_jefe IS NULL " +
                "ORDER BY nombre";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA F");
            while (resultSet.next()) {
                System.out.println("Departamento: " + resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // g
    public static void consultaG(Connection connection) {
        String sql = "SELECT cod, nombre, salario, comision, " + 
        "salario + comision as salario_total " + 
        "FROM EMPLEADOS " + 
        "WHERE salario + comision > 1300 " + 
        "ORDER BY cod";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA G");
            while (resultSet.next()) {
                System.out.println("Codigo: " + resultSet.getInt("cod"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Salario: " + resultSet.getDouble("salario"));
                System.out.println("Comision: " + resultSet.getDouble("comision"));
                System.out.println("Total: " + resultSet.getDouble("salario_total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // h
    public static void consultaH(Connection connection) {
        String sql = "SELECT COUNT(*) as total_empleados FROM EMPLEADOS";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA H");
            if (resultSet.next()) {
                System.out.println("Total empleados: " + resultSet.getInt("total_empleados"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // i
    public static void consultaI(Connection connection) {
        String sql = "SELECT COUNT(*) as num_departamentos, AVG(presupuesto) as presupuesto_medio " +
                "FROM DEPARTAMENTOS";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA I");
            if (resultSet.next()) {
                System.out.println("Numero de departamentos: " + resultSet.getInt("num_departamentos"));
                System.out.println("Presupuesto medio: " + resultSet.getDouble("presupuesto_medio") + "miles de eutos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // j
    public static void consultaJ(Connection connection) {
        String sql = "SELECT COUNT(*) as num_empleados, COUNT(DISTINCT telefono) as extensiones_distintas " +
                "FROM EMPLEADOS WHERE departamento = 112";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA J");
            if (resultSet.next()) {
                System.out.println("Numero de empleados: " + resultSet.getInt("num_empleados"));
                System.out.println("Extensiones telefonicas distintas: " + resultSet.getInt("extensiones_distintas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // k
    public static void consultaK(Connection connection) {
        String sql = "SELECT numero FROM DEPARTAMENTOS " +
                "WHERE numero NOT IN (SELECT DISTINCT depto_jefe FROM DEPARTAMENTOS WHERE depto_jefe IS NOT NULL)";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA K");
            while (resultSet.next()) {
                System.out.println("Departamento: " + resultSet.getInt("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // l
    public static void consultaL(Connection connection) {
        String sql = "SELECT DISTINCT depto_jefe as numero FROM DEPARTAMENTOS WHERE depto_jefe IS NOT NULL";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("CONSULTA L");
            while (resultSet.next()) {
                System.out.println("Departamento: " + resultSet.getInt("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}