package Vista.GUI_Paciente;

import Controlador.MedicoCabeceraDAO;
import Controlador.MedicoDAO;
import Modelo.Medico;
import Modelo.Paciente;

import javax.swing.*;
import java.awt.*;

public class PanelMedicoCabecera {
    JPanel panPersonalPaciente;
    MedicoCabeceraDAO medicoCabeceraDAO = new MedicoCabeceraDAO();
    MedicoDAO mDAO = new MedicoDAO();
    Medico medico ;
    public  JPanel agregarPanelMedicoCabecera( Paciente p ){
        panPersonalPaciente = new JPanel();
        panPersonalPaciente.setBounds(5,100,1050,470);
        panPersonalPaciente.setBackground(new Color(225, 253, 207));
        panPersonalPaciente.setLayout(null);
        String NSSmediquito = medicoCabeceraDAO.buscar_NSS_MedicCabecera( p);

        medico =  mDAO.mostrarMedico( NSSmediquito,"ID");

        JLabel txtPerfil = new JLabel();
        formatoPerfilPaciente(txtPerfil,"Medico de Cabecera", 20,10,300,40,"Verdana",24,panPersonalPaciente );

        JLabel txtNombre = new JLabel();
        formatoPerfilPaciente(txtNombre, "Nombre:  ", 73, 170,200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtNombreRes = new JLabel();
        formatoPerfilPacienteRes(txtNombreRes, medico.getNombre(), 73, 190,200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtApellidoUno = new JLabel();
        formatoPerfilPaciente(txtApellidoUno, "Apellido Paterno:", 350,170,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtApellidoUnoRes = new JLabel();
        formatoPerfilPacienteRes(txtApellidoUnoRes, medico.getPrimerApellido(), 350,190,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtApellidoDos = new JLabel();
        formatoPerfilPaciente(txtApellidoDos, "Apellido Materno:", 700,170,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtApellidoDosRes = new JLabel();
        formatoPerfilPacienteRes(txtApellidoDosRes, medico.getSegundoApellido(), 700,190,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtEspecialidad = new JLabel();
        formatoPerfilPaciente(txtEspecialidad, "Especialidad:", 73,250, 200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtEspecialidadRes = new JLabel();
        formatoPerfilPacienteRes(txtEspecialidadRes, medico.getEspecialidad()+"", 73,270, 200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtAnosExpe = new JLabel();
        formatoPerfilPaciente(txtAnosExpe, "Años de experiencia:", 350, 250, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtAñosRes = new JLabel();
        formatoPerfilPacienteRes(txtAñosRes, String.valueOf(  medico.getAñosExperiencia()), 350, 270, 200,20, "Verdana",14,panPersonalPaciente );

        return panPersonalPaciente;
    }

    public void formatoPerfilPacienteRes(JLabel etiqueta, String texto, int x, int y ,
                                         int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        etiqueta.setForeground(new Color( 35, 97, 154));
        pan.add(etiqueta);
    }
    public void formatoPerfilPaciente(JLabel etiqueta, String texto, int x, int y ,
                                      int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        pan.add(etiqueta);
    }

}
