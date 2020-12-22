package pt.ipleiria.estg.dei.aed.modelo.pessoas;

public class Pessoa {
    private long BI;
    private String nome;

    public Pessoa(long BI, String nome){
        this.BI = BI;
        this.nome = nome;
    }

    public long getBI() {
        return BI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
