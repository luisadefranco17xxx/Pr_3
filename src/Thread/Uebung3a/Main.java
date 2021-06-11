package Thread.Uebung3a;



public class Main {
    public static void main(String[] args) {
        Worker w1=new Worker();
        Thread th1=new Thread(w1);
        Thread th2 =new Thread(w1);

        th1.start();
        th2.start();
        ConsoleHelper consoleHelper =new ConsoleHelper(w1);
        Thread th3 =new Thread(consoleHelper);
        th3.start();

        try {
            th1.join();
            th2.join();
            System.out.println(" Fertig mit Counter");
        } catch (Exception e){
            e.printStackTrace();
        }


        try {
            th3.interrupt();
            System.out.println("  Interrupt by User");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
