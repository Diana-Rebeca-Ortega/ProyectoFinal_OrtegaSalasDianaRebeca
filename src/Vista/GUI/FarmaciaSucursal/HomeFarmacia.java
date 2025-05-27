package Vista.GUI.FarmaciaSucursal;

import Modelo.Farmacia;
import Vista.GUI.FarmaciaSucursal.ABCC_CompañiasFarmaceuticas.Altas_CompañiasFarmaceuticas;
import Vista.GUI.FarmaciaSucursal.ABCC_CompañiasFarmaceuticas.Cambios_CompañiasFarmaceuticas;
import Vista.GUI.FarmaciaSucursal.ABCC_CompañiasFarmaceuticas.Consultas_CompañiasFarmaceuticas;
import Vista.GUI.FarmaciaSucursal.ABCC_Medicamentos.Altas_Medicamentos;
import Vista.GUI.FarmaciaSucursal.ABCC_Medicamentos.Bajas_Medicamentos;
import Vista.GUI.FarmaciaSucursal.ABCC_Medicos.AltasMedicoss;
import Vista.GUI.FarmaciaSucursal.ABCC_Medicos.BajasMedicoss;
import Vista.GUI.FarmaciaSucursal.ABCC_Medicos.CambiosMedicoss;
import Vista.GUI.FarmaciaSucursal.ABCC_Medicos.ConsultasMedicoss;
import Vista.GUI.FarmaciaSucursal.ABCC_Supervisores.AltasSupervisores;
import Vista.GUI.FarmaciaSucursal.ABCC_Supervisores.BajasSupervisores;
import Vista.GUI.FarmaciaSucursal.ABCC_Supervisores.CambiosSupervisores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFarmacia extends JFrame implements ActionListener {
    JToolBar toolBar;
    private JLabel encabezado, lugar;
    private  JPanel panelEncabezado;
    JButton contratos;
    JButton RegistrosMedicos;
    JButton comFarmaceuticas;
    JButton supervisores;
    JMenuItem ContratosRegistros, NewContrato;
    JMenuItem AltasComFarmaceutica, CambiosComFarmaceuticas, ConsultasComFarmaceutica, BajasComFarmaceutica;
    JMenu Medicamentos;
    JMenuItem AltasMedicamentos, BajasMedicamentos, CambiosMedicamentos, ConsultasMedicamentos;
    JMenuItem AltasSupervisores, BajasSupervisores, CambiosSupervisores, ConsultasSupervisores;
    JPopupMenu menuDespegableContratos, menuMedicos, menuDespegableComFarmaceuticas, menuSupervisores;
    JMenuItem AltasMedicos, BajasMedicos, CambiosMedicos, ConsultasMedicos;
    PanelNuevoContrato pnc = new PanelNuevoContrato();
    PanelRegistrosContratos pr = new PanelRegistrosContratos();
    Farmacia farmacic;
    JPanel nuevoContrato, registrosContratos;
    public HomeFarmacia(Farmacia farmacia){
        farmacic=farmacia;

        setTitle("FARMACIA SUCURSAL");
        setSize(1080,560);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        nuevoContrato =pnc.AgregarpanelNuevoContrato( farmacia);
        registrosContratos= pr.Agregar_panelRegistros(farmacia);

        panelEncabezado = new JPanel();
        panelEncabezado.setLayout(null);
        panelEncabezado.setBackground(new Color(255,255,255));
        panelEncabezado.setBounds( 0,0,1080,60);


        encabezado = new JLabel();
        encabezado.setBounds(19,3,800,60);
        encabezado.setIcon(new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\logoTituloFRX.png"));
        panelEncabezado.add(encabezado);
        ImageIcon  ImagenMunicipio = null;
        if (farmacia.getMunicipio().equals("Jerez")){
             ImagenMunicipio = new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\RX_Municipios\\jerez,zacatecas.png");
        }else if (farmacia.getMunicipio().equals("Zacatecas")  ){
            ImagenMunicipio = new ImageIcon(
                 "C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\RX_Municipios\\zac,zac.png"
                    );
        }else if (farmacia.getMunicipio().equals("Canatlán")  ){
            ImagenMunicipio = new ImageIcon(
                  "C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\RX_Municipios\\canatlan,durango.png"
            );
        }else if (farmacia.getMunicipio().equals("Canelas")  ){
            ImagenMunicipio = new ImageIcon(
             "C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\RX_Municipios\\canelas,durango.png"
            );
        }else if (farmacia.getMunicipio().equals("Cuencamé")  ){
            ImagenMunicipio = new ImageIcon(
               "C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\RX_Municipios\\cuencame,durango.png"
            );
        }else if (farmacia.getMunicipio().equals("Puerto Vallarta")  ){
            ImagenMunicipio = new ImageIcon(
             "C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\RX_Municipios\\ptoVallarta.png"
            );
        }


        lugar = new JLabel();
        lugar.setBounds(getWidth()-400,10,400,30);
        lugar.setIcon(ImagenMunicipio);
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
        ContratosRegistros = new JMenuItem("Contratos Registrados");
        NewContrato = new JMenuItem("Nuevo Contrato");
        NewContrato.setBackground(new Color(123, 254, 31));

        menuDespegableContratos.add(NewContrato );
        menuDespegableContratos.add(ContratosRegistros);

        ContratosRegistros.addActionListener(this);
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
        BajasComFarmaceutica= new JMenuItem("Eliminar Compañia Farmaceutica");
        BajasComFarmaceutica.setBackground(new Color(255, 22, 22));
        Medicamentos= new JMenu("Medicamentos");

        AltasMedicamentos= new JMenuItem("Agregar Medicamentos");
        AltasMedicamentos.setBackground(new Color(123, 254, 31));
        CambiosMedicamentos= new JMenuItem("Modificaciones Medicamentos");
        CambiosMedicamentos.setBackground(new Color(255, 147, 22));
        ConsultasMedicamentos= new JMenuItem("Consultas Medicamentos");
        ConsultasMedicamentos.setBackground(new Color(22, 156, 255));
        BajasMedicamentos= new JMenuItem("Eliminar Medicamentos");
        BajasMedicamentos.setBackground(new Color(255, 22, 22));


        Medicamentos.add(AltasMedicamentos);
        Medicamentos.add(CambiosMedicamentos);
        Medicamentos.add(ConsultasMedicamentos);
        Medicamentos.add(BajasMedicamentos);

        AltasMedicamentos.addActionListener(this);
        CambiosMedicamentos.addActionListener(this);
        ConsultasMedicamentos.addActionListener(this);
        BajasMedicamentos.addActionListener(this);

        menuDespegableComFarmaceuticas.add(AltasComFarmaceutica);
        menuDespegableComFarmaceuticas.add(CambiosComFarmaceuticas);
        menuDespegableComFarmaceuticas.add(ConsultasComFarmaceutica);
        menuDespegableComFarmaceuticas.add(BajasComFarmaceutica);

        menuDespegableComFarmaceuticas.add(Medicamentos);

        AltasComFarmaceutica.addActionListener(this);
        CambiosComFarmaceuticas.addActionListener(this);
        ConsultasComFarmaceutica.addActionListener(this);
        BajasComFarmaceutica.addActionListener(this);
        Medicamentos.addActionListener(this);
//*****************************Supervisores*******************
        supervisores = new JButton("Supervisores");
        supervisores.setSize(200,20);
        toolBar.add(supervisores );
        supervisores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSupervisores.show(supervisores,0, supervisores.getHeight());
            }
        });
        menuSupervisores = new JPopupMenu();

        AltasSupervisores  = new JMenuItem("Agregar Supervisores");
        AltasSupervisores.setBackground(new Color(123, 254, 31));
        BajasSupervisores  = new JMenuItem("Eliminar Supervisores");
        BajasSupervisores.setBackground(new Color(255, 22, 22));
        CambiosSupervisores  = new JMenuItem("Cambios Supervisores");
        CambiosSupervisores.setBackground(new Color(255, 147, 22));
        ConsultasSupervisores  = new JMenuItem("Consultas Supervisores");
        ConsultasSupervisores.setBackground(new Color(22, 156, 255));

        AltasSupervisores.addActionListener(this);
        BajasSupervisores.addActionListener(this);
        CambiosSupervisores.addActionListener(this);
        ConsultasSupervisores.addActionListener(this);

        menuSupervisores.add(AltasSupervisores);
        menuSupervisores.add(BajasSupervisores);
        menuSupervisores.add(CambiosSupervisores);
        menuSupervisores.add(ConsultasSupervisores);
