package Vista.GUI_Administrativo;

import Vista.GUI_Medico.CambiosPacientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdministrativo  extends JFrame implements ActionListener {
    JPanel panelEncabezado ;
    JLabel encabezado ;
    JToolBar toolBar ;
    JButton AltasFarmacias, CambiosFarmacias, ConsultasFarmacias;
    public HomeAdministrativo(){
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

    add(panelEncabezado);

        toolBar = new JToolBar();
        toolBar.setBounds(0,panelEncabezado.getHeight() , 1080,22);

        AltasFarmacias = new JButton("Altas Farmacias");
        AltasFarmacias.setSize(300,20);

        CambiosFarmacias = new JButton("Cambios Farmacias");
        CambiosFarmacias.setSize(300,20);

        ConsultasFarmacias = new JButton("Consultas Farmacias");
        ConsultasFarmacias.setSize(300,20);

        toolBar.add(AltasFarmacias);
        toolBar.add(CambiosFarmacias);
        toolBar.add(ConsultasFarmacias);

        add(toolBar);

        AltasFarmacias.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==AltasFarmacias){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AltasFarmacias();
                }
            });
        }
    }
}
