package Vista.GUI.FarmaciaSucursal.ABCC_CompañiasFarmaceuticas;

import Controlador.ComFarmaceuticaDAO;
import Modelo.CompanniaFarmaceutica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Consultas_CompañiasFarmaceuticas extends JFrame implements ActionListener{
        ComFarmaceuticaDAO comFaDAO = new ComFarmaceuticaDAO();
        JPanel panelAzul, panelCian;
        JTable tablaComFarCambios;
        JLabel texCriterioBusqueda;
        JButton btnBuscar, btnBorrar,btnCancelar;
        JRadioButton radioTodos, radioNombreCF, radioTelefono;
        JTextField cajaNombreCF, cajaTelefono;

        JButton btnPrimero;
        JButton btnUltimo;
        JButton btnAnterior;
        JButton btnDespues;
        JTextField buscador ;

        int pagina=1;
        public Consultas_CompañiasFarmaceuticas(){
            getContentPane().setLayout(null);
            setTitle("Consultas Pacientes");
            setSize(900,530);
            setLocationRelativeTo(null);//locacion en la ventana
            setVisible(true);

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

            tablaComFarCambios = new JTable();
            tablaComFarCambios.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                            {null, null},
                            {null, null},
                            {null, null},
                            {null, null},
                            {null, null}},
                    new String[]{
                            "Nombre Compañia", "Telefono"
                    }) {boolean[] canEdit = new boolean[]{
                    false, false};public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }});

            CompanniaFarmaceutica ob1 = comFaDAO.mostrarComFar ("", "Uno");
            actualizarTablaConsultas(tablaComFarCambios, ob1);

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
                        CompanniaFarmaceutica al = comFaDAO.mostrarComFar("","Uno");
                        actualizarTablaConsultas(tablaComFarCambios, al);
                        cajaNombreCF.setText(al.getNombreCompania());
                        cajaTelefono.setText(al.getTelefono());

                    }
                }
            });
            btnUltimo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==btnUltimo){
                        btnAnterior.setEnabled(true);
                        btnDespues.setEnabled(false);
                        pagina=comFaDAO.tamañoTablas();
                        buscador.setText(pagina+"");
                        CompanniaFarmaceutica al = comFaDAO.mostrarComFar(comFaDAO.tamañoTablas()-1+"","Ultimo");
                        actualizarTablaConsultas(tablaComFarCambios, al);
                        cajaNombreCF.setText(al.getNombreCompania());
                        cajaTelefono.setText(al.getTelefono());
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
                        CompanniaFarmaceutica al = comFaDAO.mostrarComFar((pagina-1)+"","Ultimo");
                        actualizarTablaConsultas(tablaComFarCambios, al);
                        cajaNombreCF.setText(al.getNombreCompania());
                        cajaTelefono.setText(al.getTelefono());

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
                            if (pagina> comFaDAO.tamañoTablas()  || pagina< 1  ){
                                JOptionPane.showMessageDialog(null,"El numero de registro seleccionado no existe");
                            }else {
                                if (pagina==1){
                                    btnAnterior.setEnabled(false);
                                    btnDespues.setEnabled(true);
                                }else if(pagina==comFaDAO.tamañoTablas()){
                                    btnAnterior.setEnabled(true);
                                    btnDespues.setEnabled(false);
                                }else{
                                    btnAnterior.setEnabled(true);
                                    btnDespues.setEnabled(true);
                                }
                                CompanniaFarmaceutica al = comFaDAO.mostrarComFar((pagina-1)+"","Ultimo");
                                actualizarTablaConsultas(tablaComFarCambios, al);
                                cajaTelefono.setText(al.getTelefono());
                                cajaNombreCF.setText(al.getNombreCompania());

                            }}
                    }catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(null,"ERROR: El buscador de registros solo admite numeros");
                    }
                }// castch

            });
            if (comFaDAO.tamañoTablas()==1){
                btnDespues.setEnabled(false);
            }
            btnDespues.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==btnDespues){
                        btnAnterior.setEnabled(true);
                        pagina= pagina+1;
                        if(pagina==comFaDAO.tamañoTablas())
                            btnDespues.setEnabled(false);
                        buscador.setText(pagina+"");
                        CompanniaFarmaceutica al = comFaDAO.mostrarComFar((pagina-1)+"","Ultimo");
                        actualizarTablaConsultas(tablaComFarCambios, al);
                        cajaNombreCF.setText(al.getNombreCompania());
                        cajaTelefono.setText(al.getTelefono());

                    }
                }
            });

// Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(tablaComFarCambios);
            scrollPane.setBounds(10, 30, 840, 150);
            panelCian.add(scrollPane);

            add(panelCian);


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
            radioNombreCF = new JRadioButton("NSS:");
            radioTelefono = new JRadioButton("Nombre:");

            radioTodos = new JRadioButton("TODOS");
            radioTodos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (radioTodos.isSelected()){
                        radioNombreCF.setSelected(true);
                        radioTelefono.setSelected(true);

                        cajaNombreCF.setEditable(true);
                        cajaTelefono.setEditable(true);

                    }else{
                        radioNombreCF.setSelected(false);
                        radioTelefono.setSelected(false);

                        cajaNombreCF.setEditable(false);
                        cajaTelefono.setEditable(false);

                    }
                }
            });

            radioTodos.setBounds(20, 60, 80,20);
            radioNombreCF.setBounds(100, 60, 80,20);
            radioTelefono.setBounds(100, 90, 130,20);

            radioNombreCF.addActionListener(this);
            radioTelefono.addActionListener(this);

            add(radioTodos);
            add(radioNombreCF);
             add(radioTelefono);

            //Poner los datos del primer registro al abrir la ventana consultas
            CompanniaFarmaceutica al = comFaDAO.mostrarComFar("","Uno");
            cajaNombreCF = new JTextField(al.getNombreCompania());
            cajaTelefono = new JTextField(al.getTelefono());

            cajaNombreCF.setEditable(false);
            cajaTelefono.setEditable(false);

            cajaNombreCF.setBounds(250, 60, 250, 20);
            cajaTelefono.setBounds(250, 90, 220, 20);

            add(cajaNombreCF);
            add(cajaTelefono);

        }//constructor

            public void SeleccionBotones (JRadioButton botonSeleccionado, JTextField a,  ActionEvent E,
                                          JTextField b, JRadioButton A ){
                if(E.getSource()==botonSeleccionado){
                    if (botonSeleccionado.isSelected()){
                        a.setEditable(true);
                        b.setEditable(false);

                        A.setSelected(false);

                    }else{
                        a.setEditable(false);
                        b.setEditable(false);
                    }
                }
            }

        public void actualizarTablaConsultas(JTable t, CompanniaFarmaceutica ob1){
            t.setValueAt(ob1.getNombreCompania(), 0,0);
            t.setValueAt(ob1.getTelefono(), 0,1);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//inabilitar les demas espacios de los radiobuttons   ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡

            if(e.getSource()== radioTelefono){
                SeleccionBotones(radioTelefono, cajaTelefono,e,
                        cajaNombreCF, radioNombreCF);
            }
            if(e.getSource()== radioNombreCF){
                SeleccionBotones(radioNombreCF, cajaNombreCF,e, cajaTelefono ,
                        radioTelefono);
            }

            if(e.getSource()==btnBuscar){//*********************************************
                Thread hiloBusqueda = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CompanniaFarmaceutica ob1 = comFaDAO.mostrarComFar(cajaNombreCF.getText(), "ID");
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                actualizarTablaConsultas(tablaComFarCambios, ob1);
                            }
                        });
                    }
                });
/*
            if(radioNombreCF.isSelected()){
                    if(comFaDAO.mostrarComFar(cajaNombreCF.getText(), "ID")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else{
                        CompanniaFarmaceutica ob1 = comFaDAO.mostrarComFar(cajaNombreCF.getText(), "ID");
                        actualizarTablaConsultas(tablaComFarCambios, ob1);
                    }//else
                }//********************************************************
                if(radioTelefono.isSelected()){
                    if(comFaDAO.mostrarComFar(cajaTelefono.getText(), "Tel")==null){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        CompanniaFarmaceutica ob1 = comFaDAO.mostrarComFar(cajaNombreCF.getText(), "Nombre");
                        actualizarTablaConsultas(tablaComFarCambios, ob1);
                    }
                }//********************************************************::::::

                 if(radioTodos.isSelected()){
                    if(comFaDAO.mostrarComFar(cajaTelefono.getText(), "TODOS")==null
                            &&comFaDAO.mostrarComFar(cajaNombreCF.getText(), "ID")==null
                    ){
                        JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                    }else {
                        CompanniaFarmaceutica ob1 = comFaDAO.mostrarComFar(cajaNombreCF.getText(), "TODOS");
                        actualizarTablaConsultas(tablaComFarCambios, ob1);
                    }
                }//********************************************************TODOS
*/

            }//****************Boton Buscar *********************************************
            if(e.getSource()==btnBorrar){
                cajaNombreCF.setText("");
                cajaTelefono.setText("");

                tablaComFarCambios.setValueAt(null, 0,0);
                tablaComFarCambios.setValueAt(null, 0,1);
            }
            if( e.getSource().equals(btnCancelar)){
                setVisible(false);
            }
        }
}
