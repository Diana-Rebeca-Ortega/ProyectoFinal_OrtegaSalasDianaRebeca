package Modelo;

public class Paciente {
    private String numSSN;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private byte Edad;
    private String Calle;
    private String Colonia;
    private String No_Casa;
    private String CP;

    public Paciente(String numSSN, String nombre, String primerApellido,
                    String segundoApellido, byte edad, String calle,
                    String colonia, String no_Casa, String CP) {
        this.numSSN = numSSN;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        Edad = edad;
        Calle = calle;
        Colonia = colonia;
        No_Casa = no_Casa;
        this.CP = CP;
    }

    public String getNumSSN() {
        return numSSN;
    }

    public void setNumSSN(String numSSN) {
        this.numSSN = numSSN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public byte getEdad() {
        return Edad;
    }

    public void setEdad(byte edad) {
        Edad = edad;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String colonia) {
        Colonia = colonia;
    }

    public String getNo_Casa() {
        return No_Casa;
    }

    public void setNo_Casa(String no_Casa) {
        No_Casa = no_Casa;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }
}
