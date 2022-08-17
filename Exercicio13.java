import java.util.Map;
import java.util.stream.Collectors;

public class Exercicio13 {

    /**
     * Exercícios de streams
     * 1 - Retornar o estado com mais filhos
     * 2 - Imprimir a seguinte mensagem, interpolando as chaves pelos resultados encontrados
     *      "O estado com mais filhos é: [NOME_DO_ESTADO] o total de filhos são: [TOTAL_DE_FILHOS]
     */


    public static void main(String[] args) {


        BancoDeDados.pegaPessoas()
                .stream()
                .filter(Pessoa::isTemFilhos)
                .collect(Collectors.groupingBy(Pessoa::getUf, Collectors.summingInt(Pessoa::getFilhos)))
                .entrySet()
                        .stream()
                        .sorted(Map.Entry.<UF,Integer>comparingByValue().reversed())
                        .limit(1)
                        .findFirst()
                        .ifPresent(result -> System.out.println("O estado com mais filhos é:" + result.getKey() + "o total de filhos são: " + result.getValue()));


    }

}
