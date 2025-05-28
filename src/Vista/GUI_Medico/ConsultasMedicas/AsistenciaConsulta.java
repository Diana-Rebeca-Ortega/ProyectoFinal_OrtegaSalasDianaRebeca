package Vista.GUI_Medico.ConsultasMedicas;

import Modelo.Consulta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsistenciaConsulta extends JFrame implements ActionListener {
    JButton btnGenerarReceta;
    JRadioButton radioSi = new JRadioButton("Si");
    JRadioButton radioNo = new JRadioButton("No");
    JComboBox comboNoAtendido = new JComboBox();
    String idPaciente, idMedico;
    public  AsistenciaConsulta(Consulta consulta){
        setTitle("Atender Paciente");
        setSize(900,700);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        idPaciente = consulta.getID_Paciente();
        idMedico = consulta.getID_Medico();

        JLabel txtTitulo = new JLabel(">>>NNS Paciente<<<");
        txtTitulo.setBounds(20,10,300,40);
        add( txtTitulo);

        JLabel paciente = new JLabel(consulta.getID_Paciente()+"" );
        paciente.setBounds(20,30,300,40);
        add( paciente);

        JLabel txtCitas = new JLabel("Motivo");
        txtCitas.setBounds(20,50,300,40);
        add( txtCitas);

        JLabel txtMotivo = new JLabel(consulta.getMorivo());
        txtMotivo.setBounds(20,70,300,40);
        add( txtMotivo);

        JLabel txtsiOnoAtendido = new JLabel("¿El paciente fue atendido?");
        txtsiOnoAtendido.setBounds(20,200,300,40);
        add( txtsiOnoAtendido);

        ButtonGroup bg = new ButtonGroup();


        bg.add(radioNo);
        bg.add(radioSi);

        radioSi.setBounds(30,240,50,20);
        radioNo.setBounds(100,240,50,20);

                JLabel txtnoAtendido = new JLabel("¿Porque no se atendio?");
                txtnoAtendido.setBounds(20,280,300,20);
                add( txtnoAtendido);


        comboNoAtendido.setEnabled(false);
                comboNoAtendido.addItem("Elija una opción...");
                comboNoAtendido.addItem("No asistio a la consulta");
                comboNoAtendido.addItem("Cancelacion");
                comboNoAtendido.addItem("Otras razones");
                comboNoAtendido.setBounds(20,310,300,20);
                add(comboNoAtendido);

        add(radioNo);
        radioNo.addActionListener(this);
        radioSi.addActionListener(this);
        add(radioSi);

        btnGenerarReceta = new JButton("Generar RECETA medica");
        btnGenerarReceta.setBounds(20,500,300,20);
        btnGenerarReceta.setEnabled(false);
        btnGenerarReceta.setBackground(new Color(255, 221, 0));
        add( btnGenerarReceta);
        btnGenerarReceta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== radioSi){
            btnGenerarReceta.setEnabled(true);
            comboNoAtendido.setEnabled(false);
        }if (e.getSource()== radioNo){
            comboNoAtendido.setEnabled(true);
            btnGenerarReceta.setEnabled(false);
        }
        if(e.getSource()== btnGenerarReceta){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new GenerarReceta(idMedico, idPaciente);
                }
            });
        }
    }
}
