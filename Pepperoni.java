/**
 * Pepperoni is one of two meat ingredients available in our pizza
 * machine. The class represents the pepperoni ingredient.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Pepperoni extends Meat
{
    /**
     * Constructor makes an alfredo base object with a cost of
     * $3.25 and a calorie count of 450.
     */
    public Pepperoni(){
        super("This pepperoni is fresh and hearty", new Money(3,25), 450);
    }
    
     public static void main(String[] args){
        Pepperoni pep = new Pepperoni();
        
        assert(pep.getCost().getMoney() == 3.25): "Cost should be 3.25";
        assert(pep.getCalorieCount() == 450): "Calories should be 450";
    }
}
