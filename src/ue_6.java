

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ue_6 {

    public static void main(String[] args) {
        /*
        1. Create a directory with 10 files in a folder
        2. Create a method, which renames all 10 files (only files and not directories!) within the folder
            2.1 for example: test.txt to 1_test.txt
                2.1.1 for the new file name - concatinate a string with .getParent(), seperator + getName()
                2.1.2 use renameTo() method
                2.1.3 Check if the rename was a success (via if) and print the according message to the console
         */

        String fileSeparator = System.getProperty("file.separator");
        File source = new File("C:" + fileSeparator + "test_ZULOESCHEN" );
        create_files(source);
        //rename_files(source);
        delete_files(source);
    }
    public static void create_files(File source) {

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            try {
                File file = new File( source.getPath()+"\\"+ random.nextInt() + ".txt");
                file.createNewFile();
                System.out.println("file " + file.getAbsolutePath() + " created");
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
    }

    public static void rename_files(File source) {
      if(source.isDirectory()){
          for (File file: source.listFiles()
               ) {
              String path="C:"+"\\"+"test_ZULOESCHEN"+"\\"+ "1_"+file.getName(); //getParent() altra possibilita
              //System.out.println("path = " + path);
              File newFile=new File(path);
              System.out.println("alt File  "+file+" in the new file "+newFile.getName()+" hat funktioniert: " + file.renameTo(newFile));
          }
      }else{
          System.out.println("source soll eine directory sein");
      }
    }

    public static void delete_files(File source) {
        if (source.isDirectory()) {
            for (File file : source.listFiles()
            ) {
                System.out.println("Ich werde die Datei = " + file + " löschen.");
                file.delete();
            }
        }
    }
}