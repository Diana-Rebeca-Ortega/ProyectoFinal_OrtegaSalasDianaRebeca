package Vista.GUI_Administrativo;

import Controlador.FarmaciaDAO;
import Controlador.PacienteDAO;
import Modelo.Farmacia;
import Modelo.Paciente;
import Modelo.ResultSetTableModel;
import conexionBD.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AltasFarmacias extends JFrame implements ActionListener {
    JTextField Municipio, ID_Farmacia, Estado,  Telefono;
    JTextField cajaCalle, CP, cajaNoLocal, NombreFar;
    JComboBox comboColonia;
    JTable tablaFarmaciasAltas;
    JButton btnCAceptar, btnBorrar, btnCancelar;
    JPanel panelVerde, panelMENTA;
    ConexionBD conexionBD = new ConexionBD();
    public AltasFarmacias(){
        setTitle("Altas Farmacias");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        tablaFarmaciasAltas = new JTable();
        tablaFarmaciasAltas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null,null, null },
                        {null, null, null, null, null, null,  null,null, null},
                        {null, null, null, null, null, null,  null,null, null},
                        {null, null, null, null, null, null,  null,null, null},
                        {null, null, null, null, null, null,  null,null, null}
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
        actualizarTabla(tablaFarmaciasAltas);

//Panel Verde NEON
        panelVerde = new JPanel();
        panelVerde.setLayout(null);
        panelVerde.setBackground(new Color(11, 178, 16));
        panelVerde.setBounds(0, 0, 900, 30);

        JLabel texALTAS = new JLabel("    ALTAS FARMACIAS:");
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
        JScrollPane scrollPane = new JScrollPane(tablaFarmaciasAltas);
        scrollPane.setBounds(10, 10, 825, 180);
        panelMENTA.add(scrollPane);

        add(panelMENTA);

        JLabel texIDFar = new JLabel("ID:");
        texIDFar.setBounds(20, 30, 230, 20);
        add(texIDFar);

        ID_Farmacia = new JTextField("");
        ID_Farmacia.setBounds(160, 33, 200, 15);
        add(ID_Farmacia);

        JLabel texTelefono = new JLabel("Telefono:");
        texTelefono.setBounds(20, 55, 300, 20);
        add(texTelefono);

        Telefono = new JTextField("");
        Telefono.setBounds(100, 60, 200, 15);
        add(Telefono);

        JLabel texEstado = new JLabel("Estado:");
        texEstado.setBounds(20, 80, 300, 20);
        add(texEstado);

        Estado = new JTextField("");
        Estado.setBounds(150, 85, 200, 15);
        add(Estado);

        JLabel texApMunicipio = new JLabel("Municipio:");
        texApMunicipio.setBounds(20, 110, 300, 20);
        add(texApMunicipio);

        Municipio = new JTextField("");
        Municipio.setBounds(150, 115, 200, 15);
        add(Municipio);

        JLabel texColonia = new JLabel("Colonia:");
        texColonia.setBounds(20, 135, 300, 20);
        add(texColonia);

        comboColonia = new JComboBox<String>();
        comboColonia.addItem("Elige EDAD...");
        for(int i =1; i <=100;i++){
            comboColonia.addItem(i);
        }
        comboColonia.setBounds(100, 135,300,20);
        add(comboColonia);

        JLabel texCalle = new JLabel("Calle:");
        texCalle.setBounds(20, 160, 300, 20);
        add(texCalle);


        cajaCalle = new JTextField();
        cajaCalle.setBounds(100, 160, 300, 20);
        add(cajaCalle);

        JLabel texCp = new JLabel("CP:");
        texCp.setBounds(20, 185, 300, 20);
        add(texCp);

        CP = new JTextField();
        CP.setBounds(100, 185, 300, 20);
        add(CP);

        JLabel texNoLocal = new JLabel("No.Local:");
        texNoLocal.setBounds(20, 210, 300, 20);
        add(texNoLocal);

        cajaNoLocal = new JTextField();
        cajaNoLocal.setBounds(100, 210, 300, 20);
        add(cajaNoLocal);

        JLabel texNombreFarmacia = new JLabel("Nombre Farmacia:");
        texNombreFarmacia.setBounds(20, 235, 300, 20);
        add(texNombreFarmacia);

        NombreFar = new JTextField();
        NombreFar.setBounds(100, 235, 300, 20);
        add(NombreFar);

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

    int filasAñadidas=0;
    int filasOriginales=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCAceptar) {
            try {
                Farmacia far = new Farmacia (ID_Farmacia.getText(), Telefono.getText(), Estado.getText(),
                        Municipio.getText(),
                        comboColonia.getSelectedItem()+"", cajaCalle.getText(),
                        CP.getText(), Integer.parseInt(cajaNoLocal.getText()), NombreFar.getText());

                FarmaciaDAO farDAO = new FarmaciaDAO();
                if (ID_Farmacia.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,  "No has ingresado un NSS ");
                }else{
                    if (farDAO.agregarFarmacia(far)) {
                        filasAñadidas++;
                        actualizarTabla(tablaFarmaciasAltas);
                        System.out.println("FELICIDADES: se agrego una nueva Farmacia a la BDD (desde la ventanaInicio)");
                    }else {
                        System.out.println("ERROR: no se pudo agregar un nuevo Farmacia a la BDD (desde la ventanaInicio)");
                    }
                }
            }catch (Exception exception ){
                if (comboColonia.getSelectedItem().equals("Elige EDAD...")){
                    JOptionPane.showMessageDialog(null,  "No has elegido una edad ");
                }
            }

        }//if si es el btm aceptar
        if (e.getSource() == btnBorrar) {//**********************************************************************
            ID_Farmacia.setText("");
            Estado.setText("");
            Municipio.setText("");
            Telefono.setText("");
            comboColonia.setSelectedIndex(0);
            cajaCalle.setText("");
            CP.setText("");
            cajaNoLocal.setText("");
            NombreFar.setText("");

        }if (e.getSource() == btnCancelar) {//**************************************************************
            filasOriginales= tablaFarmaciasAltas.getRowCount()- filasAñadidas;
            setVisible(false);
            for (   int i =1; i <= filasAñadidas;i++  ){
                System.out.println(i+" añadido");
                String sql = "DELETE FROM pacientes WHERE ID_Paciente_SSN='"+ tablaFarmaciasAltas.getValueAt(tablaFarmaciasAltas.getRowCount()-i, 0)+"' ";
                conexionBD.ejecutarInstruccionLMD(sql);
            }//for
        }
    }
}
