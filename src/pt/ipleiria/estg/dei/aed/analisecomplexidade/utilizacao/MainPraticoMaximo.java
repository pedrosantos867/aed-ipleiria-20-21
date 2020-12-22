package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.Maximo;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;
import java.util.Random;

public class MainPraticoMaximo {
    public MainPraticoMaximo(){
        Maximo maximo = new Maximo();

        //seedAleatoria = false => Vai gerar sempre o mesmo conjunto de numeros, útil para quando se está
        //a fazer a comparação dos algoritmos, para desta forma ser o mais equitivo possível
        //b)
        //EstatisticaDeComparacoes estatisticaDeComparacoes = maximo.getEstatisticaDeComparacoes(VetorDeInteiros.criarAleatorioInt(200,-50, 50, false));

        //c)

        LinkedList<Estatistica> listaDeEstatisticas = new LinkedList<>();

        for (int i = 10; i < 510; i+=10) {
            listaDeEstatisticas.add(maximo.getEstatisticaDeComparacoes(VetorDeInteiros.criarAleatorioInt(i, true)));
        }

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();
        visualizadorEstatisticas.adicionarEstatisticas("Maximo: ", listaDeEstatisticas);
        visualizadorEstatisticas.visualizar();

        //d) O numero de comparações para n = 15 é de 14 porque o primeiro elemento nunca é compradado com ele próprio


    }
    public static void main(String[] args) {
        new MainPraticoMaximo();
    }
}
