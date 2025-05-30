package Vista.GUI.FarmaciaSucursal;

import Controlador.ComFarmaceuticaDAO;
import Controlador.ContratoDAO;
import Controlador.SupervisorDAO;
import Modelo.CompanniaFarmaceutica;
import Modelo.Contrato;
import Modelo.Farmacia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

public class PanelNuevoContrato extends JFrame  implements  ActionListener{
    JPanel panelNewContrato;
    JScrollPane sp ;
    JComboBox Mes, year, Dia,  Mes2, year2, Dia2, compañiasNombres ,comboNombresSupervisores ;
    List<String> listaNomCom, supervisores;
    String NSSSupervisores;
    JButton generarContrato, borrar;
    DecimalFormat format = new DecimalFormat("0000");
    JLabel txtIDContrato =new JLabel();
    String idcontrato ;
    String farmac ;
    String fechaInicios, fechaFin;

public JPanel AgregarpanelNuevoContrato(Farmacia farmacia){
     panelNewContrato = new JPanel();
    panelNewContrato.setBounds(5,100,1050,470);
    panelNewContrato.setBackground(new Color(225, 253, 207));
    panelNewContrato.setLayout(null);

     JLabel txtTitulo=new JLabel();
     formatoLetra(txtTitulo, "Añadir Contrato", 30,10,200,40,"Arial",23,panelNewContrato);

    ContratoDAO contratoDAO = new ContratoDAO();
 int n = contratoDAO.tamañoTablas();
     txtIDContrato =new JLabel();
    idcontrato= format.format(n)+"";
    farmac = String.valueOf(  farmacia.getID_Farmacia());
   formatoLetra(txtIDContrato,"ID_Contrato:  "+ format.format(n), 30, 50,200,20, "Arial", 15, panelNewContrato);

    JLabel txtIDFarmacia =new JLabel();
    formatoLetra(txtIDFarmacia,"ID_Farmacia:   " +farmacia.getID_Farmacia() , 30, 70,200,20, "Arial", 15, panelNewContrato);

    JLabel txtNombreCompañia =new JLabel();
    formatoLetra(txtNombreCompañia,"Nombre de la Compañia:", 30, 100,200,20, "Arial", 13, panelNewContrato);

    ComFarmaceuticaDAO cfDAO = new ComFarmaceuticaDAO();
    listaNomCom = cfDAO.NombresCompañiasFarmaceuticas();

    compañiasNombres = new JComboBox();
    compañiasNombres.addItem("Elije una Compañia");
    for (int i =0; i<cfDAO.tamañoTablas(); i++ ){
        compañiasNombres.addItem(listaNomCom.get(i));
    }

    compañiasNombres.setBounds( 200, 97, 200,18);
    panelNewContrato.add(compañiasNombres);

    JLabel txtFechaInicio =new JLabel();
    formatoLetra(txtFechaInicio,"Inicio Contrato:", 30, 120,200,20, "Arial", 13, panelNewContrato);

    year = new JComboBox( );
    year.addItem( "YYYY");
    for (int i = 2025; i<= 2030;i++){
        year.addItem( i+"");
    }
    year.setBounds(170,120,60,20);
    panelNewContrato.add(year);

    JLabel dp = new JLabel(" - ");
    dp.setBounds(230,120,20,20);
    panelNewContrato.add(dp);

    Mes = new JComboBox();
    Mes.addItem("MM");
    for (int i = 1; i<= 12;i++){
        Mes.addItem( i+"");
    }
    Mes.setBounds(250,120,50,20);
    panelNewContrato.add(Mes);

    JLabel dp2 = new JLabel(" - ");
    dp2.setBounds(300,120,20,20);
    panelNewContrato.add(dp2);

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
    Dia.setBounds(320,120,50,20);
    panelNewContrato.add(Dia);

   JLabel txtFechaFin =new JLabel();
    formatoLetra(txtFechaFin,"Fin Contrato:", 30, 140,200,20, "Arial", 13, panelNewContrato);

    year2 = new JComboBox( );
    year2.addItem( "YYYY");
    for (int i = 2025; i<= 2030;i++){
        year2.addItem( i+"");
    }
    year2.setBounds(160,145,60,20);
    panelNewContrato.add(year2);

    JLabel dp22 = new JLabel(" - ");
    dp22.setBounds(220,145,20,20);
    panelNewContrato.add(dp22);

    Mes2 = new JComboBox();
    Mes2.addItem("MM");
    for (int i = 1; i<= 12;i++){
        Mes2.addItem( i+"");
    }
    Mes2.setBounds(240,145,50,20);
    panelNewContrato.add(Mes2);

    JLabel dp2R = new JLabel(" - ");
    dp2R.setBounds(290,145,20,20);
    panelNewContrato.add(dp2R);

    Dia2 = new JComboBox();
    Mes2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Mes2){
                Dia2.removeAllItems();
                if(Mes2.getSelectedItem().equals("1") ||
                        Mes2.getSelectedItem().equals("3") ||
                        Mes2.getSelectedItem().equals("5") ||
                        Mes2.getSelectedItem().equals("7") ||
                        Mes2.getSelectedItem().equals("8") ||
                        Mes2.getSelectedItem().equals("10") ||
                        Mes2.getSelectedItem().equals("12")
                ){

                    for (int i = 1; i<= 31;i++){
                        Dia2.addItem( i+"");
                    }
                }if(Mes2.getSelectedItem().equals("4" )||
                        Mes2.getSelectedItem().equals("6") ||
                        Mes2.getSelectedItem().equals("9") ||
                        Mes2.getSelectedItem().equals("11")
                ){
                    for (int i = 1; i<= 30;i++){
                        Dia2.addItem( i+"");
                    }
                }if(Mes2.getSelectedItem().equals("2")){
                    for (int i = 1; i<= 28;i++){
                        Dia2.addItem( i+"");
                    }
                }
            }
        }
    });
    Dia2.setBounds(310,145,50,20);
    panelNewContrato.add(Dia2);


    JLabel txtSupervisor = new JLabel();
    formatoLetra(txtSupervisor,"Supervisor:", 30, 170,200,20, "Arial", 13, panelNewContrato);

    SupervisorDAO supervisorDAO = new SupervisorDAO();
    supervisores =  supervisorDAO.NombresSupervisores();
    comboNombresSupervisores = new JComboBox();
    comboNombresSupervisores.addItem("Selecciona Supervisor ...");
    for (int i =0; i<supervisorDAO.tamañoTablas(); i++  ){
        comboNombresSupervisores.addItem(supervisores.get(i)  );
    }
    comboNombresSupervisores.setBounds(110,170,200,20);
    panelNewContrato.add(comboNombresSupervisores);
    JLabel txtNSS_Supervisor = new JLabel();
    comboNombresSupervisores.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            NSSSupervisores = supervisorDAO.NSS_Supervisores(comboNombresSupervisores.getSelectedItem()+"");
            txtNSS_Supervisor.setText( "NSS Supervisor:   "+  NSSSupervisores);
        }
    });
    formatoLetra(txtNSS_Supervisor,"NSS Supervisor:", 30, 200,200,20, "Arial", 13, panelNewContrato);

    JLabel txtMedicamentos = new JLabel();
   // formatoLetra(txtMedicamentos,"Medicamentos:", 30, 240,200,20, "Arial", 13, panelNewContrato);

    generarContrato = new JButton("GENERAR CONTRATO");
    generarContrato.setBounds(30,400, 200,20);
    panelNewContrato.add(generarContrato);
    generarContrato.addActionListener(this);

    borrar = new JButton("Restablecer");
    borrar.setBounds(260,400, 200,20);
    panelNewContrato.add(borrar);
    borrar.addActionListener(this);



    sp = new JScrollPane(panelNewContrato);
    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    sp.setBounds(5,100,1050,470);
    //return  sp;
    return panelNewContrato;
}
    public void formatoLetra(JLabel etiqueta, String texto, int x, int y ,
                                    int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        pan.add(etiqueta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==generarContrato){
                fechaInicios = "" + year.getSelectedItem() + "-" + Mes.getSelectedItem() + "-" + Dia.getSelectedItem();
                fechaFin = "" + year2.getSelectedItem() + "-" + Mes2.getSelectedItem() + "-" + Dia2.getSelectedItem();



                if ( comboNombresSupervisores.getSelectedItem().equals("Elije una Compañia") ){
                    JOptionPane.showMessageDialog(null,  "No has seleccionado una Compañia");
                }else {
                    if (year.getSelectedItem().equals("YYYY")||
                            Mes.getSelectedItem().equals("MM")) {
                        JOptionPane.showMessageDialog(null,  "No has seleccionado fecha Inicio");
                    }else {
                        if (year2.getSelectedItem().equals("YYYY")||
                                Mes2.getSelectedItem().equals("MM")) {
                            JOptionPane.showMessageDialog(null,  "No has seleccionado fecha Fin");
                        }else {
                            if (fechaInicios.compareTo(fechaFin)>0){
                                JOptionPane.showMessageDialog(null,  "No existe logica para las Fechas");
                            }
                            if (fechaInicios.equals(fechaFin)){
                                JOptionPane.showMessageDialog(null,  "Las fecha no pueden ser iguales");
                            }
                           if (fechaInicios.compareTo(fechaFin)<0){
                               if (comboNombresSupervisores.getSelectedItem().equals("Selecciona Supervisor ...")){
                                   JOptionPane.showMessageDialog(null,  "No has seleccionado Supervisor");
                               }else {

                            Contrato contrato = new Contrato(
                                    idcontrato,
                                    compañiasNombres.getSelectedItem() + "",
                                    farmac,
                                    fechaInicios,
                                    fechaFin,
                                    NSSSupervisores);
                            System.out.println(idcontrato);
                            System.out.println(compañiasNombres.getSelectedItem() + "");
                            System.out.println(farmac);
                            System.out.println(fechaInicios);
                            System.out.println(fechaFin);
                            System.out.println(NSSSupervisores);

                            ContratoDAO contratoDAO = new ContratoDAO();
                            if (contratoDAO.agregarContrato(contrato)) {
                                JOptionPane.showMessageDialog(null,  "FELICIDADES:Registro realizado con exito!!!");
                                System.out.println("FELICIDADES: se agrego ");
                                int n = contratoDAO.tamañoTablas();
                                idcontrato = format.format(n) + "";
                                txtIDContrato.setText("ID_Contrato:  " + idcontrato);
                            } else {
                                System.out.println("ERROR: no se pudo agregar  ");
                            }


                               }
                           }
                        }
                    }
                }
            }

            if (e.getSource()==borrar){
        comboNombresSupervisores.setSelectedIndex(0);
        compañiasNombres.setSelectedIndex(0);
        year.setSelectedIndex(0);
        Mes.setSelectedIndex(0);
            year2.setSelectedIndex(0);
            Mes2.setSelectedIndex(0);

        }
    }
}
