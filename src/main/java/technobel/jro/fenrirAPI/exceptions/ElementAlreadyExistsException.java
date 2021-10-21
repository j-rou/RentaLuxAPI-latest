package technobel.jro.fenrirAPI.exceptions;

public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException() {
        super("L'element existe deja");
    }
}
