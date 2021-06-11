package fileio.ue_11_text;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> products=new ArrayList<>();


    public void add(Product p){
        products.add(p);

    }

    public void saveToFile(String path){
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (int i = 0; i < products.size(); i++) {
                bufferedWriter.write(products.get(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //bufferedReader.close();   //spostare qui
        }

    }

    public void readFromFile(String path){

        try {
            FileReader fileReader=new FileReader(new File(path));
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            String line;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println("line = " + line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            //bufferedReader.close();   //spostare qui
        }


    }
}
