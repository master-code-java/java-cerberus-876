import java.util.stream.Collectors;

public class Exercicio11 {

    /**
     * Exercícios de streams
     *  1 - Retornar a quantidade de pessoas em cada estado
     *
     */


    public static void main(String[] args) {

        System.out.println(BancoDeDados.pegaPessoas()
               .stream()
               .collect(Collectors.groupingBy(Pessoa::getUf, Collectors.counting())));

    }

}
