package Vista.GUI_Medico;

import Controlador.PacienteDAO;
import Modelo.Medico;
import Modelo.Paciente;
import Vista.GUI_Medico.ConsultasMedicas.AsignarConsulta_Altas;

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
    JButton btnBuscar;
    JTextField cajaBuscarPaciente;
    PacienteDAO pacienteDAO = new PacienteDAO();
    JLabel txtNombree;
    JLabel txtAPuno;
    JLabel txtAPdos;
    JLabel txtSSNConsulta;
    JLabel txtEdaad;
    JLabel txtColonia ;
    JLabel txtCalle ;
    JLabel txtNO;
    JLabel txtCP ;
    JButton btnAsignarConsulta;
    JButton btnCancelar;
    Medico me ;
    Paciente pa;

    public PanelMenuItemAsignarConsultaMedica(Medico me) {
        this.me = me;
    }

    public JPanel agregar_panelAsignarConsulta(JToolBar toolBar,
                                               JButton btnCancelar){


//*******************Panel ASIGNAR Consulta ***************************
    panelAsignarConsulta = new JPanel();
        panelAsignarConsulta.setBounds(5,toolBar.getHeight()+5,1050,470);
        panelAsignarConsulta.setBackground(new Color(180, 228, 165));
        panelAsignarConsulta.setLayout(null);

    JLabel txtAsignarConsulta = new JLabel();
    formatoPerfilMedico(txtAsignarConsulta,"ASIGNAR CONSULTA",30,10,350,40,"Arial",25, panelAsignarConsulta);

    JLabel txtSeleccionar = new JLabel();
    formatoPerfilMedico(txtSeleccionar, "Seleccione un paciente para asignarle una consulta medica", 40,40,450,20,"Arial", 16, panelAsignarConsulta);

    JLabel txtBuscandolo = new JLabel();
    formatoPerfilMedico(txtBuscandolo,"Ingrese SSN para tener acceso a los datos del Paciente", 50,70,600,20,"Arial", 12, panelAsignarConsulta);

     cajaBuscarPaciente = new JTextField();
        cajaBuscarPaciente.setBounds(50, 95, 300, 20);
        panelAsignarConsulta.add(cajaBuscarPaciente);

    BufferedImage imBuscar;
        try {imBuscar = ImageIO.read(new File("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\buscar.png"));
    } catch (
    IOException e) {throw new RuntimeException(e);}

    btnBuscar = new JButton(new ImageIcon(imBuscar.getScaledInstance(20,20, Image.SCALE_SMOOTH)));
        btnBuscar.setBounds(350, 95, 20, 20);
        panelAsignarConsulta.add(btnBuscar);
        btnBuscar.addActionListener(this);

    JLabel txtDatos = new JLabel();
    formatoPerfilMedico(txtDatos, "Datos del Paciente:", 50, 170, 250,20, "Arial", 15, panelAsignarConsulta );

    txtSSNConsulta = new JLabel();
    formatoPerfilMedico(txtSSNConsulta, "SSN:", 50, 200, 300, 20, "Arial", 14, panelAsignarConsulta);

    txtNombree = new JLabel();
    formatoPerfilMedico(txtNombree, "Nombre:", 50, 230, 300, 20, "Arial", 12, panelAsignarConsulta);

    txtAPuno = new JLabel();
    formatoPerfilMedico(txtAPuno, "A.Paterno: ", 50, 260, 300, 20, "Arial", 12, panelAsignarConsulta);

    txtAPdos = new JLabel();
    formatoPerfilMedico(txtAPdos, "A.Materno: ", 50, 290, 300, 20, "Arial", 12, panelAsignarConsulta);

    txtEdaad = new JLabel();
    formatoPerfilMedico(txtEdaad, "Edad: ", 50, 320, 300, 20, "Arial", 12, panelAsignarConsulta);

     txtColonia = new JLabel();
     txtCalle = new JLabel();
     txtNO = new JLabel();
     txtCP = new JLabel();

    formatoPerfilMedico(txtColonia, "Colonia: ", 500, 200, 300, 20, "Arial", 12, panelAsignarConsulta);
    formatoPerfilMedico(txtCalle, "Calle: ", 500, 230, 300, 20, "Arial", 12, panelAsignarConsulta);
    formatoPerfilMedico(txtNO, "NO.Casa: ", 500, 260, 300, 20, "Arial", 12, panelAsignarConsulta);
    formatoPerfilMedico(txtCP, "Codigo Postal: ", 500, 290, 300, 20, "Arial", 12, panelAsignarConsulta);

    btnAsignarConsulta = new JButton("Asignar Consulta");
        btnAsignarConsulta.setBounds(100,410,160,20 );
        panelAsignarConsulta.add(btnAsignarConsulta);
        btnAsignarConsulta.setEnabled(false);
        btnAsignarConsulta.setToolTipText("Este boton no se activara hasta que ingrese un NSS registrado en FarmaciasRX");
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
        if(e.getSource()==btnBuscar){
            System.out.println("buscando nns");
                if(pacienteDAO.mostrarPaciente(cajaBuscarPaciente.getText(), "ID")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else{

                    btnAsignarConsulta.setEnabled(true);
                    Paciente ob1 = pacienteDAO.mostrarPaciente(cajaBuscarPaciente.getText(), "ID");
                    txtSSNConsulta.setText("SSN:     "+ob1.getNumSSN());
                    txtNombree.setText("Nombre:     "+ob1.getNombre());
                    txtAPuno.setText("A.Paterno:     "+ob1.getPrimerApellido());
                    txtAPdos.setText("A.Materno:     "+ob1.getSegundoApellido());
                    txtEdaad.setText("Edad:     "+ob1.getEdad());
                    txtCalle.setText("Colonia:     "+ob1.getColonia());
                    txtColonia.setText("Calle:     "+ob1.getCalle());
                    txtCP.setText("NO.Casa:     "+ob1.getNo_Casa());
                    txtNO.setText("Codigo Postal:     "+ob1.getCP());
                    pa = ob1;
                }//else
        }
        if(e.getSource()==btnAsignarConsulta){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AsignarConsulta_Altas(me, pa );
                }
            });
        }if (e.getSource() == btnCancelar){
            txtSSNConsulta.setText("SSN:     ");
            txtNombree.setText("Nombre:     ");
            txtAPuno.setText("A.Paterno:     ");
            txtAPdos.setText("A.Materno:     ");
            txtEdaad.setText("Edad:     ");
            txtCalle.setText("Colonia:     ");
            txtColonia.setText("Calle:     ");
            txtCP.setText("NO.Casa:     ");
            txtNO.setText("Codigo Postal:     ");
        }
    }
}