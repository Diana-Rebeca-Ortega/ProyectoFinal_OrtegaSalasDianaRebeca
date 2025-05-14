package Vista;

import Vista.GUI_Medico.HomeMedico;
import Vista.GUI_Medico.LoginMedico;
import Vista.GUI_Paciente.HomePaciente;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class VentanaLogin extends JFrame  {

    public VentanaLogin() {

        setTitle("FARMACIA RX");
        setSize(390,500);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\LogoRX.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel logo = new JLabel(new ImageIcon(image.getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        logo.setBounds((getWidth()/2)-30,5,50,50);
        add(logo);

        JLabel txtIntroduccion = new JLabel("Bienvenido al sistema de control de Farmacias RX");
        txtIntroduccion.setBounds(50,50,370,20);
        add(txtIntroduccion);
        JLabel txtIntroduccion2 = new JLabel("Porfavor seleccione el tipo de usuario para ingresar al sistema");
        txtIntroduccion2.setBounds(15,65,370,20);
        add(txtIntroduccion2);

        JButton btnPaciente = new JButton("PACIENTE");
        btnPaciente.setBounds(130, 140, 100,30);
        add(btnPaciente);
        btnPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btnPaciente){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new HomePaciente();
                        }});}}});

        JButton btnMedico = new JButton("MEDICO");
        btnMedico.setBounds(130, 240, 100,30);
        add(btnMedico);
        btnMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btnMedico){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new HomeMedico();
                        }});}}});

        JButton btnFarmacia = new JButton("ADMINISTRAYIVO");
        btnFarmacia.setBounds(130, 340, 100,30);
        add(btnFarmacia);
        btnFarmacia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btnFarmacia){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new VentanaAdministracion();
                        }});}}});


    }//VentanaPantallaCompleta

}
class VentanaPrincipal extends  JFrame implements ActionListener{
    JMenu menuPrincipal, informacion;
    JPanel panelEncabezado, panelScroll;
    JLabel encabezado;
    JMenuBar menuBar;
    JScrollPane scrollPane;
    JMenuItem AccesoAlSistema;
    public VentanaPrincipal(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);//para que no queden registros en la ram
        setTitle("FARMACIA SIMILARES");
        setSize(1080,560);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        panelEncabezado = new JPanel();
        panelEncabezado.setLayout(null);
        panelEncabezado.setBackground(Color.cyan);
        panelEncabezado.setBounds( 0,0,1080,100);

        encabezado = new JLabel();
        encabezado.setBounds(300,0,800,100);
        encabezado.setIcon(new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\EncabezadoFarmaciasSimilares.png"));
        panelEncabezado.add(encabezado);
        add(panelEncabezado);

        menuBar = new JMenuBar();

        menuPrincipal = new JMenu ("Menu Principal ");

        AccesoAlSistema = new JMenuItem ("Acceso al Sistema de Datos");
        menuPrincipal.add(AccesoAlSistema);
        AccesoAlSistema.addActionListener(this);
        AccesoAlSistema.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK)//poner el ctrl e
        );

        informacion = new JMenu("Informacion");

        menuPrincipal.setBounds(0,0 , 70, 15);
        informacion.setBounds(80,0,70,15);

        menuBar.add(menuPrincipal);
        menuBar.add(informacion);

        add(menuBar);
        setJMenuBar(menuBar);

        panelScroll = new JPanel();
        panelScroll.setLayout(null);
        panelScroll.setBackground(new Color(227, 239, 248));
        panelScroll.setPreferredSize(new Dimension( 1080,getHeight()+100));

        JLabel txt = new JLabel("hhhhh");
        txt.setBounds(0,0,293,20);
        panelScroll.add(txt);


        scrollPane = new JScrollPane(panelScroll);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //scrollPane.setSize(getWidth(),getHeight());
                scrollPane.setBounds(4,100,getWidth()-20,getHeight()-160);
                panelScroll.setPreferredSize(new Dimension(getWidth()-40,getHeight()+100));
                panelScroll.revalidate();
                scrollPane.revalidate();
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AccesoAlSistema){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new VentanaLogin();
                }
            });
        }
    }
}

public class VentanaInicio {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new VentanaPrincipal();
            }
        });
    }
}
