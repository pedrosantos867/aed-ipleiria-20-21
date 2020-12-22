package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadasEMovimentos;

import java.util.EmptyStackException;
import java.util.concurrent.ThreadPoolExecutor;

public class Hanoi {
    /* -- REGRAS --:
    • Mover apenas um disco de cada vez.
    • Um disco apenas se pode mover para cima de um disco maior.
    • Nenhum disco deverá ser movido para cima de um disco menos.
     */
    public void executarHanoi(EstatisticaDeChamadasEMovimentos estatisticaDeChamadasEMovimentos, int numeroDiscos, Torre torreOrigem, Torre torreAuxiliar, Torre torreDestino/*char torreOrigem, char torreAuxiliar, char torreDestino*/){
        if(numeroDiscos == 0){
            throw new IllegalArgumentException("Número de discos " + numeroDiscos + " inválido, deverá de ser maior que zero");
        }
        executarRecursivo(estatisticaDeChamadasEMovimentos, numeroDiscos, torreOrigem, torreAuxiliar, torreDestino);
    }

    private void executarRecursivo(EstatisticaDeChamadasEMovimentos estatisticaDeChamadasEMovimentos, int numeroDiscos, Torre torreOrigem, Torre torreAuxiliar, Torre torreDestino/*char torreOrigem, char torreAuxiliar, char torreDestino*/){
        estatisticaDeChamadasEMovimentos.incrementarChamadas();
        if(numeroDiscos == 1){
            estatisticaDeChamadasEMovimentos.incrementarMovimentos();
            //Colocamos na torre de destino o disco que fomos tirar à torre de origem
            torreDestino.colocarDisco(torreOrigem.tirarDisco());
            System.out.println("Mover disco 1 do pilar " + torreOrigem + " para o pilar " + torreDestino);
            return;
        }

        //Mover sub torre de n-1 discos da origem para auxiliar
        executarRecursivo(estatisticaDeChamadasEMovimentos, numeroDiscos-1, torreOrigem, torreDestino, torreAuxiliar);

        //System.out.println("Mover disco " + numeroDiscos + " do pilar " + torreOrigem + " para o pilar " + torreAuxiliar);
        //Mover a base (1 disco) da origem para o destino
        //executarRecursivo(estatisticaDeChamadasEMovimentos, numeroDiscos-1, torreOrigem, torreAuxiliar, torreDestino);

        estatisticaDeChamadasEMovimentos.incrementarMovimentos();
        //Mover sub torre de n-1 discos do auxiliar para distino
        executarRecursivo(estatisticaDeChamadasEMovimentos, numeroDiscos-1, torreAuxiliar, torreOrigem, torreDestino);
    }

    public EstatisticaDeChamadasEMovimentos getEstatisticasDeChamadasEMovimentos(int numeroDiscos){
        //Criar torres
        Torre torreA = new Torre("A", numeroDiscos);
        Torre torreB = new Torre("B", numeroDiscos);
        Torre torreC = new Torre("C", numeroDiscos);

        //Preencher torre de origem
        torreA.preencherComDiscos();

        EstatisticaDeChamadasEMovimentos estatisticaDeChamadasEMovimentos = new EstatisticaDeChamadasEMovimentos(numeroDiscos);
        executarHanoi(estatisticaDeChamadasEMovimentos, numeroDiscos, torreA, torreB, torreC/*'A', 'B', 'C'*/);
        estatisticaDeChamadasEMovimentos.parar();
        estatisticaDeChamadasEMovimentos.apresentar();
        return estatisticaDeChamadasEMovimentos;
    }
}
