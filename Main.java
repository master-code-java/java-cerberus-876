public class Main {

    public static void main(String[] args) {
        /**
         *  Trazer os dados do usuário e o dados do perfil
         *  Dados do usuário - Banco de Dados (5000 ms)
         *  Dados do perfil - WebService (10000 ms)
         *
         */

        /*
              Thread main
                    vai no banco de dados 5
                    volta
                    vai no web service 10
                    volta
                    concatena o resultado
                    imprime na tela

         */

        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName());

        try{

            String user =  getUsuario("Cerberus");
            String profile = getProfile("Cerberus");

            System.out.println(user +" "+ profile);

        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }finally {
            long end = System.currentTimeMillis();
            System.out.println((end-start)/1000 +"s time elapsed.");
        }

    }

    private static String getUsuario(String user) throws InterruptedException {
        Thread.sleep(5000);
        return "USER: Cerberus - 876";
    }

    private static String getProfile(String user) throws InterruptedException {
        Thread.sleep(10000);
        return "PROFILE: admin";
    }

}
