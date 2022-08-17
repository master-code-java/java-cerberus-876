import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BancoDeDados {

   public static List<Pessoa> pegaPessoas(){
       return Stream.of(new Pessoa("Thiago", 37, UF.SP, true, 1),
                        new Pessoa("João alves", 40, UF.RJ, false, 0),
                        new Pessoa("Tereza May", 15, UF.MG, false, 0),
                        new Pessoa("João Feliciano Souza", 14, UF.DF, false, 0),
                        new Pessoa("Marcos de alves", 50, UF.SP, true, 2),
                        new Pessoa("Amelia Nunes", 30, UF.DF, true, 1),
                        new Pessoa("Juliana Barbosa", 25, UF.MG, true, 5),
                        new Pessoa("Heloisa Rosa Antunes", 12, UF.SP, false, 0))
                .collect(Collectors.toList());
    };
}
