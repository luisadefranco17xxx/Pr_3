package fileio;


import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReaderExample  {
        /*
        Java FileReader class is used to read data from the file.
        It returns data in byte format like FileInputStream class.
        It is character-oriented class which is used for file handling in java.
     */
        public static void main(String[] args) throws IOException {
           // BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\Luisa\\IdeaProjects\\Pr_3\\src\\fileio\\zuloeschen.txt"));

            FileReader fileReader = new FileReader("C:\\Users\\Luisa\\IdeaProjects\\Pr_3\\src\\fileio\\zuloeschen.txt");

            int i;
            // read() returns -1 = end of file = -1
            while ((i = fileReader.read()) != -1)
                System.out.print((char) i);
            fileReader.close();

            //zweite Probe
            FileReader fileReader2 = new FileReader("zuloeschen2.txt", StandardCharsets.ISO_8859_1);  //standard ist UTF_8

            while ((i = fileReader2.read()) != -1)
                System.out.print((char) i);
            fileReader2.close();

        }
}

