package fileio;
import java.io.*;

public class BufferedReaderExampleCharByChar {

    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Luisa\\IdeaProjects\\Pr_3\\src\\fileio\\zuloeschen.txt"));

            int c;
            while ((c = bufferedReader.read()) != -1) {
                char character = (char) c;
                System.out.println(c + " - " + character);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found " );
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
   }
}