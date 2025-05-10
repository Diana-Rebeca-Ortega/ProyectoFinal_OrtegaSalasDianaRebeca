package Vista.GUI_Medico;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsignarConsulta extends JFrame {
    public  AsignarConsulta(){
        setTitle("Asignar Consulta");
        setSize(700,490);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
        setBackground( new Color(244, 254, 237));

        BufferedImage image;
        try {image = ImageIO.read(new File("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\LogoRX.png"));
        } catch (IOException e) {throw new RuntimeException(e);}

        JLabel logo = new JLabel(new ImageIcon(image.getScaledInstance(30,30,Image.SCALE_SMOOTH)));
        logo.setBounds((getWidth()/2)-30,5,30,30);
        add(logo);

        JLabel txtFMX = new JLabel("Farmacias RX");
        txtFMX.setBounds((getWidth()/2)-50,33,80,20);
        add(txtFMX);

        JLabel txtDireccionFar = new JLabel("Dirección de Farmacia:");
        txtDireccionFar.setBounds(10,50,200,20);
        add(txtDireccionFar);

        JLabel txtMedico = new JLabel("Medico que atiende:");
        txtMedico.setBounds(10,70,200,20);
        add(txtMedico);

        JLabel txtEspe = new JLabel("Especialidad:");
        txtEspe.setBounds(10,90,200,20);
        add(txtEspe);

        JLabel txtPaciente = new JLabel("Paciente:");
        txtPaciente.setBounds(10,110,200,20);
        add(txtPaciente);

        JLabel txtPacienteSSN = new JLabel("SSN:");
        txtPacienteSSN.setBounds(10,130,200,20);
        add(txtPacienteSSN);

        JLabel txtPacienteNombre = new JLabel("Nombre:");
        txtPacienteNombre.setBounds(10,150,200,20);
        add(txtPacienteNombre);

        JLabel txtPacienteAP1 = new JLabel("A.Paterno:");
        txtPacienteAP1.setBounds(10,170,200,20);
        add(txtPacienteAP1);

        JLabel txtPacienteAP2 = new JLabel("A.Materno:");
        txtPacienteAP2.setBounds(10,190,200,20);
        add(txtPacienteAP2);

        JLabel txtMotivoConsulta = new JLabel("Motivo Consulta:");
        txtMotivoConsulta.setBounds(10,210,200,20);
        add(txtMotivoConsulta);

        JTextArea motivo = new JTextArea(10,20);
        motivo.setBounds(10,230,400,50);
        motivo.setLineWrap(true);
        motivo.setWrapStyleWord(true);
        add(motivo);

        JLabel txtFecha = new JLabel("Fecha para la cita");
        txtFecha.setBounds(10,300,200,20);
        add(txtFecha);

        JLabel txtHora = new JLabel("Hora de la cita");
        txtHora.setBounds(10,330,200,20);
        add(txtHora);

        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBounds(10,380,100,20);
        add(btnAceptar);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(150,380,100,20);
        add(btnCancelar);

    }

}
