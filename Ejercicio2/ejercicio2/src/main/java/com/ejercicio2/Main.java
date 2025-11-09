package com.ejercicio2;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/EMPRESA";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conectado a EMPRESA");

            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("CONSULTAS:");
                System.out.println("1. Empleados con mas de 3 hijos");
                System.out.println("2. Departamentos que no dependen de otros");
                System.out.println("3. Empleados cuyo salario esta comprendido entre 1250€ y 1300€");
                System.out.println("4. Empleados cuyo salario esta comprendido entre 1250€ y 1300€ o tienen al menos un hijo");
                System.out.println("5. Departamentos que no contienen Direccion ni Sector");
                System.out.println("6. Departamentos que no exceden de 5000€ o no dependen de ningun otro departamento");
                System.out.println("7. Empleados cuyo salario total supera los 1300€ mensuales");
                System.out.println("8. Numero total empleados");
                System.out.println("9. Cuantos departamentos hay y presupuesto anual medio");
                System.out.println("10. Numero de empleados y de extensiones telefonicas distintas del departamento 112");
                System.out.println("11. Codigos de departamentos que no hacen de departamento jefe");
                System.out.println("12. Codigos de departamentos que si hacen de departamento jefe");
                System.out.println("0. Salir");
                System.out.print("Elige una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        Empresa.consultaA(connection);
                        break;
                    case 2:
                        Empresa.consultaB(connection);
                        break;
                    case 3:
                        Empresa.consultaC(connection);
                        break;
                    case 4:
                        Empresa.consultaD(connection);
                        break;
                    case 5:
                        Empresa.consultaE(connection);
                        break;
                    case 6:
                        Empresa.consultaF(connection);
                        break;
                    case 7:
                        Empresa.consultaG(connection);
                        break;
                    case 8:
                        Empresa.consultaH(connection);
                        break;
                    case 9:
                        Empresa.consultaI(connection);
                        break;
                    case 10:
                        Empresa.consultaJ(connection);
                        break;
                    case 11:
                        Empresa.consultaK(connection);
                        break;
                    case 12:
                        Empresa.consultaL(connection);
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