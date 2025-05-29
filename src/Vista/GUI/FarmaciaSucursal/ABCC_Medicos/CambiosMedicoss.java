package Vista.GUI.FarmaciaSucursal.ABCC_Medicos;

import Controlador.MedicoDAO;
import Modelo.Medico;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CambiosMedicoss extends JFrame implements ActionListener {
    JPanel panelNaranja, panelAmarillo;
    JTable tablaPacientesModificaiones;
    JTextField cajaSSN,cajaNombre, cajaApPaterno, cajaApMaterno;
    JLabel texNSS, txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtEspecialidad, txtAñosExperiencia;
    JButton btnBuscar, btnBorrar, btnGuardarCambios, btnCancelar;
    JComboBox comboAñosExpe, comboEspecialidad;

    public CambiosMedicoss() {
        getContentPane().setLayout(null);
        setTitle("Modificar Medicos");
        setSize(900,580);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);

        tablaPacientesModificaiones = new JTable();
        tablaPacientesModificaiones.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "NSS", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "ESPECIALIDAD", "AÑOS DE EXPERIENCIA"
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
        JLabel texBAJAS = new JLabel("    MODIFICACIONES MEDICOS:");
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
        txtEspecialidad = new JLabel("ESPECIALIDAD:");
        txtAñosExperiencia = new JLabel("Años de Experiencia:");

        txtNombre.setBounds( 40, 100, 300, 20);
        txtApellidoPaterno.setBounds( 40, 130, 300, 20);
        txtApellidoMaterno.setBounds( 40, 160, 300, 20);
        txtEspecialidad.setBounds(40, 190, 300, 20);
        txtAñosExperiencia.setBounds( 40, 220, 300, 20);

        add(txtNombre);
        add(txtApellidoPaterno);
        add(txtApellidoMaterno);
        add(txtEspecialidad);
        add(txtAñosExperiencia);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(110, 100, 200, 18);
        add(cajaNombre);

        cajaApPaterno = new JTextField();
        cajaApPaterno.setBounds(170, 130, 200, 18);
        add(cajaApPaterno);

        cajaApMaterno = new JTextField();
        cajaApMaterno.setBounds(185, 160, 200, 18);
        add(cajaApMaterno);

        comboEspecialidad = new JComboBox<String>();
        comboEspecialidad.addItem("Elige Especialidad...");
        comboEspecialidad.addItem("cardiología");
        comboEspecialidad.addItem("ginecología");
        comboEspecialidad.addItem("ortopedia");
        comboEspecialidad.addItem("neurología");
        comboEspecialidad.addItem("gastroenterología ");

        comboEspecialidad.setBounds(130, 190, 270, 22);
        add(comboEspecialidad);

        comboAñosExpe = new JComboBox<String>();
        comboAñosExpe.addItem("0");
        for(int i =1; i <99;i++){
            comboAñosExpe.addItem(i);
        }
        comboAñosExpe.setBounds(170, 220, 200, 18);
        add(comboAñosExpe);


        cajaApPaterno.setEnabled(false);
        cajaApMaterno.setEnabled(false);
        cajaNombre.setEnabled(false);
        comboEspecialidad.setEnabled(false);
        comboAñosExpe.setEnabled(false);

        actualizarTabla(tablaPacientesModificaiones);
    }//constructor
    public void actualizarTabla(JTable tabla) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = " select * from medicos;";
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
            comboEspecialidad.setSelectedIndex(0);
            comboAñosExpe.setSelectedIndex(0);

            cajaApPaterno.setEnabled(false);
            cajaApMaterno.setEnabled(false);
            cajaNombre.setEnabled(false);
            comboEspecialidad.setEnabled(false);
            comboAñosExpe.setEnabled(false);
        }
        MedicoDAO medicoDAO = new MedicoDAO();
        if (e.getSource().equals(btnGuardarCambios)) {

            if (cajaSSN.getText().length()!=11) {
                JOptionPane.showMessageDialog(null, "El NSS debe tener 11 digitos");
            } else {
                if (comprobacionNumero(cajaSSN.getText())==false){
                    JOptionPane.showMessageDialog(null, "El NSS debe tener puros numeros");
                }else {
                    if (cajaNombre.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "El Nombre no puede ser null");
                    }else{
                        if (comprobacionTieneNumeros(cajaNombre.getText() )==true){
                            JOptionPane.showMessageDialog(null, "El Registro Nombres solo admite letras");
                        }else{
                            if (cajaApPaterno.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "El Apellido Paterno no puede ser null");
                            }else{
                                if (comprobacionTieneNumeros(cajaApPaterno.getText() )==true){
                                    JOptionPane.showMessageDialog(null, "El Apellido Paterno solo admite letras");
                                }else {
                                    if (comprobacionTieneNumeros(cajaApMaterno.getText()) == true) {
                                        JOptionPane.showMessageDialog(null, "El Apellido Materno solo admite letras");
                                    } else {
                                        if (comboEspecialidad.getSelectedItem().equals("Elige Especialidad...")) {
                                            JOptionPane.showMessageDialog(null, "No has elegido Especialidad");
                                        }else {
                                            if (comboAñosExpe.getSelectedItem().equals("Elige Años de Experiencia...")) {
                                                JOptionPane.showMessageDialog(null, "No has elegido Años de Experiencia");
                                            }else {




try {

    Medico a1 = new Medico(cajaSSN.getText(), cajaNombre.getText(), cajaApPaterno.getText(),
            cajaApMaterno.getText(),
            comboEspecialidad.getSelectedItem() + "", Byte.parseByte(comboAñosExpe.getSelectedItem() + ""));
    if (medicoDAO.cambiarMedico(a1)) {
        actualizarTabla(tablaPacientesModificaiones);
        System.out.println("Registro modificado CORRECTAMENTE desde la Ven_Inicio");
    } else
        System.out.println("ERROR en la modificacion del registro lindo desde la Ven_Inicio");
}catch (Exception exception){
    if (comboEspecialidad.getSelectedItem().equals("Elige Especialidad...")) {
        JOptionPane.showMessageDialog(null, "No has elegido  Especialidad  ");
    }
    if (comboAñosExpe.getSelectedItem().equals("Elige Años de Experiencia...")) {
        JOptionPane.showMessageDialog(null, "No has elegido Años de especialida");
    }
}

                                            }
                                        }
                                    }


                                }}}}}}}

        if (e.getSource().equals(btnBuscar)) {//**************************************************************************
            System.out.println("buscar datos");
            System.out.println(cajaSSN.getText());
            int registro = 1;
            for (int i = 0; i < tablaPacientesModificaiones.getRowCount(); i++) {// muestra cuantas filas hay
                if (tablaPacientesModificaiones.getValueAt(i, 0).equals(cajaSSN.getText())) {///tabla.getValueAt(fila,columna)
                    cajaNombre.setText(tablaPacientesModificaiones.getValueAt(i, 1) + "");
                    cajaApPaterno.setText(tablaPacientesModificaiones.getValueAt(i, 2) + "");
                    cajaApMaterno.setText(tablaPacientesModificaiones.getValueAt(i, 3) + "");
                    comboEspecialidad.setSelectedItem(tablaPacientesModificaiones.getValueAt(i, 4));
                    comboAñosExpe.setSelectedItem(tablaPacientesModificaiones.getValueAt(i, 5));
                    registro = registro * 0;

                }
            }
            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
            }else {
                cajaApPaterno.setEnabled(true);
                cajaApMaterno.setEnabled(true);
                cajaNombre.setEnabled(true);
                comboEspecialidad.setEnabled(true);
                comboAñosExpe.setEnabled(true);
            }
        }
        if( e.getSource().equals(btnCancelar)){//******************************************************************
            setVisible(false);
            //aqui podriamos poner un historial q regrese los valores
        }
    }
    public  boolean comprobacionNumero( String cajita){
        try {
            Long.parseLong(cajita);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean comprobacionTieneNumeros(String cajita) {
        for (int i = 0; i < cajita.length(); i++) {
            char c = cajita.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return true;
            }
        }
        return false;
    }
}
