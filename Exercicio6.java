import java.util.Comparator;

public class Exercicio6 {

    /**
     * Exercícios de streams
     *  1 - Imprimir a lista ordenada pelo nome das pessoas
     *
     */


    public static void main(String[] args) {
        BancoDeDados.pegaPessoas()
                .stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);

    }

}
