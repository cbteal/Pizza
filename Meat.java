/**
 * The meat class is an extension of the ingredient class. It represents
 * the meats available in our pizza machine.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Meat extends Ingredient
{
    /**
     * Constructor takes a string for description, money object for cost,
     * int for calorie count and creates a meat ingredient with those
     * values.
     * 
     * @param String description
     * @param Money cost
     * @param int caloriecount
     */
    public Meat(String description, Money cost, int calories){
        super(description,cost,calories);
    }
}
