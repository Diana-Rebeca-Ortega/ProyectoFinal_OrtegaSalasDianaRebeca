package Controlador;

import Modelo.CompanniaFarmaceutica;
import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                " Telefono='" +cf.getTelefono() + "' WHERE NombreCompania='"+ cf.getNombreCompania()+"'";
        return  conexionBD.ejecutarInstruccionLMD(sql); //retorta 0, 1 o 2... false o true
    }
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from  compañiasfarmaceuticas";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}

    //************************************ NOMBRES DE ComFARMACEUTICAS ***********
    public List<String> NombresCompañiasFarmaceuticas() {
        sql = "select NombreCompania from compañiasfarmaceuticas";
        rs = conexionBD.ejecutarInstruccionSQL(sql);
        List<String> companias = new ArrayList<>();
        try {
            while (rs.next()) {
                companias.add(rs.getString(1));
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
        return companias;
    }



    //*******************************CONSULTAS/*****************************
    public CompanniaFarmaceutica mostrarComFar(String filtro, String tipoBusqueda){
        String sql= "";

        if (tipoBusqueda.equals("Uno")){
            sql = "select * from compañiasfarmaceuticas ORDER BY NombreCompania DESC LIMIT 0,1;";}
        if (tipoBusqueda.equals("Ultimo")){
            sql = "select * from compañiasfarmaceuticas ORDER BY NombreCompania DESC LIMIT "+filtro+",1;";}


        if (tipoBusqueda.equals("ID"))
            sql = "SELECT * FROM compañiasfarmaceuticas WHERE NombreCompania='"+filtro+"'";
        if (tipoBusqueda.equals("Tel"))
            sql = "SELECT * FROM compañiasfarmaceuticas WHERE Telefono='"+filtro+"'";

        System.out.println(sql);
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        CompanniaFarmaceutica a = null;
        try {
            if(rs.next()) {//busca al menos un registro con el filtro seleciionado
                String id = rs.getString(1);
                String tel = rs.getString("Telefono");


                a = new CompanniaFarmaceutica(id,tel);
                System.out.println("Si encontramos registros");
            }else
                System.out.println("NO se encontró el registro"); //!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hay una exeption");
        }
        return a;
    }


}
