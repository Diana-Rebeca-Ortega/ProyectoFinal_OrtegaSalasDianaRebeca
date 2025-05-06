package Modelo;


import Vista.VentanaInicio;
    public class Medico {
        private String numSSN;
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String especialidad;
        private byte añosExperiencia;

        public VentanaInicio abcc_datos_pantalla = new VentanaInicio();

        public Medico(String numSSN, String nombre, String primerApellido, String segundoApellido, String especialidad, byte añosExperiencia) {
            this.numSSN = numSSN;
            this.nombre = nombre;
            this.primerApellido = primerApellido;
            this.segundoApellido = segundoApellido;
            this.especialidad = especialidad;
            this.añosExperiencia = añosExperiencia;
        }
        /// AQUI DE POJO'S

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

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        public byte getAñosExperiencia() {
            return añosExperiencia;
        }

        public void setAñosExperiencia(byte añosExperiencia) {
            this.añosExperiencia = añosExperiencia;
        }
    }