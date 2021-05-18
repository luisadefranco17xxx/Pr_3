package fileio.ue_11_text;

import java.io.IOException;

public class main {
        /*
    1. Schreiben Sie eine Klasse Product zur Abbildung von Produkten mit folgenden Attributen.
        String ProductName
        Double Price
        String ProductCategory
        (+ Methoden: Getter / Setter / toString() / Constructor)
    2. Schreiben Sie eine Klasse ProductManager zum Verwalten von Produkten in einer privaten
     Liste und implementieren Sie folgende Methoden
        2.1 public void add(Product p) ➔ fügt ein Produkt zur Liste hinzu
        2.2 public void saveToFile(String path) ➔ speichert die Produkte in der übergebenen Datei. -
            Realisieren Sie dies mittels BufferedWriter und Filewriter.
        2.3 public void readFromFile(String path) ➔ laden Sie den Text von der
        übergebenen Datei und geben Sie den Text auf der Konsole aus.
     */

    public static void main(String[] args) throws IOException {
      ProductManager pm=new ProductManager();
        pm.add(new Product("Hefe",0.1,"Frische"));
        pm.add(new Product("Milch",1.9,"Frische"));
        pm.add(new Product("Käse",1.9,"Frische"));
      pm.add(new Product("Toilettenpapier",0.9,"Home"));
      pm.add(new Product("Seife",1.9,"Home"));
      pm.add(new Product("Wurst",1.9,"Fleisch"));

      String path="e11_toloeschen.txt";
      pm.saveToFile(path);
      pm.readFromFile(path);
    }

}
