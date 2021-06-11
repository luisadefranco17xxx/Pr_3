import java.io.File;
import java.io.IOException;


public class ue_1 {

    public static void main(String[] args) {

        File file= new File("campus02-text2.txt");

        String fileSeparator = System.getProperty("file.separator" );
        System.out.println("fileSeparator = " + fileSeparator);

        //File file2= new File("C:"+fileSeparator+"Benutzer"+fileSeparator+"Desktop"+fileSeparator+"andere-text.txt");
        File file2= new File("C:"+fileSeparator+"prova"+fileSeparator+"andere-text.txt");
        File file3=new File ("C:\\Users\\Luisa\\IdeaProjects\\Pr_3\\probe_zu_loschen.txt");
        File file4=new File ("C:/Users/Luisa/IdeaProjects/Pr_3/files/probe_zu_loschen2.txt");

        printInformations(file);
        printInformations(file2);
        printInformations(file3);
        //printInformations(file4);

        //File dir ="C:\\Users\\Public";
        File file5 = new File("C:\\Users\\Luisa\\Documents\\documenti ufficiali\\loeschen.txt");
        //printls(dir.getPath());
        String path = "C:\\Users\\Luisa\\Documents\\documenti ufficiali\\";
        printInformations(new File(path));
        printls(path);

        //printls2(file5.getAbsolutePath());
        printls2(file5);
    }

    public static void printInformations(File file) {
        System.out.println("file.isFile() = " + file.isFile());
        try{
            if(file.createNewFile()){
                System.out.println("file2.getAbsolutePath()+\"filename\"+file2.getName() = "
                        + file.getAbsolutePath()+";  filename: "+file.getName());
                System.out.println("file.getParent()"+file.getParent());
                System.out.println("file.getPath() = " + file.getPath());
                System.out.println("file.toString() = " + file.toString());
                System.out.println("file.isDirectory() = " +file.isDirectory());
                System.out.println("file.canRead() = " + file.canRead());
                System.out.println("file.canWrite() = " + file.canWrite());
                System.out.println("file.length() = " + file.length());

            }else{
                System.out.println("die Detei existeiert schon" );
                System.out.println("file.getParent()"+file.getParent());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void printls(String myPath){
        File file = new File(myPath);
        File[] paths;

        try {
                    // returns pathnames for files and directory
                    paths = file.listFiles();
                    //paths = file.list();
                    // for each pathname in pathname array
                    for(File path:paths) {
                        // prints file and directory paths
                        //System.out.println(path);
                        if(path.isDirectory()){
                            System.out.println("DIR:"+path);

                            //TODO qui chiamata ricorsiva
                            printls(path.toString());
                        }else {
                            System.out.println("FILE:"+path);
                        }
                    }

                } catch(Exception e) {
                    // if any error occurs
                    e.printStackTrace();
                }
    }

    public static void printls2(File file){
//        ACHTUNG:
//        Tipp:
//        The list() method returns the names of all files in the given directory in the form of a String array.
//        The ListFiles() method returns the objects (File) of the files in the given directory, in the form of an array of type File.
        String[] paths;

        try {
            // returns pathnames for files and directory
            paths = file.list();
            if (paths!=null) {   //zu unterbreaken die recursive loop
                System.out.println("paths" + paths);
                //paths = file.list();
                // for each pathname in pathname array
                for (String path : paths) {
                    // prints file and directory paths
                    System.out.println(path);  //recursive
                }
            }
        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }
}