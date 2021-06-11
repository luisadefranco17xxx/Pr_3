package Thread.Uebung3a;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ConsoleHelper implements Runnable{
    Worker worker;

    public ConsoleHelper(Worker worker) {
        this.worker = worker;
    }

    public static String readLine() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void run() {
        System.out.println("Drücken Sie eine Taste um zu stoppen ...");
        String input;
        if ((input = ConsoleHelper.readLine()) != null) {
            worker.setInput(input);
        }
    }
}