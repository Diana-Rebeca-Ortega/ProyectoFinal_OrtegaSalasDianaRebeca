package Vista.GUI_Medico.ABCC_Pacientes;

import Controlador.PacienteDAO;
import Modelo.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultasPacientes extends JFrame implements ActionListener {
    PacienteDAO pacienteDAO = new PacienteDAO();
    JPanel panelAzul, panelCian;
    JTable tablaPacientesModificaiones;
    JLabel texCriterioBusqueda;
    JButton btnBuscar, btnBorrar,btnCancelar;
    JRadioButton radioTodos, radioNSS, radioNombre, radioAPpaterno, radioAPMaterno, radioEdad, radioCallee, radioColonia;
    JTextField cajaNSS, cajaNombre, cajaApPaterno, cajaApMaterno, cajaCalle, cajaColonia;


    JButton btnPrimero;
    JButton btnUltimo;
    JButton btnAnterior;
    JButton btnDespues;
    JTextField buscador ;
    JComboBox<String> cajaEdad;

    int pagina=1;
    public ConsultasPacientes(){

        getContentPane().setLayout(null);
        setTitle("Consultas Pacientes");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);
        tablaPacientesModificaiones = new JTable();
        tablaPacientesModificaiones.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null}
                },
                new String[]{
                        "SSN", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "EDAD", "Calle", "Colonia", "No.Casa", "CP"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
                //Actualizar el primer registro
                Paciente ob1 = pacienteDAO.mostrarPaciente ("", "Uno");
                actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
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
                    Paciente al = pacienteDAO.mostrarPaciente("","Uno");
                    actualizarTablaConsultas(tablaPacientesModificaiones, al);
                    cajaNSS.setText(al.getNumSSN());
                    cajaNombre.setText(al.getNombre());
                    cajaApPaterno.setText(al.getPrimerApellido());
                    cajaApMaterno.setText(al.getSegundoApellido());
                    cajaEdad.setSelectedItem(al.getEdad()+"");
                    cajaCalle.setText(al.getCalle());
                    cajaColonia.setText(al.getColonia());

                }
            }
        });
        btnUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnUltimo){
                    btnAnterior.setEnabled(true);
                    btnDespues.setEnabled(false);
                    pagina=pacienteDAO.tamañoTablas();
                    buscador.setText(pagina+"");
                    Paciente al = pacienteDAO.mostrarPaciente(pacienteDAO.tamañoTablas()-1+"","Ultimo");
                    actualizarTablaConsultas(tablaPacientesModificaiones, al);
                    cajaNSS.setText(al.getNumSSN());
                    cajaNombre.setText(al.getNombre());
                    cajaApPaterno.setText(al.getPrimerApellido());
                    cajaApMaterno.setText(al.getSegundoApellido());
                    cajaEdad.setSelectedItem(al.getEdad()+"");
                    cajaCalle.setText(al.getCalle());
                    cajaColonia.setText(al.getColonia());
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
                    Paciente al = pacienteDAO.mostrarPaciente((pagina-1)+"","Ultimo");
                    actualizarTablaConsultas(tablaPacientesModificaiones, al);
                    cajaNSS.setText(al.getNumSSN());
                    cajaNombre.setText(al.getNombre());
                    cajaApPaterno.setText(al.getPrimerApellido());
                    cajaApMaterno.setText(al.getSegundoApellido());
                    cajaEdad.setSelectedItem(al.getEdad()+"");
                    cajaCalle.setText(al.getCalle());
                    cajaColonia.setText(al.getColonia());
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
                        if (pagina> pacienteDAO.tamañoTablas()  || pagina< 1  ){
                            JOptionPane.showMessageDialog(null,"El numero de registro seleccionado no existe");
                        }else {
                            if (pagina==1){
                                btnAnterior.setEnabled(false);
                                btnDespues.setEnabled(true);
                            }else if(pagina==pacienteDAO.tamañoTablas()){
                                btnAnterior.setEnabled(true);
                                btnDespues.setEnabled(false);
                            }else{
                                btnAnterior.setEnabled(true);
                                btnDespues.setEnabled(true);
                            }
                            Paciente al = pacienteDAO.mostrarPaciente((pagina-1)+"","Ultimo");
                            actualizarTablaConsultas(tablaPacientesModificaiones, al);
                            cajaNombre.setText(al.getNombre());
                            cajaApPaterno.setText(al.getPrimerApellido());
                            cajaApMaterno.setText(al.getSegundoApellido());
                            cajaEdad.setSelectedItem(al.getEdad()+"");
                            cajaCalle.setText(al.getCalle());
                            cajaColonia.setText(al.getColonia());
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
                    if(pagina==pacienteDAO.tamañoTablas())
                        btnDespues.setEnabled(false);
                    buscador.setText(pagina+"");
                    Paciente al = pacienteDAO.mostrarPaciente((pagina-1)+"","Ultimo");
                    actualizarTablaConsultas(tablaPacientesModificaiones, al);
                    cajaNSS.setText(al.getNumSSN());
                    cajaNombre.setText(al.getNombre());
                    cajaApPaterno.setText(al.getPrimerApellido());
                    cajaApMaterno.setText(al.getSegundoApellido());
                    cajaEdad.setSelectedItem(al.getEdad()+"");
                    cajaCalle.setText(al.getCalle());
                    cajaColonia.setText(al.getColonia());

                }
            }
        });

