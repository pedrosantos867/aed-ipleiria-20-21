package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.Pontos;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

public class MainPraticaPontos {
    public MainPraticaPontos(){
        Pontos pontos = new Pontos();

        LinkedList<Estatistica> estatisticaDeComparacoes = new LinkedList<>();

        for (int i = 3; i < 21; i+=3) {
            estatisticaDeComparacoes.add(pontos.getEstatistica(i));
        }

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();
        visualizadorEstatisticas.adicionarEstatisticas("Pontos:", estatisticaDeComparacoes);
        visualizadorEstatisticas.visualizar();

        /*
        System.out.println("Pontos mais proximos => " + pontosMaisProximos.getPrimeiro() + ", " + pontosMaisProximos.getSegundo());
        System.out.println("Distancia: " + pontosMaisProximos.getPrimeiro().distance(pontosMaisProximos.getSegundo()));
        */
    }
    public static void main(String[] args) {
        new MainPraticaPontos();
    }
}
