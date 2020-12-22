package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.QuickSort;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaRecursiva;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;

import java.util.Random;

public class MainPraticaPesquisaTernariaRecursiva {
    public MainPraticaPesquisaTernariaRecursiva(){
        PesquisaTernariaRecursiva<Integer> pesquisaTernariaRecursiva = new PesquisaTernariaRecursiva<>(ComparacaoInteiros.CRITERIO);
        Integer[] sequencia = VetorDeInteiros.criarAleatorioInteger(20, -10, 10, true);

        new QuickSort<>(ComparacaoInteiros.CRITERIO).getEstatistica(sequencia);

        for (int i = 0; i < sequencia.length; i++) {
            System.out.print(sequencia[i] + " ");
        }
        System.out.println("\n");

        int elemento = new Random().nextInt(21) - 10;
        pesquisaTernariaRecursiva.getEstatistica(elemento, sequencia);
    }

    public static void main(String[] args) {
        new MainPraticaPesquisaTernariaRecursiva();
    }
}
