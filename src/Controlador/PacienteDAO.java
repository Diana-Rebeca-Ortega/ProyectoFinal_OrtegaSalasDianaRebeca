package Controlador;

import Modelo.Paciente;
import conexionBD.ConexionBD;

public class PacienteDAO {
    ConexionBD conexionBD = new ConexionBD();
    //***************************************ALTAS*******************************
    public boolean agregarPaciente(Paciente paciente){
        String sql = "INSERT INTO pacientes VALUES('"+paciente.getNumSSN()+"','"+paciente.getNombre()+"','"+paciente.getPrimerApellido()+"','"+paciente.getSegundoApellido()+"','"+paciente.getEdad()+"','"+paciente.getCalle()+"','"+paciente.getColonia()+"','"+paciente.getNo_Casa()+"','"+paciente.getCP()+"' )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //*******************************BAJAS/*****************************
    public  boolean eliminarAlumnos (String numSeguroSocial){
        String sql = "DELETE FROM pacientes WHERE ID_Paciente_SSN='"+numSeguroSocial+"' ";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }

}
