package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class VentanaLogin extends JFrame  {


    public VentanaLogin() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);//para que no queden registros en la ram
        setTitle("FARMACIA SIMILARES");
        setSize(300,500);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);


        JLabel txtLogin = new JLabel("LOGIN");
        txtLogin.setBounds(105, 15, 300,30);
        txtLogin.setFont(new Font("Arial", Font.PLAIN, 24));
        add(txtLogin);

        JButton btnPaciente = new JButton("PACIENTE");
        btnPaciente.setBounds(90, 90, 100,30);
        add(btnPaciente);
        btnPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btnPaciente){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new VentanaPaciente();
                        }});}}});

        JButton btnMedico = new JButton("MEDICO");
        btnMedico.setBounds(90, 190, 100,30);
        add(btnMedico);
        btnMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btnMedico){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new VentanaMedico();
                        }});}}});

        JButton btnFarmacia = new JButton("FARMACIA");
        btnFarmacia.setBounds(90, 290, 100,30);
        add(btnFarmacia);
        btnFarmacia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btnFarmacia){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new VentanaFarmacia();
                        }});}}});


    }//VentanaPantallaCompleta

}
class VentanaPrincipal extends  JFrame{
    JMenu menuPrincipal, informacion;
    public VentanaPrincipal(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);//para que no queden registros en la ram
        setTitle("FARMACIA SIMILARES");
        setSize(1080,560);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        JPanel panelEncabezado = new JPanel();
        panelEncabezado.setLayout(null);
        panelEncabezado.setBackground(Color.cyan);
        panelEncabezado.setBounds( 0,0,1080,100);

        JLabel encabezado = new JLabel();
        encabezado.setBounds(300,0,800,100);
        encabezado.setIcon(new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\EncabezadoFarmaciasSimilares.png"));
        panelEncabezado.add(encabezado);
        add(panelEncabezado);

        JMenuBar menuBar = new JMenuBar();

        menuPrincipal = new JMenu ("Menu Principal ");
        informacion = new JMenu("Informacion");
        menuPrincipal.setBounds(0,0 , 70, 15);
        informacion.setBounds(80,0,70,15);
        menuBar.add(menuPrincipal);
        menuBar.add(informacion);

        add(menuBar);
        setJMenuBar(menuBar);
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
