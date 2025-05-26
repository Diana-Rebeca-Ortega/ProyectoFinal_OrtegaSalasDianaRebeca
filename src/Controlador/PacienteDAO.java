package Controlador;

import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDAO {
    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
    //***************************************ALTAS*******************************
    public boolean agregarPaciente(Paciente paciente){
        String sql = "INSERT INTO pacientes VALUES('"+paciente.getNumSSN()+"','"+paciente.getNombre()+"','"+paciente.getPrimerApellido()+"','"+paciente.getSegundoApellido()+"','"+paciente.getEdad()+"','"+paciente.getCalle()+"','"+paciente.getColonia()+"','"+paciente.getNo_Casa()+"','"+paciente.getCP()+"' )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //*******************************BAJAS/*****************************
    public  boolean eliminarPaciente(String numSeguroSocial){
        String sql = "DELETE FROM pacientes WHERE ID_Paciente_SSN='"+numSeguroSocial+"' ";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //************************************TAMAÑO REGISTROS***********
    public int tamañoTablas (){
        sql = "select count(*) from pacientes";
        rs= conexionBD.ejecutarInstruccionSQL(sql);
        int tamaño=0;
        try {
            if (rs.next()){
                tamaño = rs.getInt(1);
                System.out.println("reistris : "+tamaño);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}return tamaño;}

    //*******************************CONSULTAS/*****************************
    public Paciente mostrarPaciente(String filtro, String tipoBusqueda){
        String sql= "";

        if (tipoBusqueda.equals("Uno")){
            sql = "select * from pacientes ORDER BY ID_Paciente_SSN DESC LIMIT 0,1;";}
        if (tipoBusqueda.equals("Ultimo")){
            sql = "select * from pacientes ORDER BY ID_Paciente_SSN DESC LIMIT "+filtro+",1;";}


        if (tipoBusqueda.equals("ID"))
            sql = "SELECT * FROM pacientes WHERE ID_Paciente_SSN='"+filtro+"'";
        if (tipoBusqueda.equals("Nombre"))
            sql = "SELECT * FROM pacientes WHERE Nombre='"+filtro+"'";
        if (tipoBusqueda.equals("PApellido")){
            sql = "SELECT * FROM pacientes WHERE PApellido='"+filtro+"'";}
        if (tipoBusqueda.equals("SApellido")){
            sql = "SELECT * FROM pacientes WHERE SApellido='"+filtro+"'";}
        if (tipoBusqueda.equals("Edad")){
            sql = "SELECT * FROM pacientes WHERE Edad='"+filtro+"'";}
        if (tipoBusqueda.equals("calle")){
            sql = "SELECT * FROM pacientes WHERE  calle='"+filtro+"'";}
        if (tipoBusqueda.equals("Colonia")){
            sql = "SELECT * FROM pacientes WHERE Colonia='"+filtro+"'";}
        System.out.println(sql);
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        Paciente a = null;
        try {
            if(rs.next()) {//busca al menos un registro con el filtro seleciionado
                String id = rs.getString(1);
                String n = rs.getString("Nombre");
                String pa = rs.getString(3);
                String sa = rs.getString("SApellido");
                byte e = rs.getByte(5);
                String ca = rs.getString(6);
                String col = rs.getString(7);
                String nc = rs.getString(8);
                String cp = rs.getString(9);

                a = new Paciente(id,n,pa,sa,e,ca,col,nc,cp);
                System.out.println("Si encontramos registros");
            }else
                System.out.println("NO se encontró el registro"); //!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hay una exeption");
        }
        return a;
    }
    //*******************************CAMBIOS*****************************
    public boolean cambiarPaciente(Paciente paciente){
        sql = "UPDATE pacientes SET Nombre='"+
                paciente.getNombre()+"',PApellido='"+
                paciente.getPrimerApellido()+"', SApellido='"+
                paciente.getSegundoApellido()+"',Edad='"+
                paciente.getEdad()+"', calle='"+
                paciente.getCalle()+"', Colonia='"+
                paciente.getColonia()+"',No_Casa='"+
                paciente.getNo_Casa()+"', CP='"+
                paciente.getCP()+"'  WHERE ID_Paciente_SSN='"+
                paciente.getNumSSN()+"'; ";
        return  conexionBD.ejecutarInstruccionLMD(sql); //retorta 0, 1 o 2... false o true
    }
}
