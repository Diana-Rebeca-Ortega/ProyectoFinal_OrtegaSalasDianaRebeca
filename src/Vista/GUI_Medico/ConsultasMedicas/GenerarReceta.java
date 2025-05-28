package Vista.GUI_Medico.ConsultasMedicas;

import Controlador.MedicamentosDAO;
import Controlador.RecetaDAO;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class GenerarReceta  extends JFrame  implements ActionListener {
    JTable tablaMedicamentos;
    JComboBox buscador;
    List<String> listaMedicinas ;
    JButton btnAgregar;
    JLabel txtIDRecetaRes;
    JLabel txtIDMedicoRes;
    JLabel txtIDPacienteRes;
    public GenerarReceta( String idMedico, String idPaciente) {
        setTitle("GENERAR RECETA");
        setSize(900, 700);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(255,255,255));

        JLabel txtTitulo = new JLabel(new ImageIcon( "C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\Vista\\Iconos\\GenerarReceta.png"));
        txtTitulo.setBounds( getWidth()/2-200, 20, 400,80);
        add( txtTitulo);

        JLabel txtIDReceta = new JLabel("ID Receta:");
        txtIDReceta.setBounds( 30, 100, 200,20);
        add( txtIDReceta);

        RecetaDAO recetaDAO = new RecetaDAO();
        int n = recetaDAO.tamañoTablas();
        DecimalFormat format = new DecimalFormat("0000");

         txtIDRecetaRes = new JLabel(""+ format.format(n));
        txtIDRecetaRes.setBounds( 30, 120, 200,20);
        txtIDRecetaRes.setForeground( new Color(0, 22, 126));
        add( txtIDRecetaRes);

        JLabel txtIDMedico = new JLabel("NSS Medico:");
        txtIDMedico.setBounds( 30, 140, 200,20);
        add( txtIDMedico);

         txtIDMedicoRes = new JLabel(idMedico);
        txtIDMedicoRes.setBounds( 30, 160, 200,20);
        txtIDMedicoRes.setForeground( new Color(0, 22, 126));
        add( txtIDMedicoRes);

        JLabel txtIDPaciente = new JLabel("NSS Paciente:");
        txtIDPaciente.setBounds( 30, 180, 200,20);
        add( txtIDPaciente);

         txtIDPacienteRes = new JLabel(idPaciente);
        txtIDPacienteRes.setBounds( 30, 200, 200,20);
        txtIDPacienteRes.setForeground( new Color(0, 22, 126));
        add( txtIDPacienteRes);

        Date fechaActual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatter.format(fechaActual);

        JLabel txtFechaGeneracion = new JLabel("Fecha Generacion:");
        txtFechaGeneracion.setBounds( getWidth()-200, 100, 200,20);
        add( txtFechaGeneracion);

        JLabel txtFechaGeneracionRes = new JLabel(String.valueOf(fechaFormateada));
        txtFechaGeneracionRes.setBounds( getWidth()-200, 120, 200,20);
        txtFechaGeneracionRes.setForeground( new Color(0, 22, 126));
        add( txtFechaGeneracionRes);

        JLabel txtMedicamentos = new JLabel("Medicamentos:");
        txtMedicamentos.setBounds( 30, 220, 200,20);
        add( txtMedicamentos);

        tablaMedicamentos = new JTable();
        tablaMedicamentos.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "NombreComercial", "Formula"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        MedicamentosDAO medicamentosDAO = new MedicamentosDAO();
        listaMedicinas = medicamentosDAO.NombresComerciales();

        buscador = new JComboBox();
        buscador.addItem("Elige medicamento");
        for (int i =0; i < medicamentosDAO.tamañoTablas(); i++){
            buscador.addItem( listaMedicinas.get(i));
        }
        buscador.setBounds(30, 250, 300, 20);
        add( buscador);

        JScrollPane scrollPane = new JScrollPane(tablaMedicamentos);
        scrollPane.setBounds(20, 280, 825, 140);
        add(scrollPane);

         btnAgregar = new JButton("AGREGAR");
        btnAgregar.setBounds(370, 250, 130, 20);
        add(btnAgregar);
        btnAgregar.addActionListener(this);

        JLabel txtIndicaciones = new JLabel("Indicaciones:");
        txtIndicaciones.setBounds( 30, 430, 200,20);
        add( txtIndicaciones);

         indocaciones = new JTextArea(3,1);
        indocaciones.setBackground(new Color(251, 207, 253));
        indocaciones.setBounds(20, 450, 400, 60);
        indocaciones.setLineWrap(true);
        indocaciones.setWrapStyleWord(true);
        add(indocaciones);

         recetaTerminado = new JButton("ACEPTAR");
        recetaTerminado.setBounds(650, 470, 130, 20);
        recetaTerminado.setBackground(new Color(219, 120, 241));
        recetaTerminado.addActionListener(this);
        add(recetaTerminado);
    }
    JButton recetaTerminado;
    String medicinas="";
    JTextArea indocaciones;

    @Override
    public void actionPerformed(ActionEvent e) {
    if ( e.getSource()== btnAgregar){
        String nmComercial = String.valueOf(buscador.getSelectedItem());
        buscador.removeItem(nmComercial);
        medicinas= nmComercial+"," +medicinas;
        RecetaDAO recetaDAO = new RecetaDAO();
        recetaDAO.actualizarTabla( tablaMedicamentos,  nmComercial );
    }if (e.getSource()==recetaTerminado){
            RecetaDAO recetaDAO = new RecetaDAO();
        if (recetaDAO.agregarReceta( txtIDRecetaRes.getText(),txtIDMedicoRes.getText(),
                txtIDPacienteRes.getText(), medicinas,indocaciones.getText())){
            JOptionPane.showMessageDialog(null, "La receta se genero correctamente", "PROCESO EXITOSO!!!", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        }


        }
    }
}
