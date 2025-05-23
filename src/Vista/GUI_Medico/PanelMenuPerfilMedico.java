package Vista.GUI_Medico;

import javax.swing.*;
import java.awt.*;

public class PanelMenuPerfilMedico {
    JPanel panelPerfil;
    public JPanel añadirPanelPerfilMedico(JToolBar toolBar ){
        //**********************Panel del Perfil Personal*****************************
        panelPerfil = new JPanel();
        panelPerfil.setBounds(5,toolBar.getHeight()+5,1050,470);
        panelPerfil.setBackground(new Color(225, 253, 207));
        panelPerfil.setLayout(null);

        JLabel txtPerfil = new JLabel();
        formatoPerfilMedico(txtPerfil,"Información del Perfil", 20,10,300,40,"Verdana",24,panelPerfil );

        JLabel txtUsuario = new JLabel();
        txtUsuario.setForeground(Color.red);
        formatoPerfilMedico( txtUsuario,"usuario:", 25,90,100,50,"Tahoma",11 , panelPerfil  );

        JLabel txtSSN = new JLabel();
        formatoPerfilMedico(txtSSN, "SSN (Número de Seguro Social):", 73,90,300,20,"Verdana",14,panelPerfil);

        JLabel txtNombre = new JLabel();
        formatoPerfilMedico(txtNombre, "Nombre:", 73, 170,200,20, "Verdana",14,panelPerfil);

        JLabel txtApellidoUno = new JLabel();
        formatoPerfilMedico(txtApellidoUno, "Apellido Paterno:", 350,170,300,20,"Verdana",14,panelPerfil);

        JLabel txtApellidoDos = new JLabel();
        formatoPerfilMedico(txtApellidoDos, "Apellido Materno:", 700,170,300,20,"Verdana",14,panelPerfil);

        JLabel txtEspecialidad = new JLabel();
        formatoPerfilMedico(txtEspecialidad, "Especialidad:", 73,250, 200,20, "Verdana",14,panelPerfil);

        JLabel txtAñosExperiencias = new JLabel();
        formatoPerfilMedico(txtAñosExperiencias, "Años de Experiencia:", 73, 330, 200,20, "Verdana",14,panelPerfil );

return panelPerfil;
    }
    public void formatoPerfilMedico(JLabel etiqueta, String texto, int x, int y ,
                                    int width, int heith, String letra, int tamLetra, JPanel pan){
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,width,heith);
        etiqueta.setFont(new Font(letra, Font.BOLD,tamLetra));
        pan.add(etiqueta);
    }
}
