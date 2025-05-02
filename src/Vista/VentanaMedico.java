package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMedico extends JFrame implements ActionListener {
    JRadioButton radioLogin, radioSignup;
    ButtonGroup bg;
    JPanel panelLogin, panelSingUp;
    JButton btnIniciarSesion;
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
            radioLogin.addActionListener(this);

            radioSignup = new JRadioButton("Sign up");
            radioSignup.setBounds(300,80, 150,30);
            radioSignup.setFont(new Font("Arial", Font.PLAIN, 18));
            bg.add(radioSignup);
            add(radioSignup);
            radioSignup.addActionListener(this);
//PANEL LOGIN*******************************************************
            panelLogin = new JPanel();
            panelLogin.setLayout(null);
            panelLogin.setBounds(20, 120,500,400);
            panelLogin.setBackground(new Color(103, 188, 252));

            JLabel txtSSN = new JLabel("Ingrese Usuario (SSN)");
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

        JLabel txtRecuperarContraseña = new JLabel("¿Olvidaste tu Contraseña?");
        txtRecuperarContraseña.setFont(new Font("Arial", Font.PLAIN, 10));
        txtRecuperarContraseña.setBackground(Color.GRAY);
        txtRecuperarContraseña.setBounds(150,120,200,20);
        panelLogin.add(txtRecuperarContraseña);

         btnIniciarSesion = new JButton("Iniciar Sesion");
        btnIniciarSesion.setBounds(170,140,150,20);
        panelLogin.add(btnIniciarSesion);
        btnIniciarSesion.addActionListener(this);

//PANEL SIGN UP********************************************************
            panelSingUp = new JPanel();
            panelSingUp.setLayout(null);
            panelSingUp.setBounds(20, 120,520,400);
            panelSingUp.setBackground(Color.pink);

        JLabel txtDatos = new JLabel("Ingrese los siguientes datos:");
        txtDatos.setBounds(150,20,200,20);
        panelSingUp.add(txtDatos);

        JLabel txtSSNS = new JLabel("SSN:");
        txtSSNS.setBounds(30,50,100,20);
        txtSSNS.setToolTipText("(Número de Seguro Social)");
        panelSingUp.add(txtSSNS);

        JTextField cajaSSNS = new JTextField();
        cajaSSNS.setBounds(70, 50, 200,17);
        panelSingUp.add(cajaSSNS);

        JLabel txtNombreMedico = new JLabel("Nombre:");
        txtNombreMedico.setBounds(30,70,100,20);
        panelSingUp.add(txtNombreMedico);

        JTextField cajaNombreMedico = new JTextField();
        cajaNombreMedico.setBounds(100, 70, 200,17);
        panelSingUp.add(cajaNombreMedico);

        JLabel txtPrimerApMedico = new JLabel("Primer Apellido:");
        txtPrimerApMedico.setBounds(30,90,130,20);
        panelSingUp.add(txtPrimerApMedico);

        JTextField cajaPrimerApMedico = new JTextField();
        cajaPrimerApMedico.setBounds(180, 90, 200,17);
        panelSingUp.add(cajaPrimerApMedico);

        JLabel txtSegundoApMedico = new JLabel("Segundo Apellido:");
        txtSegundoApMedico.setBounds(30,110,130,20);
        panelSingUp.add(txtSegundoApMedico);

        JTextField cajaSegundoApMedico = new JTextField();
        cajaSegundoApMedico.setBounds(180, 110, 200,17);
        panelSingUp.add(cajaSegundoApMedico);

        JLabel txtEspecialidad = new JLabel("Especialidad:");
        txtEspecialidad.setBounds(30,130,130,20);
        panelSingUp.add(txtEspecialidad);

        JTextField cajaEspecialidad = new JTextField();
        cajaEspecialidad.setBounds(110, 130, 200,17);
        panelSingUp.add(cajaEspecialidad);

        JLabel txtAñosExperiencia = new JLabel("Años de Experiencia:");
        txtAñosExperiencia.setBounds(30,150,130,20);
        panelSingUp.add(txtAñosExperiencia);

        JTextField cajaAñosExperiencia = new JTextField();
        cajaAñosExperiencia.setBounds(160, 150, 200,17);
        panelSingUp.add(cajaAñosExperiencia);
        

        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==radioLogin){
            add(panelLogin);
          remove(panelSingUp);
            revalidate();
            repaint();
        }if(e.getSource()==radioSignup){
            add(panelSingUp);
           remove(panelLogin);
            revalidate();
            repaint();
        }
        //////////////////////////////////////////////INICIAR SESION

        if (e.getSource()==btnIniciarSesion){
/*
                if(alumnoDAO.mostrarAlumno(cajaNombres.getText(), "Nombre")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else{
                    Alumno ob1 = alumnoDAO.mostrarAlumno(cajaNombres.getText(), "Nombre");
                    actualizarTablaConsultas(tablaAlumnosModificaiones, ob1);
                }//else
*/
        }/////////////////////////////////////////INICIAR SESION
    }//actionListener
}
