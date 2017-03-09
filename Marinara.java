
/**
 * Marinara is a classic base and go-to option for pizza. It's one of
 * two Base's that are available to create a pizza.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Marinara extends Base
{
    /**
     * Constructor makes a marinara base object with a cost of
     * $4 and a calorie count of 200.
     */
    public Marinara(){
        super("Classic marinara sauce", new Money(4), 200);
    }
    
    public static void main(String[] args){
        Marinara mari = new Marinara();
        
        assert(mari.getCost().getMoney() == 4.00): "Cost should be 4";
        assert(mari.getCalorieCount() == 200): "Calories should be 200";
    }
}
