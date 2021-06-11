package Thread.Uhrzeit;


import java.util.Date;

public class Main {

    public static void main(String[] args) {

        DateClass d1 =new DateClass();
        DateClass d2 =new DateClass();
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        System.out.println("Bitte drücken Sie eine Taste, um die die Threads zu Stoppen!");

        t1.start();
        t2.start();

        System.out.println(t1.getState());


        if (ConsoleHelper.readLine() != null) {
            d1.requestShutDown();
            System.out.println(t1.getState());
        }
        if (ConsoleHelper.readLine() != null) {
            d2.requestShutDown();
            System.out.println(t1.getState());
        }


        try {
            t1.join();
            t2.join();
            System.out.println(t1.getState());
            System.out.println(t2.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fertig");

    }
}