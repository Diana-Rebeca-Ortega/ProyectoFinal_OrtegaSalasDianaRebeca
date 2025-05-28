package Vista.GUI.FarmaciaSucursal;

import Controlador.FarmaciaDAO;
import Controlador.MedicoDAO;
import Modelo.Farmacia;
import Modelo.Medico;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login_FarmaciaSucursal extends JFrame implements ActionListener {
        JComboBox Estado, Municipio, Sucursales ;
        JPanel panelLogin;
        JButton btnIniciarSesion;
        JTextField cajaSSNContraseña, cajaSSN;
        JLabel txtUsuarioMalo;
        public Login_FarmaciaSucursal(){
            setTitle("FARMACIA SUCURSAL ");
            setSize(570,700);
            setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
            setLayout(null);
            setVisible(true);
            getContentPane().setBackground(new Color(157, 220, 147));

            JLabel txtLogin = new JLabel("FARMACIAS RX (sucursal)");
            txtLogin.setFont(new Font("font", Font.PLAIN, 24));
            txtLogin.setBounds(130,30, 300,30);
            add(txtLogin);

//PANEL LOGIN*******************************************************
            panelLogin = new JPanel();
            panelLogin.setLayout(null);
            panelLogin.setBounds(20, 120,500,400);
            panelLogin.setBackground(new Color(201, 232, 185));
            panelLogin.setBorder(BorderFactory.createLineBorder(  new Color(52, 181, 23)));

            JLabel txt = new JLabel("Porfavor seleccione la Sucursal de la Farmacia para Iniciar Sesion");
            txt.setFont(new Font( "Agency FB", Font.BOLD, 18));
            txt.setBounds(60,3,420,20);
            panelLogin.add(txt);

            JLabel txtEstado = new JLabel("Estado: ");
            txtEstado.setBounds(170,30,300,20);
            txtEstado.setToolTipText("(Estado en el que se ubica la farmacia)");
            panelLogin.add(txtEstado);

            Estado = new JComboBox();
            Estado.addItem("Elige Estado...");
            Estado.addItem("Durango");
            Estado.addItem("Zacatecas");
            Estado.addItem("Jalisco");

            Estado.setBounds(100, 50, 300,20);
            panelLogin. add(Estado);

            JLabel txtSSNContraseña = new JLabel("Municipio: ");
            txtSSNContraseña.setBounds(170,100,150,20);
            panelLogin.add(txtSSNContraseña);

            Municipio = new JComboBox();
            Estado.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Municipio.removeAllItems();
                    Municipio.addItem("Elige Municipio...");
                    if (Estado.getSelectedItem().equals("Durango")){
                        Municipio.addItem("Canatlán");
                        Municipio.addItem("Canelas");
                        Municipio.addItem("Cuencamé");
                    }else if (Estado.getSelectedItem().equals("Zacatecas")){
                        Municipio.addItem("Jerez");
                        Municipio.addItem("Zacatecas");
                    }else if (Estado.getSelectedItem().equals("Jalisco")){
                        Municipio.addItem("Puerto Vallarta");
                    }
                }
            });

            Municipio.setBounds(100, 120, 300,20);
            panelLogin.  add(Municipio);

            JLabel txtSucursal = new JLabel("SUCURSAL: ");
            txtSucursal.setBounds(20, 165, 200,20);
            panelLogin.  add(txtSucursal);

            FarmaciaDAO farmaciaDAO = new FarmaciaDAO();
            Sucursales = new JComboBox();
            Municipio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<String> listaSucursales = farmaciaDAO.buscarSucursalesFarmacias(Municipio.getSelectedItem()+"" );
                    Sucursales.removeAllItems();
                    for ( int i=0 ; i< farmaciaDAO.buscarSucursalesFarmacias(Municipio.getSelectedItem()+"" ).size() ; i ++ ){
                        Sucursales.addItem( listaSucursales.get(i)+"");
                    }
                }
            });
            Sucursales.setBounds(100, 165, 300,20  );
            panelLogin.  add(Sucursales);


            JLabel txtContraseña = new JLabel("Ingrese Contraseña");
            txtContraseña.setBounds(170,215,150,20);
            panelLogin.add(txtContraseña);

            cajaSSNContraseña = new JTextField();
            cajaSSNContraseña.setBounds(100, 235, 300,20);
            panelLogin.add(cajaSSNContraseña);

            JLabel txtRecuperarContraseña = new JLabel("¿Olvidaste tu Contraseña?");
            txtRecuperarContraseña.setFont(new Font("Arial", Font.PLAIN, 10));
            txtRecuperarContraseña.setBackground(Color.GRAY);
            txtRecuperarContraseña.setBounds(150,255,200,20);
            panelLogin.add(txtRecuperarContraseña);


            btnIniciarSesion = new JButton("Iniciar Sesion");
            btnIniciarSesion.setBounds(100,panelLogin.getHeight()-50,300,20);
            panelLogin.add(btnIniciarSesion);
            btnIniciarSesion.addActionListener(this);
            add(panelLogin);

            txtUsuarioMalo = new JLabel("La farmacia no existe");
            txtUsuarioMalo.setFont(new Font("Arial", Font.PLAIN, 10));
            txtUsuarioMalo.setForeground(new Color(255, 8, 8));
            txtUsuarioMalo.setBounds(150, panelLogin.getHeight()- 25, 200,20);

        }


        @Override
        public void actionPerformed(ActionEvent e) {

FarmaciaDAO farmaciaDAO = new FarmaciaDAO();
            Farmacia fa = farmaciaDAO.mostrarFarmacia(Sucursales.getSelectedItem()+"", "Nombre" );
            if (fa==null) {
                panelLogin.add(txtUsuarioMalo);
                repaint();
            }else {


            if (e.getSource()==btnIniciarSesion){
                setVisible(false);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new HomeFarmacia(fa);
                        }
                    });
                }
           }
        }
           }


