
import java.io.File;
import java.io.IOException;

public class creation_of_files {

    public static void main(String[] args) {

        File file= new File("campus02-text.txt");  //this file is never created

        String fileSeparator = System.getProperty("file.separator" );
        System.out.println("fileSeparator = " + fileSeparator);


        File file2= new File("C:"+fileSeparator+"prova"+fileSeparator+"andere-text.txt");   //aktung Path: C:/prova/andere-text.txt
        File file3=new File ("C:\\Users\\Luisa\\IdeaProjects\\Pr_3\\probe_zu_loschen.txt");
        try{
            if(file2.createNewFile()){
                System.out.println("file2.getAbsolutePath()+\"filename\"+file2.getName() = "
                        + file2.getAbsolutePath()+" filename="+file2.getName());
                System.out.println("file2.getPath() = " + file2.getPath());
            }else{
                System.out.println("File2 existiert nicht den Ordner oder die Detei existeiert schon" );
            }
        }catch(IOException e){
            e.printStackTrace();
        }


        try{
            if(file3.createNewFile()){
                System.out.println("file2.getAbsolutePath()+\"filename\"+file2.getName() = "
                        + file3.getAbsolutePath()+"filename"+file3.getName());
                System.out.println("file3.getPath() = " + file3.getPath());
            }else{
                System.out.println("File3 existiert nicht den Ordner oder die Detei existeiert schon\" " );
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
