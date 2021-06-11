package Network.Beispiele1.Beispiele1.Beispiele3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class UE_3_new {
    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

        try {
            socket = new Socket("time-a.timefreq.bldrdoc.gov", 13);

            // LESEN
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printWriter = new PrintWriter("content.html");
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
