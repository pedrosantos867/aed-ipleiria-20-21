package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.QuickSort;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;
import pt.ipleiria.estg.dei.aed.utils.Vetor;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;

import java.util.Arrays;

public class MainPraticaPesquisaTernariaIterativa {
    public MainPraticaPesquisaTernariaIterativa(){
        PesquisaTernariaIterativa<Integer> pesquisaTernariaIterativa = new PesquisaTernariaIterativa<>(ComparacaoInteiros.CRITERIO);

        Integer[] sequencia = VetorDeInteiros.criarAleatorioInteger(20, -10, 10, false);
        new QuickSort<Integer>(ComparacaoInteiros.CRITERIO).getEstatistica(sequencia);


        for (int i = 0; i < sequencia.length; i++) {
            System.out.print(sequencia[i] + " ");
        }
        System.out.println("\n");

        pesquisaTernariaIterativa.getEstatistica(3, sequencia);
    }

    public static void main(String[] args) {
        new MainPraticaPesquisaTernariaIterativa();
    }
}
