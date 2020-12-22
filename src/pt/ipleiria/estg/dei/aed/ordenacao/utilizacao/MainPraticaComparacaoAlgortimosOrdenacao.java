package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.io.ContactosIO;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.BubbleSortOtimizado;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.QuickSort;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.SelectionSort;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparadoresContactosPorPrimeiroNome;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainPraticaComparacaoAlgortimosOrdenacao {
    public MainPraticaComparacaoAlgortimosOrdenacao(){
        Contacto[] contactos = {};
        contactos = ContactosIO.lerContactos("C:\\AED_Base\\src\\pt\\ipleiria\\estg\\dei\\aed\\utils\\dados_contactos_50000.csv");

        //Estatisticas
        List<Estatistica> estatisticasInsertionSort = new LinkedList<>();
        List<Estatistica> estatisticasSelectionSort = new LinkedList<>();
        List<Estatistica> estatisticasBubbleSort = new LinkedList<>();
        List<Estatistica> estatisticasQuickSort = new LinkedList<>();

        Comparacao<Contacto> comparacao = ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente.CRITERIO;

        InsertionSort<Contacto> insertionSort = new InsertionSort<>(comparacao);
        SelectionSort<Contacto> selectionSort = new SelectionSort<>(comparacao);
        BubbleSortOtimizado<Contacto> bubbleSortOtimizado = new BubbleSortOtimizado<>(comparacao);
        QuickSort<Contacto> quickSort = new QuickSort<>(comparacao);

        for (int i = 10; i <1001; i+=10) {
            estatisticasInsertionSort.add(insertionSort.getEstatistica(Arrays.copyOf(contactos, i)));
            estatisticasSelectionSort.add(selectionSort.getEstatistica(Arrays.copyOf(contactos, i)));
            estatisticasBubbleSort.add(bubbleSortOtimizado.getEstatistica(Arrays.copyOf(contactos, i)));
            estatisticasQuickSort.add(quickSort.getEstatistica(Arrays.copyOf(contactos, i)));
        }
        
        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();
        visualizadorEstatisticas.adicionarEstatisticas("Insertion Sort", estatisticasInsertionSort);
        visualizadorEstatisticas.adicionarEstatisticas("Selection Sort", estatisticasSelectionSort);
        visualizadorEstatisticas.adicionarEstatisticas("Bubble Sort", estatisticasBubbleSort);
        visualizadorEstatisticas.adicionarEstatisticas("Quick Sort", estatisticasQuickSort);

        //Mostrar gráficos
        visualizadorEstatisticas.visualizar();
    }

    public static void main(String[] args){
        new MainPraticaComparacaoAlgortimosOrdenacao();
    }
}
