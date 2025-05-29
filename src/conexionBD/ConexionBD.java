package conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

public class ConexionBD {
    private Connection conexion;
    private PreparedStatement preparedStatement; //Es mejor ya que evita SQL Injection //la vamos a utiloizar en nuestro proyecto
    private ResultSet rs;

    public ConexionBD() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //el localhost es el 127.0.0.1
                String URL = "jdbc:mysql://localhost:3306/farmaciarx";
                try {
                    conexion = DriverManager.getConnection(URL, "root", "1819diana");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("ERROR EN LA CONECCION DE BASE DE DATOS");
                }
                System.out.println("YEIII CASI SOY ING INMORTAL muchas gracias, se conecto el programa a la base de datos");

            } catch (ClassNotFoundException e) {
                System.out.println("ERROR en el conector driver ");
            }
    }
    public ResultSet ejecutarInstruccionSQL(String sql,  Object... parametros) {
        rs = null;
        try {
            preparedStatement = conexion.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            rs = preparedStatement.executeQuery(); //ejecuta la consulta
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }
        return rs;
    }

        public boolean ejecutarInstruccionLMD(String sql, Object... parametros) {
            boolean resultado = false;
            try {
                preparedStatement = conexion.prepareStatement(sql);
                for (int i = 0; i < parametros.length; i++) {
                    preparedStatement.setObject(i + 1, parametros[i]);
                }
                if (preparedStatement.executeUpdate() >= 1) resultado = true;
            } catch (SQLException e) {
                System.out.println("Error en la ejecucion de la instruccion SQL");
            }
            return resultado;
        }

    public static void main(String[] args) {
        System.out.println("Magia magia para hacer magia");
        new ConexionBD();
    }

}
