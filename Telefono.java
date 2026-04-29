// Carlos Eduardo Chairez Audelo

// Programación orientada a Objetos 
// Maria Lucia Barron Estrada
// Programa de la Agenda

// Clase Telefono con sus atributos, constructor, getters, setters y método toString.
public class Telefono {
    //Agregué los atributos que se pedían de la clase - Carlos
    private char tipoTelefono;
    private String clavePais;
    private String numeroTelefonico;
    //Agregué el constructor - Carlos
    public Telefono (char tipoTelefono, String clavePais, String numeroTelefonico){
        // quitar comprobaciones del constructor 
        if (clavePais == null || !clavePais.matches("\\+?\\d{2}")) {
            System.out.println("Clave de país inválida");
            return;
        }
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
        
        return "["+tipoTelefono + ", "+ clavePais +","+ numeroTelefonico + "]";
    }
}