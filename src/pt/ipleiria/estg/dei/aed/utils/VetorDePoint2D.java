package pt.ipleiria.estg.dei.aed.utils;

import java.awt.geom.Point2D;
import java.util.Date;
import java.util.Random;

public class VetorDePoint2D {
    public static Point2D[] criarAleatorio(int tamanho) {
        Point2D[] resultado = new Point2D[tamanho];
        long time  = new Date().getTime();
        Random rnd = new Random(time);
        System.out.println("**DEBUG** Seed: " + time);
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = new Point2D.Double(rnd.nextInt(10000), rnd.nextInt(10000));
        }
        return resultado;
    }
}
