import java.util.function.Predicate;

public class Exercicio4 {

    /**
     * Exercícios de streams
     * Contar as pessoas que possuam filhos
     *
     */


    public static void main(String[] args) {
        System.out.println(BancoDeDados.pegaPessoas()
                .stream()
                .filter(Pessoa::isTemFilhos)
                .map(Pessoa::getFilhos)
                .reduce(0, Integer::sum));
    }

}
