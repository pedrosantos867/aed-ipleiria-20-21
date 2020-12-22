package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.util.Arrays;
import java.util.Random;

public class Maximo {
    public int executar(EstatisticaDeComparacoes estatisticaDeComparacoes, int... valores){
        if(valores.length == 0){
            throw new IllegalArgumentException("Numero de argumento inválido!");
        }

        int indiceMaximo = 0;

        //Começa no inice 1 porque não vale a pena comparar com o primeiro indice
        for (int i = 1; i < valores.length; i++) {
            estatisticaDeComparacoes.incrementarComparacoes();
            if(valores[i] > valores[indiceMaximo]){
                indiceMaximo = i;
            }
        }

        return valores[indiceMaximo];
    }

    public EstatisticaDeComparacoes getEstatisticaDeComparacoes(int... valores){
        try {
            EstatisticaDeComparacoes estatisticaDeComparacoes = new EstatisticaDeComparacoes(valores.length);
            int valorMaximo = executar(estatisticaDeComparacoes, valores);
            estatisticaDeComparacoes.parar();
            System.out.println(Arrays.toString(valores) +"\nMáximo(" + valorMaximo + ")" + "\nTamanho: " + valores.length);
            estatisticaDeComparacoes.apresentar();
            return estatisticaDeComparacoes;

        }catch(IllegalArgumentException exception){
            System.out.println(exception.getMessage() + "\n");
            return null;
        }
    }
}
