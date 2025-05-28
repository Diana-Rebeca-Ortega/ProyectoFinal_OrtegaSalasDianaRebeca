package Vista.GUI_Medico.ConsultasMedicas;

import Controlador.ConsultaDAO;
import Modelo.Consulta;
import Modelo.Medico;
import Modelo.Paciente;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Year;

public class AsignarConsulta_Altas extends JFrame  implements ActionListener {
    JButton btnAceptar, btnCancelar, btnRestablecer;
    JLabel txtPacienteSSNRes;
    JLabel txtNNSMedicoRes, txtPacienteSSN  ;
    JTextArea motivo;
    JComboBox year, Mes, Dia, Hora, Min ;
    public AsignarConsulta_Altas(Medico m, Paciente p ){
        setTitle("Asignar Consulta");
        setSize(700,490);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
        setBackground( new Color(244, 254, 237));

        BufferedImage image;
        try {image = ImageIO.read(new File("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\LogoRX.png"));
        } catch (IOException e) {throw new RuntimeException(e);}

        JLabel logo = new JLabel(new ImageIcon(image.getScaledInstance(30,30,Image.SCALE_SMOOTH)));
        logo.setBounds((getWidth()/2)-30,5,30,30);
        add(logo);

        JLabel txtFMX = new JLabel("Farmacias RX");
        txtFMX.setBounds((getWidth()/2)-50,33,80,20);
        add(txtFMX);

        JLabel txtNNSMedico = new JLabel("NSS Medico:");
        txtNNSMedico.setBounds(10,50,200,20);
        add(txtNNSMedico);

         txtNNSMedicoRes  = new JLabel(m.getNumSSN());
        txtNNSMedicoRes.setBounds(125,50,200,20);
        txtNNSMedicoRes.setForeground(new Color( 0, 57, 110));
        add(txtNNSMedicoRes);

        JLabel txtMedico = new JLabel("Medico que atiende:");
        txtMedico.setBounds(10,70,200,20);
        add(txtMedico);

        JLabel txtMedicoRes  = new JLabel("M."+m.getNombre()+" "+m.getPrimerApellido()+" "+m.getSegundoApellido());
        txtMedicoRes.setBounds(150,70,200,20);
        txtMedicoRes.setForeground(new Color( 0, 57, 110));
        add(txtMedicoRes);

        JLabel txtEspe = new JLabel("Especialidad:");
        txtEspe.setBounds(10,90,200,20);
        add(txtEspe);

        JLabel txtEspeRes = new JLabel(m.getEspecialidad());
        txtEspeRes.setBounds(100,90,200,20);
        txtEspeRes.setForeground(new Color( 0, 57, 110));
        add(txtEspeRes);

        JLabel txtPaciente = new JLabel("Paciente:");
        txtPaciente.setBounds(10,110,200,20);
        add(txtPaciente);

        JLabel txtPacienteRes = new JLabel(p.getNombre());
        txtPacienteRes.setBounds(90,110,200,20);
        txtPacienteRes.setForeground(new Color( 0, 57, 110));
        add(txtPacienteRes);

         txtPacienteSSN = new JLabel("SSN Paciente:");
        txtPacienteSSN.setBounds(10,130,200,20);
        add(txtPacienteSSN);

         txtPacienteSSNRes = new JLabel(p.getNumSSN());
        txtPacienteSSNRes.setBounds(110,130,200,20);
        txtPacienteSSNRes.setForeground(new Color( 0, 57, 110));
        add(txtPacienteSSNRes);

        JLabel txtPacienteNombre = new JLabel("Nombre:");
        txtPacienteNombre.setBounds(10,150,200,20);
        add(txtPacienteNombre);

        JLabel txtPacienteNombreRes = new JLabel(p.getNombre());
        txtPacienteNombreRes.setBounds(90,150,200,20);
        txtPacienteNombreRes.setForeground(new Color( 0, 57, 110));
        add(txtPacienteNombreRes);

        JLabel txtPacienteAP1 = new JLabel("A.Paterno:");
        txtPacienteAP1.setBounds(10,170,200,20);
        add(txtPacienteAP1);

        JLabel txtPacienteAP1Res = new JLabel(p.getPrimerApellido());
        txtPacienteAP1Res.setBounds(100,170,200,20);
        txtPacienteAP1Res.setForeground(new Color( 0, 57, 110));
        add(txtPacienteAP1Res);

        JLabel txtPacienteAP2 = new JLabel("A.Materno:");
        txtPacienteAP2.setBounds(10,190,200,20);
        add(txtPacienteAP2);

        JLabel txtPacienteAP2Res = new JLabel(p.getSegundoApellido());
        txtPacienteAP2Res.setBounds(100,190,200,20);
        txtPacienteAP2Res.setForeground(new Color( 0, 57, 110));
        add(txtPacienteAP2Res);

        JLabel txtMotivoConsulta = new JLabel("Motivo Consulta:");
        txtMotivoConsulta.setBounds(10,210,200,20);
        add(txtMotivoConsulta);

         motivo = new JTextArea(10,20);
        motivo.setBounds(10,230,400,50);
        motivo.setLineWrap(true);
        motivo.setWrapStyleWord(true);
        add(motivo);

        JLabel txtFecha = new JLabel("Fecha para la cita");
        txtFecha.setBounds(10,300,200,20);
        add(txtFecha);

        year = new JComboBox( );
        year.addItem( "YYYY");
        for (int i = 2025; i<= 2030;i++){
            year.addItem( i+"");
        }
        year.setBounds(200,300,60,20);
        add(year);

        JLabel dp = new JLabel(" - ");
        dp.setBounds(260,300,20,20);
        add(dp);

        Mes = new JComboBox();
        Mes.addItem("MM");
        for (int i = 1; i<= 12;i++){
            Mes.addItem( i+"");
        }
        Mes.setBounds(280,300,50,20);
        add(Mes);

        JLabel dp2 = new JLabel(" - ");
        dp2.setBounds(330,300,20,20);
        add(dp2);

        Dia = new JComboBox();
        Mes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Mes){
                Dia.removeAllItems();
                if(Mes.getSelectedItem().equals("1") ||
                        Mes.getSelectedItem().equals("3") ||
                        Mes.getSelectedItem().equals("5") ||
                        Mes.getSelectedItem().equals("7") ||
                        Mes.getSelectedItem().equals("8") ||
                        Mes.getSelectedItem().equals("10") ||
                        Mes.getSelectedItem().equals("12")
                ){

                    for (int i = 1; i<= 31;i++){
                        Dia.addItem( i+"");
                    }
                }if(Mes.getSelectedItem().equals("4" )||
                        Mes.getSelectedItem().equals("6") ||
                        Mes.getSelectedItem().equals("9") ||
                        Mes.getSelectedItem().equals("11")
                ){
                    for (int i = 1; i<= 30;i++){
                        Dia.addItem( i+"");
                    }
                }if(Mes.getSelectedItem().equals("2")){
                    for (int i = 1; i<= 28;i++){
                        Dia.addItem( i+"");
                    }
                }
            }
            }
        });
        Dia.setBounds(350,300,50,20);
        add(Dia);

        JLabel txtHora = new JLabel("Hora de la cita");
        txtHora.setBounds(10,330,200,20);
        add(txtHora);


        Hora = new JComboBox();
        Hora.addItem( "HH");
        for (int i = 0; i<= 23;i++){
            String formato = String.format("%02d", i);
            Hora.addItem( formato);
        }
        Hora.setBounds(190,330,50,20);
        add(Hora);

        JLabel ddp = new JLabel(" :");
        ddp.setBounds(240,330,20,20);
        add(ddp);

        Min = new JComboBox();
        Min.addItem( "MM");
        for (int i = 0; i<= 60;i++){
            String formato = String.format("%02d", i);
            Min.addItem( formato);
        }
        Min.setBounds(260,330,50,20);
        add(Min);

         btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBounds(10,380,100,20);
        add(btnAceptar);

        btnAceptar.addActionListener(this);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(230,380,100,20);
        add(btnCancelar);


        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setBounds(370,380,150,20);
        add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnCancelar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnAceptar){
            if ( year.getSelectedItem().equals("YYYY")||
                    Mes.getSelectedItem().equals("MM")
            ){
                JOptionPane.showMessageDialog(null,  "La fecha esta incompleta");
            }else {
                if ( Hora.getSelectedItem().equals("HH")||
                        Mes.getSelectedItem().equals("MM")
                ){
                    JOptionPane.showMessageDialog(null,  "La Hora esta incompleta");
                }else {
            String fecha = ""+year.getSelectedItem()+"-"+Mes.getSelectedItem()+"-"+ Dia.getSelectedItem()+" "+ Hora.getSelectedItem()+":"+ Min.getSelectedItem()+":00";
            ConsultaDAO consultaDAO = new ConsultaDAO();
            String IDConsulta = String.format("%04d",  consultaDAO.tamañoTablas());
            Consulta c = new Consulta (IDConsulta, txtPacienteSSNRes.getText()
                    ,txtNNSMedicoRes.getText(),  motivo.getText(), fecha);
            if (consultaDAO.agregarConsulta(c)) {
                System.out.println("FELICIDADES: se agrego un nuevo Consulta a la BDD (desde la ventanaInicio)");
                 JOptionPane.showMessageDialog(null,"La consulta se ha registrado con Exito ", "Registro Realizado con EXITO!!!",JOptionPane.INFORMATION_MESSAGE);
                 dispose();
            }else {
                System.out.println("ERROR: no se pudo agregar un nuevo Consulta a la BDD (desde la ventanaInicio)");
            }
        }
            }
        }
        if(e.getSource()== btnCancelar){
            dispose();
        }if(e.getSource()== btnRestablecer){
            motivo.setText("");
            year.setSelectedIndex(1);
            Mes.setSelectedIndex(1);
            Hora.setSelectedIndex(1);
            Min.setSelectedIndex(1);

        }
    }
}
