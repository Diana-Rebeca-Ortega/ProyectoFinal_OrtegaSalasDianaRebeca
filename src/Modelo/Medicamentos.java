package Modelo;

public class Medicamentos {

    private  String ID_Registro;
    private  String NombreCompañia;
    private  String NombreComercial;
    private  String Formula;

    public Medicamentos(String ID_Registro, String nombreCompañia, String nombreComercial, String formula) {
        this.ID_Registro = ID_Registro;
        NombreCompañia = nombreCompañia;
        NombreComercial = nombreComercial;
        Formula = formula;
    }

    public String getID_Registro() {
        return ID_Registro;
    }

    public void setID_Registro(String ID_Registro) {
        this.ID_Registro = ID_Registro;
    }

    public String getNombreCompañia() {
        return NombreCompañia;
    }

    public void setNombreCompañia(String nombreCompañia) {
        NombreCompañia = nombreCompañia;
    }

    public String getNombreComercial() {
        return NombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        NombreComercial = nombreComercial;
    }

    public String getFormula() {
        return Formula;
    }

    public void setFormula(String formula) {
        Formula = formula;
    }
}