// Agregar la tabla a un JScrollPane
                JScrollPane scrollPane = new JScrollPane(tablaPacientesModificaiones);
                scrollPane.setBounds(10, 30, 840, 150);
                panelCian.add(scrollPane);
                add(panelCian);


//Panel AZUL TITULO
                panelAzul = new JPanel();
                panelAzul.setLayout(null);
                panelAzul.setBackground(new Color(26, 32, 234  ));
                panelAzul.setBounds(0, 0, getWidth(), 30);
                JLabel texBAJAS = new JLabel("    CONSULTAS PACIENTES:");
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
                radioEdad = new JRadioButton("Edad:");
                    radioCallee = new JRadioButton("Calle:");
                radioColonia = new JRadioButton("Colonia:");


                radioTodos = new JRadioButton("TODOS");
                radioTodos.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (radioTodos.isSelected()){
                            radioNSS.setSelected(true);
                            radioNombre.setSelected(true);
                            radioAPpaterno.setSelected(true);
                            radioAPMaterno.setSelected(true);
                            radioEdad.setSelected(true);
                            radioCallee.setSelected(true);
                            radioColonia.setSelected(true);

                            cajaNSS.setEditable(true);
                            cajaNombre.setEditable(true);
                            cajaApPaterno.setEditable(true);
                            cajaEdad.setEditable(true);
                            cajaApMaterno.setEditable(true);
                            cajaCalle.setEditable(true);
                            cajaColonia.setEditable(true);
                        }else{
                            radioNSS.setSelected(false);
                            radioNombre.setSelected(false);
                            radioAPpaterno.setSelected(false);
                            radioAPMaterno.setSelected(false);
                            radioEdad.setSelected(false);
                            radioCallee.setSelected(false);
                            radioColonia.setSelected(false);

                            cajaNSS.setEditable(false);
                            cajaNombre.setEditable(false);
                            cajaApPaterno.setEditable(false);
                            cajaEdad.setEditable(false);
                            cajaApMaterno.setEditable(false);
                            cajaCalle.setEditable(false);
                            cajaColonia.setEditable(false);
                        }
                    }
                });

                radioTodos.setBounds(20, 60, 80,20);
                radioNSS.setBounds(100, 60, 80,20);
                radioNombre.setBounds(100, 90, 130,20);
                radioAPpaterno.setBounds(100, 120, 130,20);
                radioAPMaterno.setBounds(100, 150, 130,20);
                radioEdad.setBounds(100, 180, 90,20);
                radioCallee.setBounds(100, 210, 90,20);
                radioColonia.setBounds(100, 240, 90,20);

                radioNSS.addActionListener(this);
                radioNombre.addActionListener(this);
                radioAPpaterno.addActionListener(this);
                radioAPMaterno.addActionListener(this);
                radioEdad.addActionListener(this);
                radioCallee.addActionListener(this);
                radioColonia.addActionListener(this);

                add(radioTodos);
                add(radioNSS);
                add(radioNombre);
                add(radioAPpaterno);
                add(radioAPMaterno);
                add(radioEdad);
                add(radioCallee);
                add(radioColonia);
                //Poner los datos del primer registro al abrir la ventana consultas
                Paciente al = pacienteDAO.mostrarPaciente("","Uno");
                cajaNSS = new JTextField(al.getNumSSN());
                cajaNombre = new JTextField(al.getNombre());
                cajaApPaterno = new JTextField(al.getPrimerApellido());
                cajaApMaterno = new JTextField(al.getSegundoApellido()  );
                cajaEdad = new JComboBox<String>();////////////////////////////
                cajaEdad.addItem("");
                for(int i =0; i <99;i++){
                    cajaEdad.addItem(i+"");}/////////////////////////
                cajaEdad.setSelectedIndex(al.getEdad()+1);
                cajaCalle = new JTextField(al.getCalle());///////////////////////////////////
                cajaColonia = new JTextField(al.getColonia());
                ///////////////////////////////////////////////////////////////////

                cajaNSS.setEditable(false);
                cajaNombre.setEditable(false);
                cajaApPaterno.setEditable(false);
                cajaApMaterno.setEditable(false);
                cajaEdad.setEditable(false);
                cajaCalle.setEditable(false);
                cajaColonia.setEditable(false);


                cajaNSS.setBounds(250, 60, 250, 20);
                cajaNombre.setBounds(250, 90, 220, 20);
                cajaApPaterno.setBounds(250, 120, 220, 20);
                cajaApMaterno.setBounds(250, 150, 240, 20);
                cajaEdad.setBounds(250, 180, 260, 20);
                cajaCalle.setBounds(250, 210, 250, 20);
                 cajaColonia.setBounds(250, 240, 250, 20);


                add(cajaNSS);
                add(cajaNombre);
                add(cajaApPaterno);
                add(cajaEdad);
                add(cajaApMaterno);
                add(cajaCalle);
                add(cajaColonia);


            }//constructor

            public void SeleccionBotones (JRadioButton botonSeleccionado, JTextField a,  ActionEvent E,
                                          JTextField b, JTextField c, JComboBox<String> d, JTextField f ,  JTextField g,
                                          JRadioButton A,  JRadioButton B,  JRadioButton C, JRadioButton D,  JRadioButton F,
                                          JTextField id, JRadioButton ID
            ){
                if(E.getSource()==botonSeleccionado){
                    if (botonSeleccionado.isSelected()){
                        a.setEditable(true);
                        b.setEditable(false);
                        c.setEditable(false);
                        d.setEditable(false);
                        f.setEditable(false);
                        g.setEditable(false);
                        id.setEditable(false);

                        A.setSelected(false);
                        B.setSelected(false);
                        C.setSelected(false);
                        D.setSelected(false);
                        F.setSelected(false);
                        ID.setSelected(false);

                    }else{
                        a.setEditable(false);
                        b.setEditable(false);
                        c.setEditable(false);
                        d.setEditable(false);
                        f.setEditable(false);
                        g.setEditable(false);
                        id.setEditable(false);

                    }
                }
            }
            public void SeleccionBotonesDos (JRadioButton botonSeleccionado, JComboBox a,  ActionEvent E,
                                             JTextField b, JTextField c, JTextField d,  JTextField f ,  JTextField g,
                                             JRadioButton A,  JRadioButton B,  JRadioButton C, JRadioButton D,  JRadioButton F
            ){
                if(E.getSource()==botonSeleccionado){
                    if (botonSeleccionado.isSelected()){
                        a.setEditable(true);
                        b.setEditable(false);
                        c.setEditable(false);
                        d.setEditable(false);
                        f.setEditable(false);
                        g.setEditable(false);

                        A.setSelected(false);
                        B.setSelected(false);
                        C.setSelected(false);
                        D.setSelected(false);
                        F.setSelected(false);

                    }else{
                        a.setEditable(false);
                        b.setEditable(false);
                        c.setEditable(false);
                        d.setEditable(false);
                        f.setEditable(false);
                        g.setEditable(false);

                    }
                }
            }

            public void actualizarTablaConsultas (JTable t, Paciente ob1){
                t.setValueAt(ob1.getNumSSN(), 0,0);
                t.setValueAt(ob1.getNombre(), 0,1);
                t.setValueAt(ob1.getSegundoApellido(), 0,3);
                t.setValueAt(ob1.getPrimerApellido(), 0,2);
                t.setValueAt(ob1.getEdad(), 0,4);
                t.setValueAt(ob1.getCalle(), 0,5);
                t.setValueAt(ob1.getColonia(), 0,6);
                t.setValueAt(ob1.getNo_Casa(), 0,7);
                t.setValueAt(ob1.getCP(), 0,8);

            }

            @Override
            public void actionPerformed(ActionEvent e) {
//inabilitar les demas espacios de los radiobuttons   ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡

                if(e.getSource()==radioNombre){
                    SeleccionBotones(radioNombre,cajaNombre,e, cajaApPaterno, cajaApMaterno,
                            cajaEdad, cajaCalle, cajaColonia,
                            radioAPpaterno, radioAPMaterno, radioEdad,radioCallee,radioColonia,
                            cajaNSS, radioNSS
                    );
                }
                if(e.getSource()==radioAPpaterno){
                    SeleccionBotones(radioAPpaterno,cajaApPaterno,e,cajaNombre , cajaApMaterno,
                            cajaEdad, cajaCalle, cajaColonia,
                            radioNombre, radioAPMaterno, radioEdad,radioCallee,radioColonia,
                            cajaNSS, radioNSS
                    );
                }

                if(e.getSource()==radioAPMaterno){
                    SeleccionBotones(radioAPMaterno,cajaApMaterno,e,cajaNombre , cajaApPaterno,
                            cajaEdad, cajaCalle, cajaColonia,
                            radioNombre, radioAPpaterno, radioEdad,radioCallee,radioColonia,
                            cajaNSS, radioNSS
                    );
                }
                if(e.getSource()==radioNSS){
                    SeleccionBotones(radioNSS,cajaNSS,e,cajaNombre , cajaApPaterno,
                            cajaEdad, cajaCalle, cajaColonia,
                            radioNombre, radioAPpaterno, radioEdad,radioCallee,radioColonia,
                            cajaApMaterno, radioAPMaterno
                    );
                }
                if(e.getSource()==radioCallee){
                    SeleccionBotones(radioCallee,cajaCalle,e,cajaNombre , cajaApPaterno,
                            cajaEdad, cajaNSS, cajaColonia,
                            radioNombre, radioAPpaterno, radioEdad,radioNSS,radioColonia,
                            cajaApMaterno, radioAPMaterno
                    );
                }if(e.getSource()==radioColonia){
                    SeleccionBotones(radioColonia,cajaColonia,e,cajaNombre , cajaApPaterno,
                            cajaEdad, cajaCalle, cajaNSS,
                            radioNombre, radioAPpaterno, radioEdad,radioCallee,radioNSS,
                            cajaApMaterno, radioAPMaterno
                    );
                }

                if(e.getSource()==radioEdad){
                    SeleccionBotonesDos(radioEdad,cajaEdad,e,cajaNombre , cajaApPaterno, cajaApMaterno,
                            cajaCalle, cajaColonia,
                            radioNombre, radioAPpaterno, radioAPMaterno,radioCallee,radioColonia
                    );
                }

                //inabilitar les demas espacios de los radiobuttons   ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡



                if(e.getSource()==btnBuscar){//*********************************************

                    if(radioNSS.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaNSS.getText(), "ID")==null){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else{
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaNSS.getText(), "ID");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }//else
                    }//********************************************************Nombre
                    if(radioNombre.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaNombre.getText(), "Nombre")==null){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else {
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaNSS.getText(), "Nombre");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }
                    }//********************************************************APpATERNO
                    if(radioAPpaterno.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaApPaterno.getText(), "PApellido")==null){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else {
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaApPaterno.getText(), "PApellido");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }
                    }//********************************************************APMaterno

                    if(radioAPMaterno.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaEdad.getSelectedItem()+"", "SApellido")==null){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else {
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaEdad.getSelectedItem()+"", "SApellido");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }
                    }//********************************************************EDAD
                    if(radioEdad.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaApMaterno.getText(), "Edad")==null){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else {
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaApMaterno.getText()+"", "Edad");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }
                    }//********************************************************CALLE
                    if(radioCallee.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaCalle.getText()+"", "calle")==null){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else {
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaCalle.getText()+"", "calle");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }
                    }if(radioColonia.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaColonia.getText()+"", "Colonia")==null){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else {
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaColonia.getText()+"", "Colonia");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }
                    }

                    //********************************************************TODOS
                    if(radioTodos.isSelected()){
                        if(pacienteDAO.mostrarPaciente(cajaCalle.getText(), "TODOS")==null
                                && pacienteDAO.mostrarPaciente(cajaApMaterno.getText()+"", "Semestre")==null
                                && pacienteDAO.mostrarPaciente(cajaEdad.getSelectedItem()+"", "Edad")==null
                                && pacienteDAO.mostrarPaciente(cajaApPaterno.getText(), "SegundoAP")==null
                                && pacienteDAO.mostrarPaciente(cajaNombre.getText(), "PrimerAP")==null
                                &&pacienteDAO.mostrarPaciente(cajaNSS.getText(), "Nombre")==null
                        ){
                            JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                        }else {
                            Paciente ob1 = pacienteDAO.mostrarPaciente(cajaNSS.getText(), "TODOS");
                            actualizarTablaConsultas(tablaPacientesModificaiones, ob1);
                        }
                    }//********************************************************TODOS



                    //for ich,,, each
                /*
                for (Alumno alumno: lista)
                    System.out.println(alumno.getNumControl());
                */
                }//********************************************************************
                if(e.getSource()==btnBorrar){
                    cajaNSS.setText("");
                    cajaNombre.setText("");
                    cajaApPaterno.setText("");
                    cajaEdad.setSelectedIndex(0);
                    cajaApMaterno.setText("");
                    cajaCalle.setText("");
                    tablaPacientesModificaiones.setValueAt(null, 0,0);
                    tablaPacientesModificaiones.setValueAt(null, 0,1);
                    tablaPacientesModificaiones.setValueAt(null, 0,2);
                    tablaPacientesModificaiones.setValueAt(null, 0,3);
                    tablaPacientesModificaiones.setValueAt(null, 0,4);
                    tablaPacientesModificaiones.setValueAt(null, 0,5);
                    tablaPacientesModificaiones.setValueAt(null, 0,6);

                }
                if( e.getSource().equals(btnCancelar)){
                    setVisible(false);
                    //aqui podriamos poner un historial q regrese los valores
                }
            }
        }

