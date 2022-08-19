public class MainThreads {

    private static final String USER ="Cerberus";
    private static volatile String userResponse;
    private static volatile String userProfile;

    public static void main(String[] args) {


        /**
         *  Trazer os dados do usuário e o dados do perfil
         *  Dados do usuário - Banco de Dados (5000 ms)
         *  Dados do perfil - WebService (10000 ms)
         *
         */

        long start = System.currentTimeMillis();

        Thread threadGetUsuario = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "- getUserDatabase");
            userResponse = getUsuario(USER);
        });
        Thread threadGetProfile = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "- getProfileWebService");

            userProfile = getProfile(USER);
        });

        threadGetUsuario.start();
        threadGetProfile.start();

        try {
//            threadGetUsuario.join(1000);
            threadGetProfile.join(5500);

            System.out.println(userResponse +" "+ userProfile);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            long end = System.currentTimeMillis();
            System.out.println((end-start)/1000 +"s time elapsed.");
        }

    }

    private static String getUsuario(String user) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "USER: Cerberus - 876";
    }

    private static String getProfile(String user) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "PROFILE: admin";
    }

}
