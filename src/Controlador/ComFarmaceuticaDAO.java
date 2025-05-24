package Controlador;

import Modelo.CompanniaFarmaceutica;
import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComFarmaceuticaDAO {
    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;
    //***************************************ALTAS*******************************
    public boolean agregarCF(CompanniaFarmaceutica cf){
        String sql = "INSERT INTO compañiasfarmaceuticas VALUES('"+cf.getNombreCompania()+"','"+cf.getTelefono()+"' )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //*******************************CAMBIOS*****************************
    public boolean cambiarComFar( CompanniaFarmaceutica cf){
        String sql = "UPDATE compañiasfarmaceuticas SET  NombreCompania='" +cf.getNombreCompania() +"'," +
                " Telefono='" +cf.getTelefono() + "'";
        return  conexionBD.ejecutarInstruccionLMD(sql); //retorta 0, 1 o 2... false o true
    }


}
