package Vista.GUI_Medico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsistenciaConsulta extends JFrame implements ActionListener {
    JButton btnGenerarReceta;
    public  AsistenciaConsulta(){
        setTitle("Atender Paciente");
        setSize(900,700);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);

        JLabel txtTitulo = new JLabel(">>>Paciente<<<");
        txtTitulo.setBounds(20,20,300,40);
        add( txtTitulo);

        JLabel txtCitas = new JLabel("Motivo");
        txtCitas.setBounds(20,50,300,40);
        add( txtCitas);

        JLabel txtsiOnoAtendido = new JLabel("¿El paciente fue atendido?");
        txtsiOnoAtendido.setBounds(20,200,300,40);
        add( txtsiOnoAtendido);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton radioSi = new JRadioButton("Si");
        JRadioButton radioNo = new JRadioButton("No");

        bg.add(radioNo);
        bg.add(radioSi);

        radioSi.setBounds(30,240,50,20);
        radioNo.setBounds(100,240,50,20);

                JLabel txtnoAtendido = new JLabel("¿Porque no se atendio?");
                txtnoAtendido.setBounds(20,280,300,20);
                add( txtnoAtendido);

                JComboBox comboNoAtendido = new JComboBox();

                comboNoAtendido.addItem("Elija una opción...");
                comboNoAtendido.addItem("No asistio a la consulta");
                comboNoAtendido.addItem("Cancelacion");
                comboNoAtendido.addItem("Otras razones");
                comboNoAtendido.setBounds(20,310,300,20);
                add(comboNoAtendido);

        add(radioNo);
        add(radioSi);

        btnGenerarReceta = new JButton("Generar RECETA medica");
        btnGenerarReceta.setBounds(20,500,300,20);
        add( btnGenerarReceta);
        btnGenerarReceta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnGenerarReceta){

        }
    }
}
