package fileio.binarInput;


import java.io.BufferedInputStream;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;

public class ue_13_buffered_reader {
    /*
    Java BufferedInputStream class is used to read information from stream. It internally uses buffer mechanism to make the performance fast.
    The important points about BufferedInputStream are:
    When the bytes from the stream are skipped or read, the internal buffer automatically refilled from the contained input stream, many bytes at a time.
    When a BufferedInputStream is created, an internal buffer array is created.
    BufferedInputStream is buffered, but FileInputStream is not.
    A BufferedInputStream reads from another InputStream, but a FileInputStream reads from a file1.
     */

    /*
    TODO:
    Schreiben Sie ein Programm, welches von einer Datei alle Zeichen einfließt und auf der Konsole ausgibt. (Effizient!)
    Zählen Sie die Anzahl der eingelesenen Zeichen und geben Sie die Gesamtanzahl am Ende aus.
     */

    public static void main(String[] args) throws IOException {
        // Repräsentiert eine Datei auf dem Dateisystem
        File file = new File("campus02-test.txt");

        // FileInputStream stellt eine Verbindung zur Datei her. Datei wird geöffnet.
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        // read() liefert Byte for Byte aus der Datei. Wenn das Ende erreicht ist, dann liefert die Methode -1 als Ergebnis.
        // While-Schleife liest somit Zeichen um Zeichen aus.
        int byteRead;
        // character -> Damit man die Anzahl der Zeichen zählen kann
        int character = 0;

        while ((byteRead = bufferedInputStream.read()) != -1) {
            System.out.println((char) byteRead);
            character++;
        }

        // Ausgabe Anzahl der Zeichen, nachdem  die Datei vollständig durchgesehen wurde.
        System.out.println(character);
        // close() gibt die Datei wieder frei.
        fileInputStream.close();
        bufferedInputStream.close();
    }

}