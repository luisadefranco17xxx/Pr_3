



import java.io.File;

    public class ue_5 {

        public static void main(String[] args) {
        /*
        Tip: use mkdirs()
        Write a method (it should take a parameter FILE to work with, which create a directory like, "C:\\campus02\\test\\demo4"
            - it also should be checked, if the given File is a file or a Directory. + the console messages need to have the information whether it was created or not.
                -> IF Yes: Directory C:\campus02\test\demo4  created?: false
                -> IF No: Directory C:\campus02\test\demo4  created?: true
        Question: What is the difference Between mkdirs() and mkdir() ?
        Question: What does mkdirs() return?
        Question: What does mkdir() return?
         */

            File dir = new File("C:\\test_ZULOESCHEN\\loeschen\\FILE_TOLOESCHEN.txt");
            File dir2 = new File("C:\\test_ZULOESCHEN2");
            createDirectories(dir);
            createDirectory(dir2);
        }

        public static void createDirectories(File f) {
          if (f.isDirectory()) {
              System.out.println("Der Ordner " + f +" existiert schon");
          } else {
              System.out.println(" provo a creare directories, funktioniert?= " + f.mkdirs());
          }
        }

        public static void createDirectory(File f) {
            if (f.isDirectory()) {
                System.out.println("Der Ordner " + f +" existiert schon");
            } else {
                System.out.println(" provo a creare directory, funktioniert?= " + f.mkdir());
            }
        }

    }

