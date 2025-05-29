package Controlador;

import Modelo.Medico;

import Modelo.Paciente;
import conexionBD.ConexionBD;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoCabeceraDAO {
    ConexionBD conexionBD =  ConexionBD.getInstance();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;
    public boolean agregarMedicCabecera(Medico m, Paciente p ){
        String sql = "INSERT INTO  medicosCabecera VALUES('"+m.getNumSSN()+"','"+p.getNumSSN()+"' );";
        return  conexionBD.ejecutarInstruccionLMD(sql);
    }
    public String buscar_NSS_MedicCabecera( Paciente p ){
        String sql = "select NSS from medicosCabecera where ID_Paciente_SSN= '"+ p.getNumSSN() + "'";
        String id = "";
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        try {
            if(rs.next()) {//busca al menos un registro con el filtro seleciionado
                id = rs.getString(1);
                System.out.println("Si encontramos registros");
            }else
                System.out.println("NO se encontró el registro"); //!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hay una exeption");
        }
        return  id;
    }



}
