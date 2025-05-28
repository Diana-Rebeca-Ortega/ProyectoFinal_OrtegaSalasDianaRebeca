package Vista.GUI_Medico;

import javax.swing.*;
import java.awt.*;

public class SolicitudesDeConsultaMedico extends JFrame {
    JTable tablaSolicitudes;
    public SolicitudesDeConsultaMedico(){
        setTitle("Solicitudes recibidas");
        setSize(900,700);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(139, 174, 225));



        tablaSolicitudes = new JTable();
        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(

                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String[]{
                        "NO. DE CONTROL", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "EDAD", "SEMESTRE", "CARRERA"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        JScrollPane sp = new JScrollPane(tablaSolicitudes);
        sp.setBounds(10,10,500,200);
        add(sp);

        JLabel txtSolicitudDeConsulta = new JLabel(">>>Solicitud de consulta<<<");
        txtSolicitudDeConsulta.setBounds(20,230,300,20);
        add(txtSolicitudDeConsulta);

        JLabel txtSSN = new JLabel("SSN:");
        txtSSN.setBounds(20,280,40,20);
        add(txtSSN);

        JLabel txtPaciente = new JLabel("PACIENTE");
        txtPaciente.setBounds(20,310,100,20);
        add(txtPaciente);

        JLabel txtNombre = new JLabel("Nombre:");
        txtNombre.setBounds(20,330,100,20);
        add(txtNombre);

        JLabel txtApellidoUno = new JLabel("1º Apellido:");
        txtApellidoUno.setBounds(20,350,110,20);
        add(txtApellidoUno);

        JLabel txtApellidoDos = new JLabel("2º Apellido:");
        txtApellidoDos.setBounds(20,370,110,20);
        add(txtApellidoDos);

        JLabel txtMotivo = new JLabel("Motivo:");
        txtMotivo.setBounds(20,390,110,20);
        add(txtMotivo);

        JLabel txtFecha = new JLabel("Fecha Solicitada:");
        txtFecha.setBounds(20,410,150,20);
        add(txtFecha);

        JLabel txtHora = new JLabel("Hora Solicitada:");
        txtHora.setBounds(20,430,150,20);
        add(txtHora);

        JButton btnAGENDAR = new JButton("AGENDAR");
        btnAGENDAR.setBounds( 40,500,100,20);
        add(btnAGENDAR);

        JButton btnSinDisponibilidad = new JButton("Sin Disponibilidad");
        btnSinDisponibilidad.setBounds( 200,500,170,20);
        add(btnSinDisponibilidad);



    }

}
