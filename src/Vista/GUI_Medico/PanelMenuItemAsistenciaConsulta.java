package Vista.GUI_Medico;

import Controlador.ConsultaDAO;
import Controlador.PacienteDAO;
import Modelo.Consulta;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.ResultSetTableModel;
import Vista.GUI_Medico.ConsultasMedicas.AsistenciaConsulta;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class PanelMenuItemAsistenciaConsulta  implements ActionListener {
    JPanel panelAsistenciaConsulta;
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
    JButton btnAsistenciaConsulta;
    JButton btnRestablecer;
    Medico me ;
    Paciente pa;
    JTable tablaConsultas;
    String ID_Consulta="";
    public PanelMenuItemAsistenciaConsulta(Medico me) {
        this.me = me;
    }
    public void actualizarTabla(JTable tabla, Paciente pa ) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = "select * from consultas where ID_Paciente_SSN ='"+pa.getNumSSN()+"'";
        try {
            ResultSetTableModel modelo = new ResultSetTableModel(Driver_Controlador, URL, CONSULTA);
            tabla.setModel(modelo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }//actualizarTabla
    public JPanel agregar_panelAsistenciaConsulta(JToolBar toolBar,
                                               JButton btnCancelar){


//*******************Panel ASISTENCIA Consulta ***************************
        panelAsistenciaConsulta = new JPanel();
        panelAsistenciaConsulta.setBounds(5,toolBar.getHeight()+5,1050,470);
        panelAsistenciaConsulta.setBackground(new Color(207, 253, 242));
        panelAsistenciaConsulta.setLayout(null);

        tablaConsultas = new JTable();
        tablaConsultas.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "ID Consulta", "NSS Paciente", "ID Medico", "Motivo", "Fecha y Hora"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tablaConsultas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAsistenciaConsulta.setEnabled(true);
                int row = tablaConsultas.rowAtPoint(e.getPoint());
                int column = tablaConsultas.columnAtPoint(e.getPoint());
                // Código para ejecutar cuando se hace clic en una celda
                System.out.println("Clic en la fila " + row + " y columna " + column);
                System.out.println( tablaConsultas.getRowCount());
                 ID_Consulta = String.valueOf( tablaConsultas.getValueAt(row, column));
                Consulta con = conDAO.buscarConsulta( ID_Consulta);

                btnAsistenciaConsulta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new AsistenciaConsulta(con );
                            }
                        });
                    }
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaConsultas);
        scrollPane.setBounds(500, 200, 500, 180);
        panelAsistenciaConsulta.add(scrollPane);

        JLabel txtAsignarConsulta = new JLabel();
        formatoPerfilMedico(txtAsignarConsulta,"ASISTENCIA CONSULTA",30,10,350,40,"Arial",25, panelAsistenciaConsulta);

        JLabel txtSeleccionar = new JLabel();
        formatoPerfilMedico(txtSeleccionar, "Seleccione un paciente para continuar con la consulta", 40,40,450,20,"Arial", 16, panelAsistenciaConsulta);

        JLabel txtBuscandolo = new JLabel();
        formatoPerfilMedico(txtBuscandolo,"Ingrese SSN para tener acceso a los datos del Paciente", 50,70,600,20,"Arial", 12, panelAsistenciaConsulta);

        cajaBuscarPaciente = new JTextField();
        cajaBuscarPaciente.setBounds(50, 95, 300, 20);
        panelAsistenciaConsulta.add(cajaBuscarPaciente);

        BufferedImage imBuscar;
        try {imBuscar = ImageIO.read(new File("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\buscar.png"));
        } catch (
                IOException e) {throw new RuntimeException(e);}

        btnBuscar = new JButton(new ImageIcon(imBuscar.getScaledInstance(20,20, Image.SCALE_SMOOTH)));
        btnBuscar.setBounds(350, 95, 20, 20);
        panelAsistenciaConsulta.add(btnBuscar);
        btnBuscar.addActionListener(this);

        JLabel txtDatos = new JLabel();
        formatoPerfilMedico(txtDatos, "Datos del Paciente:", 50, 170, 250,20, "Arial", 15, panelAsistenciaConsulta);

        txtSSNConsulta = new JLabel();
        formatoPerfilMedico(txtSSNConsulta, "SSN:", 50, 200, 300, 20, "Arial", 14, panelAsistenciaConsulta);

        txtNombree = new JLabel();
        formatoPerfilMedico(txtNombree, "Nombre:", 50, 230, 300, 20, "Arial", 12, panelAsistenciaConsulta);

        txtAPuno = new JLabel();
        formatoPerfilMedico(txtAPuno, "A.Paterno: ", 50, 260, 300, 20, "Arial", 12, panelAsistenciaConsulta);

        txtAPdos = new JLabel();
        formatoPerfilMedico(txtAPdos, "A.Materno: ", 50, 290, 300, 20, "Arial", 12, panelAsistenciaConsulta);

        txtEdaad = new JLabel();
        formatoPerfilMedico(txtEdaad, "Edad: ", 50, 320, 300, 20, "Arial", 12, panelAsistenciaConsulta);

        txtColonia = new JLabel();
        txtCalle = new JLabel();
        txtNO = new JLabel();
        txtCP = new JLabel();

        formatoPerfilMedico(txtColonia, "Colonia: ", 300, 200, 300, 20, "Arial", 12, panelAsistenciaConsulta);
        formatoPerfilMedico(txtCalle, "Calle: ", 300, 230, 300, 20, "Arial", 12, panelAsistenciaConsulta);
        formatoPerfilMedico(txtNO, "NO.Casa: ", 300, 260, 300, 20, "Arial", 12, panelAsistenciaConsulta);
        formatoPerfilMedico(txtCP, "Codigo Postal: ", 300, 290, 300, 20, "Arial", 12, panelAsistenciaConsulta);

        btnAsistenciaConsulta = new JButton("Tomar Asistencia Consulta");
        btnAsistenciaConsulta.setBounds(550,410,200,20 );
        panelAsistenciaConsulta.add(btnAsistenciaConsulta);
        btnAsistenciaConsulta.setEnabled(false);
        btnAsistenciaConsulta.addActionListener(this);

        btnRestablecer = new JButton("Reestablecer");
        btnRestablecer.setBounds(230,410,110,20 );
        panelAsistenciaConsulta.add(btnRestablecer);
        btnRestablecer.addActionListener(this);
        return panelAsistenciaConsulta;
    }

    public void formatoPerfilMedico(JLabel etiqueta, String texto, int x, int y ,
                                    int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        pan.add(etiqueta);
    }
    ConsultaDAO conDAO= new ConsultaDAO();
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBuscar){
            System.out.println("buscando nns");
            if(pacienteDAO.mostrarPaciente(cajaBuscarPaciente.getText(), "ID")==null){
                JOptionPane.showMessageDialog(null,  "No se encontraron registros");
            }else{
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
                actualizarTabla(tablaConsultas, ob1);
            }//else
        }

        if (e.getSource() == btnRestablecer){
            System.out.println("cnacelar");
            cajaBuscarPaciente.setText("");
            txtSSNConsulta.setText("SSN:     ");
            txtNombree.setText("Nombre:     ");
            txtAPuno.setText("A.Paterno:     ");
            txtAPdos.setText("A.Materno:     ");
            txtEdaad.setText("Edad:     ");
            txtCalle.setText("Colonia:     ");
            txtColonia.setText("Calle:     ");
            txtCP.setText("NO.Casa:     ");
            txtNO.setText("Codigo Postal:     ");
            tablaConsultas.setModel( new DefaultTableModel(
                    new Object[][]{}, new String[]{
                            "ID Consulta", "NSS Paciente", "ID Medico", "Motivo", "Fecha y Hora"
                    }

            ));
            panelAsistenciaConsulta.repaint();
            panelAsistenciaConsulta.revalidate();
            btnAsistenciaConsulta.setEnabled(false);
        }
    }
}
