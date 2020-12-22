package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaxima;
import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaximaDeOrdemN3;

public class MainTeoricaSubsequenciaSomaMaximaDeOrdemN3 {

   public MainTeoricaSubsequenciaSomaMaximaDeOrdemN3() {
      SubsequenciaSomaMaxima subsequenciaSomaMaxima = new SubsequenciaSomaMaximaDeOrdemN3();
      subsequenciaSomaMaxima.getEstatistica(-2, 11, -4, 5, 7, -3, 13, 7, -5, 3);
   }

   public static void main(String[] args) {
      new MainTeoricaSubsequenciaSomaMaximaDeOrdemN3();
   }
}
