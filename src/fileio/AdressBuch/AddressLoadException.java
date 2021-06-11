package fileio.AdressBuch;

public class AddressLoadException extends  Exception{
    public AddressLoadException(String message) {
        super(message);
        System.out.println("AddressLoadException = " + message);
    }
}
