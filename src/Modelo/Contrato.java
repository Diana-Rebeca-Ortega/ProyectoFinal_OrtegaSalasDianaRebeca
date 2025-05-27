package Modelo;

public class Contrato {
    private  String ID_Contrato;
    private  String Nombre_ComFarmaceutica;
    private  String ID_Farmacia;
    private  String FechaInicio;
    private  String FechaFin;
    private  String SSN_Supervisor;

    public Contrato(String ID_Contrato, String ID_ComFarmaceutica, String ID_Farmacia, String fechaInicio, String fechaFin, String SSN_Supervisor) {
        this.ID_Contrato = ID_Contrato;
        this.Nombre_ComFarmaceutica = ID_ComFarmaceutica;
        this.ID_Farmacia = ID_Farmacia;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        this.SSN_Supervisor = SSN_Supervisor;
    }

    public String getID_Contrato() {
        return ID_Contrato;
    }

    public void setID_Contrato(String ID_Contrato) {
        this.ID_Contrato = ID_Contrato;
    }

    public String getNombre_ComFarmaceutica() {
        return Nombre_ComFarmaceutica;
    }

    public void setNombre_ComFarmaceutica(String nombre_ComFarmaceutica) {
        this.Nombre_ComFarmaceutica = nombre_ComFarmaceutica;
    }

    public String getID_Farmacia() {
        return ID_Farmacia;
    }

    public void setID_Farmacia(String ID_Farmacia) {
        this.ID_Farmacia = ID_Farmacia;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public String getSSN_Supervisor() {
        return SSN_Supervisor;
    }

    public void setSSN_Supervisor(String SSN_Supervisor) {
        this.SSN_Supervisor = SSN_Supervisor;
    }
}
