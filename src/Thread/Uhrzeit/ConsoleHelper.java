package Thread.Uhrzeit;
import java.util.Scanner;

public class ConsoleHelper {
    public static String readLine() {
        // InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }
}