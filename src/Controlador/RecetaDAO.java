package Controlador;

import Modelo.Paciente;
import conexionBD.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RecetaDAO extends JFrame {
    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from recetas";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}

    public void actualizarTabla(JTable tabla, String nombreComercial) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String sql = "select NombreComercial, Formula from Medicamentos  where NombreComercial = '" + nombreComercial + "'";
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("NombreComercial"), rs.getString("Formula")});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean agregarReceta(String idReceta, String idMedico, String idPaciente, String listaMedicamentos, String Indicacion){
        String sql = "INSERT INTO recetas VALUES('"+idReceta+"','"+idMedico+"','"+idPaciente+"','"+listaMedicamentos+"','"+Indicacion+"' )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }

}
