package Vista.GUI.FarmaciaSucursal.ABCC_CompañiasFarmaceuticas;

import Controlador.ComFarmaceuticaDAO;
import Modelo.CompanniaFarmaceutica;
import Modelo.ResultSetTableModel;
import conexionBD.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Altas_CompañiasFarmaceuticas extends JFrame implements ActionListener {

    JTextField cajaID_ComFarmaceutica,  cajTelefono;

    JTable tablaComFarAltas;
    JButton btnCAceptar, btnBorrar, btnCancelar;
    JPanel panelVerde, panelMENTA;
    ConexionBD conexionBD = new ConexionBD();
    public Altas_CompañiasFarmaceuticas(){
        setTitle("Altas Compañias Farmaceuticas");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        tablaComFarAltas = new JTable();
        tablaComFarAltas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Nombre Compañia", "Telefono"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        actualizarTabla(tablaComFarAltas);

//Panel Verde NEON
        panelVerde = new JPanel();
        panelVerde.setLayout(null);
        panelVerde.setBackground(new Color(11, 178, 16));
        panelVerde.setBounds(0, 0, 900, 30);

        JLabel texALTAS = new JLabel("    ALTAS COMPAÑIAS FARMACEUTICAS:");
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
        JScrollPane scrollPane = new JScrollPane(tablaComFarAltas);
        scrollPane.setBounds(10, 10, 825, 180);
        panelMENTA.add(scrollPane);

        add(panelMENTA);

        JLabel texID_CF = new JLabel("Nombre Compañia Farmaceutica:");
        texID_CF.setBounds(20, 30, 300, 20);
        add(texID_CF);

        cajaID_ComFarmaceutica = new JTextField("");
        cajaID_ComFarmaceutica.setBounds(20, 50, 200, 15);
        add(cajaID_ComFarmaceutica);

        JLabel texNombres = new JLabel("Telefono:");
        texNombres.setBounds(20, 70, 300, 20);
        add(texNombres);

        cajTelefono = new JTextField("");
        cajTelefono.setBounds(20, 90, 200, 15);
        add(cajTelefono);



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
        final String CONSULTA = " select * from compañiasfarmaceuticas;";
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

                //int zy = Integer.parseInt(String.valueOf(cajTelefono.getText()));
            if (cajTelefono.getText().length()!=10){
                JOptionPane.showMessageDialog(null,  "Los números telefonicos deben contar con 10 digitos");

            }else {
                CompanniaFarmaceutica cf = new CompanniaFarmaceutica (cajaID_ComFarmaceutica.getText(), cajTelefono.getText());

                ComFarmaceuticaDAO cfDAO = new ComFarmaceuticaDAO();
                if (cajaID_ComFarmaceutica.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,  "No has ingresado El nombre de la compañia ");
                }else{
                    if (cfDAO.agregarCF(cf)) {
                        filasAñadidas++;
                        actualizarTabla(tablaComFarAltas);
                        System.out.println("FELICIDADES: se agrego un nueva CF a la BDD");
                    }else {
                        System.out.println("ERROR: no se pudo agregar un nuevo CF a la BDD ");
                        JOptionPane.showMessageDialog(null,  "Solo se permiten cadenas numericas para el registro de telefonos");

                    }
                }
            }


        }//if si es el btm aceptar
        if (e.getSource() == btnBorrar) {//**********************************************************************
            cajaID_ComFarmaceutica.setText("");
            cajTelefono.setText("");

        }if (e.getSource() == btnCancelar) {//**************************************************************
            filasOriginales= tablaComFarAltas.getRowCount()- filasAñadidas;
            setVisible(false);
            for (   int i =1; i <= filasAñadidas;i++  ){
                System.out.println(i+" añadido");
                String sql = "DELETE FROM compañiasfarmaceuticas WHERE NombreCompania='"+ tablaComFarAltas.getValueAt(tablaComFarAltas.getRowCount()-i, 0)+"' ";
                conexionBD.ejecutarInstruccionLMD(sql);
            }//for
        }
    }
}
