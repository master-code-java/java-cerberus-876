import java.util.Optional;

public class MainOptional {
    private static String msg=null;

    public static void main(String[] args) throws Exception {

        System.out.println(sendSMS(msg));

        User thiago = new User("Thia", 37);

        User teste1 = finUserById(thiago)
                .orElseThrow(() -> new Exception("Usuário não encontrado!"));

        User teste2 = finUserById(thiago)
                .orElse(new User("Coringa", 50));

        finUserById(thiago)
                .ifPresent(user -> {
                    if(user.getName().equals("Thiago")){
                        System.out.println("Usuário existe");
                    }else{
                        System.out.println("Usuário não existe");
                    }
                });

        /**
         *  {
         *      "nomeProduto": "no value present"
         *
         *  }
         *
         *
         *  ProdutoController.pageProduto(
         *       Optional<Produto> ServiceProduto.pegaProduto(
         *          Optional<Produto>DaoProduto.pegaproduto(String id))
         *
         */

        Optional<User> user = finUserById(thiago);
        if(user.isPresent()){
            user.get();
        }
    }

    static String sendSMS(String texto){
        if(texto == null){
            return "";
        }
        return String.valueOf(texto.length());
    }

    static Optional<User> finUserById(User user){
        if(user.getName().equals("Thiago")){
            return Optional.of(new User("Thiago", 37));
        }
            return Optional.empty();
    }

}
