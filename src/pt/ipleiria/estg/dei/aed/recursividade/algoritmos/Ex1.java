package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

public class Ex1 {
    public Ex1(int... numeros) {
        System.out.println("Exemplo n = " + numeros.length);

        for (int i = 1; i < numeros.length+1; i++) {
            for (int j = 1; j < numeros.length+1; j++) {
                System.out.print("(" + i + "," + j + "), ");
            }
            System.out.println("");
        }
    }

}
