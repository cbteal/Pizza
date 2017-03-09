import java.awt.Color;
import java.util.Map;
import java.util.HashMap;
/**
 * Write a description of class Vegetable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vegetable extends Ingredient
{
    private Color vegetableColor;
    private Map<Color, String> mapColors = new HashMap<Color,String>();
    
    public Vegetable(String description, Money cost, int calories,
    Color colorValue){
        super(description,cost,calories);
        this.vegetableColor = colorValue;
        
        mapColors.put(Color.RED,"Red");
        mapColors.put(Color.BLACK,"Black");
    }
    
    /**
     * setColor sets the color of a vegetable to the color it's passed
     * 
     * @param Color to set vegetable to
     * @return Nothing
     */
    public void setColor(Color colorValue){
        this.vegetableColor = colorValue;
    }
    
    /**
     * getColor will return the color of the vegetable
     * 
     * @return Color of the vegetable as an awt color
     */
    public Color getColor(){
        return this.vegetableColor;
    }
    
    /**
     * equals will compare two vegetables for equality on the basis of
     * description, cost, calorie count, and color.
     * 
     * @param Object vegetable to compare with
     * @return boolean true if equal instance variables
     * @exception if object isn't an instance of vegetable
     */
    @Override
    public boolean equals(Object other){
        if(other instanceof Vegetable == false){
            throw new IllegalArgumentException();
        }
        Vegetable tempVegetable = (Vegetable) other;
        if(super.equals(other) && this.vegetableColor == 
        tempVegetable.vegetableColor){
            return true;
        }
        return false;
    }
    
    @Override
    /**
     * toString will return the instance variables as a string. They
     * include: description, cost in dollars, calorie count, and color.
     * 
     * @return String of instance variable values.
     */
    public String toString(){
        String returnValue = super.toString();
        returnValue += "Color: " + this.mapColors.get(vegetableColor);
        
        return returnValue;
    }
}
