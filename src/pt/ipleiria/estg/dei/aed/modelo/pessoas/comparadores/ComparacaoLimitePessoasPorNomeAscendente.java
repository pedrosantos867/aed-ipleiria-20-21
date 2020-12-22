package pt.ipleiria.estg.dei.aed.modelo.pessoas.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;

public enum ComparacaoLimitePessoasPorNomeAscendente implements ComparacaoLimite<Pessoa> {
    CRITERIO;

    private static final Pessoa LIMITE = new Pessoa(0, String.valueOf(Character.MAX_VALUE));

    @Override
    public int comparar(Pessoa o1, Pessoa o2) {
        return ComparacaoPessoasPorNomeAscendente.CRITERIO.comparar(o1, o2);
    }

    @Override
    public Pessoa getLimite() {
        return LIMITE;
    }
}
