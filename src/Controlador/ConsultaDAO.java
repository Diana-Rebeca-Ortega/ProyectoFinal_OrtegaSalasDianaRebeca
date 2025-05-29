package Controlador;

import Modelo.Consulta;
import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaDAO {
    ConexionBD conexionBD = ConexionBD.getInstance();
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

    public Consulta buscarConsulta( String idConsulta ){
        String sql = "select * from consultas where ID_Consulta ='"+idConsulta+"'";
        Consulta consulta = null;
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        try {
            if(rs.next()) {//busca al menos un registro con el filtro seleciionado
                String c = rs.getString(1);
                String p  = rs.getString(2);
                String m  = rs.getString(3);
                String mo = rs.getString(4);
                String f  = rs.getString(5);

                consulta = new Consulta(c,p,m,mo,f);
                System.out.println("Si encontramos registros");
            }else
                System.out.println("NO se encontró el registro"); //!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hay una exeption");
        }
        return  consulta;
    }

}
