/**
 * Sausage is one of two meat ingredients available in our pizza
 * machine. The class represents the sausage ingredient.
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Sausage extends Meat
{
    /**
     * Constructor makes a Sausage meat object with a cost of
     * $2.75 and a calorie count of 410.
     */
    public Sausage(){
        super("This sausage is perfectly spicey", new Money(2,75), 410);
    }
    
     public static void main(String[] args){
        Sausage saus = new Sausage();
        
        assert(saus.getCost().getMoney() == 2.75): "Cost should be 2.75";
        assert(saus.getCalorieCount() == 410): "Calories should be 410";
    }
}
