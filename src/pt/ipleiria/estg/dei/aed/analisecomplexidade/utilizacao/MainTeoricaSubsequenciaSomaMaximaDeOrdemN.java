package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaxima;
import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaximaDeOrdemN;

public class MainTeoricaSubsequenciaSomaMaximaDeOrdemN {

    public MainTeoricaSubsequenciaSomaMaximaDeOrdemN() {
        SubsequenciaSomaMaxima subsequenciaSomaMaxima = new SubsequenciaSomaMaximaDeOrdemN();
        subsequenciaSomaMaxima.getEstatistica(-2, 11, -4, 5, 7, -30, 13, 7, -5, 3);
    }

    public static void main(String[] args) {
        new MainTeoricaSubsequenciaSomaMaximaDeOrdemN();
    }
}
