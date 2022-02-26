import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tasks.add(() -> {
                int count = 0;
                for (int j = 0; j < 3; j++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.printf("I'm %s. Hello everybody!\n", Thread.currentThread().getName());
                    count++;
                }
                return count;
            });
        }

        threadPool.invokeAll(tasks);

        System.out.println(threadPool.invokeAny(tasks));

        threadPool.shutdown();
    }
}