package fileio.binaryOutput;

import java.io.*;

public class ue_15 {

        /*
    Java FileOutputStream is an output stream used for writing data to a file.
    If you have to write primitive values into a file,
    use FileOutputStream class. You can write byte-oriented as
    well as character-oriented data through FileOutputStream class.
    But, for character-oriented data, it is preferred to use FileWriter
    than FileOutputStream.
     */

    public static void main(String[] args) throws IOException {
        File file =new File("test-output.txt");

        FileOutputStream fileOutputStream =new FileOutputStream(file);

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int c;

        while ((c=bufferedReader.read()) != -1) {

            if(c=='x') break;
            fileOutputStream.write(c);
        }
        bufferedReader.close();
        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
