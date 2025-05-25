package Vista.GUI_Administrativo;

import Controlador.FarmaciaDAO;
import Modelo.Farmacia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultasFarmacias extends JFrame implements ActionListener{
    FarmaciaDAO farmaciaDAO = new FarmaciaDAO();
    JPanel panelAzul, panelCian;
    JTable tablaFarmaciasConsultas;
    JLabel texCriterioBusqueda;
    JButton btnBuscar, btnBorrar,btnCancelar;
    JRadioButton radioTodos, radioID, radioTelefono, radioEstado, radioMunicipio, radioColonia, radioCallee, radioCP;
    JTextField cajaID, cajaTel, cajaEstado, cajaMunicipio, cajaColon, cajaCalle, cajaCP;


    JButton btnPrimero;
    JButton btnUltimo;
    JButton btnAnterior;
    JButton btnDespues;
    JTextField buscador ;

    int pagina=1;

    public void actualizarDatosTXT(  Farmacia al){
        cajaID.setText(al.getID_Farmacia());
        cajaTel.setText(al.getTelefono()+"");
        cajaEstado.setText(al.getEstado()+"");
        cajaMunicipio.setText(al.getMunicipio());
        cajaColon.setText(al.getColonia());
        cajaCalle.setText(al.getCalle());
        cajaCP.setText(al.getCP()+"");
    }
    public ConsultasFarmacias(){

        getContentPane().setLayout(null);
        setTitle("Consultas Pacientes");
        setSize(900,530);
        setLocationRelativeTo(null);//locacion en la ventana
        setVisible(true);
        tablaFarmaciasConsultas = new JTable();
        tablaFarmaciasConsultas.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null},
                        {null, null, null, null, null, null,  null,null,null}
                },
                new String[]{
                        "ID", "Telefono", "Estado", "Municipio", "Colonia", "Calle", "CP", "No.Local", "Nombre"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        //Actualizar el primer registro
        Farmacia ob1 = farmaciaDAO.mostrarFarmacia ("", "Uno");
        actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
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
                    Farmacia al = farmaciaDAO.mostrarFarmacia("","Uno");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, al);
                    actualizarDatosTXT(al);

                }
            }
        });
        btnUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnUltimo){
                    btnAnterior.setEnabled(true);
                    btnDespues.setEnabled(false);
                    pagina= farmaciaDAO.tamañoTablas();
                    buscador.setText(pagina+"");
                    Farmacia al = farmaciaDAO.mostrarFarmacia(farmaciaDAO.tamañoTablas()-1+"","Ultimo");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, al);
                    actualizarDatosTXT(al);
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
                    Farmacia al = farmaciaDAO.mostrarFarmacia((pagina-1)+"","Ultimo");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, al);
                    actualizarDatosTXT(al);
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
                        if (pagina> farmaciaDAO.tamañoTablas()  || pagina< 1  ){
                            JOptionPane.showMessageDialog(null,"El numero de registro seleccionado no existe");
                        }else {
                            if (pagina==1){
                                btnAnterior.setEnabled(false);
                                btnDespues.setEnabled(true);
                            }else if(pagina== farmaciaDAO.tamañoTablas()){
                                btnAnterior.setEnabled(true);
                                btnDespues.setEnabled(false);
                            }else{
                                btnAnterior.setEnabled(true);
                                btnDespues.setEnabled(true);
                            }
                            Farmacia al = farmaciaDAO.mostrarFarmacia((pagina-1)+"","Ultimo");
                            actualizarTablaConsultas(tablaFarmaciasConsultas, al);
                            actualizarDatosTXT(al);
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
                    if(pagina== farmaciaDAO.tamañoTablas())
                        btnDespues.setEnabled(false);
                    buscador.setText(pagina+"");
                    Farmacia al = farmaciaDAO.mostrarFarmacia((pagina-1)+"","Ultimo");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, al);
                    actualizarDatosTXT(al);

                }
            }
        });

// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaFarmaciasConsultas);
        scrollPane.setBounds(10, 30, 840, 150);
        panelCian.add(scrollPane);
        add(panelCian);


