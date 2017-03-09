import java.awt.Color;
/**
 * Pepper is a vegetable ingredient available on pizzas in our
 * pizza machine.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Pepper extends Vegetable
{
    /**
     * Constructor makes a red pepper ingredient object with a cost of
     * $3 and a calorie count of 100.
     */
    public Pepper(){
        super("Enjoy these hot red peppers!", new Money(3), 100,Color.RED);
    }
    
    public static void main(String[] args){
        Pepper redP = new Pepper();
        
        assert(redP.getCost().getMoney() == 3.00): "Cost should be 3.00";
        assert(redP.getCalorieCount() == 100): "Calorie count should be 100";
        
        System.out.println(redP.toString());
    }
}
