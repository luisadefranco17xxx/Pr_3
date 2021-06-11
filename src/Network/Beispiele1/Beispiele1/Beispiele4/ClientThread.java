package Network.Beispiele1.Beispiele1.Beispiele4;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClientThread implements  Runnable{

    private Socket connectionToClient;    //quando viene istanziata una Classe ClientThreat allora viene creato un Socet e

    public ClientThread(Socket connectionToClient){

        this.connectionToClient =connectionToClient;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Client Port" + connectionToClient.getPort());

        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            br=new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));// Kunde sproieck uber Telnet
            bw=new BufferedWriter(new OutputStreamWriter(connectionToClient.getOutputStream()));// Server Antwort zu Kunde

            bw.write("Hallo");
            bw.newLine();
            bw.flush();

            String command;
            while((command=br.readLine())!=null) {
                if ("TIME".equals(command)) {
                    Calendar cal = GregorianCalendar.getInstance();
                    bw.write(cal.get(Calendar.HOUR_OF_DAY) + " :" + cal.get(Calendar.MINUTE) + " :" + cal.get(Calendar.SECOND));
                    bw.newLine();
                    bw.flush();
                } else if ("PORT".equals(command)) {
                    bw.write("PORT: " + connectionToClient.getLocalPort());
                    bw.newLine();
                    bw.flush();
                } else if ("END".equals(command)) {
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write("unknow kommand");
                    bw.newLine();
                    bw.flush();
                }

            }
            br.close();
            bw.close();
        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println(" Beendet " );
    }
}
