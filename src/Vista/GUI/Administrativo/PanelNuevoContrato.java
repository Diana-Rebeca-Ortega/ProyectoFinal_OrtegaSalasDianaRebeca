package Vista.GUI.Administrativo;

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
     formatoLetra(txtTitulo, "Añadir Contrato", 30,10,200,40,"Arial",20,panelNewContrato);
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
