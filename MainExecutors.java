import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainExecutors {

    private static final String USER ="Cerberus";

    public static void main(String[] args) {


        /**
         *  Trazer os dados do usuário e o dados do perfil
         *  Dados do usuário - Banco de Dados (5000 ms)
         *  Dados do perfil - WebService (10000 ms)
         *
         */

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> t1 = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            return getUsuario(USER);
        });
        Future<String> t2 = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            return getProfile(USER);
        });
        try {

            System.out.println(t1.get()+" "+t2.get());

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
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
