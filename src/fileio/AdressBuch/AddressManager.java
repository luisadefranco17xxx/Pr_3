package fileio.AdressBuch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressManager {
    private ArrayList<Address> myList;

    public AddressManager() {
        myList= new ArrayList<>();
    }

    public ArrayList<Address> getMyList() {
        return myList;
    }

    @Override
    public String toString() {
        return "AddressManager{" +
                "myList=" + myList +
                '}';
    }

    public void add(Address a){

        myList.add(a);
    }

    public void exportToCsv(String path, String separator) throws AddressExportException, AddressExportFileAlreadyExistsException {
        //throws IOException{
        try {
            File f = new File(path);
            if (f.exists()) throw new AddressExportFileAlreadyExistsException();   //pre provare si puo coomentare altrimento sempre throsws
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;

            try {
                fileWriter = new FileWriter(path);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (Address a : myList
                ) {
                    bufferedWriter.write(a.getFirstname() + separator + a.getLastname() + separator +
                            a.getMobilNumber() + separator + a.getEmail() + separator);
                    bufferedWriter.newLine();
                }

            } finally {

                    bufferedWriter.flush();
                    bufferedWriter.close();

            }
        } catch (IOException e){
            new AddressExportException(e);   //meine eigene
        }
   }

    public void loadFromCsv(String path, String separator) throws AddressLoadException,AddressLoadWrongFormatException  {
        try {
            FileReader fileReader;
            BufferedReader bufferedReader = null;
            String line;
        //myList.removAll();
            ArrayList<Address> myList = new ArrayList<>();

            Address myA= new Address(null, null, null, null);

            fileReader = new FileReader(new File(path));
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] substrings = line.split(";");
                for (int i = 0; i < 2; i++) {
                    if (substrings[i] == null) throw new AddressLoadException("Address unvollständig");
                }
                if (substrings.length != 4) throw new AddressLoadWrongFormatException("length!=4");  //
                else {
                   // myA = new Address(null, null, null, null);
                    myA.setFirstname(substrings[0]);
                    myA.setLastname(substrings[1]);

                    myA.setMobilNumber(substrings[2]);
                    myA.setEmail(substrings[3]);
                }

                //System.out.println("line = " + line);
                System.out.println("myList = " + myList);
                myList.add(myA);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("End of File erriched = " + e);
            new AddressLoadException(e.toString());
        }
//        } finally {
//            try {
//                bufferedReader.close();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
        System.out.println("myList-am Ende = " + myList);
    }


}
