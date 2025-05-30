package Vista.GUI_Paciente;

import Modelo.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePaciente  extends JFrame implements ActionListener{
    private ImageIcon fondo;
    private JPopupMenu menuDespegable;
    PanelInformacionPersonal ip = new PanelInformacionPersonal( );
    PanelMedicoCabecera mca = new PanelMedicoCabecera();
    JPanel ac, mc;
    JMenuItem cerrandolo;
    JMenuItem perfil, menuDatosPersonales, medicoCabecera, historialConsultas, SolicitarConsulta;
    public HomePaciente(Paciente paciente){

        setTitle("PACIENTE");
        setSize(900,700);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(255, 252, 206, 255));

        JToolBar toolBar = new JToolBar();
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
        perfil = new JMenuItem("Paciente: "+ paciente.getNombre());
        menuDatosPersonales = new JMenuItem("Información de Perfil");
        medicoCabecera = new JMenuItem("Médico de cabecera");
        historialConsultas = new JMenuItem("Historial de Consultas");
        SolicitarConsulta = new JMenuItem("Solicitar Consulta");
        perfil.setEnabled(false);
        cerrandolo= new JMenuItem("Cerrar Sesion");

        menuDespegable.add(perfil);
        menuDespegable.add(menuDatosPersonales);
        menuDespegable.add(medicoCabecera);
        menuDespegable.add(cerrandolo);
        //menuDespegable.add(historialConsultas);
       // menuDespegable.add(SolicitarConsulta);

        SolicitarConsulta.addActionListener(this);
        menuDatosPersonales.addActionListener(this);
        historialConsultas.addActionListener(this);
        medicoCabecera.addActionListener(this);
        cerrandolo.addActionListener(this);

        ac= new JPanel();
        mc= new JPanel();
        ac = ip.agregarPanelPerfil(paciente);
        mc = mca.agregarPanelMedicoCabecera( paciente);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cerrandolo){
            int res = JOptionPane.showConfirmDialog(null,"¿Estas seguro de que quieres cerrar sesion?", "Cerrando Sesion",JOptionPane.YES_NO_OPTION);
            if(res==JOptionPane.YES_OPTION){
                dispose();
            }
        }

        if(e.getSource()==SolicitarConsulta){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new SolicitarConsultaPaciente();
                }
            });
        }if(e.getSource()==menuDatosPersonales){
            add(ac, BorderLayout.CENTER);
            remove( mc );
            revalidate();
            repaint();
        }
        if(e.getSource()==medicoCabecera){
            add(mc, BorderLayout.CENTER);
            remove( ac );
            revalidate();
            repaint();
        }
    }
}
