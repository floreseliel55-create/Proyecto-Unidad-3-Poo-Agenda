// Carlos Eduardo Chairez Audelo

// Programación orientada a Objetos 
// Maria Lucia Barron Estrada
// Programa de la Agenda

import java.util.regex.Pattern;

public class Telefono {
    //Agregué los atributos que se pedían de la clase - Carlos
    private char tipoTelefono;
    private String clavePais;
    private String numeroTelefonico;
    // Expresion regular para validar el formato del número telefónico
    private static final Pattern regexTelefono = Pattern.compile("^\\d{10}$");
    // Expresion regular para validar el formato de la clave de país
    private static final Pattern regexClavePais = Pattern.compile("^\\+?\\d{2}$");
    // Expresion regular para validar el tipo de teléfono
    private static final Pattern regexTipoTelefono = Pattern.compile("^[MF]$");

    //Agregué el constructor - Carlos
    public Telefono (char tipoTelefono, String clavePais, String numeroTelefonico){
        // quitar comprobaciones del constructor 
        setTipoTelefono(tipoTelefono);
        setClavePais(clavePais);
        setNumeroTelefonico(numeroTelefonico);
    }

    //Agregué los getters y setters - Carlos
    public char getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(char tipoTelefono) {
        if (regexTipoTelefono.matcher(String.valueOf(tipoTelefono)).matches()) {
            this.tipoTelefono = Character.toUpperCase(tipoTelefono);
        } else {
            throw new IllegalArgumentException("Tipo de teléfono inválido. Debe ser 'M' o 'F'.");
        }
    }

    public String getClavePais() {
        return clavePais;
    }

    public void setClavePais(String clavePais) {
        if (regexClavePais.matcher(clavePais).matches()) {
            this.clavePais = clavePais;
        } else {
            throw new IllegalArgumentException("Clave de país inválida. Debe tener el formato '+XX' o 'XX'.");
        }
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        if (regexTelefono.matcher(numeroTelefonico).matches()) {
            this.numeroTelefonico = numeroTelefonico;
        } else {
            throw new IllegalArgumentException("Número telefónico inválido. Debe tener 10 dígitos.");
        }
    }
    //Metodo toString para representar el objeto - Carlos

        @Override
    public String toString() {
        
        return "[" + tipoTelefono + "," + clavePais + "," + numeroTelefonico + "]";
    }
}
