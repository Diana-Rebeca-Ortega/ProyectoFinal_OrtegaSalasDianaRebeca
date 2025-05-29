package Controlador;

//importar otros paquetes
import Modelo.Medico;
import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;


//importar librerias


//CLASE CONTROLADOERA DEL MODELO ALUMNO
//DAO - DATA ACCESSS OBJECT
public class MedicoDAO {
    ConexionBD conexionBD =  ConexionBD.getInstance();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;


    //***************************************ALTAS*******************************
    public boolean agregarMedico(Medico medico){
        // System.out.println("numcontrol"+alumno.getNumControl());
        String sql = "INSERT INTO medicos VALUES('"+medico.getNumSSN()+"','"+medico.getNombre()+"','"+medico.getPrimerApellido()+"','"+medico.getSegundoApellido()+"','"+medico.getEspecialidad()+"','"+medico.getAñosExperiencia()+"')";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }

    //*******************************BAJAS/*****************************
    public  boolean eliminarMedicos (String medico){
        String sql = "DELETE FROM medicos WHERE  NSS='"+medico+"' ";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }


    //*******************************CAMBIOS*****************************
    public boolean cambiarMedico( Medico medico){
        String sql = "UPDATE medicos SET Nombre='" + medico.getNombre() +"'," +
                " PApellido='" + medico.getPrimerApellido() +"',  SApellido='" + medico.getSegundoApellido() +"'," +
                " Especialidad='"+medico.getEspecialidad()+"', AñosExperiencia='"+medico.getAñosExperiencia()+
                " WHERE NSS='" + medico.getNumSSN() + "'";
        return  conexionBD.ejecutarInstruccionLMD(sql); //retorta 0, 1 o 2... false o true
    }
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from medicos";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}


    //*******************************CONSULTAS/*****************************
    public Medico mostrarMedico(String filtro, String tipoBusqueda){
        String sql= "";

        if (tipoBusqueda.equals("Uno")){
            sql = "select * from medicos ORDER BY NSS DESC LIMIT 0,1;";}
        if (tipoBusqueda.equals("Ultimo")){
            sql = "select * from medicos ORDER BY NSS DESC LIMIT "+filtro+",1;";}


        if (tipoBusqueda.equals("ID"))
            sql = "SELECT * FROM medicos WHERE NSS='"+filtro+"'";
        if (tipoBusqueda.equals("Nombre"))
            sql = "SELECT * FROM medicos WHERE Nombre='"+filtro+"'";
        if (tipoBusqueda.equals("PApellido")){
            sql = "SELECT * FROM medicos WHERE PApellido='"+filtro+"'";}
        if (tipoBusqueda.equals("SApellido")){
            sql = "SELECT * FROM medicos WHERE SApellido='"+filtro+"'";}
        if (tipoBusqueda.equals("espe")){
            sql = "SELECT * FROM medicos WHERE Especialidad='"+filtro+"'";}
        if (tipoBusqueda.equals("ae")){
            sql = "SELECT * FROM medicos WHERE  AñosExperiencia='"+filtro+"'";}
        System.out.println(sql);
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        Medico a = null;
        try {
            if(rs.next()) {//busca al menos un registro con el filtro seleciionado
                String id = rs.getString(1);
                String n = rs.getString(2);
                String pa = rs.getString(3);
                String sa = rs.getString(4);
                String e = rs.getString(5);
                Byte ae = rs.getByte(6);


                a = new Medico(id,n,pa,sa,e,ae);
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
