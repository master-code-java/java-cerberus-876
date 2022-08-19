import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Application implements Runnable {
    private static int test = 0;

    public static void main(String... args) throws InterruptedException, ExecutionException {
        /*
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread("Thread " + i) {
                @Override
                public void run() {
                    System.out.println(this.getName() + " está a correr");
                }
            });
        }
        threads.forEach(Thread::start);
        Runnable runnable = () -> {System.out.println("Runnable a correr");};
        Thread t = new Thread(runnable);
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
         */
/*
        Application app1 = new Application();
        Thread t = new Thread(app1);
        Application app2 = new Application();
        Thread t2 = new Thread(app2);
        System.out.println(test);
        t.start();
        t2.start();
        int j = 0;*/
        /*while (j < 10000) {
            System.out.println(j++);
        }*/
  /*      Thread.sleep(10000);
        t.join();
        t2.join();
        //while(t.isAlive())
        System.out.println(test);
*/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        /*for (int i = 0; i < 5; i++) {
            int j = i;
            list.add(CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread " + j + " rodando!");
                return "Olá da Thread " + j;
            }));
        }*/
        list
            .stream()
            .parallel().filter(s -> s % 2 == 0)
            .map((Integer i) -> CompletableFuture.supplyAsync(() -> "Olá da Thread " + i + ": " + Application.test++))
            .forEach(cf -> {
            try {
                System.out.println(cf.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
    @Override
    public void run() {
        Application.test++;
    }
}