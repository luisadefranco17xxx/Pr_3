package Thread.Uebung3;


public class Main {
    public static void main(String[] args) {

        Worker w1 = new Worker();
        Worker w2 = new Worker();
        Thread t1 = new Thread(w1);
        //Thread t2 = new Thread(w2);
        Thread t2 = new Thread(w1);   // in diesem Fall die zwei Threads arbeiten abwechseln, und "count" geht von 1 bis 20 (abwechseln gerechnet
                                                                              // von dem ersten oder von dem zweitem Prozess  )
        t1.start();
        t2.start();

        System.out.println("Drücken Sie eine Taste um zu stoppen ...");
        if (ConsoleHelper.readLine() != null) {
            w1.requestShutDown();
        }
        if (ConsoleHelper.readLine() != null) {
            w2.requestShutDown();
        }

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Fertig!");
    }
}