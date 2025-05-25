package Vista.GUI.FarmaciaSucursal;

import javax.swing.*;
import java.awt.*;

public class PanelNuevoContrato {
    JPanel panelNewContrato;
    JScrollPane sp ;
public JScrollPane AgregarpanelNuevoContrato(){
     panelNewContrato = new JPanel();
    panelNewContrato.setBounds(5,100,1050,470);
    panelNewContrato.setBackground(new Color(225, 253, 207));
    panelNewContrato.setLayout(null);

     JLabel txtTitulo=new JLabel();
     formatoLetra(txtTitulo, "Añadir Contrato", 30,10,200,40,"Arial",23,panelNewContrato);

   JLabel txtIDContrato =new JLabel();
   formatoLetra(txtIDContrato,"ID_Contrato:", 30, 50,100,20, "Arial", 15, panelNewContrato);

    JLabel txtIDFarmacia =new JLabel();
    formatoLetra(txtIDFarmacia,"ID_Farmacia:", 30, 70,100,20, "Arial", 15, panelNewContrato);

    JLabel txtNombreCompañia =new JLabel();
    formatoLetra(txtNombreCompañia,"Nombre de la Compañia:", 30, 100,200,20, "Arial", 13, panelNewContrato);

    JLabel txtFechaInicio =new JLabel();
    formatoLetra(txtFechaInicio,"Inicio Contrato:", 30, 120,200,20, "Arial", 13, panelNewContrato);

    JLabel txtFechaFin =new JLabel();
    formatoLetra(txtFechaFin,"Fin Contrato:", 30, 140,200,20, "Arial", 13, panelNewContrato);

    JLabel txtSupervisor = new JLabel();
    formatoLetra(txtSupervisor,"Supervisor:", 30, 170,200,20, "Arial", 13, panelNewContrato);

    JLabel txtMedicamentos = new JLabel();
    formatoLetra(txtMedicamentos,"Medicamentos:", 30, 190,200,20, "Arial", 13, panelNewContrato);



    sp = new JScrollPane(panelNewContrato);
    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    sp.setBounds(5,100,1050,470);
    return  sp;
}
    public void formatoLetra(JLabel etiqueta, String texto, int x, int y ,
                                    int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        pan.add(etiqueta);
    }
}
