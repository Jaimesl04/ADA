package com.ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/BD_EJERCICIO4";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("BD_EJERCICIO4");

            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("CONSULTAS:");
                System.out.println("1. Consulta A");
                System.out.println("2. Consulta B");
                System.out.println("3. Consulta C");
                System.out.println("4. Consulta D");
                System.out.println("5. Consulta E");
                System.out.println("6. Consulta F");
                System.out.println("7. Consulta G");
                System.out.println("8. Consulta H");
                System.out.println("9. Consulta I");
                System.out.println("10. Consulta J");
                System.out.println("11. Consulta K");
                System.out.println("12. Consulta L");
                System.out.println("0. Salir");
                System.out.print("Elige una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        Ejercicio4Llamadas.consultaA(connection);
                        break;
                    case 2:
                        Ejercicio4Llamadas.consultaB(connection);
                        break;
                    case 3:
                        Ejercicio4Llamadas.consultaC(connection);
                        break;
                    case 4:
                        Ejercicio4Llamadas.consultaD(connection);
                        break;
                    case 5:
                        Ejercicio4Llamadas.consultaE(connection);
                        break;
                    case 6:
                        Ejercicio4Llamadas.consultaF(connection);
                        break;
                    case 7:
                        Ejercicio4Llamadas.consultaG(connection);
                        break;
                    case 8:
                        Ejercicio4Llamadas.consultaH(connection);
                        break;
                    case 9:
                        Ejercicio4Llamadas.consultaI(connection);
                        break;
                    case 10:
                        Ejercicio4Llamadas.consultaJ(connection);
                        break;
                    case 11:
                        Ejercicio4Llamadas.consultaK(connection);
                        break;
                    case 12:
                        Ejercicio4Llamadas.consultaL(connection);
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