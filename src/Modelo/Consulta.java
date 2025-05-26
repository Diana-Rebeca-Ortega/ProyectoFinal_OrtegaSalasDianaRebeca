package Modelo;

public class Consulta {
   private String ID_Consulta;
   private String ID_Paciente;
   private String ID_Medico;
   private String morivo;
   private String FechaHora;

    public Consulta(String ID_Consulta, String ID_Paciente, String ID_Medico, String morivo, String fechaHora) {
        this.ID_Consulta = ID_Consulta;
        this.ID_Paciente = ID_Paciente;
        this.ID_Medico = ID_Medico;
        this.morivo = morivo;
        FechaHora = fechaHora;
    }

    public String getID_Consulta() {
        return ID_Consulta;
    }

    public void setID_Consulta(String ID_Consulta) {
        this.ID_Consulta = ID_Consulta;
    }

    public String getID_Paciente() {
        return ID_Paciente;
    }

    public void setID_Paciente(String ID_Paciente) {
        this.ID_Paciente = ID_Paciente;
    }

    public String getID_Medico() {
        return ID_Medico;
    }

    public void setID_Medico(String ID_Medico) {
        this.ID_Medico = ID_Medico;
    }

    public String getMorivo() {
        return morivo;
    }

    public void setMorivo(String morivo) {
        this.morivo = morivo;
    }

    public String getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(String fechaHora) {
        FechaHora = fechaHora;
    }
}
