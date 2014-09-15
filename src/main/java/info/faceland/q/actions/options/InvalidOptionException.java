package info.faceland.q.actions.options;

public class InvalidOptionException extends RuntimeException {

    public InvalidOptionException() {
        super("That is not a valid option.");
    }

}
