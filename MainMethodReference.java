import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainMethodReference {

    public static void main(String[] args) {

        // Method Reference
        // Optional
        // Stream
            // métodos de entradas
            // métodos de transformação
            // métodos de saída


//        nomePrint( msg -> criaNome(msg));
//          nomePrint(Main::criaNome);


        nomePrint(MainMethodReference::criaNome, MainMethodReference::qualquerCoisa);

        // T -> T
        // T -> R
        // () -> T
        // T,R -> R
        // T - ()
        // T -> R

        filtraOrder(Collections.emptyList(), MainMethodReference::validData);
    }

    static boolean validData(String str){
        return str.length() > 3;
    }
    static void qualquerCoisa(String qualquerCoisaTambem){
        System.out.println(qualquerCoisaTambem +" qualquer coisa mesmo!!!!");
    }
    private static String criaNome(String msg) {
        return msg + "pedro";
    }

    static void nomePrint(NameMaker name, Printer printer){
        printer.print(name.generator("A mensagem: "));
    }

    static List<String> filtraOrder(List<String> order, Predicate<String> predicate){
        return order.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}

interface NameMaker{
    String generator(String msg);
}

interface Printer{
    void print(String value);
}