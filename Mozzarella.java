
/**
 * Mozzarella cheese is an option for users to create their pizza with.
 * It's a subclass of cheese.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Mozzarella extends Cheese
{
    /**
    * Constructor creates a Mozzarella cheese with a description, price, and
    * calorie count. The price is $2.50 and the calorie count is 400.
    * 
    */
    public Mozzarella(){
        super("Mozzarella cheese is the go-to " + 
        "cheese for pizza.", new Money(2,50), 400);
    }
    
    public static void main(String[] args){
        Mozzarella mozarella = new Mozzarella();
        
        assert(mozarella.getCost().getMoney() == 2.50): "Cost should equal 2.50";
        assert(mozarella.getCalorieCount() == 400): "CalorieCount should be 400";
        
        System.out.println(mozarella.toString());
    }
}
