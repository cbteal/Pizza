/**
 * The cheese class is an extension of the Ingredient class and will
 * serve as the parent class for specific kinds of cheese, such as
 * cheddar or mozzarella.
 * 
 * @author Connor Teal 
 * @version March 2017
 */
public class Cheese extends Ingredient
{
    /**
     * Constructor takes a string for description, money object for cost,
     * int for calorie count and creates a cheese ingredient with those
     * values.
     * 
     * @param String description
     * @param Money cost
     * @param int caloriecount
     */
    public Cheese(String description, Money cost, int calories){
        super(description,cost,calories);
    }
}
