package Controlador;

import Modelo.Medicamentos;
import Modelo.Supervisor;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentosDAO {

    ConexionBD conexionBD = new ConexionBD();
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

}
