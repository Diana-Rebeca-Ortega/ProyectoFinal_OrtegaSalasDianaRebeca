package Vista.GUI_Paciente;

import Modelo.Paciente;

import javax.swing.*;
import java.awt.*;

public class PanelInformacionPersonal extends JFrame {
    JPanel panPersonalPaciente;

    public  JPanel agregarPanelPerfil(Paciente p ){
        panPersonalPaciente = new JPanel();
        panPersonalPaciente.setBounds(5,100,1050,470);
        panPersonalPaciente.setBackground(new Color(225, 253, 207));
        panPersonalPaciente.setLayout(null);


        JLabel txtPerfil = new JLabel();
        formatoPerfilPaciente(txtPerfil,"Información del Perfil", 20,10,300,40,"Verdana",24,panPersonalPaciente );

        JLabel txtUsuario = new JLabel();
        txtUsuario.setForeground(Color.red);
        formatoPerfilPaciente( txtUsuario,"usuario:", 25,90,100,50,"Tahoma",11 , panPersonalPaciente  );

        JLabel txtSSN = new JLabel();
        formatoPerfilPaciente(txtSSN, "SSN (Número de Seguro Social):", 73,90,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtSSNRes = new JLabel();
        formatoPerfilPacienteRes(txtSSNRes, p.getNumSSN(), 73,120,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtNombre = new JLabel();
        formatoPerfilPaciente(txtNombre, "Nombre:", 73, 170,200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtNombreRes = new JLabel();
        formatoPerfilPacienteRes(txtNombreRes, p.getNombre(), 73, 190,200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtApellidoUno = new JLabel();
        formatoPerfilPaciente(txtApellidoUno, "Apellido Paterno:", 350,170,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtApellidoUnoRes = new JLabel();
        formatoPerfilPacienteRes(txtApellidoUnoRes, p.getPrimerApellido(), 350,190,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtApellidoDos = new JLabel();
        formatoPerfilPaciente(txtApellidoDos, "Apellido Materno:", 700,170,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtApellidoDosRes = new JLabel();
        formatoPerfilPacienteRes(txtApellidoDosRes, p.getSegundoApellido(), 700,190,300,20,"Verdana",14,panPersonalPaciente);

        JLabel txtEdad = new JLabel();
        formatoPerfilPaciente(txtEdad, "Edad:", 73,250, 200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtEdadRes = new JLabel();
        formatoPerfilPacienteRes(txtEdadRes, p.getEdad()+"", 73,270, 200,20, "Verdana",14,panPersonalPaciente);

        JLabel txtCALLE = new JLabel();
        formatoPerfilPaciente(txtCALLE, "Calle:", 350, 250, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtCALLERes = new JLabel();
        formatoPerfilPacienteRes(txtCALLERes, String.valueOf(  p.getCalle()), 350, 270, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtColonia = new JLabel();
        formatoPerfilPaciente(txtColonia, "Colonia:", 700, 250, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtColoniaRes = new JLabel();
        formatoPerfilPacienteRes(txtColoniaRes, String.valueOf(  p.getColonia()), 700, 270, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtNOCASA = new JLabel();
        formatoPerfilPaciente(txtNOCASA, "NO.CASA:", 350, 330, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtNOCASARes = new JLabel();
        formatoPerfilPacienteRes(txtNOCASARes, String.valueOf(  p.getNo_Casa()), 350, 350, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtCP = new JLabel();
        formatoPerfilPaciente(txtCP, "CP:", 700, 330, 200,20, "Verdana",14,panPersonalPaciente );

        JLabel txtCPRes = new JLabel();
        formatoPerfilPacienteRes(txtCPRes, String.valueOf(  p.getCP()), 700, 350, 200,20, "Verdana",14,panPersonalPaciente );

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
