package pt.ipleiria.estg.dei.aed;

public enum ComparacaoLimiteInteirosAscendente implements ComparacaoLimite<Integer> {
    CRITERIO;

    private static final Integer LIMITE = Integer.MAX_VALUE;

    @Override
    public int comparar(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }

    @Override
    public Integer getLimite() {
        return LIMITE;
    }
}

