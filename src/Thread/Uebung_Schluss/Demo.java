package Thread.Uebung_Schluss;

public class Demo {
    public static void main(String[] args) {
        TimePrintWorker tp=new TimePrintWorker("Spampa");
        FileReadWorker  fr=new FileReadWorker("Leggi","content.html");

        Thread   th1=new Thread(tp);
        Thread   th2=new Thread(fr);

        th1.start();
        th2.start();

        try {
            th2.join();
            tp.stopWorker();   //thread1.intterrupt
            th1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
