package Modelo;

public class Supervisor {
    private String numSSN;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    public Supervisor(String numSSN, String nombre, String primerApellido, String segundoApellido) {
        this.numSSN = numSSN;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
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
}
