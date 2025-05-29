package Controlador;

import Modelo.Contrato;
import Modelo.Medico;
import conexionBD.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContratoDAO {
    ConexionBD conexionBD = ConexionBD.getInstance();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);

    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from contratos";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}

   ///*********************ALTAS CONTRATOS
    public boolean agregarContrato(Contrato contrato){
        String sql = "INSERT INTO contratos VALUES('"+contrato.getID_Contrato()+"','"+contrato.getNombre_ComFarmaceutica()+"','"+contrato.getID_Farmacia()+"','"+contrato.getFechaInicio()+"','"+contrato.getFechaFin()+"','"+contrato.getSSN_Supervisor()+"');";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
}
