
/**
 * Goat cheese is  premium cheese option for a pizza. It's the most
 * expensive option. Goat cheese is a subclass of cheese.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Goat extends Cheese
{
    /**
     * Constructor creates a goat cheese with a description, price, and
     * calorie count. The price is $4.50 and the calorie count is 350.
     */
    public Goat(){
        super("Feeling adventurous? Try this tasty local goat " + 
            "cheese for  your pizza.", new Money(4,50), 350);
    }

    public static void main(String[] args){
        Goat goat = new Goat();

        assert(goat.getCost().getMoney() == 4.50): "Cost should equal 2.50";
        assert(goat.getCalorieCount() == 350): "CalorieCount should be 400";
    }
}