//Panel AZUL TITULO
        panelAzul = new JPanel();
        panelAzul.setLayout(null);
        panelAzul.setBackground(new Color(26, 32, 234  ));
        panelAzul.setBounds(0, 0, getWidth(), 30);
        JLabel texBAJAS = new JLabel("    CONSULTAS FARMACIAS:");
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
        radioID = new JRadioButton("ID:");
        radioTelefono = new JRadioButton("Telefono:");
        radioEstado = new JRadioButton("Estado:");
        radioMunicipio = new JRadioButton("Municipio:");
        radioColonia = new JRadioButton("Colonia:");
        radioCallee = new JRadioButton("Calle:");
        radioCP = new JRadioButton("CP:");


        radioTodos = new JRadioButton("TODOS");
        radioTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioTodos.isSelected()){
                    radioID.setSelected(true);
                    radioTelefono.setSelected(true);
                    radioEstado.setSelected(true);
                    radioMunicipio.setSelected(true);
                    radioColonia.setSelected(true);
                    radioCallee.setSelected(true);
                    radioCP.setSelected(true);

                    cajaID.setEditable(true);
                    cajaTel.setEditable(true);
                    cajaEstado.setEditable(true);
                    cajaColon.setEditable(true);
                    cajaMunicipio.setEditable(true);
                    cajaCalle.setEditable(true);
                    cajaCP.setEditable(true);
                }else{
                    radioID.setSelected(false);
                    radioTelefono.setSelected(false);
                    radioEstado.setSelected(false);
                    radioMunicipio.setSelected(false);
                    radioColonia.setSelected(false);
                    radioCallee.setSelected(false);
                    radioCP.setSelected(false);

                    cajaID.setEditable(false);
                    cajaTel.setEditable(false);
                    cajaEstado.setEditable(false);
                    cajaColon.setEditable(false);
                    cajaMunicipio.setEditable(false);
                    cajaCalle.setEditable(false);
                    cajaCP.setEditable(false);
                }
            }
        });

        radioTodos.setBounds(20, 60, 80,20);
        radioID.setBounds(100, 60, 80,20);
        radioTelefono.setBounds(100, 90, 130,20);
        radioEstado.setBounds(100, 120, 130,20);
        radioMunicipio.setBounds(100, 150, 130,20);
        radioColonia.setBounds(100, 180, 90,20);
        radioCallee.setBounds(100, 210, 90,20);
        radioCP.setBounds(100, 240, 90,20);

        radioID.addActionListener(this);
        radioTelefono.addActionListener(this);
        radioEstado.addActionListener(this);
        radioMunicipio.addActionListener(this);
        radioColonia.addActionListener(this);
        radioCallee.addActionListener(this);
        radioCP.addActionListener(this);

        add(radioTodos);
        add(radioID);
        add(radioTelefono);
        add(radioEstado);
        add(radioMunicipio);
        add(radioColonia);
        add(radioCallee);
        add(radioCP);
        //Poner los datos del primer registro al abrir la ventana consultas
        Farmacia al = farmaciaDAO.mostrarFarmacia("","Uno");
        cajaID = new JTextField(al.getID_Farmacia());
        cajaTel = new JTextField(al.getTelefono()+"");
        cajaEstado = new JTextField(al.getEstado());
        cajaMunicipio = new JTextField(al.getMunicipio()  );
        cajaColon = new JTextField(al.getColonia());
        cajaCalle = new JTextField(al.getCalle());
        cajaCP = new JTextField(al.getCP()+"");

        cajaID.setEditable(false);
        cajaTel.setEditable(false);
        cajaEstado.setEditable(false);
        cajaMunicipio.setEditable(false);
        cajaColon.setEditable(false);
        cajaCalle.setEditable(false);
        cajaCP.setEditable(false);


        cajaID.setBounds(250, 60, 250, 20);
        cajaTel.setBounds(250, 90, 220, 20);
        cajaEstado.setBounds(250, 120, 220, 20);
        cajaMunicipio.setBounds(250, 150, 240, 20);
        cajaColon.setBounds(250, 180, 260, 20);
        cajaCalle.setBounds(250, 210, 250, 20);
        cajaCP.setBounds(250, 240, 250, 20);


        add(cajaID);
        add(cajaTel);
        add(cajaEstado);
        add(cajaColon);
        add(cajaMunicipio);
        add(cajaCalle);
        add(cajaCP);


    }//constructor

    public void SeleccionBotones (JRadioButton botonSeleccionado, JTextField a,  ActionEvent E,
                                  JTextField b, JTextField c, JTextField d, JTextField f ,  JTextField g,
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
    public void SeleccionBotonesDos (JRadioButton botonSeleccionado, JTextField a,  ActionEvent E,
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

    public void actualizarTablaConsultas (JTable t, Farmacia ob1){
        t.setValueAt(ob1.getID_Farmacia(), 0,0);
        t.setValueAt(ob1.getTelefono(), 0,1);
        t.setValueAt(ob1.getEstado(), 0,3);
        t.setValueAt(ob1.getMunicipio(), 0,2);
        t.setValueAt(ob1.getColonia(), 0,4);
        t.setValueAt(ob1.getCalle(), 0,5);
        t.setValueAt(ob1.getCP(), 0,6);
        t.setValueAt(ob1.getNoLocal(), 0,7);
        t.setValueAt(ob1.getNombreFarmacia(), 0,8);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//inabilitar les demas espacios de los radiobuttons   ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡

        if(e.getSource()== radioTelefono){
            SeleccionBotones(radioTelefono, cajaTel,e, cajaEstado, cajaMunicipio,
                    cajaColon, cajaCalle, cajaCP,
                    radioEstado, radioMunicipio, radioColonia,radioCallee, radioCP,
                    cajaID, radioID
            );
        }
        if(e.getSource()== radioEstado){
            SeleccionBotones(radioEstado, cajaEstado,e, cajaTel, cajaMunicipio,
                    cajaColon, cajaCalle, cajaCP,
                    radioTelefono, radioMunicipio, radioColonia,radioCallee, radioCP,
                    cajaID, radioID
            );
        }

        if(e.getSource()== radioMunicipio){
            SeleccionBotones(radioMunicipio, cajaMunicipio,e, cajaTel, cajaEstado,
                    cajaColon, cajaCalle, cajaCP,
                    radioTelefono, radioEstado, radioColonia,radioCallee, radioCP,
                    cajaID, radioID
            );
        }
        if(e.getSource()== radioID){
            SeleccionBotones(radioID, cajaID,e, cajaTel, cajaEstado,
                    cajaColon, cajaCalle, cajaCP,
                    radioTelefono, radioEstado, radioColonia,radioCallee, radioCP,
                    cajaMunicipio, radioMunicipio
            );
        }
        if(e.getSource()==radioCallee){
            SeleccionBotones(radioCallee,cajaCalle,e, cajaTel, cajaEstado,
                    cajaColon, cajaID, cajaCP,
                    radioTelefono, radioEstado, radioColonia, radioID, radioCP,
                    cajaMunicipio, radioMunicipio
            );
        }if(e.getSource()== radioCP){
            SeleccionBotones(radioCP, cajaCP,e, cajaTel, cajaEstado,
                    cajaColon, cajaCalle, cajaID,
                    radioTelefono, radioEstado, radioColonia,radioCallee, radioID,
                    cajaMunicipio, radioMunicipio
            );
        }

        if(e.getSource()== radioColonia){
            SeleccionBotonesDos(radioColonia, cajaColon,e, cajaTel, cajaEstado, cajaMunicipio,
                    cajaCalle, cajaCP,
                    radioTelefono, radioEstado, radioMunicipio,radioCallee, radioCP
            );
        }

        //inabilitar les demas espacios de los radiobuttons   ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡



        if(e.getSource()==btnBuscar){//*********************************************

            if(radioID.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaID.getText(), "ID")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else{
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaID.getText(), "ID");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }//else
            }//********************************************************
            if(radioTelefono.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaTel.getText(), "Telefono")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else {
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaID.getText(), "Nombre");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }
            }//********************************************************
            if(radioEstado.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaEstado.getText(), "Estado")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else {
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaEstado.getText(), "PApellido");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }
            }//********************************************************

            if(radioMunicipio.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaColon.getText(), "Municipio")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else {
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaColon.getText(), "SApellido");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }
            }//********************************************************
            if(radioColonia.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaMunicipio.getText(), "Colonia")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else {
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaMunicipio.getText()+"", "Edad");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }
            }//********************************************************
            if(radioCallee.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaCalle.getText(), "Calle")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else {
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaCalle.getText()+"", "calle");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }
            }if(radioCP.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaCP.getText(), "CP")==null){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else {
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaCP.getText()+"", "Colonia");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }
            }

            //********************************************************TODOS
            if(radioTodos.isSelected()){
                if(farmaciaDAO.mostrarFarmacia(cajaCalle.getText(), "TODOS")==null
                        && farmaciaDAO.mostrarFarmacia(cajaMunicipio.getText(), "Municipio")==null
                        && farmaciaDAO.mostrarFarmacia(cajaColon.getText(), "Colonia")==null
                        && farmaciaDAO.mostrarFarmacia(cajaEstado.getText(), "Estado")==null
                        && farmaciaDAO.mostrarFarmacia(cajaTel.getText(), "Telefono")==null
                        && farmaciaDAO.mostrarFarmacia(cajaID.getText(), "ID")==null
                ){
                    JOptionPane.showMessageDialog(null,  "No se encontraron registros");
                }else {
                    Farmacia ob1 = farmaciaDAO.mostrarFarmacia(cajaID.getText(), "TODOS");
                    actualizarTablaConsultas(tablaFarmaciasConsultas, ob1);
                }
            }//********************************************************TODOS

        }//********************************************************************
        if(e.getSource()==btnBorrar){
            cajaID.setText("");
            cajaTel.setText("");
            cajaEstado.setText("");
            cajaColon.setText("");
            cajaMunicipio.setText("");
            cajaCalle.setText("");
            cajaCP.setText("");
            tablaFarmaciasConsultas.setValueAt(null, 0,0);
            tablaFarmaciasConsultas.setValueAt(null, 0,1);
            tablaFarmaciasConsultas.setValueAt(null, 0,2);
            tablaFarmaciasConsultas.setValueAt(null, 0,3);
            tablaFarmaciasConsultas.setValueAt(null, 0,4);
            tablaFarmaciasConsultas.setValueAt(null, 0,5);
            tablaFarmaciasConsultas.setValueAt(null, 0,6);

        }
        if( e.getSource().equals(btnCancelar)){
            setVisible(false);
            //aqui podriamos poner un historial q regrese los valores
        }
    }
}
