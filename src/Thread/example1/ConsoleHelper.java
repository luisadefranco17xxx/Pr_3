package Thread.example1;


import java.util.Scanner;

public class ConsoleHelper {  //benutzer eingabe

    public static String readline() {
        // InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Scanner in =new Scanner(System.in);   // due modi equivalemti
        String s=in.nextLine();
        return s;

    }
}