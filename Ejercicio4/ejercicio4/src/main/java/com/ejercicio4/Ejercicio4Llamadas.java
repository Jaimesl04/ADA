package com.ejercicio4;

import java.sql.*;
import java.util.*;

public class Ejercicio4Llamadas {

    // a
    public static void consultaA(Connection connection) {
        String sql = "CALL procedureA(?, ?)";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Tarifa minima: ");
            double min = scanner.nextDouble();
            System.out.print("Tarifa maxima: ");
            double max = scanner.nextDouble();
            
            callableStatement.setDouble(1, min);
            callableStatement.setDouble(2, max);
            
            try (ResultSet resultSet = callableStatement.executeQuery()) {
                System.out.println("Trabajadores con tarifa entre " + min + " y " + max + " euros:");
                while (resultSet.next()) {
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Tarifa: " + resultSet.getDouble("tarifa"));
                    System.out.println("Oficio: " + resultSet.getString("oficio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // b
    public static void consultaB(Connection connection) {
        String sql = "CALL procedureB(?)";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("ID del edificio: ");
            int idEdificio = scanner.nextInt();
            
            callableStatement.setInt(1, idEdificio);
            
            try (ResultSet resultSet = callableStatement.executeQuery()) {
                System.out.println("Oficios en el edificio " + idEdificio + ":");
                while (resultSet.next()) {
                    System.out.println("Oficio: " + resultSet.getString("oficio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // c
    public static void consultaC(Connection connection) {
        String sql = "CALL procedureC()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Trabajadores y sus supervisores:");
            while (resultSet.next()) {
                System.out.println("Trabajador: " + resultSet.getString("trabajador"));
                System.out.println("Supervisor: " + resultSet.getString("supervisor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // d
    public static void consultaD(Connection connection) {
        String sql = "CALL procedureD()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Trabajadores asignados a oficinas:");
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Oficio: " + resultSet.getString("oficio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // e
    public static void consultaE(Connection connection) {
        String sql = "CALL procedureE(?, ?)";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Oficio: ");
            String oficio = scanner.nextLine();
            System.out.print("ID del edificio: ");
            int idEdificio = scanner.nextInt();
            
            callableStatement.setString(1, oficio);
            callableStatement.setInt(2, idEdificio);
            
            try (ResultSet resultSet = callableStatement.executeQuery()) {
                System.out.println("Total dias de " + oficio + " en edificio " + idEdificio + ":");
                if (resultSet.next()) {
                    int totalDias = resultSet.getInt("total_dias");
                    System.out.println("Total dias: " + (totalDias > 0 ? totalDias : 0));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // f
    public static void consultaF(Connection connection) {
        String sql = "CALL procedureF()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Numero de oficios diferentes:");
            if (resultSet.next()) {
                System.out.println("Numero de oficios: " + resultSet.getInt("num_oficios"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // g
    public static void consultaG(Connection connection) {
        String sql = "CALL procedureG()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Tarifa maxima por supervisor:");
            while (resultSet.next()) {
                System.out.println("Supervisor: " + resultSet.getString("supervisor"));
                System.out.println("Tarifa maxima: " + resultSet.getDouble("tarifa_maxima"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // h
    public static void consultaH(Connection connection) {
        String sql = "CALL procedureH()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Tarifa maxima por supervisor con mas de un trabajador:");
            while (resultSet.next()) {
                System.out.println("Supervisor: " + resultSet.getString("supervisor"));
                System.out.println("Trabajadores: " + resultSet.getInt("num_trabajadores"));
                System.out.println("Tarifa maxima: " + resultSet.getDouble("tarifa_maxima"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // i
    public static void consultaI(Connection connection) {
        String sql = "CALL procedureI()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Trabajadores con tarifa menor al promedio:");
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Tarifa: " + resultSet.getDouble("tarifa"));
                System.out.println("Oficio: " + resultSet.getString("oficio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // j
    public static void consultaJ(Connection connection) {
        String sql = "CALL procedureJ()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Trabajadores con tarifa menor al promedio de su oficio:");
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Tarifa: " + resultSet.getDouble("tarifa"));
                System.out.println("Oficio: " + resultSet.getString("oficio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // k
    public static void consultaK(Connection connection) {
        String sql = "CALL procedureK()";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             ResultSet resultSet = callableStatement.executeQuery()) {
            
            System.out.println("Trabajadores con tarifa menor al promedio de su supervisor:");
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Tarifa: " + resultSet.getDouble("tarifa"));
                System.out.println("Supervisor: " + resultSet.getString("supervisor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // l
    public static void consultaL(Connection connection) {
        String sql = "CALL procedureL(?)";
        
        try (CallableStatement callableStatement = connection.prepareCall(sql);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Tarifa minima: ");
            double tarifaMin = scanner.nextDouble();
            
            callableStatement.setDouble(1, tarifaMin);
            
            try (ResultSet resultSet = callableStatement.executeQuery()) {
                System.out.println("Supervisores con trabajadores por encima de " + tarifaMin + " euros:");
                while (resultSet.next()) {
                    System.out.println("Supervisor: " + resultSet.getString("supervisor"));
                    System.out.println("Trabajador: " + resultSet.getString("trabajador"));
                    System.out.println("Tarifa: " + resultSet.getDouble("tarifa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}