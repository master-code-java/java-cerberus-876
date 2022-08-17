public class Exercicio3 {

    /**
     * Exercícios de streams
     * Imprimir as pessoas que possuam filhos
     *
     */


    public static void main(String[] args) {
        BancoDeDados.pegaPessoas()
                .stream()
                .filter(Pessoa::isTemFilhos)
                .forEach(System.out::println);

    }

}
