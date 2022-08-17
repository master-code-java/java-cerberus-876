import java.util.stream.Collectors;

public class Exercicio12 {

    /**
     * Exercícios de streams
     * 1 - Retornar a média de filhos em cada estado
     */


    public static void main(String[] args) {

        System.out.println(BancoDeDados.pegaPessoas()
                .stream()
                .filter(Pessoa::isTemFilhos)
                .collect(Collectors.groupingBy(Pessoa::getUf, Collectors.averagingInt(Pessoa::getFilhos))));

    }

}
