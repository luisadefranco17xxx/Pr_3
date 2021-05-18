package fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedReaderExampleExceptionHandling {
    public static void main(String[] args) {


        FileReader fileReader = null;


        try {
            fileReader = new FileReader("C:\\Luisa\\IdeaProjects\\Pr_3\\src\\fileio\\zuloeschen.txt");
            //fileReader = new FileReader("src\\fileio\\zuloeschen.txt");
            int i;
            while ((i = fileReader.read()) != -1)
                System.out.print((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
