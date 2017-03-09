
/**
 * The pizza exception class is a custom exception to handle scenarios
 * we expect to encount in our pizza program. The PizzaException is a
 * Runtime Exception.
 * 
 * @author Connor Teal
 * @version March 7, 2017
 */
public class PizzaException extends RuntimeException
{
    /**
     * No argument constructor creates an exception with the generic
     * instance variable
     * 
     * @return PizzaException
     */
    public PizzaException(){
        super();
    }
    
    /**
     * Custom message constructor takes a string as an argument and
     * sets the exception's message to that string.
     * 
     * @param String message to be assigned to exception
     * @return PizzaException 
     */
    public PizzaException(String message){
        super(message);
    }
}
