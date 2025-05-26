package Controlador;

import Modelo.Consulta;
import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaDAO {
    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
    //***************************************ALTAS*******************************
    public boolean agregarConsulta(Consulta consulta){
        String sql = "INSERT INTO consultas VALUES('"+consulta.getID_Consulta()+"','"+consulta.getID_Paciente()+"','"+consulta.getID_Medico()+"','"+consulta.getMorivo()+"','"+consulta.getFechaHora()+"');";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from consultas";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}

}
