package Vista.GUI_Administrativo;

import Controlador.FarmaciaDAO;
import Controlador.PacienteDAO;
import Modelo.Farmacia;
import Modelo.Paciente;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CambiosFarmacias extends JFrame implements ActionListener {
    JPanel panelNaranja, panelAmarillo;
    JTable tablaFarmaciasModificaiones;
    JTextField cajaid, cajaTelefono, cajaColonia, cajaCP;
    JTextField cajaCalle, cajaNoLocal, cajaNombre;
    JLabel texID, txtTel, txtEstado, txtMunicipio, txtColonia, txtCalle, txtCP, txtNocASA, txtNombre;
    JButton btnBuscar, btnBorrar, btnGuardarCambios, btnCancelar;
    JComboBox  cajaEstado, cajaMunicipio;

    public CambiosFarmacias() {
        getContentPane().setLayout(null);
        setTitle("Modificar Farmacias");
        setSize(900,580);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);

        tablaFarmaciasModificaiones = new JTable();
        tablaFarmaciasModificaiones.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null}
                },
                new String[]{
                        "ID", "Telefono", "Estado", "Municipio", "Colonia", "Calle", "CP", "No.Local", "Nombre"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true, true, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        actualizarTabla(tablaFarmaciasModificaiones);
        //PANEL  Amarillo
        panelAmarillo = new JPanel();
        panelAmarillo.setLayout(null);
        panelAmarillo.setBackground(new Color(234, 146, 26 ));
        panelAmarillo.setBounds(10, getHeight()-210, 870, 200);

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaFarmaciasModificaiones);
        scrollPane.setBounds(10, 10, 825, 180);
        panelAmarillo.add(scrollPane);

        add(panelAmarillo);



