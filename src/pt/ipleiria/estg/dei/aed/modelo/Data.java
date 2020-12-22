package pt.ipleiria.estg.dei.aed.modelo;

import java.util.Objects;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int compareTo(Data data){
        int comparacao = Integer.compare(this.ano, data.ano);

        if(comparacao != 0){
            return comparacao;
        }
        //se os anos são iguais, comparamos por mês

        comparacao = Integer.compare(this.mes, data.mes);

        if(comparacao != 0){
            return comparacao;
        }

        //se os meses são iguais comparamos por dia
        return Integer.compare(this.dia, data.dia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return dia == data.dia &&
                mes == data.mes &&
                ano == data.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, ano);
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
