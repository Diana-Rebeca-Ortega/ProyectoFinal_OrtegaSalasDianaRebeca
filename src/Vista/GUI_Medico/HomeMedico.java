package Vista.GUI_Medico;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeMedico extends JFrame implements ActionListener {
    private JPopupMenu menuDespegable;
    PanelMenuItemAsignarConsultaMedica panelMenuItemAsignarConsultaMedica = new PanelMenuItemAsignarConsultaMedica();
   JPanel ac ;
    JButton btnAsignarConsulta, btnCancelar;
    JMenuItem persona, perfil, menuAltas, menuBajas, menuCambios,menuConsultas,
            asignarConsulta, solicitudesConsultasPacientes,asistenciaConsultas,
            cerrado, cambiarContraseña;
    JMenu privacidad;
    JPanel panelPerfil, panelCambioContraseña, panelAsistencia, panelAsignarConsulta;
    JButton btnSig;
    JToolBar toolBar;
    public HomeMedico(){
        setTitle("MEDICO");
        setSize(1080,560);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

         toolBar = new JToolBar();
        toolBar.setBounds(0, 0, 1080,50);

        JButton btnToolBarAjustes = new JButton();
        JButton btnToolBarPerfil = new JButton();
        btnToolBarAjustes.setIcon(new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\amburguesa.png"));
        btnToolBarPerfil.setIcon(new ImageIcon(  "C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\perfil.png"));
        toolBar.add(btnToolBarAjustes);
        toolBar.add(btnToolBarPerfil);
        add(toolBar);

        btnToolBarAjustes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuDespegable.show(btnToolBarAjustes,0, btnToolBarAjustes.getHeight());
            }
        });

        menuDespegable= new JPopupMenu();
         persona = new JMenuItem("Medico: Diana Rebeca");
         perfil = new JMenuItem("Información de Perfil");
         menuAltas = new JMenuItem("Ingresar nuevo paciente al sistema (Altas)");
         menuBajas = new JMenuItem("Eliminar registro paciente (Bajas)");
         menuCambios = new JMenuItem("Modificar cambios paciente (Cambios)");
         menuConsultas = new JMenuItem("Listado de pacientes registrados (Consultas)");
        JMenu agendarConsultas = new JMenu("Consultas Medicas");
         asignarConsulta = new JMenuItem("Asignar Consulta Medica");
         solicitudesConsultasPacientes = new JMenuItem("Solicitudes de consultas de pacientes en línea");
         asistenciaConsultas = new JMenuItem("Atender consulta (Asistencia)");

        agendarConsultas.add(asignarConsulta);
        agendarConsultas.add(solicitudesConsultasPacientes);
        agendarConsultas.add(asistenciaConsultas);

         privacidad = new JMenu("Privacidad");
        cambiarContraseña= new JMenuItem("Cambiar Contraseña");
        privacidad.add(cambiarContraseña);
         cerrado = new JMenuItem("Cerrar Sesión");

        menuAltas.setBackground(new Color(123, 254, 31));
        menuBajas.setBackground(new Color(255, 22, 22));
        menuConsultas.setBackground(new Color(255, 147, 22));
        menuCambios.setBackground(new Color(22, 156, 255));

        menuDespegable.add(persona);
        menuDespegable.add(perfil);
        menuDespegable.add(menuAltas);
        menuDespegable.add(menuBajas);
        menuDespegable.add(menuCambios);
        menuDespegable.add(menuConsultas);
        menuDespegable.add(agendarConsultas);
        menuDespegable.add(privacidad);
        menuDespegable.add(cerrado);

        perfil.addActionListener(this);
        cambiarContraseña.addActionListener(this);
        asistenciaConsultas.addActionListener(this);
        asignarConsulta.addActionListener(this);
        menuAltas.addActionListener(this);
        menuBajas.addActionListener(this);
        menuConsultas.addActionListener(this);
        menuCambios.addActionListener(this);

        JLabel txtHome = new JLabel("Home ");
        txtHome.setBounds(520,50,300,40);
        //add(txtHome);
//**********************Panel del Perfil Personal*****************************
       panelPerfil = new JPanel();
       panelPerfil.setBounds(5,toolBar.getHeight()+5,1050,470);
       panelPerfil.setBackground(new Color(225, 253, 207));
        panelPerfil.setLayout(null);

       JLabel txtPerfil = new JLabel();
       formatoPerfilMedico(txtPerfil,"Información del Perfil", 20,10,300,40,"Verdana",24,panelPerfil );

       JLabel txtUsuario = new JLabel();
        txtUsuario.setForeground(Color.red);
       formatoPerfilMedico( txtUsuario,"usuario:", 25,90,100,50,"Tahoma",11 , panelPerfil  );

       JLabel txtSSN = new JLabel();
       formatoPerfilMedico(txtSSN, "SSN (Número de Seguro Social):", 73,90,300,20,"Verdana",14,panelPerfil);

       JLabel txtNombre = new JLabel();
       formatoPerfilMedico(txtNombre, "Nombre:", 73, 170,200,20, "Verdana",14,panelPerfil);

       JLabel txtApellidoUno = new JLabel();
       formatoPerfilMedico(txtApellidoUno, "Apellido Paterno:", 350,170,300,20,"Verdana",14,panelPerfil);

        JLabel txtApellidoDos = new JLabel();
        formatoPerfilMedico(txtApellidoDos, "Apellido Materno:", 700,170,300,20,"Verdana",14,panelPerfil);

       JLabel txtEspecialidad = new JLabel();
       formatoPerfilMedico(txtEspecialidad, "Especialidad:", 73,250, 200,20, "Verdana",14,panelPerfil);

       JLabel txtAñosExperiencias = new JLabel();
       formatoPerfilMedico(txtAñosExperiencias, "Años de Experiencia:", 73, 330, 200,20, "Verdana",14,panelPerfil );


