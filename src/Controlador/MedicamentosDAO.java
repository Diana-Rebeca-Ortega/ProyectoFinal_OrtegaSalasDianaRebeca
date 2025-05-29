package Controlador;

import Modelo.Medicamentos;
import Modelo.Supervisor;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentosDAO {

    ConexionBD conexionBD = ConexionBD.getInstance();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;
    //***************************************ALTAS*******************************
    public boolean agregarMedicamentos(Medicamentos medicamentos){
        String sql = "INSERT INTO  medicamentos VALUES('"+medicamentos.getID_Registro()+"','"+medicamentos.getNombreCompañia()+"','"+medicamentos.getNombreComercial()+"','"+medicamentos.getFormula()+"' );";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //*******************************BAJAS/*****************************
    public  boolean eliminarMedicamento(String ID){
        String sql = "DELETE FROM medicamentos WHERE  ID_Registro='"+ID+"' ";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from  medicamentos";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}
    //************************************ NOMBRES DE COMERCIALES ***********
    public List<String> NombresComerciales() {
        sql = "select NombreComercial from Medicamentos";
        rs = conexionBD.ejecutarInstruccionSQL(sql);
        List<String> nomComercial = new ArrayList<>();
        try {
            while (rs.next()) {
                nomComercial.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return nomComercial;
    }

    public String obtenerFormula (String nombreComercial ){
        final String sql = "select Formula from Medicamentos where NombreComercial = '" + nombreComercial + "'";
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);

        try {
            if (rs.next()) {
                return rs.getString("Formula");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
