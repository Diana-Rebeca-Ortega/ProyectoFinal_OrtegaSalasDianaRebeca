package Vista.GUI.FarmaciaSucursal;

import Modelo.Farmacia;
import Modelo.ResultSetTableModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class PanelRegistrosContratos extends  JFrame{
    JPanel panelNewContrato;
    JTable tablaContratosAltas;
    public JPanel Agregar_panelRegistros(Farmacia farmacia) {
        panelNewContrato = new JPanel();
        panelNewContrato.setBounds(5, 100, 1050, 470);
        panelNewContrato.setBackground(new Color(225, 253, 207));
        panelNewContrato.setLayout(null);


        tablaContratosAltas = new JTable();
        tablaContratosAltas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "ID", "NOMBRE COMPAÑIA FARMACEUTICA", "ID Farmacia", "FechaInicio", "FechaFin", "NSS Supervisor"
                }) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
// Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaContratosAltas);
        scrollPane.setBounds(10, 10, 825, 180);
        panelNewContrato.add(scrollPane);
        actualizarTabla(tablaContratosAltas);

        return  panelNewContrato;
    }
    public void actualizarTabla(JTable tabla) {
        final String Driver_Controlador = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/farmaciarx";
        final String CONSULTA = " select * from contratos;";
        //el final se refiere a que son constantes
        try {
            ResultSetTableModel modelo = new ResultSetTableModel(Driver_Controlador, URL, CONSULTA);
            tabla.setModel(modelo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }//actualizarTabla

}
