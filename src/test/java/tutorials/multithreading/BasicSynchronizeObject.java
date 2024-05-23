package tutorials.multithreading;

public class BasicSynchronizeObject {

    public static int counter = 0;
    private static  Object lock=new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> incrementCounter());

            t.start();

        }
        System.out.println("final value of "+counter);
    }

    private  static void incrementCounter() {

        synchronized (lock){
            int c=counter;
            System.out.println("Before: "+counter+"|thread-->"+Thread.currentThread().getId());
            counter=c+1;
            System.out.println("After: "+counter+"|thread-->"+Thread.currentThread().getId());

        }


    }
}
