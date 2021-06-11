package Thread.Uebung_Schluss;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {

    private String path;
    public ArrayList<String > lines;
    private int count=0;

    public FileReadWorker(String name, String path) {
        super(name);
        this.path = path;
        lines=new ArrayList<>();
    }

    public void work() throws IOException, InterruptedException {
        printStarted();
        FileReader fr=new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String tempLine;
        while((tempLine=br.readLine())!=null) {
           if (!shouldRun) {break;}
           lines.add(tempLine);
           System.out.println("Es ist geladet"+lines);
           Thread.sleep(100);
        }
        br.close();
        printStopped();
        return;
    }



    @Override
    public void run() {
        try {
            work();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hllo00, ich bin :"+Thread.currentThread().getName());
    }
}
