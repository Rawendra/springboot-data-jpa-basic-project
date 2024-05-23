package tutorials.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class BasicExecutor {

    public static int counter = 0;
    public static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static Future<Double> getRandom(int i) {
        return executorService.submit(() -> {
            Thread.sleep(1000);
            System.out.println(i + " | Thread id: " + Thread.currentThread().getId());
            return Math.random();
        });
    }

    public static void runSomeTask(List<Callable<Integer>> callables) throws InterruptedException {
        System.out.println( executorService.invokeAll(callables));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
          Future<Double> result=  getRandom(i);
          if(result.isDone()){
              System.out.println("printing in future: "+result);
          }
        }


        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);
        callables.add(() -> 3);
        try {
            System.out.println("****************************************************");
            runSomeTask(callables);
        } catch (Exception e) {
            System.out.println(e);

        }
executorService.shutdown();

    }


}
