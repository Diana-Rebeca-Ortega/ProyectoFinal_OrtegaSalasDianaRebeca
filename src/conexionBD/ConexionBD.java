package conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class ConexionBD {
    private Connection conexion;
    private Statement stm; //Es mejor ya que evita SQL Injection //la vamos a utiloizar en nuestro proyecto
    private ResultSet rs;

    public ConexionBD() {

            // Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //el localhost es el 127.0.0.1
                String URL = "jdbc:mysql://localhost:3306/farmaciarx";
                try {
                    conexion = DriverManager.getConnection(URL, "root", "1819diana");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("YEIII CASI SOY ING INMORTAL muchas gracias, se conecto el programa a la base de datos");

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


    }

    public static void main(String[] args) {
        System.out.println("Magia magia para hacer magia");
        new ConexionBD();
    }

}
