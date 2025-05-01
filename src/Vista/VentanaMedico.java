package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaMedico extends JFrame  {
    JRadioButton radioLogin, radioSignup;
    ButtonGroup bg;
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

            bg= new ButtonGroup();
            radioLogin = new JRadioButton("Login");
            radioLogin.setBounds(100,80, 150,30);
            radioLogin.setFont(new Font("Arial", Font.PLAIN, 18));
            bg.add(radioLogin);
            add(radioLogin);

            radioSignup = new JRadioButton("Sing up");
            radioSignup.setBounds(300,80, 150,30);
            radioSignup.setFont(new Font("Arial", Font.PLAIN, 18));
            bg.add(radioSignup);
            add(radioSignup);



        }


    }
