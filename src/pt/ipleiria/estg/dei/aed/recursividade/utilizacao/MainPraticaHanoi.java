package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Hanoi;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadasEMovimentos;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;
import java.util.List;

public class MainPraticaHanoi {
    public MainPraticaHanoi(){
        Hanoi hanoi = new Hanoi();
        hanoi.getEstatisticasDeChamadasEMovimentos(5);
        /*
        LinkedList<Estatistica> estatisticas = new LinkedList<>();

        for (int i = 3; i < 16; i++) {
            estatisticas.add(hanoi.getEstatisticasDeChamadasEMovimentos(i));
        }

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();

        visualizadorEstatisticas.adicionarEstatisticas("Torres de Hanoi: ", estatisticas);
        visualizadorEstatisticas.visualizar();
         */
    }

    public static void main(String[] args) {
        new MainPraticaHanoi();
    }
}
