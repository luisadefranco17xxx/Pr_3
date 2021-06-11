package Thread.Uebung_Schluss;

import java.util.Date;

public class TimePrintWorker extends Worker implements Runnable {

    private static Object lock=new Object();

    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    protected void work() {
        printStarted();
        while (shouldRun) {
                try {
                    Date d = new Date();
                    System.out.println("d.toString() = " + d.toString());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        printStopped();
    }

    @Override
    public void run() {
        work();
    }
}
