import java.awt.*;
/**
 * Write a description of class Olive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Olive extends Vegetable
{
    /**
     * Constructor makes an olive ingredient object with a cost of
     * $1.50 and a calorie count of 130.
     */
    public Olive(){
        super("Liven up your za with some olives.", new Money(1,50), 130,Color.BLACK);
    }
    
    public static void main(String[] args){
        Olive olive = new Olive();
        
        assert(olive.getCost().getMoney() == 1.50): "Cost should be 1.50";
        assert(olive.getCalorieCount() == 130): "Calorie count should be 130";
        
        System.out.println(olive.toString());
    }
}
