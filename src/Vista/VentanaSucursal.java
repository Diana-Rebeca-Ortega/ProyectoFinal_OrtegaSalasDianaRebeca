package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaSucursal extends JFrame {
    JMenuBar menuBar;
    JMenu menuMedicos;
    public VentanaSucursal(){
        setTitle("Administración de Farmacia");
        setSize(570,700);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
/*
        menuBar = new JMenuBar();
        menuMedicos = new JMenu ("Medicos");
        altasMedicos = new JMenuItem ("Acceso al Sistema de Datos");
        menuPrincipal.add(AccesoAlSistema);
        AccesoAlSistema.addActionListener(this);*/

        JLabel txtLogin = new JLabel("BIENVENIDO AL SISTEMA DE CONTROL ");
        txtLogin.setFont(new Font("Arial", Font.PLAIN, 24));
        txtLogin.setBounds(100,30, 300,30);
        add(txtLogin);

        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBounds(20, 120,500,400);
        panelLogin.setBackground(new Color(215, 103, 252));
        add(panelLogin);

        JLabel txtSSN = new JLabel("Ingrese ID Farmacia");
        txtSSN.setBounds(170,30,150,20);
        txtSSN.setToolTipText("(Número de Seguro Social)");
        panelLogin.add(txtSSN);

        JTextField cajaSSN = new JTextField();
        cajaSSN.setBounds(150, 50, 200,20);
        panelLogin.add(cajaSSN);

        JLabel txtSSNContraseña = new JLabel("Ingrese Contraseña");
        txtSSNContraseña.setBounds(170,80,150,20);
        panelLogin.add(txtSSNContraseña);

        JTextField cajaSSNContraseña = new JTextField();
        cajaSSNContraseña.setBounds(150, 100, 200,20);
        panelLogin.add(cajaSSNContraseña);

    }
}
