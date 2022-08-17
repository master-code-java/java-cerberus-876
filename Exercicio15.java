import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Exercicio15 {

    /**
     * Exercícios de streams
     * 1 - Com base na idade das pessoas, adicionar duas cadas decimais a idade
     * Dica: use bigDecimal
     *
     */


    public static void main(String[] args) {

        System.out.println(BancoDeDados.pegaPessoas()
                .stream()
                .mapToInt(Pessoa::getIdade)
                .mapToObj(BigDecimal::new)
                .map( value -> value.setScale(2,MathContext.DECIMAL128.getRoundingMode()))
                .collect(Collectors.toList()));

    }

}
