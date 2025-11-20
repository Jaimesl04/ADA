package clinica.modelo;

import java.sql.*;


public class GestorBD {
    private String url = "jdbc:mysql://localhost:3306/clinica";
    private String user = "root";
    private String password = "1234";
    private Connection con;

    public GestorBD() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        System.out.println("Conectado a la base de datos");
    }

}