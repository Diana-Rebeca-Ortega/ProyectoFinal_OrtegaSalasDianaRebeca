package Vista.GUI.Administrativo;

import Vista.GUI.Administrativo.ABCC_CompañiasFarmaceuticas.Altas_CompañiasFarmaceuticas;
import Vista.GUI.Administrativo.ABCC_CompañiasFarmaceuticas.Cambios_CompañiasFarmaceuticas;
import Vista.GUI.Administrativo.ABCC_CompañiasFarmaceuticas.Consultas_CompañiasFarmaceuticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdministrativo extends JFrame implements ActionListener {
    JToolBar toolBar;
    private JLabel encabezado, lugar;
    private  JPanel panelEncabezado;
    JButton contratos;
    JButton RegistrosMedicos;
    JButton comFarmaceuticas;
    JMenuItem Contratos, NewContrato;
    JMenuItem AltasComFarmaceutica, CambiosComFarmaceuticas, ConsultasComFarmaceutica;
    JPopupMenu menuDespegableContratos, menuDespegableComFarmaceuticas;
    PanelNuevoContrato pnc = new PanelNuevoContrato();
    public  HomeAdministrativo(){
        setTitle("ADMINISTRATIVO");
        setSize(1080,560);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        panelEncabezado = new JPanel();
        panelEncabezado.setLayout(null);
        panelEncabezado.setBackground(new Color(255,255,255));
        panelEncabezado.setBounds( 0,0,1080,60);

        encabezado = new JLabel();
        encabezado.setBounds(19,3,800,60);
        encabezado.setIcon(new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\logoTituloFRX.png"));
        panelEncabezado.add(encabezado);

        lugar = new JLabel();
        lugar.setBounds(getWidth()-200,10,200,30);
        lugar.setIcon(new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\jerezZ.png"));
        panelEncabezado.add(lugar);
        add(panelEncabezado);

        toolBar = new JToolBar();
        toolBar.setBounds(0,panelEncabezado.getHeight() , 1080,22);

        contratos = new JButton("Contratos");
        contratos.setSize(300,20);
        toolBar.add(contratos);

        RegistrosMedicos = new JButton("Registros de Medicos");
        RegistrosMedicos.setSize(200,20);
        toolBar.add(RegistrosMedicos );

        comFarmaceuticas= new JButton("Compañias Farmaceuticas");
        comFarmaceuticas.setSize(200,20);
        toolBar.add(comFarmaceuticas );

        add(toolBar);
        //****************Contratos***********************
        contratos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menuDespegableContratos.show(contratos,0, contratos.getHeight());
            }
        });
        menuDespegableContratos = new JPopupMenu();
        Contratos = new JMenuItem("Contratos Registrados");
        NewContrato = new JMenuItem("Nuevo Contrato");
        NewContrato.setBackground(new Color(123, 254, 31));

        menuDespegableContratos.add(NewContrato );
        menuDespegableContratos.add(Contratos );


        Contratos.addActionListener(this);
        NewContrato.addActionListener(this);


//********************Compañias Farmaceuticas*********************
        comFarmaceuticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuDespegableComFarmaceuticas.show(comFarmaceuticas,0, comFarmaceuticas.getHeight());
            }
        });

        menuDespegableComFarmaceuticas = new JPopupMenu();

        AltasComFarmaceutica = new JMenuItem("Agregar Compañia Farmaceutica");
        AltasComFarmaceutica.setBackground(new Color(123, 254, 31));
        CambiosComFarmaceuticas= new JMenuItem("Modificaciones Compañia Farmaceutica");
        CambiosComFarmaceuticas.setBackground(new Color(255, 147, 22));
        ConsultasComFarmaceutica= new JMenuItem("Consultas Compañia Farmaceutica");
        ConsultasComFarmaceutica.setBackground(new Color(22, 156, 255));

        menuDespegableComFarmaceuticas.add(AltasComFarmaceutica);
        menuDespegableComFarmaceuticas.add(CambiosComFarmaceuticas);
        menuDespegableComFarmaceuticas.add(ConsultasComFarmaceutica);

        AltasComFarmaceutica.addActionListener(this);
        CambiosComFarmaceuticas.addActionListener(this);
        ConsultasComFarmaceutica.addActionListener(this);




        nuevoCOntrato = pnc.AgregarpanelNuevoContrato();

    }
JScrollPane nuevoCOntrato;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==NewContrato){
             add(nuevoCOntrato);
            revalidate();
            repaint();
        }if (e.getSource()==AltasComFarmaceutica){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Altas_CompañiasFarmaceuticas();
                }
            });
        }if (e.getSource()==CambiosComFarmaceuticas){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Cambios_CompañiasFarmaceuticas();
                }
            });
        }if (e.getSource()==ConsultasComFarmaceutica){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Consultas_CompañiasFarmaceuticas();
                }
            });
        }

    }
}
