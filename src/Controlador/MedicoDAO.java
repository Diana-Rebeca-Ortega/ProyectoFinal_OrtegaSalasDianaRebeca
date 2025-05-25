package Controlador;

//importar otros paquetes
import Modelo.Medico;
import conexionBD.ConexionBD;


//importar librerias


//CLASE CONTROLADOERA DEL MODELO ALUMNO
//DAO - DATA ACCESSS OBJECT
public class MedicoDAO {
    ConexionBD conexionBD = new ConexionBD();

    //MMMMMMMMMMMMMMMMMMMMMMETODOS ABCCccccccccccccccccccccccccccccccccc


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

/*
    //*******************************CONSULTAS/*****************************
    public Alumno mostrarAlumno(String filtro, String tipoBusqueda){
        String sql= "";
        if (tipoBusqueda.equals("Nombre")){
            sql = "SELECT * FROM alumnos WHERE Nombre='"+filtro+"'";
        }
        if (tipoBusqueda.equals("PrimerAP")){
            sql = "SELECT * FROM alumnos WHERE PrimerAP='"+filtro+"'";
        }
        if (tipoBusqueda.equals("SegundoAP")){
            sql = "SELECT * FROM alumnos WHERE SegundoAP='"+filtro+"'";
        }
        if (tipoBusqueda.equals("Edad")){
            sql = "SELECT * FROM alumnos WHERE Edad='"+filtro+"'";
        }
        if (tipoBusqueda.equals("Semestre")){
            sql = "SELECT * FROM alumnos WHERE Semestre='"+filtro+"'";
        }
        if (tipoBusqueda.equals("Carrera")){
            sql = "SELECT * FROM alumnos WHERE Carrera='"+filtro+"'";
        }
        if (tipoBusqueda.equals("TODOS")){
            sql = "SELECT * FROM alumnos WHERE Nombre='"+filtro+"', PrimerAP='"+filtro+"'" +
                    "SegundoAP='"+filtro+"'" +
                    "Edad='"+filtro+"'" +
                    "Semestre='"+filtro+"'" +
                    "Carrera='"+filtro+"'";
        }

        System.out.println(sql);
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql);
        Alumno a = null;
        try {
            if(rs.next()) {//busca al menos un registro con el filtro seleciionado
                String nc = rs.getString(1);
                String n = rs.getString("Nombre");
                String pa = rs.getString(3);
                String sa = rs.getString("SegundoAP");
                byte e = rs.getByte(5);
                byte s = rs.getByte(6);
                String c = rs.getString(7);
                a = new Alumno(nc, n, pa, sa, e, s, c);
                System.out.println("Si encontramos registros");
                System.out.println("ayuda" +a);
            }else
                System.out.println("NO se encontró el registro"); //!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hay una exeption");
        }
        return a;
    }
/*
    public ArrayList mostrarAlumnos(String filtro){
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
       //String sql = "SELECT * FROM Alumnos";
        String sql4 = "SELECT * FROM Alumnos WHERE Semestre='"+filtro+"'";
        ResultSet rs = conexionBD.ejecutarInstruccionSQL(sql4);
        try {
            rs.next();
            do {
                String nc = rs.getString(1);
                String n = rs.getString("Nombre");
                String pa = rs.getString(3);
                String sa = rs.getString("SegundoAP");
                byte e = rs.getByte(5);
                byte s = rs.getByte(6);
                String c = rs.getString(7);

                Alumno a = new Alumno(nc, n, pa, sa, e, s, c);
                listaAlumnos.add(a);
            }while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }
*/

}
