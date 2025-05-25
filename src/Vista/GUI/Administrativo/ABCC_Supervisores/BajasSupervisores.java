package Vista.GUI.Administrativo.ABCC_Supervisores;

import Controlador.PacienteDAO;
import Controlador.SupervisorDAO;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BajasSupervisores extends JFrame implements ActionListener {

    JTable tablaSupervisoresBajas;
    JTextField cajaNSS;
    JLabel cajaNombre, cajaApPaterno, cajaApMaterno;
    JLabel txtNSS,  txtNombre, txtApellidoPaterno, txtApellidoMaterno;
    JPanel panelRojo, panelROSA;
    JButton btnBuscar, btnBorrar, btnEliminar, btnCancelar;

    public BajasSupervisores() {
        getContentPane().setLayout(null);
        setTitle("Bajas Supervisores");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);

        tablaSupervisoresBajas = new JTable();
        tablaSupervisoresBajas.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null,null},
                        {null, null, null,null },
                        {null, null, null,null},
                        {null, null, null,null},
                        {null, null, null,null}
                },
                new String[]{
                        "NSS", "Nombre", "Primer Apellido","Segundo Apellido"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        //PANEL VERDE ROSA
        panelROSA = new JPanel();
        panelROSA.setLayout(null);
        panelROSA.setBackground(new Color(255, 46, 93 ));
        panelROSA.setBounds(10, 320, 870, 170);

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaSupervisoresBajas);
        scrollPane.setBounds(10, 10, 840, 150);
        panelROSA.add(scrollPane);

        add(panelROSA);


//Panel ROJO TITULO
        panelRojo = new JPanel();
        panelRojo.setLayout(null);
        panelRojo.setBackground(new Color(237, 0, 0));
        panelRojo.setBounds(0, 0, 900, 30);
        JLabel texBAJAS = new JLabel("    BAJAS SUPERVISORES:");
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

        txtNombre.setBounds( 40, 100, 300, 20);
        txtApellidoPaterno.setBounds( 40, 130, 300, 20);
        txtApellidoMaterno.setBounds( 40, 160, 300, 20);

        add(txtNombre);
        add(txtApellidoPaterno);
        add(txtApellidoMaterno);

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

        actualizarTabla(tablaSupervisoresBajas);

    }//constructor
    public void actualizarTabla(JTable tabla) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = " select * from supervisores;";
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
            for (int i = 0; i < tablaSupervisoresBajas.getRowCount(); i++) {// muestra cuantas filas hay
                if (tablaSupervisoresBajas.getValueAt(i, 0).equals(cajaNSS.getText())) {///tablaAlumnosBajas.getValueAt(fila,columna)
                    cajaNombre.setText(tablaSupervisoresBajas.getValueAt(i, 1) + "");
                    cajaApPaterno.setText(tablaSupervisoresBajas.getValueAt(i, 2) + "");
                    cajaApMaterno.setText(tablaSupervisoresBajas.getValueAt(i, 3) + "");
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

        }if( e.getSource().equals(btnEliminar)){
            SupervisorDAO supervisorDAO = new SupervisorDAO();
            if (supervisorDAO.eliminarSupervisor(cajaNSS.getText())) {
                actualizarTabla(tablaSupervisoresBajas);
                System.out.println("FELICIDADES: se ha ELIMINADO correctamente desde la Ven_Inicio");
            }else
                System.out.println("ERROR:  la ELIMINACION del registro lindo desde la Ven_Inicio no se consiguio");
        }
        if( e.getSource().equals(btnCancelar)){
            setVisible(false);
        }

    }
}
