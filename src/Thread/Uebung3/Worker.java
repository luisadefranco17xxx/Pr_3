package Thread.Uebung3;


import java.util.Date;

public class Worker implements Runnable {
    private final int sleepIntervall = 1000; //msec
    private int count=0;
    private boolean isRunning = true;

    public void requestShutDown() {
        isRunning = false;
    }

    private static Object lock = new Object();

    @Override
    public void run() {

        while (isRunning && count < 20) {
            synchronized (lock) {
                count++;
                Date d = new Date();
                System.out.print("[");
                System.out.print(Thread.currentThread().getName() + " " + d.toString());
                System.out.print(", Counter: ");
                System.out.print(count);
                System.out.print("]");
                System.out.println();
            }
            try {
                Thread.sleep(sleepIntervall);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
