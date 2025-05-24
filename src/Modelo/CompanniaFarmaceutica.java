package Modelo;

public class CompanniaFarmaceutica {
    private String NombreCompania;
    private String Telefono;


    public CompanniaFarmaceutica(String nombreCompania, String telefono) {
        NombreCompania = nombreCompania;
        Telefono = telefono;
    }

    public String getNombreCompania() {
        return NombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        NombreCompania = nombreCompania;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