//*********************Medicos ***********************************
        RegistrosMedicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuMedicos.show(RegistrosMedicos,0, RegistrosMedicos.getHeight());
            }
        });
        menuMedicos = new JPopupMenu();

        AltasMedicos = new JMenuItem("Altas Medicos");
        AltasMedicos.setBackground(new Color(123, 254, 31));
        BajasMedicos = new JMenuItem("Bajas Medicos");
        BajasMedicos.setBackground(new Color(255, 22, 22));
        CambiosMedicos= new JMenuItem("Modificaciones Medicos");
        CambiosMedicos.setBackground(new Color(255, 147, 22));
        ConsultasMedicos= new JMenuItem("Consultas Medicos");
        ConsultasMedicos.setBackground(new Color(22, 156, 255));

        menuMedicos.add(AltasMedicos);
        menuMedicos.add(BajasMedicos);
        menuMedicos.add(CambiosMedicos);
        menuMedicos.add(ConsultasMedicos);

        AltasMedicos.addActionListener(this);
        BajasMedicos.addActionListener(this);
        CambiosMedicos.addActionListener(this);
        ConsultasMedicos.addActionListener(this);


    }
    //JScrollPane sp =   pnc.AgregarpanelNuevoContrato();
//JScrollPane nuevoCOntrato;
    @Override
    public void actionPerformed(ActionEvent e) {
        //****************COMPAÑIAS FARMACEUTICAS*****************
        if (e.getSource()==AltasComFarmaceutica){
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
        //*************************SUPERVISORES***********************
        if (e.getSource()==AltasSupervisores){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AltasSupervisores();
                }
            });
        }if (e.getSource()==BajasSupervisores){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new BajasSupervisores();
                }
            });
        }if (e.getSource()==CambiosSupervisores){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new CambiosSupervisores();
                }
            });
        }
        //***************MEDICOS****************************
        if (e.getSource()==AltasMedicos){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AltasMedicoss();
                }
            });
        } if (e.getSource()==BajasMedicos){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new BajasMedicoss();
                }
            });
        }if (e.getSource()==CambiosMedicos){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new CambiosMedicoss();
                }
            });
        }if (e.getSource()==ConsultasMedicos){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ConsultasMedicoss();
                }
            });
        }
        //********************Contratos****************
        if (e.getSource()==NewContrato){
            add(nuevoContrato, BorderLayout.CENTER);
            remove( registrosContratos);
            revalidate();
            repaint();

        }if (e.getSource()== ContratosRegistros){
            add(registrosContratos, BorderLayout.CENTER);
            remove( nuevoContrato);
            revalidate();
            repaint();
        }
        //********************Medicinas***************

        if (e.getSource()==AltasMedicamentos){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Altas_Medicamentos();
                }
            });
        }if (e.getSource()==BajasMedicamentos){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Bajas_Medicamentos();
                }
            });
        }
    }
}
