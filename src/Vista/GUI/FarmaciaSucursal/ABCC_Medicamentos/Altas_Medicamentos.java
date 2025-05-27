package Vista.GUI.FarmaciaSucursal.ABCC_Medicamentos;

import Controlador.ComFarmaceuticaDAO;
import Controlador.MedicamentosDAO;
import Modelo.Medicamentos;
import Modelo.ResultSetTableModel;
import conexionBD.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Altas_Medicamentos extends JFrame implements ActionListener {
    JTextField cajaID_Registro, cajaFormula, cajaNombreComercial;
    JComboBox cajaNombreCompañia ;
    JTable tablaMedicamentosAltas;
    JButton btnCAceptar, btnBorrar, btnCancelar;
    JPanel panelVerde, panelMENTA;
    List<String> listaNomCom;
    ConexionBD conexionBD = new ConexionBD();
    public Altas_Medicamentos(){
        setTitle("Altas Medicamentos");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        tablaMedicamentosAltas = new JTable();
        tablaMedicamentosAltas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null,null},
                        {null, null, null,null },
                        {null, null, null,null},
                        {null, null, null,null},
                        {null, null, null,null}
                },
                new String[]{
                        "ID_Registro", "NombreCompañia", "Nombre Comercial","Formula"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        actualizarTabla(tablaMedicamentosAltas);

//Panel Verde NEON
        panelVerde = new JPanel();
        panelVerde.setLayout(null);
        panelVerde.setBackground(new Color(11, 178, 16));
        panelVerde.setBounds(0, 0, 900, 30);

        JLabel texALTAS = new JLabel("    ALTAS MEDICAMENTOS:");
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
        JScrollPane scrollPane = new JScrollPane(tablaMedicamentosAltas);
        scrollPane.setBounds(10, 10, 825, 180);
        panelMENTA.add(scrollPane);

        add(panelMENTA);

        JLabel texID_Registro = new JLabel("ID_Registro:");
        texID_Registro.setBounds(20, 30, 300, 20);
        add(texID_Registro);

        cajaID_Registro = new JTextField("");
        cajaID_Registro.setBounds(20, 50, 200, 15);
        add(cajaID_Registro);

        JLabel texNombreCompañia = new JLabel("Nombre Compañia:");
        texNombreCompañia.setBounds(20, 70, 300, 20);
        add(texNombreCompañia);

        ComFarmaceuticaDAO cfDAO = new ComFarmaceuticaDAO();
        listaNomCom = cfDAO.NombresCompañiasFarmaceuticas();
        cajaNombreCompañia = new JComboBox();
        for (int i =0; i<cfDAO.tamañoTablas(); i++ ){
            cajaNombreCompañia.addItem(listaNomCom.get(i));
        }

        cajaNombreCompañia.setBounds(20, 90, 200, 15);
        add(cajaNombreCompañia);

        JLabel texNombreComercial = new JLabel("Nombre Comercial:");
        texNombreComercial.setBounds(20, 110, 300, 20);
        add(texNombreComercial);

        cajaNombreComercial = new JTextField("");
        cajaNombreComercial.setBounds(20, 130, 200, 15);
        add(cajaNombreComercial);

        JLabel texFormula = new JLabel("Formula:");
        texFormula.setBounds(20, 150, 300, 20);
        add(texFormula);

        cajaFormula = new JTextField("");
        cajaFormula.setBounds(20, 170, 200, 15);
        add(cajaFormula);


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
        final String CONSULTA = " select * from medicamentos;";
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

                Medicamentos medicamentos = new Medicamentos (cajaID_Registro.getText(), cajaNombreCompañia.getSelectedItem()+"", cajaNombreComercial.getText(),  cajaFormula.getText());
                MedicamentosDAO medicamentosDAO = new MedicamentosDAO();
                    if (medicamentosDAO.agregarMedicamentos(medicamentos)) {
                        filasAñadidas++;
                        actualizarTabla(tablaMedicamentosAltas);
                        System.out.println("FELICIDADES: se agrego ");
                    }else {
                        System.out.println("ERROR: no se pudo agregar  ");
                    }
        }//if si es el btm aceptar
        if (e.getSource() == btnBorrar) {//**********************************************************************
            cajaID_Registro.setText("");
            cajaFormula.setText("");
            cajaNombreComercial.setText("");
            cajaNombreCompañia.setSelectedIndex(0);

        }if (e.getSource() == btnCancelar) {//**************************************************************
            filasOriginales= tablaMedicamentosAltas.getRowCount()- filasAñadidas;
            setVisible(false);
            for (   int i =1; i <= filasAñadidas;i++  ){
                System.out.println(i+" añadido");
                String sql = "DELETE FROM medicamentos WHERE ID_Registro='"+ tablaMedicamentosAltas.getValueAt(tablaMedicamentosAltas.getRowCount()-i, 0)+"' ";
                conexionBD.ejecutarInstruccionLMD(sql);
            }//for
        }
    }

}
