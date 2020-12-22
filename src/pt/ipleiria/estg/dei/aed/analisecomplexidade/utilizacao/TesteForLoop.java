package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

public class TesteForLoop {
    public TesteForLoop(){
        int[] valores = new int[4];
        int numeroDeComparacoes = 0;

        for (int i = 0; i < valores.length; i++){
            valores[i] = i;
        }

        for (int i = 0; i < valores.length+1; i++){
            for (int j = i + 1; j < valores.length +1; j++){
                //System.out.println("i => " + i + "\tj => " + j);
                System.out.println(i + ", " + j);
                numeroDeComparacoes ++;
            }
        }
        System.out.println("\nN= " + valores.length);
        System.out.println("Número de comparações= " + numeroDeComparacoes);
    }
    public static void main(String[] args) {
        new TesteForLoop();
    }
}
