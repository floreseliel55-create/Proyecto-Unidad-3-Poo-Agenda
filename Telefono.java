public class Telefono {
    //Agregué los atributos que se pedían de la clase - Carlos
    private char tipoTelefono;
    private String clavePais;
    private String numeroTelefonico;

    //Agregué el constructor - Carlos
    public Telefono (char tipoTelefono, String clavePais, String numeroTelefonico){

        this.tipoTelefono = Character.toUpperCase(tipoTelefono);
        this.clavePais = clavePais;
        this.numeroTelefonico = numeroTelefonico;
        
    }

    //Agregué los getters y setters - Carlos
    public char getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(char tipoTelefono) {
        this.tipoTelefono = Character.toUpperCase(tipoTelefono);
    }

    public String getClavePais() {
        return clavePais;
    }

    public void setClavePais(String clavePais) {
        this.clavePais = clavePais;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    //Metodo toString para representar el objeto - Carlos

        @Override
    public String toString() {
        
        return "Telefono [Tipo de télefono =" + tipoTelefono + ", clave país=" + clavePais + ", número telefónico=" + numeroTelefonico + "]";
    }
}
