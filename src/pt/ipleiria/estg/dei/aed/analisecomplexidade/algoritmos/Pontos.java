package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.Par;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;
import java.awt.geom.Point2D;

public class Pontos {
    public Par<Point2D, Point2D> executar(EstatisticaDeComparacoes estatisticaDeComparacoes, int tamanho){
        Point2D[] pontos = VetorDePoint2D.criarAleatorio(tamanho);
        System.out.println("**DEBUG** Tamanho= " + pontos.length);

        for (int i = 0; i < pontos.length; i++) {
            //System.out.println("Ponto: " + i + " => X: " + pontos[i].getX() + "\tY: " + pontos[i].getY());
        }

        if(pontos.length < 2){
            throw new IllegalArgumentException("Numero de pontos inálido, no mínimo sáo necessários dois pontos");
        }

        if(pontos.length == 2){
            return new Par<>(pontos[0], pontos[1]);
        }

        Par<Point2D, Point2D> pontosMaisProximos = new Par<>(pontos[0], pontos[1]);
        double differencaEntrePontosMinima = pontos[0].distance(pontos[1]);

        for (int i = 0; i < pontos.length-1; i++) {
            for (int j = i+1; j < pontos.length; j++) {
                //System.out.println("["+ i + ", " + j + "]");
                estatisticaDeComparacoes.incrementarComparacoes();
                if(Double.compare(pontos[i].distanceSq(pontos[j]), differencaEntrePontosMinima) < 0){ //alterar valores para a diferença minima
                    differencaEntrePontosMinima = pontos[i].distanceSq(pontos[j]);
                    pontosMaisProximos.setPrimeiro(pontos[i]);
                    pontosMaisProximos.setSegundo(pontos[j]);
                    //System.out.println("Pontos mais proximos atualmente => " + pontosMaisProximos.getPrimeiro() + ", " + pontosMaisProximos.getSegundo());
                    System.out.println("Dist. min. atual= " + (int)pontosMaisProximos.getPrimeiro().distance(pontosMaisProximos.getSegundo()));
                }
            }
        }

        return pontosMaisProximos;
    }

    public EstatisticaDeComparacoes getEstatistica(int tamanho){
        EstatisticaDeComparacoes estatisticaDeComparacoes =  new EstatisticaDeComparacoes(tamanho);

        Par<Point2D, Point2D> pontosMaisProximos = executar(estatisticaDeComparacoes, tamanho);

        System.out.println("Tamanho:" + tamanho);
        System.out.println("Pontos mais proximos => " + "[" + pontosMaisProximos.getPrimeiro().getY() + ", "
                + pontosMaisProximos.getPrimeiro().getX() + "]" + " -> " + "[" + pontosMaisProximos.getSegundo().getX() +
                ", " + pontosMaisProximos.getSegundo().getY() + "]");
        System.out.println("Distância= " + pontosMaisProximos.getPrimeiro().distance(pontosMaisProximos.getSegundo()));
        estatisticaDeComparacoes.parar();
        estatisticaDeComparacoes.apresentar();
        System.out.println("--------------------------------------------------------------");
        return estatisticaDeComparacoes;
    }
}
