package pt.ipleiria.estg.dei.aed;

public interface ComparacaoLimite<T> extends Comparacao<T> {

    // Define o limite do critério de comparação
    T getLimite();

    // Verifica se o elemento elem respeita o critério de comparação limite
    default boolean isElementoValido(T elem) {
        return elem != null && comparar(elem, getLimite()) < 0;
    }
}
