package fileio.AdressBuch;

public class AddressLoadWrongFormatException extends  Exception{
    public AddressLoadWrongFormatException(String message) {
        super(message);
        System.out.println("AddressLoadWrongFormatException = " +message);
    }
}

