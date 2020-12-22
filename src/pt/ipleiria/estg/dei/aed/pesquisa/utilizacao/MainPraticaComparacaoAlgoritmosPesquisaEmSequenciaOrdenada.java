package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.QuickSort;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaRecursiva;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainPraticaComparacaoAlgoritmosPesquisaEmSequenciaOrdenada {
    public MainPraticaComparacaoAlgoritmosPesquisaEmSequenciaOrdenada(){
        PesquisaTernariaIterativa pesquisaTernariaIterativa = new PesquisaTernariaIterativa(ComparacaoInteiros.CRITERIO);
        PesquisaTernariaRecursiva pesquisaTernariaRecursiva = new PesquisaTernariaRecursiva(ComparacaoInteiros.CRITERIO);
        List<Estatistica> estatisticasIterativa = new ArrayList<>();
        List<Estatistica> estatisticasRecursivo = new ArrayList<>();

        for (int i = 10; i < 201; i+=10) {
            Integer[] sequencia = VetorDeInteiros.criarAleatorioInteger(i, -i, i, true);
            QuickSort<Integer> quickSort = new QuickSort<>(ComparacaoInteiros.CRITERIO);

            quickSort.ordenar(new EstatisticaDeComparacoesETrocas(i), sequencia);

            estatisticasIterativa.add(pesquisaTernariaIterativa.getEstatistica(sequencia.clone()));
            estatisticasRecursivo.add(pesquisaTernariaRecursiva.getEstatistica(sequencia.clone()));
        }

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();
        visualizadorEstatisticas.adicionarEstatisticas("Pesquisa Ternária Iterativa", estatisticasIterativa);
        visualizadorEstatisticas.adicionarEstatisticas("Pesquisa Ternária Recursiva", estatisticasRecursivo);

        visualizadorEstatisticas.visualizar();
    }
    
    public static void main(String[] args) {
        new MainPraticaComparacaoAlgoritmosPesquisaEmSequenciaOrdenada();
    }
}
