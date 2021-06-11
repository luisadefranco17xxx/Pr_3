package Network.Beispiele1.Beispiele1.Beispiele4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ListenToClient {
    // start via CommandLine: telnet localhost 9090
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket=new ServerSocket(9090); // ich bin den Server
        Socket socket=serverSocket.accept();   //adesso sono pronto  sta veramente ascoltando dalla porta 9090
        //start via comandoline cmd: telnet localhost 9090
        serverSocket.setSoTimeout(100000);//se

        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  //comando fenster
        
        bufferedWriter.write("HALLO");  //questo compare sul shell
        bufferedWriter.newLine();
        bufferedWriter.flush();


        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream())); // ich bin den Kunde e posso fare qualcosa
        String command;
        while ((command=bufferedReader.readLine())!=null) {   //io sto dicendo qualcosa al cliente non alla mia apppicazioe
            System.out.println("command = " + command);     // ad esempio scrivo qui sul monitor di IntelliJ

            if("TIME".equals(command)){
                Calendar cal=GregorianCalendar.getInstance();
                bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else if("PORT".equals(command)){
                bufferedWriter.write("PORT: "+socket.getLocalPort());
            } else if("END".equals(command)){
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break;
            } else {
                bufferedWriter.write("unknow kommand");
                bufferedWriter.flush();
            }
        }
        System.out.println(" Beendet " );
            

    }
}
