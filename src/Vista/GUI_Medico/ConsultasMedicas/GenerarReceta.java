package Vista.GUI_Medico.ConsultasMedicas;

import Modelo.Consulta;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GenerarReceta  extends JFrame  implements ActionListener {
    JTable tablaMedicamentos;
    JComboBox buscador;
    public GenerarReceta() {
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

        JLabel txtIDMedico = new JLabel("NSS Medico:");
        txtIDMedico.setBounds( 30, 140, 200,20);
        add( txtIDMedico);

        JLabel txtIDPaciente = new JLabel("MSS Paciente:");
        txtIDPaciente.setBounds( 30, 180, 200,20);
        add( txtIDPaciente);

        JLabel txtFechaGeneracion = new JLabel("Fecha Generacion:");
        txtFechaGeneracion.setBounds( getWidth()-200, 100, 200,20);
        add( txtFechaGeneracion);

        JLabel txtMedicamentos = new JLabel("Medicamentos:");
        txtMedicamentos.setBounds( 30, 220, 200,20);
        add( txtMedicamentos);

        tablaMedicamentos = new JTable();
        tablaMedicamentos.setModel(new DefaultTableModel(
                new Object[][]{
                        { null, null},
                        { null, null},
                        { null, null},
                        { null, null},
                        { null, null}
                },
                new String[]{
                        "Nombre", "Formula"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        buscador = new JComboBox();
        buscador.addItem("Elige medicamento");
        buscador.setBounds(30, 250, 300, 20);
        add( buscador);

        JScrollPane scrollPane = new JScrollPane(tablaMedicamentos);
        scrollPane.setBounds(20, 280, 825, 180);
        add(scrollPane);

        JButton btnAgregar = new JButton("AGREGAR");
        btnAgregar.setBounds(370, 250, 130, 20);
        add(btnAgregar);

        JButton recetaTerminado = new JButton("ACEPTAR");
        recetaTerminado.setBounds(650, 470, 130, 20);
        recetaTerminado.setBackground(new Color(219, 120, 241));
        add(recetaTerminado);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
