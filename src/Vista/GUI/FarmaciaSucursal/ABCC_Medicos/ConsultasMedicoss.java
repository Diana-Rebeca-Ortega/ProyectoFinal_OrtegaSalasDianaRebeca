package Vista.GUI.FarmaciaSucursal.ABCC_Medicos;

import Controlador.MedicoDAO;
import Modelo.Medico;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;

public class ConsultasMedicoss extends JFrame implements ActionListener{
    MedicoDAO medicoDAO = new MedicoDAO();
    JPanel panelAzul, panelCian;
    JTable tablaMedicosModificaiones;
    JLabel texCriterioBusqueda;
    JButton btnBuscar, btnBorrar,btnCancelar;
    JRadioButton  radioNombre,radioNSS, radioAPpaterno, radioAPMaterno, radioEspe, radioAñosExpe;
    JTextField cajaNSS, cajaNombre, cajaApPaterno, cajaApMaterno;
    ButtonGroup bg= new ButtonGroup();
    JRadioButton radioTodos;
    ButtonGroup bgDos= new ButtonGroup();
    JButton btnPrimero;
    JButton btnUltimo;
    JButton btnAnterior;
    JButton btnDespues;
    JTextField buscador ;
    JComboBox<String> comboEspecialidad, comboEdad;

    int pagina=1;

    public ConsultasMedicoss(){

        getContentPane().setLayout(null);
        setTitle("Consultas Medicos");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);
        tablaMedicosModificaiones = new JTable();
        tablaMedicosModificaiones.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null}

                },
                new String[]{
                        "NSS", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "ESPECIALIDAD", "AÑOS DE EXPERIENCIA"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true, true, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        //Actualizar el primer registro
        Medico ob1 = medicoDAO.mostrarMedico ("", "Uno");
        actualizarTablaConsultas(tablaMedicosModificaiones, ob1);
        //PANEL VERDE MENTA
        panelCian = new JPanel();
        panelCian.setLayout(null);
        panelCian.setBackground(new Color(26, 221, 234  ));
        panelCian.setBounds(10, 320, 870, 170);

        //JButton btnPrimero, btnUltimo, btnAnterior,btnDespues;
        btnPrimero = new JButton("<<");
        btnUltimo = new JButton(">>");
        btnAnterior = new JButton("<");
        btnDespues = new JButton(">");
        buscador= new JTextField("1");
        buscador.setHorizontalAlignment(JTextField.CENTER);
        btnAnterior.setEnabled(false);

        btnPrimero.setBounds(280,10, 50,20);
        btnUltimo.setBounds(480,10, 50,20);
        btnAnterior.setBounds(330,10, 50,20);
        btnDespues.setBounds(430,10, 50,20);
        buscador.setBounds(380,10,50,20);

        btnPrimero.setToolTipText("Este boton se direcciona al primer registro");
        btnUltimo.setToolTipText("Este boton se direcciona al ultimo registro");
        btnAnterior.setToolTipText("Este boton se direcciona al registro anterior");
        btnDespues.setToolTipText("Este boton se direcciona al registro siguiente");
        buscador.setToolTipText("Este boton se direcciona al numero de registro seleccionado");

        panelCian.add(btnPrimero);
        panelCian.add(btnUltimo);
        panelCian.add(btnAnterior);
        panelCian.add(btnDespues);
        panelCian.add(buscador);
        btnPrimero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnPrimero){
                    btnAnterior.setEnabled(false);
                    btnDespues.setEnabled(true);
                    pagina=1;
                    buscador.setText(pagina+"");
                    Medico al = medicoDAO.mostrarMedico("","Uno");
                    actualizarTablaConsultas(tablaMedicosModificaiones, al);


                }
            }
        });
        btnUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnUltimo){
                    btnAnterior.setEnabled(true);
                    btnDespues.setEnabled(false);
                    pagina=medicoDAO.tamañoTablas();
                    buscador.setText(pagina+"");
                    Medico al = medicoDAO.mostrarMedico(medicoDAO.tamañoTablas()-1+"","Ultimo");
                    actualizarTablaConsultas(tablaMedicosModificaiones, al);

                }
            }
        });
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnAnterior){
                    btnDespues.setEnabled(true);
                    pagina= pagina-1;
                    if(pagina==1)
                        btnAnterior.setEnabled(false);
                    buscador.setText(pagina+"");
                    Medico al = medicoDAO.mostrarMedico((pagina-1)+"","Ultimo");
                    actualizarTablaConsultas(tablaMedicosModificaiones, al);

                }
            }
        });
        buscador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {

                    if(e.getKeyCode()==KeyEvent.VK_ENTER){
                        pagina= Integer.parseInt(buscador.getText());
                        if (pagina> medicoDAO.tamañoTablas()  || pagina< 1  ){
                            JOptionPane.showMessageDialog(null,"El numero de registro seleccionado no existe");
                        }else {
                            if (pagina==1){
                                btnAnterior.setEnabled(false);
                                btnDespues.setEnabled(true);
                            }else if(pagina==medicoDAO.tamañoTablas()){
                                btnAnterior.setEnabled(true);
                                btnDespues.setEnabled(false);
                            }else{
                                btnAnterior.setEnabled(true);
                                btnDespues.setEnabled(true);
                            }
                            Medico al = medicoDAO.mostrarMedico((pagina-1)+"","Ultimo");
                            actualizarTablaConsultas(tablaMedicosModificaiones, al);

                        }}
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null,"ERROR: El buscador de registros solo admite numeros");
                }
            }// castch

        });
        btnDespues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnDespues){
                    btnAnterior.setEnabled(true);
                    pagina= pagina+1;
                    if(pagina==medicoDAO.tamañoTablas())
                        btnDespues.setEnabled(false);
                    buscador.setText(pagina+"");
                    Medico al = medicoDAO.mostrarMedico((pagina-1)+"","Ultimo");
                    actualizarTablaConsultas(tablaMedicosModificaiones, al);
                }
            }
        });

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaMedicosModificaiones);
        scrollPane.setBounds(10, 30, 840, 150);
        panelCian.add(scrollPane);
        add(panelCian);


