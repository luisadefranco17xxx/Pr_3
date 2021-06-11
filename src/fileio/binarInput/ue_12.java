package fileio.binarInput;

import javax.imageio.IIOException;
import java.io.*;

public class ue_12 {
    public static void main(String[] args) throws IOException {
        File file =new File("test-output.txt");

        FileInputStream fileInputStream=new FileInputStream(file);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);

        int byteRead;

        while((byteRead = bufferedInputStream.read()) !=-1){   //leafert byte for Byte aus der datei, sono abbligata a leggere carattere per carattere
            char[] ch =Character.toChars(byteRead);
            System.out.println("ch = " + ch);
            System.out.println((char)byteRead);   // questo e´sufficiente
        }
        fileInputStream.close();
    }
}
