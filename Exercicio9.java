import java.util.Comparator;
import java.util.stream.Collectors;

public class Exercicio9 {

    /**
     * Exercícios de streams
     *  1 - retornar uma lista com nome das três pessoas mais velhas
     *  2 - Imprimir a lista
     *
     */


    public static void main(String[] args) {

        System.out.println(BancoDeDados.pegaPessoas()
                .stream()
                .sorted(Comparator.comparingInt(Pessoa::getIdade).reversed())
                .limit(3)
                .map(Pessoa::getNome)
                .collect(Collectors.toList()));

    }

}
