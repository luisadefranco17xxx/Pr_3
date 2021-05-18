package fileio;
import java.io.*;
import java.util.Scanner;
//oder u8

public class ue_read_system_input {
    /*
    Schreiben Sie ein Programm, das zeilenweise Tastatureingaben auf die Konsole schreibt, bis das Wort „STOP“ eingegeben wird.
    Verwenden Sie dazu den InputStream System.in
    Verwenden Sie weiters die Klassen: InputStreamReader und BufferedReader
     */

    public static void main(String[] args) throws IOException{             //die schmutziger Lösung, besser wäre try catch
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("line = " + line);
            if (line.equals("STOP")) break;
        }
        bufferedReader.close();
    }

}