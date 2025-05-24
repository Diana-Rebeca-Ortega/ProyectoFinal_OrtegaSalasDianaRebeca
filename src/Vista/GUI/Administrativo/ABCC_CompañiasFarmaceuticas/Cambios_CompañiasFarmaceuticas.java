package Vista.GUI.Administrativo.ABCC_CompañiasFarmaceuticas;

import Controlador.ComFarmaceuticaDAO;
import Modelo.CompanniaFarmaceutica;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Cambios_CompañiasFarmaceuticas extends JFrame implements ActionListener {
    JPanel panelNaranja, panelAmarillo;
    JTable tablaComFarCambios;
    JTextField cajaNombreCom, cajaTelefono;
    JLabel texNombreFarmacias, txtTelefono ;
    JButton btnBuscar, btnBorrar, btnGuardarCambios, btnCancelar;

    public Cambios_CompañiasFarmaceuticas() {
        getContentPane().setLayout(null);
        setTitle("Modificar Compañias Farmaceuticas");
        setSize(900,580);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);

        tablaComFarCambios = new JTable();
        tablaComFarCambios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                new String[]{
                        "Nombre Compañia", "Telefono"
                }) {boolean[] canEdit = new boolean[]{
                    false, false};public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }});
        actualizarTabla(tablaComFarCambios);

        //PANEL  Amarillo
        panelAmarillo = new JPanel();
        panelAmarillo.setLayout(null);
        panelAmarillo.setBackground(new Color(234, 146, 26 ));
        panelAmarillo.setBounds(10, getHeight()-210, 870, 200);

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaComFarCambios
        );
        scrollPane.setBounds(10, 10, 825, 180);
        panelAmarillo.add(scrollPane);

        add(panelAmarillo);



//Panel NARANJA TITULO
        panelNaranja = new JPanel();
        panelNaranja.setLayout(null);
        panelNaranja.setBackground(new Color(255, 97, 0 ));
        panelNaranja.setBounds(0, 0, getWidth(), 30);
        JLabel texBAJAS = new JLabel("    MODIFICACIONES COMPAÑIAS FARMACEUTICAS:");
        texBAJAS.setBounds(10, 0, 290, 20);
        texBAJAS.setForeground(Color.WHITE);
        panelNaranja.add(texBAJAS);
        add(panelNaranja);

        texNombreFarmacias = new JLabel("Nombre Compañia:");
        texNombreFarmacias.setBounds(40, 40, 230, 20);
        texNombreFarmacias.setFont(new Font("Arial", Font.BOLD, 13));
        add(texNombreFarmacias);

        JLabel  linea = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
        linea.setBounds(3, 80, 700, 20);
        linea.setBackground(new Color(139, 166, 169 ));
        add(linea);

        cajaNombreCom = new JTextField();
        cajaNombreCom.setBounds(190, 40, 200, 20);
        add(cajaNombreCom);

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

        txtTelefono = new JLabel("Telefono:");
        txtTelefono.setBounds( 40, 100, 300, 20);
        add(txtTelefono);

        cajaTelefono = new JTextField();
        cajaTelefono.setBounds(110, 100, 200, 18);
        add(cajaTelefono);

        actualizarTabla(tablaComFarCambios
        );
    }//constructor
    public void actualizarTabla(JTable tabla) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = " select * from compañiasfarmaceuticas;";
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
            cajaNombreCom.setText("");
        }
        ComFarmaceuticaDAO cfDAO = new ComFarmaceuticaDAO();
        if (e.getSource().equals(btnGuardarCambios)) {
            CompanniaFarmaceutica cf = new CompanniaFarmaceutica(cajaNombreCom.getText(), cajaTelefono.getText());
            if (cfDAO.cambiarComFar(cf)) {
                actualizarTabla(tablaComFarCambios
        );
                System.out.println("Registro modificado CORRECTAMENTE");
            }else
                System.out.println("ERROR en la modificacion del registro lindo ");
        }

        if (e.getSource().equals(btnBuscar)) {//**************************************************************************
            System.out.println("buscar datos");
            System.out.println(cajaNombreCom.getText());
            int registro = 1;
            for (int i = 0; i < tablaComFarCambios.getRowCount(); i++) {// muestra cuantas filas hay
                if (tablaComFarCambios.getValueAt(i, 0).equals(cajaNombreCom.getText())) {///tabla.getValueAt(fila,columna)
                    cajaTelefono.setText(tablaComFarCambios.getValueAt(i, 1) + "");
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
