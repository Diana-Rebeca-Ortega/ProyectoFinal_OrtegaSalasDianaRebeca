package Vista.GUI_Medico.ABCC_Pacientes;

import Controlador.PacienteDAO;
import Modelo.Paciente;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CambiosPacientes extends JFrame implements ActionListener {
    JPanel panelNaranja, panelAmarillo;
    JTable tablaPacientesModificaiones;
    JTextField cajaSSN,cajaNombre, cajaApPaterno, cajaApMaterno;
    JTextField cajaCalle, cajaColonia, cajaNoCasa, cajaCP;
    JLabel texNSS, txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtEdad, txtCalle, txtColonia, txtNocASA, txtCP   ;
    JButton btnBuscar, btnBorrar, btnGuardarCambios, btnCancelar;
    JComboBox comboEDAD;

    public CambiosPacientes() {
        getContentPane().setLayout(null);
        setTitle("Modificar Pacientes");
        setSize(900,580);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);

        tablaPacientesModificaiones = new JTable();
        tablaPacientesModificaiones.setModel(new DefaultTableModel(
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
                    false, false, false, false, true, true, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        actualizarTabla(tablaPacientesModificaiones);
        //PANEL  Amarillo
        panelAmarillo = new JPanel();
        panelAmarillo.setLayout(null);
        panelAmarillo.setBackground(new Color(234, 146, 26 ));
        panelAmarillo.setBounds(10, getHeight()-210, 870, 200);

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaPacientesModificaiones);
        scrollPane.setBounds(10, 10, 825, 180);
        panelAmarillo.add(scrollPane);

        add(panelAmarillo);



//Panel NARANJA TITULO
        panelNaranja = new JPanel();
        panelNaranja.setLayout(null);
        panelNaranja.setBackground(new Color(255, 97, 0 ));
        panelNaranja.setBounds(0, 0, getWidth(), 30);
        JLabel texBAJAS = new JLabel("    MODIFICACIONES PACIENTES:");
        texBAJAS.setBounds(10, 0, 290, 20);
        texBAJAS.setForeground(Color.WHITE);
        panelNaranja.add(texBAJAS);
        add(panelNaranja);

        texNSS = new JLabel("NO. Seguro Social:");
        texNSS.setBounds(40, 40, 230, 20);
        texNSS.setFont(new Font("Arial", Font.BOLD, 13));
        add(texNSS);

        JLabel  linea = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
        linea.setBounds(3, 80, 700, 20);
        linea.setBackground(new Color(139, 166, 169 ));
        add(linea);

        cajaSSN = new JTextField();
        cajaSSN.setBounds(190, 40, 200, 20);
        add(cajaSSN);

        btnBuscar = new JButton();
        btnBuscar.addActionListener(this);
        ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
        btnBuscar.setIcon(buscarRuta  );
        btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
        btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnBuscar.setBounds(getWidth()-170, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
        add(btnBuscar);

        btnBorrar = new JButton("BORRAR");
        btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
        btnCancelar = new JButton("CANCELAR");

        btnBorrar .addActionListener(this);
        btnGuardarCambios.addActionListener(this);
        btnCancelar.addActionListener(this);



        btnBorrar.setBounds(getWidth()-150, 130, 100, 20);
        add(btnBorrar);
        btnGuardarCambios.setBounds(getWidth()-180, 160, 170, 20);
        add(btnGuardarCambios);
        btnCancelar.setBounds(getWidth()-150, 190, 100, 20);
        add(btnCancelar);

        txtNombre = new JLabel("NOMBRE:");
        txtApellidoPaterno= new JLabel("APELLIDO PATERNO:");
        txtApellidoMaterno = new JLabel("APELLIDO MATERNO:");
        txtEdad = new JLabel("EDAD:");
        txtCalle = new JLabel("CALLE:");
        txtColonia = new JLabel("COLONIA:");
        txtNocASA = new JLabel("NO.CASA:");
        txtCP = new JLabel("CP:");

        txtNombre.setBounds( 40, 100, 300, 20);
        txtApellidoPaterno.setBounds( 40, 130, 300, 20);
        txtApellidoMaterno.setBounds( 40, 160, 300, 20);
        txtEdad.setBounds(40, 190, 300, 20);
        txtCalle.setBounds( 40, 220, 300, 20);
        txtColonia.setBounds( 40, 250, 300, 20);
        txtNocASA.setBounds( 40, 280, 300, 20);
        txtCP.setBounds( 40, 310, 300, 20);

        add(txtNombre);
        add(txtApellidoPaterno);
        add(txtApellidoMaterno);
        add(txtEdad);
        add(txtCalle);
        add(txtColonia);
        add(txtNocASA);
        add(txtCP);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(110, 100, 200, 18);
        add(cajaNombre);

        cajaApPaterno = new JTextField();
        cajaApPaterno.setBounds(170, 130, 200, 18);
        add(cajaApPaterno);

        cajaApMaterno = new JTextField();
        cajaApMaterno.setBounds(185, 160, 200, 18);
        add(cajaApMaterno);

        comboEDAD = new JComboBox<String>();
        comboEDAD.addItem("0");
        for(int i =1; i <99;i++){
            comboEDAD.addItem(i);
        }
        comboEDAD.setBounds(130, 190, 270, 18);
        add(comboEDAD);

        cajaCalle = new JTextField();
        cajaCalle.setBounds(170, 220, 200, 18);
        add(cajaCalle);

        cajaColonia = new JTextField();
        cajaColonia.setBounds(195, 250, 200, 18);
        add(cajaColonia);

        cajaNoCasa = new JTextField();
        cajaNoCasa.setBounds(195, 280, 200, 18);
        add(cajaNoCasa);

        cajaCP = new JTextField();
        cajaCP.setBounds(195, 310, 200, 18);
        add(cajaCP);



        actualizarTabla(tablaPacientesModificaiones);
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
        if (e.getSource().equals(btnBorrar)) {//***************************************************************
            cajaSSN.setText("");
            cajaApPaterno.setText("");
            cajaApMaterno.setText("");
            cajaNombre.setText("");
            comboEDAD.setSelectedIndex(0);
            cajaCalle.setText("");
            cajaColonia.setText("");
            cajaNoCasa.setText("");
            cajaCP.setText("");
        }
        PacienteDAO pacienteDAO = new PacienteDAO();
        if (e.getSource().equals(btnGuardarCambios)) {
            Paciente a1 = new Paciente(cajaSSN.getText(), cajaNombre.getText(),cajaApPaterno.getText(),
                    cajaApMaterno.getText(), Byte.parseByte(
                    comboEDAD.getSelectedItem()+""), cajaCalle.getText(),
                    cajaColonia.getText(),cajaNoCasa.getText(), cajaCP.getText());
            if (pacienteDAO.cambiarPaciente(a1)) {
                actualizarTabla(tablaPacientesModificaiones);
                System.out.println("Registro modificado CORRECTAMENTE desde la Ven_Inicio");
            }else
                System.out.println("ERROR en la modificacion del registro lindo desde la Ven_Inicio");
        }

        if (e.getSource().equals(btnBuscar)) {//**************************************************************************
            System.out.println("buscar datos");
            System.out.println(cajaSSN.getText());
            int registro = 1;
            for (int i = 0; i < tablaPacientesModificaiones.getRowCount(); i++) {// muestra cuantas filas hay
                if (tablaPacientesModificaiones.getValueAt(i, 0).equals(cajaSSN.getText())) {///tabla.getValueAt(fila,columna)
                    cajaNombre.setText(tablaPacientesModificaiones.getValueAt(i, 1) + "");
                    cajaApPaterno.setText(tablaPacientesModificaiones.getValueAt(i, 2) + "");
                    cajaApMaterno.setText(tablaPacientesModificaiones.getValueAt(i, 3) + "");
                    comboEDAD.setSelectedItem(tablaPacientesModificaiones.getValueAt(i, 4));
                    cajaCalle.setText(tablaPacientesModificaiones.getValueAt(i, 5) + "");
                    cajaColonia.setText(tablaPacientesModificaiones.getValueAt(i, 6) + "");
                    cajaNoCasa.setText(tablaPacientesModificaiones.getValueAt(i, 7) + "" );
                    cajaCP.setText(tablaPacientesModificaiones.getValueAt(i, 8) + "" );
                    registro = registro * 0;

                }
            }
            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
            }
        }
        if( e.getSource().equals(btnCancelar)){//******************************************************************
            setVisible(false);
            //aqui podriamos poner un historial q regrese los valores
        }
    }
}
