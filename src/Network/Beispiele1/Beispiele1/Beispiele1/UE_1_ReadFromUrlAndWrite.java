package Network.Beispiele1.Beispiele1.Beispiele1;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class UE_1_ReadFromUrlAndWrite {
    public static void main(String[] args) {
        // -> 80 -> Redirect -> 443 -> Antwort
        // -> https://www.google.at ; https://www.wetter.at
        try {
            // USER INPUT
            System.out.println("Bitte gewünschte URL angeben: ");
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String user_url = userInput.readLine();
            System.out.println("URL : " + user_url);

            // URL AUSLESEN
            URL url = new URL(user_url);
            // openStream() -> Opens a connection to this URL and returns an InputStream for reading from that connection.
            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //new
            File file=new File ("Luisa_prova.txt");
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);


            // Process INPUT
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
                //fileWriter.write(input);
                bufferedWriter.write(input);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}