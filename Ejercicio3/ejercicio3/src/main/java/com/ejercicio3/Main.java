package com.ejercicio3;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/EMPRESA";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("EMPRESA");

            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("CONSULTAS:");
                System.out.println("1. Consulta I");
                System.out.println("2. Consulta II");
                System.out.println("3. Consulta III");
                System.out.println("4. Consulta IV");
                System.out.println("5. Consulta V");
                System.out.println("6. Consulta VI");
                System.out.println("7. Consulta VII");
                System.out.println("8. Consulta VIII");
                System.out.println("9. Consulta IX");
                System.out.println("10. Consulta X");
                System.out.println("11. Consulta XI");
                System.out.println("0. Salir");
                System.out.print("Elige una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        Empresa.consultaI(connection);
                        break;
                    case 2:
                        Empresa.consultaII(connection);
                        break;
                    case 3:
                        Empresa.consultaIII(connection);
                        break;
                    case 4:
                        Empresa.consultaIV(connection);
                        break;
                    case 5:
                        Empresa.consultaV(connection);
                        break;
                    case 6:
                        Empresa.consultaVI(connection);
                        break;
                    case 7:
                        Empresa.consultaVII(connection);
                        break;
                    case 8:
                        Empresa.consultaVIII(connection);
                        break;
                    case 9:
                        Empresa.consultaIX(connection);
                        break;
                    case 10:
                        Empresa.consultaX(connection);
                        break;
                    case 11:
                        Empresa.consultaXI(connection);
                        break;
                    case 0:
                        System.out.println("Has salido");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            } while (opcion != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}