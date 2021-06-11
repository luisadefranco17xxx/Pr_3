package Network.Beispiele1.Beispiele1.Beispiele3;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class UE_3 {
    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        PrintWriter printWriter2 = null;

        try {
            socket = new Socket("www.acoela.myspecies.info", 80);

            // SCHREIBEN
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("GET /en HTTP/1.1");
            bufferedWriter.newLine(); // -> sonst eine Zeile
            bufferedWriter.write("Host: www.acoela.myspecies.info");
            bufferedWriter.newLine(); // newline wird 2 mal benötigt!
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // LESEN
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printWriter = new PrintWriter("content.html");
            printWriter2 = new PrintWriter("header.html");
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                printWriter.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null)
                    printWriter.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
