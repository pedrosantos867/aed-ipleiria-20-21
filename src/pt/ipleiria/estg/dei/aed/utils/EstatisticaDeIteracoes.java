package pt.ipleiria.estg.dei.aed.utils;

public class EstatisticaDeIteracoes extends Estatistica {

    public EstatisticaDeIteracoes(int tamanho) {
        super(tamanho, "Número de Iterações");
    }

    public void incrementarIteracoes() {
        incrementarContador(0);
    }

    public long getIteracoes() {
        return getContador(0);
    }
}
