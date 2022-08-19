import java.util.concurrent.*;

public class MainCompletable {

    private static final String USER ="Cerberus";

    public static void main(String[] args) {

        /**
         *  Trazer os dados do usuário e o dados do perfil
         *  Dados do usuário - Banco de Dados (5000 ms)
         *  Dados do perfil - WebService (10000 ms)
         *
         */

        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        CompletableFuture<String> user = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return getUsuario("Cerberus");
        });

        CompletableFuture<String> profile = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return getProfile("Cerberus");
        });

        try {
            System.out.println(user.get(1000, TimeUnit.HOURS)+" "+profile.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException("TIMEOUT ERROR!!!!");
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
