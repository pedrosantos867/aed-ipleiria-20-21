package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

public class PesquisaLinearEmSequenciaOrdenada<T> extends AlgoritmoPesquisa<T> {

    public PesquisaLinearEmSequenciaOrdenada(Comparacao<T> criterio) {
        super(criterio);
    }

    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        if (elementos.length == 0 ||
                criterio.comparar(elemento, elementos[elementos.length - 1]) > 0) {
            return NAO_ENCONTRADO;
        }
        for (int i = 0; i < elementos.length; i++) {
            estatistica.incrementarComparacoes();
            int cp = criterio.comparar(elemento, elementos[i]);
            if (cp < 0) {
                return NAO_ENCONTRADO;
            }
            estatistica.incrementarComparacoes();
            if (cp == 0) {
                return i;
            }
        }
        return NAO_ENCONTRADO;
    }
}
