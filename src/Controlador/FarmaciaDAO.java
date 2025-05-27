package Controlador;

import Modelo.Farmacia;
import Modelo.Paciente;
import conexionBD.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FarmaciaDAO {
    ConexionBD conexionBD = new ConexionBD();
    String sql ="";
    ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);;
    //***************************************ALTAS*******************************
    public boolean agregarFarmacia(Farmacia far){
        String sql = "INSERT INTO farmacias VALUES('"+far.getID_Farmacia()+"','"+far.getTelefono()+"','"+far.getEstado()+"','"+far.getMunicipio()+"','"+far.getColonia()+"','"+far.getCalle()+"','"+far.getCP()+"','"+far.getNoLocal()+"','"+far.getNombreFarmacia()+"' )";
        return  conexionBD.ejecutarInstruccionLMD(sql);//retorta 0, 1 o 2... false o true
    }
    //***********************Buscar Sucursales *******************
    public List<String> buscarSucursalesFarmacias(String Municipio) {
        //Solo para el login

        sql =  "select * from  farmacias  where Municipio = '"+Municipio+"';";
        rs = conexionBD.ejecutarInstruccionSQL(sql);
        List<String> sucu = new ArrayList<>();
        try {
            while (rs.next()) {
                sucu.add(rs.getString(9));
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
        return sucu;
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
    //*******************************CAMBIOS*****************************
    public boolean cambiarFarmacia(Farmacia farmacia){
        sql = "UPDATE farmacias SET  Telefono='"+
                farmacia.getTelefono()+"',Estado='"+
                farmacia.getEstado()+"', Municipio='"+
                farmacia.getMunicipio()+"',Colonia='"+
                farmacia.getColonia()+"', Calle='"+
                farmacia.getCalle()+"', CP='"+
                farmacia.getCP()+"',No_Local='"+
                farmacia.getNoLocal()+"',  NombreFarmacia='"+
                farmacia.getNombreFarmacia()+"'  WHERE ID_Farmacia='"+
                farmacia.getID_Farmacia()+"'; ";
        return  conexionBD.ejecutarInstruccionLMD(sql); //retorta 0, 1 o 2... false o true
    }
    //*******************************CONSULTAS/*****************************
    public Farmacia mostrarFarmacia(String filtro, String tipoBusqueda){
        String sql= "";

        if (tipoBusqueda.equals("Uno")){
            sql = "select * from  farmacias ORDER BY ID_Farmacia DESC LIMIT 0,1;";}
        if (tipoBusqueda.equals("Ultimo")){
            sql = "select * from  farmacias ORDER BY ID_Farmacia DESC LIMIT "+filtro+",1;";}


        if (tipoBusqueda.equals("ID"))
            sql = "SELECT * FROM  farmacias WHERE ID_Farmacia='"+filtro+"'";
        if (tipoBusqueda.equals("Telefono"))
            sql = "SELECT * FROM  farmacias WHERE Telefono='"+filtro+"'";
        if (tipoBusqueda.equals("Estado")){
            sql = "SELECT * FROM  farmacias WHERE Estado='"+filtro+"'";}
        if (tipoBusqueda.equals("Municipio")){
            sql = "SELECT * FROM  farmacias WHERE Municipio='"+filtro+"'";}
        if (tipoBusqueda.equals("Colonia")){
            sql = "SELECT * FROM  farmacias WHERE Colonia='"+filtro+"'";}
        if (tipoBusqueda.equals("Calle")){
            sql = "SELECT * FROM  farmacias WHERE  Calle='"+filtro+"'";}
        if (tipoBusqueda.equals("CP")){
            sql = "SELECT * FROM  farmacias WHERE CP='"+filtro+"'";}
        if (tipoBusqueda.equals("Nombre")){
            sql = "SELECT * FROM  farmacias WHERE NombreFarmacia='"+filtro+"'";}
        System.out.println(sql);
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        Farmacia a = null;
        try {
            if(rs.next()) {//busca al menos un registro con el filtro seleciionado
                String id = rs.getString(1);
                int tel = rs.getInt(2);
                String es = rs.getString(3);
                String mu = rs.getString(4);
                String co = rs.getString(5);
                String ca = rs.getString(6);
                int cp = rs.getInt(7);
                int nl = rs.getInt(8);
                String no = rs.getString(9);

                a = new Farmacia(id,tel,es,mu,co,ca,cp,nl,no);
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
