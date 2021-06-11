package Network.Beispiele1.Beispiele1.Beispiele4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ListenToMultipleClients {
    // start via CommandLine: telnet localhost 9090
    public static void main(String[] args) throws IOException {
        System.out.println("Starte Server");
        Socket connectionToClient;    //ogli client riceve un Socket

        ServerSocket server;
        List<Thread> clients = new ArrayList<>();
        try {

            server = new ServerSocket(9090); // ich bin den Server
              //adesso sono pronto  sta veramente ascoltando dalla porta 9090
            //start via comandoline cmd: telnet localhost 9090
            server.setSoTimeout(30000);//in questo tempo é possibile creare nuove Verbindungen eltre no    Timeout 30secondi
            while (true) {
                try {
                    connectionToClient = server.accept();
                    //Thread implementiere um Sockeet parallel laufen zu lassen
                    Thread t = new Thread(new ClientThread(connectionToClient));  //Worker Classe
                    t.start();
                    clients.add(t);
                } catch (SocketTimeoutException e) {
                    System.out.println(" timeout ");
                    break;   // dora in poi nessun nuovo socket dolo posso andare avanti gli esistenti
                }
            }
            for (Thread t : clients)
                t.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


//        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  //comando fenster
//
//        bufferedWriter.write("Willkommen");  //questo compare sul shell
//        bufferedWriter.newLine();
//        bufferedWriter.flush();
//
//
//        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream())); // ich bin den Kunde e posso fare qualcosa
//        String command;
//        while ((command=bufferedReader.readLine())!=null) {   //io sto dicendo qualcosa al cliente non alla mia apppicazioe
//            System.out.println("command = " + command);     // ad esempio scrivo qui sul monitor di IntelliJ
//
//            if("TIME".equals(command)){
//                Calendar cal= GregorianCalendar.getInstance();
//                bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " :" + cal.get(Calendar.MINUTE)+" :"+cal.get(Calendar.SECOND));
//                bufferedWriter.newLine();
//                bufferedWriter.flush();
//            } else if("PORT".equals(command)){
//                bufferedWriter.write("PORT: "+socket.getLocalPort());
//            } else if("END".equals(command)){
//                bufferedWriter.newLine();
//                bufferedWriter.flush();
//                break;
//            } else {
//                bufferedWriter.write("unknow kommand");
//                bufferedWriter.flush();
//            }
//        }
//        System.out.println(" Beendet " );
//
//
//    }
    }
}