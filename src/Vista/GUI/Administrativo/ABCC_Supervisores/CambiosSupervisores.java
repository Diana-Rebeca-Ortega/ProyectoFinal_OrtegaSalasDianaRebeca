package Vista.GUI.Administrativo.ABCC_Supervisores;

import Controlador.PacienteDAO;
import Controlador.SupervisorDAO;
import Modelo.Paciente;
import Modelo.ResultSetTableModel;
import Modelo.Supervisor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CambiosSupervisores extends JFrame implements ActionListener {
    JPanel panelNaranja, panelAmarillo;
    JTable tablaSupervisoresModificaiones;
    JTextField cajaSSN,cajaNombre, cajaApPaterno, cajaApMaterno;
    JLabel texNSS, txtNombre, txtApellidoPaterno, txtApellidoMaterno   ;
    JButton btnBuscar, btnBorrar, btnGuardarCambios, btnCancelar;


    public CambiosSupervisores() {
        getContentPane().setLayout(null);
        setTitle("Modificar Supervisor");
        setSize(900,580);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);

        tablaSupervisoresModificaiones = new JTable();
        tablaSupervisoresModificaiones.setModel(new DefaultTableModel(
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
        actualizarTabla(tablaSupervisoresModificaiones);
        //PANEL  Amarillo
        panelAmarillo = new JPanel();
        panelAmarillo.setLayout(null);
        panelAmarillo.setBackground(new Color(234, 146, 26 ));
        panelAmarillo.setBounds(10, getHeight()-210, 870, 200);

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaSupervisoresModificaiones);
        scrollPane.setBounds(10, 10, 825, 180);
        panelAmarillo.add(scrollPane);

        add(panelAmarillo);



//Panel NARANJA TITULO
        panelNaranja = new JPanel();
        panelNaranja.setLayout(null);
        panelNaranja.setBackground(new Color(255, 97, 0 ));
        panelNaranja.setBounds(0, 0, getWidth(), 30);
        JLabel texCambios = new JLabel("    MODIFICACIONES SUPERVISORES:");
        texCambios.setBounds(10, 0, 290, 20);
        texCambios.setForeground(Color.WHITE);
        panelNaranja.add(texCambios);
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

        txtNombre.setBounds( 40, 100, 300, 20);
        txtApellidoPaterno.setBounds( 40, 130, 300, 20);
        txtApellidoMaterno.setBounds( 40, 160, 300, 20);

        add(txtNombre);
        add(txtApellidoPaterno);
        add(txtApellidoMaterno);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(110, 100, 200, 18);
        add(cajaNombre);

        cajaApPaterno = new JTextField();
        cajaApPaterno.setBounds(170, 130, 200, 18);
        add(cajaApPaterno);

        cajaApMaterno = new JTextField();
        cajaApMaterno.setBounds(185, 160, 200, 18);
        add(cajaApMaterno);

        actualizarTabla(tablaSupervisoresModificaiones);
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
        if (e.getSource().equals(btnBorrar)) {//***************************************************************
            cajaSSN.setText("");
            cajaApPaterno.setText("");
            cajaApMaterno.setText("");
            cajaNombre.setText("");
        }
        SupervisorDAO supervisorDAO = new SupervisorDAO();
        if (e.getSource().equals(btnGuardarCambios)) {
            Supervisor a1 = new Supervisor(cajaSSN.getText(), cajaNombre.getText(),cajaApPaterno.getText(),
                    cajaApMaterno.getText() );
            if (supervisorDAO.cambiarSupervisor(a1)) {
                actualizarTabla(tablaSupervisoresModificaiones);
                System.out.println("Registro modificado CORRECTAMENTE desde la Ven_Inicio");
            }else
                System.out.println("ERROR en la modificacion del registro lindo desde la Ven_Inicio");
        }

        if (e.getSource().equals(btnBuscar)) {//**************************************************************************
            System.out.println("buscar datos");
            System.out.println(cajaSSN.getText());
            int registro = 1;
            for (int i = 0; i < tablaSupervisoresModificaiones.getRowCount(); i++) {// muestra cuantas filas hay
                if (tablaSupervisoresModificaiones.getValueAt(i, 0).equals(cajaSSN.getText())) {///tabla.getValueAt(fila,columna)
                    cajaNombre.setText(tablaSupervisoresModificaiones.getValueAt(i, 1) + "");
                    cajaApPaterno.setText(tablaSupervisoresModificaiones.getValueAt(i, 2) + "");
                    cajaApMaterno.setText(tablaSupervisoresModificaiones.getValueAt(i, 3) + "");
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
