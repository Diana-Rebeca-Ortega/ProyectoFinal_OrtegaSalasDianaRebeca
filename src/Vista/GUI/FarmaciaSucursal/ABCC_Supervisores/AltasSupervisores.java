package Vista.GUI.FarmaciaSucursal.ABCC_Supervisores;

import Controlador.SupervisorDAO;
import Modelo.ResultSetTableModel;
import Modelo.Supervisor;
import conexionBD.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AltasSupervisores  extends JFrame implements ActionListener {
        JTextField cajaNSS,  cajaSegundoApellido,  cajaNombre, cajaprimerApellido;

        JTable tablaSupervisoresAltas;
        JButton btnCAceptar, btnBorrar, btnCancelar;
        JPanel panelVerde, panelMENTA;
        ConexionBD conexionBD = new ConexionBD();
        public AltasSupervisores(){
            setTitle("Altas Supervisores");
            setSize(900,530);
            setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
            setLayout(null);
            setVisible(true);

            tablaSupervisoresAltas = new JTable();
            tablaSupervisoresAltas.setModel(new javax.swing.table.DefaultTableModel(
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
            actualizarTabla(tablaSupervisoresAltas);

//Panel Verde NEON
            panelVerde = new JPanel();
            panelVerde.setLayout(null);
            panelVerde.setBackground(new Color(11, 178, 16));
            panelVerde.setBounds(0, 0, 900, 30);

            JLabel texALTAS = new JLabel("    ALTAS SUPERVISORES:");
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
            JScrollPane scrollPane = new JScrollPane(tablaSupervisoresAltas);
            scrollPane.setBounds(10, 10, 825, 180);
            panelMENTA.add(scrollPane);

            add(panelMENTA);

            JLabel texNSS = new JLabel("NSS:");
            texNSS.setBounds(20, 30, 300, 20);
            add(texNSS);

            cajaNSS = new JTextField("");
            cajaNSS.setBounds(20, 50, 200, 15);
            add(cajaNSS);

            JLabel texNombres = new JLabel("Nombres:");
            texNombres.setBounds(20, 70, 300, 20);
            add(texNombres);

            cajaNombre = new JTextField("");
            cajaNombre.setBounds(20, 90, 200, 15);
            add(cajaNombre);

            JLabel texPApellido = new JLabel("Primer Apellido:");
            texPApellido.setBounds(20, 110, 300, 20);
            add(texPApellido);

            cajaprimerApellido = new JTextField("");
            cajaprimerApellido.setBounds(20, 130, 200, 15);
            add(cajaprimerApellido);

            JLabel texSApellido = new JLabel("Segundo Apellido:");
            texSApellido.setBounds(20, 150, 300, 20);
            add(texSApellido);

            cajaSegundoApellido = new JTextField("");
            cajaSegundoApellido.setBounds(20, 170, 200, 15);
            add(cajaSegundoApellido);


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
            final String CONSULTA = " select * from supervisores;";
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
                    if (cajaNSS.getText().length()!=11){
                    JOptionPane.showMessageDialog(null,  "El NSS debe tener 10 caracteres");
                }else {
                    Supervisor supervisor = new Supervisor (cajaNSS.getText(),cajaNombre.getText(), cajaprimerApellido.getText(),  cajaSegundoApellido.getText());
                    SupervisorDAO supervisorDAO = new SupervisorDAO();
                    if (cajaNSS.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,  "No has ingresado el NSS");
                    }else{
                        if (comprobacionNumero( cajaNSS.getText())==false){
                            JOptionPane.showMessageDialog(null,  "El NSS debe tener puros numeros ");
                        }else {
                            if (supervisorDAO.agregarSupervisor(supervisor)) {
                                filasAñadidas++;
                                actualizarTabla(tablaSupervisoresAltas);
                                System.out.println("FELICIDADES: se agrego un nuevo supervisor a la BDD");
                            } else {
                                System.out.println("ERROR: no se pudo agregar un nuevo supervisor a la BDD ");
                            }
                        }
                    }
                }


            }//if si es el btm aceptar

            if (e.getSource() == btnBorrar) {//**********************************************************************
                cajaNSS.setText("");
                cajaSegundoApellido.setText("");

            }if (e.getSource() == btnCancelar) {//**************************************************************
                filasOriginales= tablaSupervisoresAltas.getRowCount()- filasAñadidas;
                setVisible(false);
                for (   int i =1; i <= filasAñadidas;i++  ){
                    System.out.println(i+" añadido");
                    String sql = "DELETE FROM compañiasfarmaceuticas WHERE NombreCompania='"+ tablaSupervisoresAltas.getValueAt(tablaSupervisoresAltas.getRowCount()-i, 0)+"' ";
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
