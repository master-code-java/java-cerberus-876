import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercicio14 {

    /**
     * Exercícios de streams
     * 1 - Extrair uma lista dos estados existentes no banco de dados.
     * 2 - Imprimir a lista na mesma stream
     * 3 - Ordernar a lista por orderm alfabetica
     *
     */


    public static void main(String[] args) {


        System.out.println(BancoDeDados.pegaPessoas()
                .stream()
                .map(Pessoa::getUf)
                .collect(Collectors.toList())
                .stream()
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparing(Enum::name))
                .collect(Collectors.toList()));

    }

}
