package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import java.util.NoSuchElementException;

public class Torre {
    private String nome;
    private int numeroDiscos;
    private int[] discos;

    public Torre(String nome, int tamanhoMaximo) {
        this.nome = nome;
        discos = new int[tamanhoMaximo + 1];
        discos[0] = tamanhoMaximo * 3;
        numeroDiscos = 0;
    }

    //Preecher torre com discos
    public void preencherComDiscos(){
        for (int i = 1; i < discos.length; i++) {
            discos[i] = discos.length - i;
        }
        numeroDiscos = discos.length -1;
    }

    //Tirar um disco da torre (o menor)
    public int tirarDisco(){
        if(numeroDiscos == 0){
            throw new NoSuchElementException("Não há discos para tirar da torre!");
        }
        int disco = discos[numeroDiscos];
        discos[numeroDiscos] = 0;
        numeroDiscos --;
        return disco;
    }

    //Colocar um disco (sobre um maior)
    public void colocarDisco(int disco){
        if(numeroDiscos == discos.length-1){
            throw new ArrayIndexOutOfBoundsException("Não há espaço para coclocar o disco!");
        }

        if (disco >= discos[numeroDiscos]){
            throw new IllegalArgumentException("O disco a colocar deve ser de meno tamanho!");
        }

        numeroDiscos ++;
        discos[numeroDiscos] = disco;
    }
}
