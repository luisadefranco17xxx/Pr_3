package fileio.binaryOutput;
import java.io.*;

public class ue_16 {
        /*
    Schreiben Sie ein Programm, das ein String- Objekt „Hallo Welt“ in eine Datei „object.dat“ serialisiert und anschließend aus dieser wieder ausliest und auf die Konsole schreibt.
    Verwenden Sie die Klassen FileOutputStream und ObjectOutputStream sowie FileInputStream und ObjectInputStream
    Verwenden Sie für das Schreiben die Methode writeObject(…), für das Lesen die Methode readObject(). Beim Lesen müssen Sie das Ergebnis in einen String casten
    Betrachten Sie die Datei in einem Editor (Notepad, Notepad++)
     */

    public static void main(String[] args) {

        String s = "Hello World";
        byte[] b = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};

        try {
            // create a new file with an ObjectOutputStream
            //File file = new File("text.txt");
            File file = new File("object.dat");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // write something in the file
            objectOutputStream.writeObject(s);
            objectOutputStream.writeObject(b);
            objectOutputStream.flush();
            objectOutputStream.close();

            // create an ObjectInputStream for the file we created before
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            // read and print an object and cast it as string
            System.out.println("" + (String) ois.readObject());

            // read and print an object and cast it as string
            byte[] read = (byte[]) ois.readObject();
            String s2 = new String(read);
            System.out.println("" + s2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

/*
FileInputStream fis = new FileInputStream("outputFile");
ArrayList<Object> objectsList = new ArrayList<>();
boolean cont = true;
while (cont) {
  try (ObjectInputStream input = new ObjectInputStream(fis)) {
    Object obj = input.readObject();
    if (obj != null) {
      objectsList.add(obj);
    } else {
      cont = false;
    }
  } catch (Exception e) {
    // System.out.println(e.printStackTrace());
  }
}
 */

