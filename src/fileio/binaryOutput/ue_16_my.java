package fileio.binaryOutput;

import java.io.*;

public class ue_16_my {
            /*
    Schreiben Sie ein Programm, das ein String- Objekt „Hallo Welt“ in eine Datei „object.dat“ serialisiert und anschließend aus dieser wieder ausliest und auf die Konsole schreibt.
    Verwenden Sie die Klassen FileOutputStream und ObjectOutputStream sowie FileInputStream und ObjectInputStream
    Verwenden Sie für das Schreiben die Methode writeObject(…), für das Lesen die Methode readObject(). Beim Lesen müssen Sie das Ergebnis in einen String casten
    Betrachten Sie die Datei in einem Editor (Notepad, Notepad++)
     */
            public static void main(String[] args) throws IOException, ClassNotFoundException {
                File file =new File("object.dat");
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                String s = "Hello World";
                byte[] b = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};

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
            }
}
