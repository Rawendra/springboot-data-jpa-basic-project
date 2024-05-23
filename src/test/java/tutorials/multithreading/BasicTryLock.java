package tutorials.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicTryLock {

    public static int counter = 0;
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> incrementCounter());

            t.start();

        }
        System.out.println("final value of " + counter);
    }

    private static void incrementCounter() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                try {

                    int c = counter;
                    System.out.println("Before: " + counter + "|thread-->" + Thread.currentThread().getId());
                    counter = c + 1;
                    System.out.println("After: " + counter + "|thread-->" + Thread.currentThread().getId());
                    System.out.println();
                } finally {
                    lock.unlock();
                }

            } else {
                System.out.println("the thread didn't get the lock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try{
//            lock.lock();
//            int c=counter;
//            System.out.println("Before: "+counter+"|thread-->"+Thread.currentThread().getId());
//            counter=c+1;
//            System.out.println("After: "+counter+"|thread-->"+Thread.currentThread().getId());
//            System.out.println();
//        }finally {
//            lock.unlock();
//        }


    }
}
