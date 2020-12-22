package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeIteracoes;
import pt.ipleiria.estg.dei.aed.utils.Par;

public class SubsequenciaSomaMaximaDeOrdemN3 extends SubsequenciaSomaMaxima {

    @Override
    public long executar(EstatisticaDeIteracoes estatistica, Par<Integer, Integer> indicesInicialEFinal, int... elementos) {
        long somaMaxima = 0, somaAtual;
        int inicio = 0, fim = 0;
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] <= 0) {
               continue;
            }
            for (int j = i; j < elementos.length; j++) {
                if (elementos[j] <= 0) {
                  continue;
                }
                somaAtual = 0;
                for (int k = i; k <= j; k++) {
                    somaAtual += elementos[k];
                    estatistica.incrementarIteracoes();
                }
                if (somaAtual > somaMaxima) {
                    inicio = i;
                    fim = j;
                    somaMaxima = somaAtual;
                }
            }
        }
        indicesInicialEFinal.setPrimeiro(inicio);
        indicesInicialEFinal.setSegundo(fim);
        return somaMaxima;
    }
}
