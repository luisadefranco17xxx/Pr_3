package fileio.ue17_binary;

import java.io.IOException;

public class mainB {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductManagerB pB=new ProductManagerB();


        pB.add(new ProductB("Hefe", 0.1, "Frische"));
        pB.add(new ProductB("Milch", 1.9, "Frische"));
        pB.add(new ProductB("Käse", 1.9, "Frische"));
        pB.add(new ProductB("Toilettenpapier", 0.9, "Home"));
        pB.add(new ProductB("Seife", 1.9, "Home"));
        pB.add(new ProductB("Wurst", 1.9, "Fleisch"));

        String path = "e11_toloeschen.txt";
        pB.saveToFile(path);
        pB.readFromFile(path);
    }
}




