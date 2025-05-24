package Vista.GUI.Administrativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdministrativo extends JFrame implements ActionListener {
    JToolBar toolBar;
    private JLabel encabezado, lugar;
    private  JPanel panelEncabezado;
    JButton compañiasFarmaceuticas;
    JButton RegistrosMedicos;
    JMenuItem Contratos, NewContrato;
    JPopupMenu menuDespegable;
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

        compañiasFarmaceuticas = new JButton("Compañias Farmaceuticas");
        compañiasFarmaceuticas.setSize(300,20);
        toolBar.add(compañiasFarmaceuticas );

        RegistrosMedicos = new JButton("Registros de Medicos");
        RegistrosMedicos.setSize(200,20);
        toolBar.add(RegistrosMedicos );

        add(toolBar);


        ScrollPane sc = new ScrollPane();
        compañiasFarmaceuticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menuDespegable.show(compañiasFarmaceuticas,0, compañiasFarmaceuticas.getHeight());
            }
        });
        menuDespegable= new JPopupMenu();
        Contratos = new JMenuItem("Contratos Registrados");
        NewContrato = new JMenuItem("Nuevo Contrato");
        NewContrato.setBackground(new Color(123, 254, 31));

        menuDespegable.add(NewContrato );
        menuDespegable.add(Contratos );

        Contratos.addActionListener(this);
        NewContrato.addActionListener(this);

        nuevoCOntrato = pnc.AgregarpanelNuevoContrato();

    }
JScrollPane nuevoCOntrato;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==NewContrato){
             add(nuevoCOntrato);
            revalidate();
            repaint();
        }
    }
}
