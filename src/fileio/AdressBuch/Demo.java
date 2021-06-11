package fileio.AdressBuch;

public class Demo {

    public static void main(String[] args) {
        Address a1=new Address("Anton1","Schmitt1","066044332211","anton1@gmail.com");
        Address a2=new Address("Anton2","Schmitt2","066044332211","anton2@gmail.com");
        Address a3=new Address("Anton3","Schmitt3","066044332211","anton3@gmail.com");
        Address a4=new Address("Anton4","Schmitt4","066044332211","anton4@gmail.com");
        Address a5=new Address("Anton5","Schmitt5","066044332211","anton5@gmail.com");
        Address a6=new Address("Anton6","Schmitt6","066044332211","anton6@gmail.com");

        AddressManager addressManager=new AddressManager();
        addressManager.add(a1);
        addressManager.add(a2);
        addressManager.add(a3);
        addressManager.add(a4);
        addressManager.add(a5);
        addressManager.add(a6);


//        try {
//            addressManager.exportToCsv("AdressBuch.csv",";");
//
//        } catch (AddressExportException | AddressExportFileAlreadyExistsException e) {
//            e.printStackTrace();
//        }

        try {

            addressManager.loadFromCsv("AdressBuch.csv",";");
        } catch ( AddressLoadException | AddressLoadWrongFormatException e) {
            e.printStackTrace();
        }
        //System.out.println(addressManager.getMyList().toString());
    }


}
