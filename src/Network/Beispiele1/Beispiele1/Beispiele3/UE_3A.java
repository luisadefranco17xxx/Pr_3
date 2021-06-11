package Network.Beispiele1.Beispiele1.Beispiele3;



import java.net.*;


import java.io.*;
        import java.net.Socket;
        import java.net.UnknownHostException;
public class UE_3A {
    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        PrintWriter printWriter2 = null;

//        URL url=null;



        try {


//            url = new URL("www.acoela.myspecies.info");
//            URLConnection conn = url.openConnection();
//            conn.setDoOutput(true);
//            //conn.getOutputStream();
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//            bw.write("GET /en HTTP/1.1");
//            bw.newLine();
//            bw.write("Host: www.acoela.myspecies.info");
//            bw.newLine();
//            bw.newLine();
//            bw.flush();
//            conn.getHeaderFields();
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            System.out.println(" PROVAAAAAA= " );
//            System.out.println(conn.getHeaderFields());



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
                if(line.startsWith("<!DOCTYPE"))  {
                    break;
                }
                else {
                    printWriter2.println(line);
                    printWriter2.flush();
                }

            }
//            do ((line = bufferedReader.readLine()) != null) {
//                if(line.startsWith("<!DOCTYPE"))  {
//                    //break;
//                }
//                else {
//                    printWriter2.println(line);
//                }
//
//            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) {

                    printWriter.close();}
                if(printWriter2!=null)  {

                    printWriter2.close();}
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
