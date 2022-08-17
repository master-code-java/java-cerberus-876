import java.util.stream.Collectors;

public class Exercicio10 {

    /**
     * Exercícios de streams
     *  1 - Retornar as pessoas agregadas por estado
     *
     */


    public static void main(String[] args) {

        System.out.println(BancoDeDados.pegaPessoas()
               .stream()
               .collect(Collectors.groupingBy(Pessoa::getUf)));

    }

}
