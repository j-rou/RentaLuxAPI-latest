package technobel.jro.RentaLuxAPI.exceptions;

public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException() {
        super("L'element existe deja");
    }
}
