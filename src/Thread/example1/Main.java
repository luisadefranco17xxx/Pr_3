package Thread.example1;

public class Main {
    public static void main(String[] args) {
        Worker worker1=new Worker("A");
        Worker worker2=new Worker("B");

        Thread t1=new Thread(worker1);
        Thread t2=new Thread(worker2);

        System.out.println(" premi tasto= " );

        t1.start();
        t2.start();

        if(ConsoleHelper.readline()  !=null) {
            worker1.requestShutDown();
            System.out.println("t1 = " + t1.getState());
            System.out.println("t2 = " + t2.getState());

        }
        if(ConsoleHelper.readline()  !=null) {
            worker2.requestShutDown();
            System.out.println("t1 = " + t1.getState());
            System.out.println("t2 = " + t2.getState());

        }

        try {
            t1.join();
            t2.join();
            System.out.println("t1r.getState() = " + t1.getState());
            System.out.println("t2.getState() = " + t2.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fertig");
    }


}
