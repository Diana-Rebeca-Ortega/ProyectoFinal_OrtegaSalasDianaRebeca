package Controlador;

import Modelo.Medicamentos;
import Modelo.Supervisor;
import conexionBD.ConexionBD;

import java.sql.ResultSet;

public class MedicamentosDAO {

    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;
    //***************************************ALTAS*******************************
    public boolean agregarMedicamentos(Medicamentos medicamentos){
        String sql = "INSERT INTO  medicamentos VALUES('"+medicamentos.getID_Registro()+"','"+medicamentos.getNombreCompañia()+"','"+medicamentos.getNombreComercial()+"','"+medicamentos.getFormula()+"' );";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
}
