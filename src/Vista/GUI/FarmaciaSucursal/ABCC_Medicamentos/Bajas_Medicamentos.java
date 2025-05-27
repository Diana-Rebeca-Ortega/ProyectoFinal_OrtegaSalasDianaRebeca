package Vista.GUI.FarmaciaSucursal.ABCC_Medicamentos;

import Controlador.MedicamentosDAO;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Bajas_Medicamentos extends JFrame implements ActionListener {
        JTable tablaMedicamentosBajas;
        JTextField cajaID;
        JLabel cajaNombreCompañia, cajaNombreComercial, cajaFormula;
        JLabel txtID, txtNombreCompañia, txtNombreComercial, txtFormula;
        JPanel panelRojo, panelROSA;
        JButton btnBuscar, btnBorrar, btnEliminar, btnCancelar;

        public Bajas_Medicamentos() {
            getContentPane().setLayout(null);
            setTitle("Bajas Medicamentos");
            setSize(900,530);
            setLocationRelativeTo(null);//locacion en la ventana
            setVisible(true);

            tablaMedicamentosBajas = new JTable();
            tablaMedicamentosBajas.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null,null},
                            {null, null, null,null },
                            {null, null, null,null},
                            {null, null, null,null},
                            {null, null, null,null}
                    },
                    new String[]{
                            "ID_Registro", "Nombre Compañia", "Nombre Comercial","Formula"
                    }) {
                boolean[] canEdit = new boolean[]{
                        false, false
                };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            //PANEL VERDE ROSA
            panelROSA = new JPanel();
            panelROSA.setLayout(null);
            panelROSA.setBackground(new Color(255, 46, 93 ));
            panelROSA.setBounds(10, 320, 870, 170);

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tablaMedicamentosBajas);
            scrollPane.setBounds(10, 10, 840, 150);
            panelROSA.add(scrollPane);

            add(panelROSA);


//Panel ROJO TITULO
            panelRojo = new JPanel();
            panelRojo.setLayout(null);
            panelRojo.setBackground(new Color(237, 0, 0));
            panelRojo.setBounds(0, 0, 900, 30);
            JLabel texBAJAS = new JLabel("    BAJAS MEDICAMENTOS:");
            texBAJAS.setBounds(10, 0, 300, 20);
            texBAJAS.setForeground(Color.WHITE);
            panelRojo.add(texBAJAS);
            add(panelRojo);

            txtID = new JLabel("ID_Registro:");
            txtID.setBounds(40, 40, 230, 20);
            txtID.setFont(new Font("Arial", Font.BOLD, 13));
            add(txtID);

            JLabel  linea = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
            linea.setBounds(3, 80, 700, 20);
            linea.setBackground(new Color(139, 166, 169 ));
            add(linea);

            cajaID = new JTextField();
            cajaID.setBounds(190, 40, 200, 20);
            add(cajaID);

            btnBuscar = new JButton();
            ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
            btnBuscar.setIcon(buscarRuta  );
            btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
            btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
            btnBuscar.setBounds(getWidth()-260, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
            add(btnBuscar);
            btnBuscar.addActionListener(this);

            btnBorrar = new JButton("BORRAR");
            btnEliminar = new JButton("ELIMINAR");
            btnCancelar = new JButton("CANCELAR");

            btnBorrar.addActionListener(this);
            btnEliminar.addActionListener(this);
            btnCancelar.addActionListener(this);

            btnBorrar.setBounds(getWidth()-130, 40, 100, 20);
            add(btnBorrar);
            btnEliminar.setBounds(getWidth()-130, 130, 100, 20);
            add(btnEliminar);
            btnCancelar.setBounds(getWidth()-130, 190, 100, 20);
            add(btnCancelar);

            txtNombreCompañia = new JLabel("NOMBRE COMPAÑIA:");
            txtNombreComercial = new JLabel("NOMBRE COMERCIAL:");
            txtFormula = new JLabel("FORMULA:");

            txtNombreCompañia.setBounds( 40, 100, 300, 20);
            txtNombreComercial.setBounds( 40, 130, 300, 20);
            txtFormula.setBounds( 40, 160, 300, 20);

            add(txtNombreCompañia);
            add(txtNombreComercial);
            add(txtFormula);

            Border borde = BorderFactory.createLineBorder(   Color.BLACK);

            cajaNombreCompañia = new JLabel();

            cajaNombreCompañia.setBorder(borde);
            cajaNombreCompañia.setBackground(new Color(218, 230, 231 ));
            cajaNombreCompañia.setOpaque(true);
            cajaNombreCompañia.setBounds(180, 100, 270, 18);
            add(cajaNombreCompañia);

            cajaNombreComercial = new JLabel();
            cajaNombreComercial.setBorder(borde);
            cajaNombreComercial.setBackground(new Color(218, 230, 231 ));
            cajaNombreComercial.setOpaque(true);
            cajaNombreComercial.setBounds(180, 130, 270, 18);
            add(cajaNombreComercial);

            cajaFormula = new JLabel();
            cajaFormula.setBorder(borde);
            cajaFormula.setBackground(new Color(218, 230, 231 ));
            cajaFormula.setOpaque(true);
            cajaFormula.setBounds(180, 160, 270, 18);
            add(cajaFormula);

            actualizarTabla(tablaMedicamentosBajas);

        }//constructor
        public void actualizarTabla(JTable tabla) {
            final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
            final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
            final String CONSULTA = " select * from medicamentos;";
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
            if( e.getSource().equals(btnBuscar)) {
                int registro = 1;
                for (int i = 0; i < tablaMedicamentosBajas.getRowCount(); i++) {// muestra cuantas filas hay
                    if (tablaMedicamentosBajas.getValueAt(i, 0).equals(cajaID.getText())) {///tablaAlumnosBajas.getValueAt(fila,columna)
                        cajaNombreCompañia.setText(tablaMedicamentosBajas.getValueAt(i, 1) + "");
                        cajaNombreComercial.setText(tablaMedicamentosBajas.getValueAt(i, 2) + "");
                        cajaFormula.setText(tablaMedicamentosBajas.getValueAt(i, 3) + "");
                        registro = registro * 0;

                    }
                }
                if (registro == 1) {
                    JOptionPane.showMessageDialog(null, "No se encontro registro");
                }
            }if (e.getSource().equals(btnBorrar)){//***************************************************************
                cajaID.setText("");
                cajaNombreComercial.setText("");
                cajaFormula.setText("");
                cajaNombreCompañia.setText("");

            }if( e.getSource().equals(btnEliminar)){
                MedicamentosDAO medicamentosDAO = new MedicamentosDAO();
                if (medicamentosDAO.eliminarMedicamento(cajaID.getText())) {
                    actualizarTabla(tablaMedicamentosBajas);
                    System.out.println("FELICIDADES: se ha ELIMINADO correctamente desde la Ven_Inicio");
                }else
                    System.out.println("ERROR:  la ELIMINACION del registro lindo desde la Ven_Inicio no se consiguio");
            }
            if( e.getSource().equals(btnCancelar)){
                setVisible(false);
            }

        }
    }

