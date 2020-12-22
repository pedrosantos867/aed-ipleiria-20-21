package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.*;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeIteracoes;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainTeoricaComparacaoSubsequenciaSomaMaxima {
    private static final int TAMANHO = 100;
    private static final int NUMERO_EXECUCOES = 10;

    public MainTeoricaComparacaoSubsequenciaSomaMaxima() {
        VisualizadorEstatisticas v = new VisualizadorEstatisticas();
//        v.adicionarEstatisticas("O(N3)", getEstatisticas(new SubsequenciaSomaMaximaDeOrdemN3()));
        v.adicionarEstatisticas("O(N2)", getEstatisticas(new SubsequenciaSomaMaximaDeOrdemN2()));
        v.adicionarEstatisticas("O(NLog2N)", getEstatisticas(new SubsequenciaSomaMaximaDeOrdemNLog2N()));
        v.adicionarEstatisticas("O(N)", getEstatisticas(new SubsequenciaSomaMaximaDeOrdemN()));

        v.visualizar();
    }

    public static void main(String[] args) {
        new MainTeoricaComparacaoSubsequenciaSomaMaxima();
    }

    private List<Estatistica> getEstatisticas(SubsequenciaSomaMaxima algoritmo) {
        List<Estatistica> estatisticas = new ArrayList<>();
        for (int i = 1; i <= NUMERO_EXECUCOES; i++) {
            EstatisticaDeIteracoes estatistica =
                    algoritmo.getEstatistica(VetorDeInteiros.criarAleatorioInt(TAMANHO * i, -TAMANHO * 10, TAMANHO * 10, false));
            estatisticas.add(estatistica);
        }
        return estatisticas;
    }

}
