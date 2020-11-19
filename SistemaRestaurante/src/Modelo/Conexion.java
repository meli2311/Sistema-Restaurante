package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String username = "root";
    private String pasword = "";
    private String hostname = "localhost";
    private String port = "3306";
    private String database = "Sistema_restaurante";
    private String classname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
    private Connection con;

    public Conexion() {
        try {
            Class.forName(classname);
            con = DriverManager.getConnection(url, username, pasword);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (SQLException esql) {
            System.err.println(esql.getMessage());
        }

    }

    public Connection getConnection() {

        return con;
    }

   
}
