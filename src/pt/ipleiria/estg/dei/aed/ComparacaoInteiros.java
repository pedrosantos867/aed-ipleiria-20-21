package pt.ipleiria.estg.dei.aed;

public enum ComparacaoInteiros implements Comparacao<Integer> {
    CRITERIO;

    @Override
    public int comparar(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
