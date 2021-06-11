package Thread.Uhrzeit;

import java.util.Date;

public class DateClass implements  Runnable{

    private boolean isRunning = true;
    private static Object lock=new Object();

    public void requestShutDown() {
        isRunning = false;
    }

    @Override
    public void run() {
        //synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    if (isRunning) {
                        Date d = new Date();
                        System.out.println("T= " + Thread.currentThread().getName());
                        System.out.print("[");
                        System.out.print(d.toString());
                        System.out.print(", CPUS: ");
                        System.out.print(Runtime.getRuntime().availableProcessors());
                        System.out.print(", FreeMem: ");
                        System.out.print(Runtime.getRuntime().freeMemory());
                        System.out.print("]");
                        System.out.println();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                } }
        }
    }



