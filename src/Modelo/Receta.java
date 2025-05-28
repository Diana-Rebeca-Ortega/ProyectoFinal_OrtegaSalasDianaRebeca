package Modelo;

public class Receta {
    private String ID_Receta;
    private String ID_Medico;
    private String ID_Paciente;
    private String ListaMedicamentos;
    private String Indicacion;

    public Receta(String ID_Receta, String ID_Medico, String ID_Paciente, String listaMedicamentos, String indicacion) {
        this.ID_Receta = ID_Receta;
        this.ID_Medico = ID_Medico;
        this.ID_Paciente = ID_Paciente;
        ListaMedicamentos = listaMedicamentos;
        Indicacion = indicacion;
    }

    public String getID_Receta() {
        return ID_Receta;
    }

    public void setID_Receta(String ID_Receta) {
        this.ID_Receta = ID_Receta;
    }

    public String getID_Medico() {
        return ID_Medico;
    }

    public void setID_Medico(String ID_Medico) {
        this.ID_Medico = ID_Medico;
    }

    public String getID_Paciente() {
        return ID_Paciente;
    }

    public void setID_Paciente(String ID_Paciente) {
        this.ID_Paciente = ID_Paciente;
    }

    public String getListaMedicamentos() {
        return ListaMedicamentos;
    }

    public void setListaMedicamentos(String listaMedicamentos) {
        ListaMedicamentos = listaMedicamentos;
    }

    public String getIndicacion() {
        return Indicacion;
    }

    public void setIndicacion(String indicacion) {
        Indicacion = indicacion;
    }
}
