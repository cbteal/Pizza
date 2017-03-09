/**
 * Alfredo is a less common base, but excellent option for pizza. It's one of
 * two Base's that are available to create a pizza.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Alfredo extends Base
{
    /**
     * Constructor makes an alfredo base object with a cost of
     * $6 and a calorie count of 350.
     */
    public Alfredo(){
        super("This Alfredo base won't disappoint", new Money(6), 350);
    }
    
     public static void main(String[] args){
        Alfredo alfred = new Alfredo();
        
        assert(alfred.getCost().getMoney() == 6.00): "Cost should be 6.00";
        assert(alfred.getCalorieCount() == 350): "Calories should be 350";
    }
}
