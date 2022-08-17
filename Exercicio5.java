public class Exercicio5 {

    /**
     * Exercícios de streams
     *  1 - Verificar se existem pessoas sem filhos e com a quantidade de filhos > 0
     *
     */


    public static void main(String[] args) {
        System.out.println((long) (int) BancoDeDados.pegaPessoas()
                .stream()
                .filter(Exercicio5::isValid)
                .count());

    }

    private static boolean isValid(Pessoa pessoa) {
        return !pessoa.isTemFilhos() && pessoa.getFilhos() > 0;
    }

}
