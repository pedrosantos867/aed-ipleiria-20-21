package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Factorial;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;

public class MainPraticaFactorial {
    public MainPraticaFactorial(){
        Factorial factorial = new Factorial();

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();

        ArrayList<Estatistica> listaDeEstatisticas = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            listaDeEstatisticas.add(factorial.getEstatisticaDeChamadas(i));
        }
        //Adicionar as estatisticas ao visualizador de estatisticas
        visualizadorEstatisticas.adicionarEstatisticas("Factorial",listaDeEstatisticas);
        visualizadorEstatisticas.visualizar();
    }

    //Shortcut: main + ctrl + Tab
    public static void main(String[] args) {
        new MainPraticaFactorial();
    }
}
