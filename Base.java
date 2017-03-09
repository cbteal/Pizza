
/**
 * The base class is an extension of the ingredient class. It represents
 * the base of a pizza, or in other words - the sauce.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Base extends Ingredient
{
    /**
     * Constructor takes a string for description, money object for cost,
     * int for calorie count and creates a base ingredient with those
     * values.
     * 
     * @param String description
     * @param Money cost
     * @param int caloriecount
     */
    public Base(String description, Money cost, int calories){
        super(description,cost,calories);
    }
}
