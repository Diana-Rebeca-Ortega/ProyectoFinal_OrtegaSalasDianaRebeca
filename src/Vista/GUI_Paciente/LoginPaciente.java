package Vista.GUI_Paciente;

import Controlador.PacienteDAO;
import Modelo.Medico;
import Modelo.Paciente;
import Vista.GUI_Medico.HomeMedico;
import Vista.VentanaInicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPaciente  extends JFrame implements ActionListener {

        JPanel panelLogin;
        JButton btnIniciarSesion;
        PacienteDAO pacienteDAO = new PacienteDAO();
        JTextField cajaSSNContraseña, cajaSSN;
        JLabel txtUsuarioMalo;
        public LoginPaciente(){
            setTitle("PACIENTE");
            setSize(570,700);
            setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
            setLayout(null);
            setVisible(true);
            getContentPane().setBackground(new Color(220, 214, 147));

            JLabel txtLogin = new JLabel("BIENVENIDO PACIENTE ");
            txtLogin.setFont(new Font("Arial", Font.PLAIN, 24));
            txtLogin.setBounds(160,30, 300,30);
            add(txtLogin);

//PANEL LOGIN*******************************************************
            panelLogin = new JPanel();
            panelLogin.setLayout(null);
            panelLogin.setBounds(20, 120,500,400);
            panelLogin.setBackground(new Color(227, 232, 185));
            panelLogin.setBorder(BorderFactory.createLineBorder(  new Color(193, 125, 96)));

            JLabel txtSSN = new JLabel("Ingrese Usuario (SSN)");
            txtSSN.setBounds(170,30,150,20);
            txtSSN.setToolTipText("(Número de Seguro Social)");
            panelLogin.add(txtSSN);

            cajaSSN = new JTextField();
            cajaSSN.setBounds(150, 50, 200,20);
            panelLogin.add(cajaSSN);

            txtUsuarioMalo = new JLabel("El usuario ingresado no existe");
            txtUsuarioMalo.setFont(new Font("Arial", Font.PLAIN, 10));
            txtUsuarioMalo.setForeground(new Color(255, 8, 8));
            txtUsuarioMalo.setBounds(150,67,200,20);


            JLabel txtSSNContraseña = new JLabel("Ingrese Contraseña");
            txtSSNContraseña.setBounds(170,100,150,20);
            panelLogin.add(txtSSNContraseña);

            cajaSSNContraseña = new JTextField();
            cajaSSNContraseña.setBounds(150, 120, 200,20);
            panelLogin.add(cajaSSNContraseña);

            JLabel txtRecuperarContraseña = new JLabel("¿Olvidaste tu Contraseña?");
            txtRecuperarContraseña.setFont(new Font("Arial", Font.PLAIN, 10));
            txtRecuperarContraseña.setBackground(Color.GRAY);
            txtRecuperarContraseña.setBounds(150,140,200,20);
            panelLogin.add(txtRecuperarContraseña);

            btnIniciarSesion = new JButton("Iniciar Sesion");
            btnIniciarSesion.setBounds(170,200,150,20);
            panelLogin.add(btnIniciarSesion);
            btnIniciarSesion.addActionListener(this);

            add(panelLogin);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            //////////////////////////////////////////////INICIAR SESION

            if (e.getSource()==btnIniciarSesion){
                if(pacienteDAO.mostrarPaciente(cajaSSN.getText(), "ID")==null){
                    //JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    cajaSSN.setText("");
                    panelLogin.add(txtUsuarioMalo);
                    repaint();
                }else{
                    //JOptionPane.showMessageDialog(null,  "SI se encontraron registros");
                    pacienteDAO.mostrarPaciente(cajaSSN.getText(), "ID");

                    Paciente paciente = pacienteDAO.mostrarPaciente(cajaSSN.getText(), "ID");
                    setVisible(false);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new HomePaciente(paciente);
                        }
                    });
                }//else
            }/////////////////////////////////////////INICIAR SESION
        }//actionListener
    }

