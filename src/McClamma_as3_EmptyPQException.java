/* Zackary McClamma
 * CPS 530
 * Assignment 1
 * 8 June 2020 
 * Disclaimer - This code was taken directly from the assignemnt on Isidore*/

/**
 * This exception signifies an invalid access on an empty heap.
 */
public class McClamma_as3_EmptyPQException extends RuntimeException {
    // assign a version number for serializable class
    private static final long serialVersionUID = 1L;

    /**
     * Empty constructor
     */
    public McClamma_as3_EmptyPQException() {
    }

    /**
     * Constructor that takes message as parameter
     * 
     * @param message
     *            the error message
     */
    public McClamma_as3_EmptyPQException(String message) {
        super(message);
    }
}