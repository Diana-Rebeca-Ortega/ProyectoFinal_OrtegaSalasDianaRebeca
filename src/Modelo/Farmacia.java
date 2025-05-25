package Modelo;

public class Farmacia {
    private String ID_Farmacia;
    private String Telefono;
    private String Estado;
    private String Municipio;
    private  String Colonia;
    private String Calle;
    private String CP;
    private int NoLocal;
    private  String NombreFarmacia;

    public Farmacia(String ID_Farmacia, String telefono, String estado, String municipio, String colonia, String calle, String CP, int noLocal, String nombreFarmacia) {
        this.ID_Farmacia = ID_Farmacia;
        Telefono = telefono;
        Estado = estado;
        Municipio = municipio;
        Colonia = colonia;
        Calle = calle;
        this.CP = CP;
        NoLocal = noLocal;
        NombreFarmacia = nombreFarmacia;
    }

    public String getID_Farmacia() {
        return ID_Farmacia;
    }

    public void setID_Farmacia(String ID_Farmacia) {
        this.ID_Farmacia = ID_Farmacia;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String colonia) {
        Colonia = colonia;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public int getNoLocal() {
        return NoLocal;
    }

    public void setNoLocal(int noLocal) {
        NoLocal = noLocal;
    }

    public String getNombreFarmacia() {
        return NombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        NombreFarmacia = nombreFarmacia;
    }
}
