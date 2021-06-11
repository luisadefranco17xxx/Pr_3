package Thread.Uebung3a;

public class Worker implements Runnable{
        private final int sleepInterval=1000;
        private int count =0;
        private static Object lock=new Object();

    private String input = null;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        synchronized (lock){    //in dieser Fall fängt der zweite Prozess an wenn der erster fertig ist
            while(count<21) {
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName()+ " count++ = " + count++);

                try{
                    // i due processi venono lternarsi regolarmente
                    System.out.println("T= " + Thread.currentThread().getName());
                    Thread.sleep(sleepInterval);
                    lock.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                lock.notifyAll();
                if (input!=null){
                    break;
                }
            }

        }
    }
}
