package technobel.jro.fenrirAPI.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException() {
        super("L'élément recherché n'a pas été trouvé");
    }


}