//Panel AZUL TITULO
        panelAzul = new JPanel();
        panelAzul.setLayout(null);
        panelAzul.setBackground(new Color(26, 32, 234  ));
        panelAzul.setBounds(0, 0, getWidth(), 30);
        JLabel texBAJAS = new JLabel("    CONSULTAS MEDICOS:");
        texBAJAS.setBounds(10, 0, 300, 20);
        texBAJAS.setForeground(Color.WHITE);
        panelAzul.add(texBAJAS);
        add(panelAzul);

        texCriterioBusqueda = new JLabel("Selecciona criterio de busqueda:");
        texCriterioBusqueda.setBounds(40, 40, 230, 20);
        texCriterioBusqueda.setFont(new Font("Arial", Font.BOLD, 13));
        add(texCriterioBusqueda);

        //Botones
        btnBuscar = new JButton();
        btnBorrar = new JButton("BORRAR");
        btnCancelar = new JButton("CANCELAR");
        ImageIcon  buscarRuta=  new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Proyecto_ABCD2025\\src\\vista\\ic_action_search.png");
        btnBuscar.setIcon(buscarRuta  );
        btnBuscar.setHorizontalTextPosition( SwingConstants.CENTER );
        btnBuscar.setVerticalTextPosition( SwingConstants.BOTTOM );
        btnBuscar.setBounds(getWidth()-120, 40, buscarRuta.getIconWidth(), buscarRuta.getIconHeight());
        btnBorrar.setBounds(getWidth()-120, 130, 100, 20);
        btnCancelar.setBounds(getWidth()-120, 190, 100, 20);
        add(btnBuscar);
        add(btnBorrar);
        add(btnCancelar);

        btnBuscar.addActionListener(this);
        btnBorrar.addActionListener(this);
        btnCancelar.addActionListener(this);


        ButtonGroup bg = new ButtonGroup();
        //radioTodos.setSelected(true);//preseleccionado
        radioNSS = new JRadioButton("NSS:");
        radioNombre = new JRadioButton("Nombre:");
        radioAPpaterno = new JRadioButton("Apellido Paterno:");
        radioAPMaterno = new JRadioButton("Apellido Materno:");
        radioEspe = new JRadioButton("Especialidad:");
        radioAñosExpe = new JRadioButton("Años Especialidad:");

        radioTodos = new JRadioButton("TODOS");
        radioTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioTodos.isSelected()){
                    actualizarTablaTodos(tablaMedicosModificaiones);
                }
            }
        });


        radioTodos.setBounds(20, 60, 80,20);
        radioNSS.setBounds(100, 60, 80,20);
        radioNombre.setBounds(100, 90, 130,20);
        radioAPpaterno.setBounds(100, 120, 130,20);
        radioAPMaterno.setBounds(100, 150, 130,20);
        radioEspe.setBounds(100, 180, 90,20);
        radioAñosExpe.setBounds(100, 210, 90,20);

        radioNSS.addActionListener(this);
        radioNombre.addActionListener(this);
        radioAPpaterno.addActionListener(this);
        radioAPMaterno.addActionListener(this);
        radioEspe.addActionListener(this);
        radioAñosExpe.addActionListener(this);

        bg.add(radioEspe );
        bg.add(radioAñosExpe );
        bg.add(radioAPMaterno );
        bg.add(radioAPpaterno );
        bg.add(radioNombre );
        bg.add(radioNSS );
        bg.add(radioTodos );

        add(radioEspe );
        add(radioAñosExpe );
        add(radioAPMaterno );
        add(radioAPpaterno );
        add(radioNombre );
        add(radioNSS );
        add(radioTodos );


        //Poner los datos del primer registro al abrir la ventana consultas
        Medico al = medicoDAO.mostrarMedico("","Uno");
        cajaNSS = new JTextField(al.getNumSSN());
        cajaNombre = new JTextField(al.getNombre());
        cajaApPaterno = new JTextField(al.getPrimerApellido());
        cajaApMaterno = new JTextField(al.getSegundoApellido()  );
        comboEspecialidad = new JComboBox();
        comboEspecialidad.addItem("Elige Especialidad...");
        comboEspecialidad.addItem("cardiología");
        comboEspecialidad.addItem("ginecología");
        comboEspecialidad.addItem("ortopedia");
        comboEspecialidad.addItem("neurología");
        comboEspecialidad.addItem("gastroenterología ");
        comboEspecialidad.setSelectedItem(al.getEspecialidad());
        comboEdad = new JComboBox();
        comboEdad.addItem("Elige Años de Experiencia...");
        for (int i =0; i<70; i++){
            comboEdad.addItem((i+1)+"");
        }
        comboEdad.setSelectedIndex(  al.getAñosExperiencia());
        ///////////////////////////////////////////////////////////////////

        cajaNSS.setEnabled(false);
        cajaNombre.setEnabled(false);
        cajaApPaterno.setEnabled(false);
        cajaApMaterno.setEnabled(false);
        comboEspecialidad.setEnabled(false);
        comboEdad.setEnabled(false);

        ((PlainDocument) cajaNSS.getDocument()).setDocumentFilter(new FiltroSoloNumeros11Digitos());

        cajaNSS.setBounds(250, 60, 250, 20);
        cajaNombre.setBounds(250, 90, 220, 20);
        cajaApPaterno.setBounds(250, 120, 220, 20);
        cajaApMaterno.setBounds(250, 150, 240, 20);
        comboEspecialidad.setBounds(250, 180, 260, 20);
        comboEdad.setBounds(250, 210, 250, 20);

        add(cajaNSS);
        add(cajaNombre);
        add(cajaApPaterno);
        add(comboEspecialidad);
        add(cajaApMaterno);
        add(comboEdad);

    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {



//inabilitar les demas espacios de los radiobuttons   ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡
        if(e.getSource()==radioNSS){
            cajaNSS.setEnabled(true);
            cajaNombre.setEnabled(false);
            cajaApPaterno.setEnabled(false);
            cajaApMaterno.setEnabled(false);
            comboEspecialidad.setEnabled(false);
            comboEdad. setEnabled(false);
        }
        if(e.getSource()==radioNombre){
            cajaNSS.setEnabled(false);
            cajaNombre.setEnabled(true);
            cajaApPaterno.setEnabled(false);
            cajaApMaterno.setEnabled(false);
            comboEspecialidad.setEnabled(false);
            comboEdad. setEnabled(false);
        }
        if(e.getSource()==radioAPpaterno){
            cajaNSS.setEnabled(false);
            cajaNombre.setEnabled(false);
            cajaApPaterno.setEnabled(true);
            cajaApMaterno.setEnabled(false);
            comboEspecialidad.setEnabled(false);
            comboEdad. setEnabled(false);
        }

        if(e.getSource()==radioAPMaterno){
            cajaNSS.setEnabled(false);
            cajaNombre.setEnabled(false);
            cajaApPaterno.setEnabled(false);
            cajaApMaterno.setEnabled(true);
            comboEspecialidad.setEnabled(false);
            comboEdad. setEnabled(false);
        }
        if(e.getSource()== radioAñosExpe){
            cajaNSS.setEnabled(false);
            cajaNombre.setEnabled(false);
            cajaApPaterno.setEnabled(false);
            cajaApMaterno.setEnabled(false);
            comboEspecialidad.setEnabled(false);
            comboEdad. setEnabled(true);
        }
        if(e.getSource()== radioEspe){
            cajaNSS.setEnabled(false);
            cajaNombre.setEnabled(false);
            cajaApPaterno.setEnabled(false);
            cajaApMaterno.setEnabled(false);
            comboEspecialidad.setEnabled(true);
            comboEdad. setEnabled(false);
        }


        if(e.getSource()==btnBuscar){

            Thread hiloConsulta = new Thread(new Runnable() {
                @Override
                public void run() {

            if (radioNSS.isSelected()) {
                    if (medicoDAO.mostrarMedico(cajaNSS.getText(), "ID") == null) {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros");
                    } else {
                        Medico ob1 = medicoDAO.mostrarMedico(cajaNSS.getText(), "ID");
                        actualizarTablaConsultas(tablaMedicosModificaiones, ob1);
                    }//else
                }//********************************************************Nombre
                if (radioNombre.isSelected()) {
                    if (medicoDAO.mostrarMedico(cajaNombre.getText(), "Nombre") == null) {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros");
                    } else {
                        Medico ob1 = medicoDAO.mostrarMedico(cajaNombre.getText(), "Nombre");
                        actualizarTablaConsultas(tablaMedicosModificaiones, ob1);
                    }
                }//********************************************************
                if (radioAPpaterno.isSelected()) {
                    if (medicoDAO.mostrarMedico(cajaApPaterno.getText(), "PApellido") == null) {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros");
                    } else {
                        Medico ob1 = medicoDAO.mostrarMedico(cajaApPaterno.getText(), "PApellido");
                        actualizarTablaConsultas(tablaMedicosModificaiones, ob1);
                    }
                }//********************************************************

                if (radioAPMaterno.isSelected()) {
                    if (medicoDAO.mostrarMedico(cajaApMaterno.getText(), "SApellido") == null) {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros");
                    } else {
                        Medico ob1 = medicoDAO.mostrarMedico(cajaApMaterno.getText(), "SApellido");
                        actualizarTablaConsultas(tablaMedicosModificaiones, ob1);
                    }
                }//********************************************************
                if (radioEspe.isSelected()) {
                    if (medicoDAO.mostrarMedico(comboEspecialidad.getSelectedItem() + "", "espe") == null) {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros");
                    } else {
                        Medico ob1 = medicoDAO.mostrarMedico(comboEspecialidad.getSelectedItem() + "", "espe");
                        actualizarTablaConsultas(tablaMedicosModificaiones, ob1);
                    }
                }//********************************************************
                if (radioAñosExpe.isSelected()) {
                    if (medicoDAO.mostrarMedico(comboEdad.getSelectedItem() + "", "ae") == null) {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros");
                    } else {
                        Medico ob1 = medicoDAO.mostrarMedico(comboEdad.getSelectedItem() + "", "ae");
                        actualizarTablaConsultas(tablaMedicosModificaiones, ob1);
                    }

            }
                }
            });
            hiloConsulta.start();
            }//********************************************************************


        if(e.getSource().equals(btnBorrar)){
            cajaNSS.setText("");
            cajaNombre.setText("");
            cajaApPaterno.setText("");
            cajaApMaterno.setText("");
            comboEspecialidad.setSelectedIndex(0);
            comboEdad.setSelectedIndex(0);

            Medico ob1 = medicoDAO.mostrarMedico("", "Uno");
           pagina=1;
           buscador.setEnabled(false);
           btnDespues.setEnabled(true);

            System.out.println("La tabla tiene filas"+ tablaMedicosModificaiones.getRowCount() );
            if ( tablaMedicosModificaiones.getRowCount()>1){
                System.out.println("Radio todos ");
                for (int y =0; y < 6; y++){
                for (int i=0; i< tablaMedicosModificaiones.getRowCount(); i++ ){
                    System.out.println( "borrar la tupla "+i+" , "+y);
                    tablaMedicosModificaiones.setValueAt("", i,y);
                } }
            }else {
                System.out.println("Radio butons ");
            tablaMedicosModificaiones.setValueAt("", 0,0);
            tablaMedicosModificaiones.setValueAt("", 0,1);
            tablaMedicosModificaiones.setValueAt("", 0,3);
            tablaMedicosModificaiones.setValueAt("", 0,2);
            tablaMedicosModificaiones.setValueAt("", 0,4);
            tablaMedicosModificaiones.setValueAt("", 0,5);
        }
        }
        if( e.getSource().equals(btnCancelar)){
            setVisible(false);
        }
    }
    public void actualizarTablaTodos(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        List<Medico> medicos = medicoDAO.obtenerTodosLosMedicos();
        for (Medico medico : medicos) {
            Object[] fila = {medico.getNumSSN(), medico.getNombre(), medico.getPrimerApellido(), medico.getSegundoApellido(), medico.getEspecialidad(), medico.getAñosExperiencia()};
            modelo.addRow(fila);
        }
    }

        public void actualizarTablaConsultas (JTable t, Medico ob1){
        t.setValueAt(ob1.getNumSSN(), 0,0);
        t.setValueAt(ob1.getNombre(), 0,1);
        t.setValueAt(ob1.getSegundoApellido(), 0,3);
        t.setValueAt(ob1.getPrimerApellido(), 0,2);
        t.setValueAt(ob1.getEspecialidad(), 0,4);
        t.setValueAt(ob1.getAñosExperiencia(), 0,5);
    }

}

class FiltroSoloNumeros11Digitos extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string.matches("[0-9]*") && (fb.getDocument().getLength() + string.length() <= 11)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text.matches("[0-9]*") && (fb.getDocument().getLength() - length + text.length() <= 11)) {
            super.replace(fb, offset, length, text, attrs);
 }
}
}
