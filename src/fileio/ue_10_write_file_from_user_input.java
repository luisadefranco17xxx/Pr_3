package fileio;


import java.io.*;

public class ue_10_write_file_from_user_input {
    /*
     Schreiben Sie ein Programm, das Ihre Noten aus allen Fächern im ersten Semester von der Konsole einliest und anschließend als „.txt“- Datei speichert.
     Z.B.: PR1: 1 Englisch: 1 •
     Die Eingabe endet, wenn das Wort „STOP“ eingegeben wird.
     Verwenden Sie die Klassen BufferedReader, InputStreamReader und FileWriter.
     */

    public static void main(String[] args)  {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter("Text_zuloeschen.txt");
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

            String line;
            while ((line=bufferedReader.readLine())!=null){
                if(line.equals("STOP")) break;
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}