package fileio.AdressBuch;

public class AddressExportFileAlreadyExistsException extends Throwable{
    public AddressExportFileAlreadyExistsException() {
    }

    public AddressExportFileAlreadyExistsException(String message) {
        super(message);
        System.out.println("file schon existiert " );
    }
}
