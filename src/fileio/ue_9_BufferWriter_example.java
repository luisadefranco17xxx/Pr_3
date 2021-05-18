package fileio;

import java.io.*;

public class ue_9_BufferWriter_example {
    /*
    Methods of BufferedWriter
        The BufferedWriter class provides implementations for different methods present in Writer.
    write() Method
    write() - writes a single character to the internal buffer of the writer
    write(char[] array) - writes the characters from the specified array to the writer
    write(String data) - writes the specified string to the writer
     */
    public static void main(String[] args) {
        String data="This information is important";
        String data2="This information is not so important";
        String data3="cancel all";
        String[] list={data,data2,data3};
        writeTheData(list);
        writeTheDataWithBuffer(list);


    }

    public static void writeTheData(String [] list){

        try {
            FileWriter fileWriter=new FileWriter("fileWriter_cancel.txt");
            for (int i = 0; i < list.length; i++) {
                fileWriter.write(list[i]);
            }

            fileWriter.flush();
            fileWriter.close();
            System.out.println("I´m ready " );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeTheDataWithBuffer(String [] list){

        try {
            FileWriter fileWriter=new FileWriter("fileWriter_cancel2.txt");
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (int i = 0; i < list.length; i++) {
                bufferedWriter.write(list[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
            char[] char_Array={'e','h','f','g'};
            bufferedWriter.write(char_Array);
            bufferedWriter.write('x');
            bufferedWriter.write('x');
            bufferedWriter.write('x');

            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("I´m ready " );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
