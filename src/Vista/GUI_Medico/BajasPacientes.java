package Vista.GUI_Medico;

import Controlador.PacienteDAO;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BajasPacientes  extends JFrame implements ActionListener {
    //**************************    BAJAS   *********************************************************

        JTable tablaPacientesBajas;
        JTextField cajaNSS;
        JLabel cajaNombre, cajaApPaterno, cajaApMaterno, cajaCalle, cajaColonia, cajaEdad;
        JLabel txtNSS,  txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtCalle, txtColonia, txtEdad;
        JPanel panelRojo, panelROSA;
        JButton btnBuscar, btnBorrar, btnEliminar, btnCancelar;

        public BajasPacientes() {
            getContentPane().setLayout(null);
            setTitle("Bajas Pacientes");
            setSize(900,530);
            setLocationRelativeTo(null);//locacion en la ventana
            setVisible(true);

            tablaPacientesBajas = new JTable();
            tablaPacientesBajas.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null, null, null,null,null},
                            {null, null, null, null, null, null,  null,null,null},
                            {null, null, null, null, null, null,  null,null,null},
                            {null, null, null, null, null, null,  null,null,null},
                            {null, null, null, null, null, null,  null,null,null}
                    },
                    new String[]{
                            "SSN", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "EDAD", "Calle", "Colonia", "No.Casa", "CP"
                    }) {
                boolean[] canEdit = new boolean[]{
                        false, false, false, false, true, true
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            //PANEL VERDE ROSA
            panelROSA = new JPanel();
            panelROSA.setLayout(null);
            panelROSA.setBackground(new Color(255, 46, 93 ));
            panelROSA.setBounds(10, 280, 870, 170);

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tablaPacientesBajas);
            scrollPane.setBounds(10, 10, 840, 150);
            panelROSA.add(scrollPane);

            add(panelROSA);


//Panel ROJO TITULO
            panelRojo = new JPanel();
            panelRojo.setLayout(null);
            panelRojo.setBackground(new Color(237, 0, 0));
            panelRojo.setBounds(0, 0, 900, 30);
            JLabel texBAJAS = new JLabel("    BAJAS PACIENTES:");
            texBAJAS.setBounds(10, 0, 300, 20);
            texBAJAS.setForeground(Color.WHITE);
            panelRojo.add(texBAJAS);
            add(panelRojo);

            txtNSS = new JLabel("NUM. SEGURO SOCIAL:");
            txtNSS.setBounds(40, 40, 230, 20);
            txtNSS.setFont(new Font("Arial", Font.BOLD, 13));
            add(txtNSS);

            JLabel  linea = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
            linea.setBounds(3, 80, 700, 20);
            linea.setBackground(new Color(139, 166, 169 ));
            add(linea);

            cajaNSS = new JTextField();
            cajaNSS.setBounds(190, 40, 200, 20);
            add(cajaNSS);

            btnBuscar = new JButton();
            ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
            btnBuscar.setIcon(buscarRuta  );
            btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
            btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
            btnBuscar.setBounds(getWidth()-260, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
            add(btnBuscar);
            btnBuscar.addActionListener(this);

            btnBorrar = new JButton("BORRAR");
            btnEliminar = new JButton("ELIMINAR");
            btnCancelar = new JButton("CANCELAR");

            btnBorrar.addActionListener(this);
            btnEliminar.addActionListener(this);
            btnCancelar.addActionListener(this);

            btnBorrar.setBounds(getWidth()-130, 40, 100, 20);
            add(btnBorrar);
            btnEliminar.setBounds(getWidth()-130, 130, 100, 20);
            add(btnEliminar);
            btnCancelar.setBounds(getWidth()-130, 190, 100, 20);
            add(btnCancelar);

            txtNombre = new JLabel("NOMBRE:");
            txtApellidoPaterno= new JLabel("APELLIDO PATERNO:");
            txtApellidoMaterno = new JLabel("APELLIDO MATERNO:");
            txtEdad = new JLabel("EDAD:");
            txtCalle = new JLabel("CALLE:");
            txtColonia = new JLabel("COLONIA:");

            txtNombre.setBounds( 40, 100, 300, 20);
            txtApellidoPaterno.setBounds( 40, 130, 300, 20);
            txtApellidoMaterno.setBounds( 40, 160, 300, 20);
            txtEdad.setBounds(40, 190, 300, 20);
            txtCalle.setBounds( 40, 220, 300, 20);
            txtColonia.setBounds( 40, 250, 300, 20);


            add(txtNombre);
            add(txtApellidoPaterno);
            add(txtApellidoMaterno);
            add(txtEdad);
            add(txtCalle);
            add(txtColonia);

            Border borde = BorderFactory.createLineBorder(   Color.BLACK);

            cajaNombre = new JLabel();

            cajaNombre.setBorder(borde);
            cajaNombre.setBackground(new Color(218, 230, 231 ));
            cajaNombre.setOpaque(true);
            cajaNombre.setBounds(110, 100, 270, 18);
            add(cajaNombre);

            cajaApPaterno = new JLabel();
            cajaApPaterno.setBorder(borde);
            cajaApPaterno.setBackground(new Color(218, 230, 231 ));
            cajaApPaterno.setOpaque(true);
            cajaApPaterno.setBounds(170, 130, 270, 18);
            add(cajaApPaterno);

            cajaApMaterno = new JLabel();
            cajaApMaterno.setBorder(borde);
            cajaApMaterno.setBackground(new Color(218, 230, 231 ));
            cajaApMaterno.setOpaque(true);
            cajaApMaterno.setBounds(185, 160, 270, 18);
            add(cajaApMaterno);

            cajaEdad= new JLabel();
            cajaEdad.setBorder(borde);
            cajaEdad.setBackground(new Color(218, 230, 231 ));
            cajaEdad.setOpaque(true);
            cajaEdad.setBounds(130, 190, 270, 18);
            add(cajaEdad);

            cajaCalle = new JLabel();
            cajaCalle.setBorder(borde);
            cajaCalle.setBackground(new Color(218, 230, 231 ));
            cajaCalle.setOpaque(true);
            cajaCalle.setBounds(120, 220, 270, 18);
            add(cajaCalle);

            cajaColonia = new JLabel();
            cajaColonia.setBorder(borde);
            cajaColonia.setBackground(new Color(218, 230, 231 ));
            cajaColonia.setOpaque(true);
            cajaColonia.setBounds(120, 250, 270, 18);
            add(cajaColonia);
            actualizarTabla(tablaPacientesBajas);

        }//constructor
    public void actualizarTabla(JTable tabla) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = " select * from pacientes;";
        //el final se refiere a que son constantes
        try {
            ResultSetTableModel modelo = new ResultSetTableModel(Driver_Controlador, URL, CONSULTA);
            tabla.setModel(modelo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }//actualizarTabla


        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource().equals(btnBuscar)) {
                int registro = 1;
                for (int i = 0; i < tablaPacientesBajas.getRowCount(); i++) {// muestra cuantas filas hay
                    if (tablaPacientesBajas.getValueAt(i, 0).equals(cajaNSS.getText())) {///tablaAlumnosBajas.getValueAt(fila,columna)
                        cajaNombre.setText(tablaPacientesBajas.getValueAt(i, 1) + "");
                        cajaApPaterno.setText(tablaPacientesBajas.getValueAt(i, 2) + "");
                        cajaApMaterno.setText(tablaPacientesBajas.getValueAt(i, 3) + "");
                        cajaEdad.setText(tablaPacientesBajas.getValueAt(i, 4) + "");
                        cajaCalle.setText(tablaPacientesBajas.getValueAt(i, 5) + "");
                        cajaColonia.setText(tablaPacientesBajas.getValueAt(i, 6) + "");
                        registro = registro * 0;

                    }
                }
                if (registro == 1) {
                    JOptionPane.showMessageDialog(null, "No se encontro registro");
                }
            }if (e.getSource().equals(btnBorrar)){//***************************************************************
                cajaNSS.setText("");
                cajaApPaterno.setText("");
                cajaApMaterno.setText("");
                cajaNombre.setText("");
                cajaCalle.setText("");
                cajaColonia.setText("");
                cajaEdad.setText("");
            }if( e.getSource().equals(btnEliminar)){
                PacienteDAO pacienteDAO = new PacienteDAO();
                if (pacienteDAO.eliminarAlumnos(cajaNSS.getText())) {
                    actualizarTabla(tablaPacientesBajas);
                    System.out.println("FELICIDADES: se ha ELIMINADO correctamente desde la Ven_Inicio");
                }else
                    System.out.println("ERROR:  la ELIMINACION del registro lindo desde la Ven_Inicio no se consiguio");
            }
            if( e.getSource().equals(btnCancelar)){
                setVisible(false);
            }

        }
}////class bajas_Alumnos

