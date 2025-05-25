package Controlador;

import Modelo.Farmacia;
import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FarmaciaDAO {
    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;
    //***************************************ALTAS*******************************
    public boolean agregarFarmacia(Farmacia far){
        String sql = "INSERT INTO farmacias VALUES('"+far.getID_Farmacia()+"','"+far.getTelefono()+"','"+far.getEstado()+"','"+far.getMunicipio()+"','"+far.getColonia()+"','"+far.getCalle()+"','"+far.getCP()+"','"+far.getNoLocal()+"','"+far.getNombreFarmacia()+"' )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from farmacias";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}

}