//Panel NARANJA TITULO
        panelNaranja = new JPanel();
        panelNaranja.setLayout(null);
        panelNaranja.setBackground(new Color(255, 97, 0 ));
        panelNaranja.setBounds(0, 0, getWidth(), 30);
        JLabel texBAJAS = new JLabel("    MODIFICACIONES FARMACIAS:");
        texBAJAS.setBounds(10, 0, 290, 20);
        texBAJAS.setForeground(Color.WHITE);
        panelNaranja.add(texBAJAS);
        add(panelNaranja);

        texID = new JLabel("ID Farmacia:");
        texID.setBounds(40, 40, 230, 20);
        texID.setFont(new Font("Arial", Font.BOLD, 13));
        add(texID);

        JLabel  linea = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
        linea.setBounds(3, 80, 700, 20);
        linea.setBackground(new Color(139, 166, 169 ));
        add(linea);

        cajaid = new JTextField();
        cajaid.setBounds(190, 40, 200, 20);
        add(cajaid);

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

        txtTel = new JLabel("Telefono:");
        txtEstado = new JLabel("Estado:");
        txtMunicipio = new JLabel("Municipio:");
        txtColonia = new JLabel("Colonia:");
        txtCalle = new JLabel("Calle:");
        txtCP = new JLabel("CP:");
        txtNocASA = new JLabel("NO.Local:");
        txtNombre = new JLabel("Nombre Farmacia:");

        txtTel.setBounds( 40, 100, 300, 20);
        txtEstado.setBounds( 40, 130, 300, 20);
        txtMunicipio.setBounds( 40, 160, 300, 20);
        txtColonia.setBounds(40, 190, 300, 20);
        txtCalle.setBounds( 40, 220, 300, 20);
        txtCP.setBounds( 40, 250, 300, 20);
        txtNocASA.setBounds( 40, 280, 300, 20);
        txtNombre.setBounds( 40, 310, 300, 20);

        add(txtTel);
        add(txtEstado);
        add(txtMunicipio);
        add(txtColonia);
        add(txtCalle);
        add(txtCP);
        add(txtNocASA);
        add(txtNombre);

        cajaTelefono = new JTextField();
        cajaTelefono.setBounds(110, 100, 200, 18);
        add(cajaTelefono);

        cajaEstado = new JComboBox();
        cajaEstado.addItem("Elige Estado...");
        cajaEstado.addItem("Durango");
        cajaEstado.addItem("Zacatecas");
        cajaEstado.addItem("Jalisco");
        cajaEstado.setBounds(170, 130, 200, 18);
        add(cajaEstado);

        cajaMunicipio = new JComboBox();
        cajaMunicipio.addItem("Elige Municipio...");
        cajaEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaMunicipio.removeAllItems();
                cajaMunicipio.addItem("Elige Municipio...");
                if (cajaEstado.getSelectedItem().equals("Durango")){
                    cajaMunicipio.addItem("Canatlán");
                    cajaMunicipio.addItem("Canelas");
                    cajaMunicipio.addItem("Cuencamé");
                }else if (cajaEstado.getSelectedItem().equals("Zacatecas")){
                    cajaMunicipio.addItem("Jerez");
                    cajaMunicipio.addItem("Zacatecas");
                }else if (cajaEstado.getSelectedItem().equals("Jalisco")){
                    cajaMunicipio.addItem("Puerto Vallarta");
                }
            }
        });
        cajaMunicipio.setBounds(185, 160, 200, 18);
        add(cajaMunicipio);

        cajaColonia = new JTextField();
        cajaColonia.setBounds(130, 190, 270, 18);
        add(cajaColonia);

        cajaCalle = new JTextField();
        cajaCalle.setBounds(170, 220, 200, 18);
        add(cajaCalle);

        cajaCP = new JTextField();
        cajaCP.setBounds(195, 250, 200, 18);
        add(cajaCP);

        cajaNoLocal = new JTextField();
        cajaNoLocal.setBounds(195, 280, 200, 18);
        add(cajaNoLocal);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(195, 310, 200, 18);
        add(cajaNombre);



        actualizarTabla(tablaFarmaciasModificaiones);
    }//constructor
    public void actualizarTabla(JTable tabla) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = " select * from farmacias;";
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
            cajaid.setText("");
            cajaEstado.setSelectedIndex(0);
            cajaMunicipio.setSelectedIndex(0);
            cajaTelefono.setText("");
            cajaColonia.setText("");
            cajaCalle.setText("");
            cajaColonia.setText("");
            cajaNoLocal.setText("");
            cajaNombre.setText("");
        }
        FarmaciaDAO farmaciaDAO = new FarmaciaDAO();
        if (e.getSource().equals(btnGuardarCambios)) {
            try{
            int tel = Integer.parseInt(cajaTelefono.getText());
            int cp = Integer.parseInt( cajaCP .getText());
            int nl = Integer.parseInt(cajaNoLocal.getText());
            if (String.valueOf(tel).length() != 10) {
                JOptionPane.showMessageDialog(null, "Los números telefonicos deben contar con 10 digitos");
            } else {
                if (String.valueOf(cp).length() != 5) {
                    JOptionPane.showMessageDialog(null, "Los Codigos Postales deben contar con 5 digitos");
                } else {
                    if (cajaEstado.getSelectedItem().equals("Elige Estado...")) {
                        JOptionPane.showMessageDialog(null, "No has seleccionado un ESTADO");
                    } else {
                        if (cajaMunicipio.getSelectedItem().equals("Elige Municipio...")) {
                            JOptionPane.showMessageDialog(null, "No has seleccionado un MUNICIPIO");
                        } else {

                            Farmacia a1 = new Farmacia(cajaid.getText(), tel, cajaEstado.getSelectedItem()+"",
                                    cajaMunicipio.getSelectedItem()+"",cajaColonia.getText() , cajaCalle.getText(),
                                    cp,nl , cajaNombre.getText());
                            if (farmaciaDAO.cambiarFarmacia (a1)){
                                actualizarTabla(tablaFarmaciasModificaiones);
                                System.out.println("Registro modificado CORRECTAMENTE desde la Ven_Inicio");
                            }else{
                                System.out.println("ERROR en la modificacion del registro lindo desde la Ven_Inicio");
                            }
                        }
                    }
                }
            }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null,  "En los campos Telefono, CP y NO.Local solo se admiten Números");
            }
        }//if cambios
        if (e.getSource().equals(btnBuscar)) {//**************************************************************************
            System.out.println("buscar datos");
            System.out.println(cajaid.getText());
            int registro = 1;
            for (int i = 0; i < tablaFarmaciasModificaiones.getRowCount(); i++) {// muestra cuantas filas hay
                if (tablaFarmaciasModificaiones.getValueAt(i, 0).equals(cajaid.getText())) {///tabla.getValueAt(fila,columna)
                    cajaTelefono.setText(tablaFarmaciasModificaiones.getValueAt(i, 1) + "");
                    cajaEstado.setSelectedItem(tablaFarmaciasModificaiones.getValueAt(i, 2) + "");
                    cajaMunicipio.setSelectedItem(tablaFarmaciasModificaiones.getValueAt(i, 3) + "");
                    cajaColonia.setText(tablaFarmaciasModificaiones.getValueAt(i, 4)+ "");
                    cajaCalle.setText(tablaFarmaciasModificaiones.getValueAt(i, 5) + "");
                    cajaColonia.setText(tablaFarmaciasModificaiones.getValueAt(i, 6) + "");
                    cajaNoLocal.setText(tablaFarmaciasModificaiones.getValueAt(i, 7) + "" );
                    cajaNombre.setText(tablaFarmaciasModificaiones.getValueAt(i, 8) + "" );
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
