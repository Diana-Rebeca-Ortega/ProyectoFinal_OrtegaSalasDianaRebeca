package Controlador;

import Modelo.Paciente;
import Modelo.Supervisor;
import conexionBD.ConexionBD;

import java.sql.ResultSet;

public class SupervisorDAO {

    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;
    //***************************************ALTAS*******************************
    public boolean agregarSupervisor(Supervisor supervisor){
        String sql = "INSERT INTO supervisores VALUES('"+supervisor.getNumSSN()+"','"+supervisor.getNombre()+"','"+supervisor.getPrimerApellido()+"','"+supervisor.getSegundoApellido()+"' )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //*******************************BAJAS/*****************************
    public  boolean eliminarSupervisor(String numSeguroSocial){
        String sql = "DELETE FROM supervisores WHERE NSS='"+numSeguroSocial+"' ";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
}
