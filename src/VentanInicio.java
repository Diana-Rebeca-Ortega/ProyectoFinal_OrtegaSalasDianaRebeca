import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class VentanaPantallaCompleta extends JFrame  {
    private JLabel fondo;
    private Panel panelBienvenido;

    public VentanaPantallaCompleta() {
        ImageIcon imagenFondo = new ImageIcon("C:\\Users\\Marcelo\\Documents\\000SEXTO\\practicas2025IntelliJ\\Farmacia_ProyectoFinal\\src\\farmacia.jpg");
        fondo = new JLabel(imagenFondo);
        addComponentListener(new ComponentAdapter() {//Redimencionar el fondo de pantalla
            @Override
            public void componentResized(ComponentEvent e) {
                Image img = imagenFondo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                fondo.setIcon(new ImageIcon(img));
                fondo.setSize(getWidth(), getHeight());//actualiza el tamaño del fondo
                centrarPanel();//centra el panel cuando se actualoce el tamaño del fondo
            }
        });//Redimencionar el fondo de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);//para que no queden registros en la ram
        setTitle("FARMACIA SIMILARES");
        setSize(300,500);
        setLocationRelativeTo(null);//locacion en la ventana con el fondo de pastillas para que aparezca en el centro
        fondo.setLayout(null);
        add(fondo);


        //Panel del login
        panelBienvenido = new Panel();
        panelBienvenido.setBackground(new Color(4, 18, 134 ));
        panelBienvenido.setSize(300,500);//tamaño panel
        fondo.add(panelBienvenido);
        centrarPanel();//centra el panel inicialmente
        setVisible(true);

        JLabel txtLogin = new JLabel("LOGIN");
        txtLogin.setBounds(20, 15, 300,30);
        txtLogin.setForeground(Color.WHITE);
        panelBienvenido.add(txtLogin);

    }//VentanaPantallaCompleta
    private void centrarPanel() {
        int x = (fondo.getWidth() - panelBienvenido.getWidth()) / 2;
        int y = (fondo.getHeight() - panelBienvenido.getHeight()) / 2;
        panelBienvenido.setLocation(x, y);
    }
}

public class VentanInicio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // new Altas_Alumnos();
                new VentanaPantallaCompleta();
            }
        });
    }
}