package fileio.ue17_binary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagerB {
    private ArrayList<ProductB> productBS=new ArrayList<>();

    public void add(ProductB p) {
        productBS.add(p);
    }

    public void saveToFile(String path)  {
        File file =new File(path);
        FileOutputStream fileOutputStream= null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (ProductB pB: productBS
            ) {
                objectOutputStream.writeObject(pB);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.flush();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void readFromFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<ProductB> productList = new ArrayList<>();

        // boolean keepReading = true;
        try {
            while (true) {
                Object object = objectInputStream.readObject();
                ProductB p = (ProductB) object;
                productList.add(p);
                System.out.println(p);
            }
        } catch (EOFException e) {
            System.out.println("End of File reached.");
            // keepReading = false;
        } finally {
            objectInputStream.close();
        }
        System.out.println("Read Object data: ");
        System.out.println(productList);
    }
//    public void readFromFile(String path)  {          //versione mia
//        File file=new File(path);
//
//        try {
//            FileInputStream   fileInputStream = new FileInputStream(file);
//            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
//            List<ProductB> productBList=new ArrayList<>();
//            boolean keepReading=true;
//            int charI;
//            //charI=(int)objectInputStream.readObject();
//            while (keepReading) {
//                Object object;
//                try {
//                    while ((object = objectInputStream.readObject()) != null) {
//                        ProductB p = (ProductB) object;
//                        System.out.println("Object= " + object);
//                    }
//                    fileInputStream.close();
//                    objectInputStream.close();
//                } catch (EOFException e){  //fine del file raggiunta
//                    //e.printStackTrace();
//                    keepReading=false;
//                }
//            }
//        } catch (ClassNotFoundException| IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
