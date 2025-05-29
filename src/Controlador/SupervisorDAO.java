package Controlador;

import Modelo.Supervisor;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupervisorDAO {

    ConexionBD conexionBD =  ConexionBD.getInstance();
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
    //*******************************CAMBIOS*****************************
    public boolean cambiarSupervisor(Supervisor supervisor){
        sql = "UPDATE supervisores SET Nombre='"+
                supervisor.getNombre()+"',PApellido='"+
                supervisor.getPrimerApellido()+"', SApellido='"+
                supervisor.getSegundoApellido()+"'  WHERE NSS='"+
                supervisor.getNumSSN()+"'; ";
        return  conexionBD.ejecutarInstruccionLMD(sql); //retorta 0, 1 o 2... false o true
    }
    //************************************ NOMBRES DE SUPERVISORES ***********
    public List<String> NombresSupervisores() {
        sql = "select   Nombre from supervisores";
        rs = conexionBD.ejecutarInstruccionSQL(sql);
        List<String> Nombres = new ArrayList<>();
        try {
            while (rs.next()) {
                Nombres.add(rs.getString(1));
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
        return Nombres;
    }
    //************************************NSS SUPERVISORES ***********
    public String NSS_Supervisores(String n) {
        sql = " select NSS from supervisores WHERE Nombre='"+n+"'";
        rs = conexionBD.ejecutarInstruccionSQL(sql);
        String nsss="" ;
        try {
            while (rs.next()) {
                nsss=rs.getString(1);
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
        return nsss;
    }
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from  supervisores";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}

}
