package Vista.GUI_Paciente;

import Vista.GUI_Medico.AsignarConsulta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePaciente  extends JFrame implements ActionListener{

    private JPopupMenu menuDespegable;
    JMenuItem perfil, menuDatosPersonales, medicoCabecera, historialConsultas, SolicitarConsulta;
    public HomePaciente(){
        setTitle("PACIENTE");
        setSize(900,700);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

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
        perfil = new JMenuItem("Paciente: Diana Rebeca");
        menuDatosPersonales = new JMenuItem("Información de Perfil");
        medicoCabecera = new JMenuItem("Médico de cabecera");
        historialConsultas = new JMenuItem("Historial de Consultas");
        SolicitarConsulta = new JMenuItem("Solicitar Consulta");


        menuDespegable.add(perfil);
        menuDespegable.add(menuDatosPersonales);
        menuDespegable.add(medicoCabecera);
        menuDespegable.add(historialConsultas);
        menuDespegable.add(SolicitarConsulta);

        SolicitarConsulta.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==SolicitarConsulta){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new SolicitarConsultaPaciente();
                }
            });
        }
    }
}
