package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaMedico extends JFrame  {

        public VentanaMedico(){
            setTitle("MEDICO");
            setSize(570,700);
            setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
            setLayout(null);
            setVisible(true);



            JLabel txtLogin = new JLabel("BIENVENIDO MEDICO ");
            txtLogin.setFont(new Font("Arial", Font.PLAIN, 24));
            txtLogin.setBounds(160,30, 300,30);
            add(txtLogin);

            JButton btnLogin = new JButton("Log in");
            btnLogin.setBounds(100,80, 150,30);
            add(btnLogin);

            JButton btnSingUp = new JButton("Sing Up");
            btnSingUp.setBounds(300,80, 150,30);
            add(btnSingUp);



        }


    }
