package fileio;

import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Luisa\\IdeaProjects\\Pr_3\\src\\fileio\\zuloeschen.txt");
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("line = " + line);
        }
        bufferedReader.close();
    }
}
