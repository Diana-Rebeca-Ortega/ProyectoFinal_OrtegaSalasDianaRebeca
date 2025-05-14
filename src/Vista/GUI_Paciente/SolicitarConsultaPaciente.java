package Vista.GUI_Paciente;

import javax.swing.*;
import java.awt.*;

public class SolicitarConsultaPaciente extends JFrame {

    public SolicitarConsultaPaciente() {
        setTitle("Solicitud de Consulta");
        setSize(700, 490);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
        setBackground(new Color(244, 254, 237));

        JLabel txtSolicitar = new JLabel("SOLICITAR CONSULTA");
        txtSolicitar.setBounds(30,30,300,40);
        add(txtSolicitar);
    }
}