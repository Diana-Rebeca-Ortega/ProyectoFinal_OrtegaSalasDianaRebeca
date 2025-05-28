package Vista.GUI.FarmaciaSucursal.ABCC_Medicos;

import Controlador.MedicoDAO;
import Modelo.Medico;
import Modelo.ResultSetTableModel;
import conexionBD.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AltasMedicoss  extends JFrame implements ActionListener {

    JTextField cajaApMaterno, cajaSSN, cajaApPaterno,  cajaNombres ;
    JComboBox comboEspecialidad, comboAñosExperiencia;
    JTable tablaMedicosAltas;
    JButton btnCAceptar, btnBorrar, btnCancelar;
    JPanel panelVerde, panelMENTA;
    ConexionBD conexionBD = new ConexionBD();
    public AltasMedicoss(){
        setTitle("Altas Medicos");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        tablaMedicosAltas = new JTable();
        tablaMedicosAltas.setModel(new javax.swing.table.DefaultTableModel(
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
                    false, false, false, false, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        actualizarTabla(tablaMedicosAltas);

//Panel Verde NEON
        panelVerde = new JPanel();
        panelVerde.setLayout(null);
        panelVerde.setBackground(new Color(11, 178, 16));
        panelVerde.setBounds(0, 0, 900, 30);

        JLabel texALTAS = new JLabel("    ALTAS MEDICOS:");
        texALTAS.setBounds(10, 0, 300, 20);
        texALTAS.setBackground(new Color(200, 201, 241));
        texALTAS.setForeground(Color.WHITE);
        panelVerde.add(texALTAS);

        add(panelVerde);

//PANEL VERDE MENTA
        panelMENTA = new JPanel();
        panelMENTA.setLayout(null);
        panelMENTA.setBackground(new Color(173, 252, 186));
        panelMENTA.setBounds(10, 260, 870, 200);

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaMedicosAltas);
        scrollPane.setBounds(10, 10, 825, 180);
        panelMENTA.add(scrollPane);

        add(panelMENTA);

        JLabel texSSN = new JLabel("SSN:");
        texSSN.setBounds(20, 30, 230, 20);
        add(texSSN);

        cajaSSN = new JTextField("");
        cajaSSN.setBounds(160, 33, 200, 15);
        add(cajaSSN);

        JLabel texNombres = new JLabel("NOMBRES:");
        texNombres.setBounds(20, 55, 300, 20);
        add(texNombres);

        cajaNombres = new JTextField("");
        cajaNombres.setBounds(150, 60, 200, 15);
        add(cajaNombres);

        JLabel texApPaterno = new JLabel("APELLIDO PATERNO:");
        texApPaterno.setBounds(20, 80, 300, 20);
        add(texApPaterno);

        cajaApPaterno = new JTextField("");
        cajaApPaterno.setBounds(150, 85, 200, 15);
        add(cajaApPaterno);

        JLabel texApMaterno = new JLabel("APELLIDO MATERNO:");
        texApMaterno.setBounds(20, 110, 300, 20);
        add(texApMaterno);

        cajaApMaterno = new JTextField("");
        cajaApMaterno.setBounds(150, 115, 200, 15);
        add(cajaApMaterno);

        JLabel Especialidad = new JLabel("ESPECIALIDAD:");
        Especialidad.setBounds(20, 135, 300, 20);
        add(Especialidad);

        comboEspecialidad = new JComboBox<String>();
        comboEspecialidad.addItem("Elige Especialidad...");
            comboEspecialidad.addItem("cardiología");
             comboEspecialidad.addItem("ginecología");
             comboEspecialidad.addItem("ortopedia");
             comboEspecialidad.addItem("neurología");
              comboEspecialidad.addItem("gastroenterología ");

        comboEspecialidad.setBounds(150, 135,300,20);
        add(comboEspecialidad);

        JLabel texAñosExp = new JLabel("Años de Experiencia:");
        texAñosExp.setBounds(20, 160, 300, 20);
        add(texAñosExp);

        comboAñosExperiencia = new JComboBox<String>();
        comboAñosExperiencia.addItem("Elige Años de Experiencia...");
        for (int i =0; i<70; i++){
            comboAñosExperiencia.addItem(i+1);
        }
        comboAñosExperiencia.setBounds(150, 160, 300, 20);
        add(comboAñosExperiencia);

        btnCAceptar = new JButton("AGREGAR");
        btnCAceptar.setBounds(getWidth()-120, 50, 100, 20);
        add(btnCAceptar);
        btnCAceptar.addActionListener(this);

        btnBorrar = new JButton("BORRAR");
        btnBorrar.setBounds(getWidth()-120, 100, 100, 20);
        add(btnBorrar);
        btnBorrar.addActionListener(this);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(getWidth()-120, 150, 100, 20);
        add(btnCancelar);
        btnCancelar.addActionListener(this);


    }

    public void actualizarTabla(JTable tabla) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = " select * from medicos;";
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

    int filasAñadidas=0;
    int filasOriginales=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCAceptar) {

            if (cajaSSN.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,  "No has ingresado un NSS ");
            }else {
                if (cajaSSN.getText().length()!=11) {
                    JOptionPane.showMessageDialog(null, "El NSS debe tener 11 digitos");
                } else {
                    if (comprobacionNumero(cajaSSN.getText())==false){
                        JOptionPane.showMessageDialog(null, "El NSS debe tener puros numeros");
                    }else {
                    try {
                        Medico m = new Medico(cajaSSN.getText(), cajaNombres.getText(), cajaApPaterno.getText(),
                                cajaApMaterno.getText(),
                                comboEspecialidad.getSelectedItem() + "", Byte.parseByte(
                                comboAñosExperiencia.getSelectedItem() + "")
                        );
                        MedicoDAO medicoDAO = new MedicoDAO();
                        if (medicoDAO.agregarMedico(m)) {
                            filasAñadidas++;
                            actualizarTabla(tablaMedicosAltas);
                            System.out.println("FELICIDADES: se agrego un nuevo Paciente a la BDD (desde la ventanaInicio)");
                        } else {
                            System.out.println("ERROR: no se pudo agregar un nuevo Paciente a la BDD (desde la ventanaInicio)");
                        }
                    } catch (Exception exception) {
                        if (comboEspecialidad.getSelectedItem().equals("Elige Especialidad...")) {
                            JOptionPane.showMessageDialog(null, "No has elegido años de experiencia ");
                        }
                        if (comboAñosExperiencia.getSelectedItem().equals("Elige Años de Experiencia...")) {
                            JOptionPane.showMessageDialog(null, "No has elegido Especialidad");
                        }
                    }
                    }
                }
            }
        }//if si es el btm aceptar
        if (e.getSource() == btnBorrar) {//**********************************************************************
            cajaSSN.setText("");
            cajaApPaterno.setText("");
            cajaApMaterno.setText("");
            cajaNombres.setText("");
            comboEspecialidad.setSelectedIndex(0);
            comboAñosExperiencia.setSelectedIndex(0);

        }if (e.getSource() == btnCancelar) {//**************************************************************
            filasOriginales= tablaMedicosAltas.getRowCount()- filasAñadidas;
            setVisible(false);
            for (   int i =1; i <= filasAñadidas;i++  ){
                System.out.println(i+" añadido");
                String sql = "DELETE FROM medicos WHERE NSS='"+ tablaMedicosAltas.getValueAt(tablaMedicosAltas.getRowCount()-i, 0)+"' ";
                conexionBD.ejecutarInstruccionLMD(sql);
            }//for
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
}
