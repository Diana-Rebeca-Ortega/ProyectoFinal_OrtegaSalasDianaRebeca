package Vista.GUI_Medico;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelMenuItemAsignarConsultaMedica implements ActionListener {
    JPanel panelAsignarConsulta;
    public JPanel agregar_panelAsignarConsulta(JToolBar toolBar, JButton btnAsignarConsulta,
    JButton btnCancelar){


//*******************Panel Asignar Consulta ***************************
    panelAsignarConsulta = new JPanel();
        panelAsignarConsulta.setBounds(5,toolBar.getHeight()+5,1050,470);
        panelAsignarConsulta.setBackground(new Color(225, 253, 207));
        panelAsignarConsulta.setLayout(null);

    JLabel txtAsignarConsulta = new JLabel();
    formatoPerfilMedico(txtAsignarConsulta,"ASIGNAR CONSULTA",30,10,350,40,"Arial",25, panelAsignarConsulta);

    JLabel txtSeleccionar = new JLabel();
    formatoPerfilMedico(txtSeleccionar, "Seleccione un paciente para asignarle una consulta medica", 40,40,450,20,"Arial", 16, panelAsignarConsulta);

    JLabel txtBuscandolo = new JLabel();
    formatoPerfilMedico(txtBuscandolo,"Ingrese SSN para tener acceso a los datos del Paciente", 50,70,600,20,"Arial", 12, panelAsignarConsulta);

    JTextField cajaBuscarPaciente = new JTextField();
        cajaBuscarPaciente.setBounds(50, 95, 300, 20);
        panelAsignarConsulta.add(cajaBuscarPaciente);

    BufferedImage imBuscar;
        try {imBuscar = ImageIO.read(new File("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\buscar.png"));
    } catch (
    IOException e) {throw new RuntimeException(e);}

    JButton btnBuscar = new JButton(new ImageIcon(imBuscar.getScaledInstance(20,20, Image.SCALE_SMOOTH)));
        btnBuscar.setBounds(350, 95, 20, 20);
        panelAsignarConsulta.add(btnBuscar);

    JLabel txtDatos = new JLabel();
    formatoPerfilMedico(txtDatos, "Datos del Paciente:", 50, 170, 250,20, "Arial", 15, panelAsignarConsulta );

    JLabel txtSSNConsulta = new JLabel();
    formatoPerfilMedico(txtSSNConsulta, "SSN:", 50, 200, 50, 20, "Arial", 14, panelAsignarConsulta);

    JLabel txtNombree = new JLabel();
    formatoPerfilMedico(txtNombree, "Nombre:", 50, 230, 100, 20, "Arial", 12, panelAsignarConsulta);

    JLabel txtAPuno = new JLabel();
    formatoPerfilMedico(txtAPuno, "A.Paterno: ", 50, 260, 100, 20, "Arial", 12, panelAsignarConsulta);

    JLabel txtAPdos = new JLabel();
    formatoPerfilMedico(txtAPdos, "A.Materno: ", 50, 290, 100, 20, "Arial", 12, panelAsignarConsulta);

    JLabel txtEdaad = new JLabel();
    formatoPerfilMedico(txtEdaad, "Edad: ", 50, 320, 100, 20, "Arial", 12, panelAsignarConsulta);

    JLabel txtColonia = new JLabel();
    JLabel txtCalle = new JLabel();
    JLabel txtNO = new JLabel();
    JLabel txtCP = new JLabel();

    formatoPerfilMedico(txtColonia, "Colonia: ", 500, 200, 100, 20, "Arial", 12, panelAsignarConsulta);
    formatoPerfilMedico(txtCalle, "Calle: ", 500, 230, 100, 20, "Arial", 12, panelAsignarConsulta);
    formatoPerfilMedico(txtNO, "NO.Casa: ", 500, 260, 100, 20, "Arial", 12, panelAsignarConsulta);
    formatoPerfilMedico(txtCP, "Codigo Postal: ", 500, 290, 100, 20, "Arial", 12, panelAsignarConsulta);

    btnAsignarConsulta = new JButton("Asignar Consulta");
        btnAsignarConsulta.setBounds(100,410,160,20 );
        panelAsignarConsulta.add(btnAsignarConsulta);
        btnAsignarConsulta.addActionListener(this);

    btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(270,410,110,20 );
        panelAsignarConsulta.add(btnCancelar);
        btnCancelar.addActionListener(this);
        return panelAsignarConsulta;
    }

    public void formatoPerfilMedico(JLabel etiqueta, String texto, int x, int y ,
                                    int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        pan.add(etiqueta);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}