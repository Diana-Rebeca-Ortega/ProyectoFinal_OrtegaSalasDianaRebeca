package Modelo;

public class MedicoCabecera {
    private String ID_Medico;
    private  String  ID_Paciente;

    public MedicoCabecera(String ID_Medico, String ID_Paciente) {
        this.ID_Medico = ID_Medico;
        this.ID_Paciente = ID_Paciente;
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
}
