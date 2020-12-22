package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.modelo.Data;

import java.util.Objects;

public class Contacto {
    private String primeiroNome;
    private String ultimoNome;
    private long numeroTelefone;
    private String morada;
    private Data dataNascimento;

    public Contacto(String primeiroNome, String ultimoNome, long numeroTelefone, String morada, Data dataNascimento) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
    }

    public long getNumeroTelefone(){
        return numeroTelefone;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getMorada() {
        return morada;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto contacto = (Contacto) o;
        return numeroTelefone == contacto.numeroTelefone &&
                Objects.equals(primeiroNome, contacto.primeiroNome) &&
                Objects.equals(ultimoNome, contacto.ultimoNome) &&
                Objects.equals(morada, contacto.morada) &&
                Objects.equals(dataNascimento, contacto.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeiroNome, ultimoNome, numeroTelefone, morada, dataNascimento);
    }

    @Override
    public String toString() {
        return primeiroNome + " " + ultimoNome + " - Nº " + numeroTelefone + " - " + dataNascimento + " - " + morada + "\n";
    }
}
