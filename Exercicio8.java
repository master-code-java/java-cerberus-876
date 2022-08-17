public class Exercicio8 {

    /**
     * Exercícios de streams
     *  1 - Verificar se a pessoa abaixo existe na Lista
     *
     *  dao.Pessoa thiago = new dao.Pessoa("Thiago", 37, dao.UF.SP, true, 1);
     *
     */


    public static void main(String[] args) {

        Pessoa resultWebService = new Pessoa("Thiago", 37, UF.SP, true, 1);

        System.out.println(BancoDeDados.pegaPessoas()
                .stream()
                .anyMatch(pessoa -> pessoa.equals(resultWebService)));

    }

}
