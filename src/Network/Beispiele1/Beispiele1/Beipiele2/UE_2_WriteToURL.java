package Network.Beispiele1.Beispiele1.Beipiele2;


import java.io.*;
        import java.net.URL;
        import java.net.URLConnection;

public class UE_2_WriteToURL
{
    public static void main(String[] args)
    {
        URL url;
        try
        {
            url = new URL("https://www.wetter.at");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            //conn.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

            bw.write("GET /wetter/oestfferreich/suedtirol/terlan HTTP/1.1");
            bw.newLine();
            bw.write("User-Agent: FIREJAVA");
            bw.newLine();
            bw.newLine();
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println(conn.getHeaderFields());
            PrintWriter pw = new PrintWriter("content.html");
            String line;
            while ((line = br.readLine()) != null)
            {
                pw.println(line);
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}