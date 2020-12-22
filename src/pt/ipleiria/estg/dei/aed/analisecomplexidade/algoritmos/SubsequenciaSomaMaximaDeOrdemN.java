package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeIteracoes;
import pt.ipleiria.estg.dei.aed.utils.Par;

public class SubsequenciaSomaMaximaDeOrdemN extends SubsequenciaSomaMaxima {

    @Override
    public long executar(EstatisticaDeIteracoes estatistica, Par<Integer, Integer> indicesInicialEFinal, int... elementos) {
        long somaMaxima = 0, somaAtual = 0;
        int inicio = 0, fim = 0, inicioAtual = 0;
        for (int j = 0; j < elementos.length; j++) {
            somaAtual += elementos[j];
            if (somaAtual < 0) { // se o primeiro número for negativo, descarta-se e o inicio atual passa para um número positivo
                inicioAtual = j + 1;
                somaAtual = 0;
            } else if (somaAtual > somaMaxima) {
                fim = j;
                inicio = inicioAtual;
                somaMaxima = somaAtual;
            }
            estatistica.incrementarIteracoes();
        }
        indicesInicialEFinal.setPrimeiro(inicio);
        indicesInicialEFinal.setSegundo(fim);
        return somaMaxima;
    }
}
