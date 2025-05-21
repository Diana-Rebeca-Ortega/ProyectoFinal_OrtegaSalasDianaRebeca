package Vista.GUI_Medico;

import Controlador.PacienteDAO;
import Modelo.Paciente;
import Modelo.ResultSetTableModel;
import conexionBD.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AltasPacientes extends JFrame implements ActionListener {

    JTextField cajaApMaterno, cajaSSN, cajaApPaterno,  cajaNombres ;
    JTextField cajaCalle, cajaColonia, cajaNoCasa, cajaCP;
    JComboBox comboEDAD ;
    JTable tablaPacientesAltas;
    JButton btnCAceptar, btnBorrar, btnCancelar;
    JPanel panelVerde, panelMENTA;
    ConexionBD conexionBD = new ConexionBD();
    public AltasPacientes(){
        setTitle("Altas Pacientes");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        tablaPacientesAltas = new JTable();
        tablaPacientesAltas.setModel(new javax.swing.table.DefaultTableModel(
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
        actualizarTabla(tablaPacientesAltas);

//Panel Verde NEON
        panelVerde = new JPanel();
        panelVerde.setLayout(null);
        panelVerde.setBackground(new Color(11, 178, 16));
        panelVerde.setBounds(0, 0, 900, 30);

        JLabel texALTAS = new JLabel("    ALTAS PACIENTES:");
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
        JScrollPane scrollPane = new JScrollPane(tablaPacientesAltas);
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
        cajaNombres.setBounds(100, 60, 200, 15);
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

        JLabel texEdad = new JLabel("EDAD:");
        texEdad.setBounds(20, 135, 300, 20);
        add(texEdad);

        comboEDAD = new JComboBox<String>();
        comboEDAD.addItem("Elige EDAD...");
        for(int i =1; i <=100;i++){
            comboEDAD.addItem(i);
        }
        comboEDAD.setBounds(100, 135,300,20);
        add(comboEDAD);

        JLabel texCalle = new JLabel("Calle:");
        texCalle.setBounds(20, 160, 300, 20);
        add(texCalle);


        cajaCalle = new JTextField();
        cajaCalle.setBounds(100, 160, 300, 20);
        add(cajaCalle);

        JLabel texColonia = new JLabel("Colonia:");
        texColonia.setBounds(20, 185, 300, 20);
        add(texColonia);

        cajaColonia = new JTextField();
        cajaColonia.setBounds(100, 185, 300, 20);
        add(cajaColonia);

        JLabel texNoCasa = new JLabel("No.Casa:");
        texNoCasa.setBounds(20, 210, 300, 20);
        add(texNoCasa);

        cajaNoCasa = new JTextField();
        cajaNoCasa.setBounds(100, 210, 300, 20);
        add(cajaNoCasa);

        JLabel texCP = new JLabel("CP:");
        texCP.setBounds(20, 235, 300, 20);
        add(texCP);

        cajaCP = new JTextField();
        cajaCP.setBounds(100, 235, 300, 20);
        add(cajaCP);

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

    int filasAñadidas=0;
    int filasOriginales=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCAceptar) {
            try {
            Paciente p = new Paciente (cajaSSN.getText(), cajaNombres.getText(),cajaApPaterno.getText(),
            cajaApMaterno.getText(), Byte.parseByte(
                    comboEDAD.getSelectedItem()+""), cajaCalle.getText(),
            cajaColonia.getText(), cajaNoCasa.getText(), cajaCP.getText());

            PacienteDAO pacienteDAO = new PacienteDAO();
                if (cajaSSN.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,  "No has ingresado un NSS ");
                }else{
            if (pacienteDAO.agregarPaciente(p)) {
                filasAñadidas++;
                actualizarTabla(tablaPacientesAltas);
                System.out.println("FELICIDADES: se agrego un nuevo Paciente a la BDD (desde la ventanaInicio)");
            }else {
                System.out.println("ERROR: no se pudo agregar un nuevo Paciente a la BDD (desde la ventanaInicio)");
            }
                }
            }catch (Exception exception ){
                if (comboEDAD.getSelectedItem().equals("Elige EDAD...")){
                    JOptionPane.showMessageDialog(null,  "No has elegido una edad ");
                }
            }

        }//if si es el btm aceptar
        if (e.getSource() == btnBorrar) {//**********************************************************************
            cajaSSN.setText("");
            cajaApPaterno.setText("");
            cajaApMaterno.setText("");
            cajaNombres.setText("");
            comboEDAD.setSelectedIndex(0);
            cajaCalle.setText("");
            cajaColonia.setText("");
            cajaNoCasa.setText("");
            cajaCP.setText("");

        }if (e.getSource() == btnCancelar) {//**************************************************************
            filasOriginales= tablaPacientesAltas.getRowCount()- filasAñadidas;
            setVisible(false);
            for (   int i =1; i <= filasAñadidas;i++  ){
                System.out.println(i+" añadido");
                String sql = "DELETE FROM alumnos WHERE Num_Control='"+ tablaPacientesAltas.getValueAt(tablaPacientesAltas.getRowCount()-i, 0)+"' ";
                conexionBD.ejecutarInstruccionLMD(sql);
            }//for
        }
    }
}