//********************************Panel Privacidad Cambiar Contraseña*************************
        panelCambioContraseña = new JPanel();
        panelCambioContraseña.setBounds(5,toolBar.getHeight()+5,1050,470);
        panelCambioContraseña.setBackground(new Color(225, 253, 207));
        panelCambioContraseña.setLayout(null);

        JLabel txtCambioContraseña = new JLabel();
        formatoPerfilMedico(txtCambioContraseña,"Cambiar Contraseña", 20,10,300,40,"Verdana",24,panelCambioContraseña );

        JLabel txtActual = new JLabel();
        formatoPerfilMedico(txtActual, "Ingrese Contraseña Actual:", 30, 60, 300,40,"Verdana",14,panelCambioContraseña );

        JLabel txtNueva = new JLabel();
        formatoPerfilMedico(txtNueva, "Ingrese Nueva Contraseña:", 30, 100, 300,40,"Verdana",14,panelCambioContraseña );

        JLabel txtRepita = new JLabel();
        formatoPerfilMedico(txtRepita, "Repita Nueva Contraseña:", 30, 140, 300,40,"Verdana",14,panelCambioContraseña );

        JButton btnCambiarContraseña = new JButton("Cambiar Contraseña");
        btnCambiarContraseña.setBounds((panelCambioContraseña.getWidth()/2)-100, 230, 200, 40);
        panelCambioContraseña.add(btnCambiarContraseña);

        JPasswordField cajaContraseñaActual = new JPasswordField();
        cajaContraseñaActual.setBounds(280,75,200,20);
        panelCambioContraseña.add(cajaContraseñaActual);

        JPasswordField cajaContraseñaNueva = new JPasswordField();
        cajaContraseñaNueva.setBounds(280,115,200,20);
        panelCambioContraseña.add(cajaContraseñaNueva);

        JPasswordField cajaContraseñaNuevaRepetida = new JPasswordField();
        cajaContraseñaNuevaRepetida.setBounds(280,155,200,20);
        panelCambioContraseña.add(cajaContraseñaNuevaRepetida);

//************************Panel Asistencia Pacientes *************************
        panelAsistencia = new JPanel();
        panelAsistencia.setBounds(5,toolBar.getHeight()+5,1050,470);
        panelAsistencia.setBackground(new Color(225, 253, 207));
        panelAsistencia.setLayout(null);

        JLabel txtSeleccion = new JLabel();
        formatoPerfilMedico(txtSeleccion, "Seleccione la cita a atender", 30,30,300,20,"Arial", 20, panelAsistencia);


        btnSig = new JButton("SIGUIENTE");
        btnSig.setBounds(30,400,100,20);
        panelAsistencia.add(btnSig);
        btnSig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new AsistenciaConsulta();
                    }
                });
            }
        });
        ac = panelMenuItemAsignarConsultaMedica.agregar_panelAsignarConsulta(toolBar, btnAsignarConsulta,btnCancelar);
        solicitudesConsultasPacientes.addActionListener(this);
    }

    public void formatoPerfilMedico(JLabel etiqueta, String texto, int x, int y ,
                                    int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        pan.add(etiqueta);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==perfil){
            add(panelPerfil, BorderLayout.CENTER);
            remove(ac);
            revalidate();
            repaint();
        }
        if(e.getSource()==asignarConsulta){//menuitem
            add(ac, BorderLayout.CENTER);
            remove(panelPerfil);
            revalidate();
            repaint();
        }
        if (e.getSource()==cambiarContraseña){
            add(panelCambioContraseña, BorderLayout.CENTER);
            revalidate();
            repaint();
        }

        /*if(e.getSource()==asistenciaConsultas){
            add(panelAsistencia, BorderLayout.CENTER);
            revalidate();
            repaint();
        }*/
         if(e.getSource()==btnAsignarConsulta){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AsignarConsulta();
                }
            });
        }if(e.getSource()==solicitudesConsultasPacientes){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new  SolicitudesDeConsultaMedico();
                }
            });
        }
        if(e.getSource()==menuAltas){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new  AltasPacientes();
                }
            });
        }if(e.getSource()==menuBajas){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new  BajasPacientes();
                }
            });
        }
        if(e.getSource()==menuConsultas){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new  ConsultasPacientes();
                }
            });
        }if(e.getSource()==menuCambios){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new  CambiosPacientes();
                }
            });
        }
    }
}
