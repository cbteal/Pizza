
/**
 * Write a description of class Ingredient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ingredient implements Comparable
{
    // instance variables - replace the example below with your own
    private final String description;
    private final Money cost;
    private final int calorieCount;
    
    /**
     * Constructor creates an Ingredient object with a description, cost,
     * and caloriecount.
     * 
     * @param String description of ingredient
     * @param Money cost of ingredient
     * @param Int calorie count of ingredient
     */
    public Ingredient(String description, Money cost, int calories){
        this.description = description;
        this.cost = cost;
        this.calorieCount = calories;
    }
    
    /**
     * compareTo will compare two ingredients on the basis of their cost.
     * It will utilize the Money class's compareto method, which compares to
     * Money objects and returns a negative value if less than, a zero if equal,
     * and a positive value if greater than the compared Money object.
     * 
     * @param Object ingredient to compareTo
     * @return int describing relationship between cost
     * @Exception if object not instance of Ingredient
     */
    @Override
    public int compareTo(Object other){
        try{
            if(other instanceof Ingredient == false){
                throw new Exception("Illegal argument in compareTo ingredients");
            }
            Ingredient otherIngredient = (Ingredient) other;
            return this.cost.compareTo(otherIngredient.cost);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return -1;
    }
    
    /**
     * Equals method will compare two ingredients for equality against all
     * instance variables, including: description, cost, and caloriecount.
     * 
     * @param Ingredient to compare to
     * @return boolean true if all instance variables are equal
     */
    @Override
    public boolean equals(Object other){
        if(other instanceof Ingredient == false){
            throw new IllegalArgumentException();
        }
        Ingredient otherIngredient = (Ingredient) other;
        if(this.description.equals(otherIngredient.description) && 
        this.cost.equals(otherIngredient.cost) &&
        this.calorieCount == otherIngredient.calorieCount){
            return true;
        }
        return false;
    }
    
    /**
     * toString will override the object string method and return all the
     * instance variables in string format. The format is description, cost,
     * then calorie count with a new line after each.
     * 
     * @return String containing instance variable values
     */
    @Override
    public String toString(){
        String retVal = "";
        retVal += "Description: " + description + "\n";
        retVal += "Cost: " + cost.toString() + "\n";
        retVal += "Calorie Count: " + calorieCount + "\n";
        
        return retVal;
    }
    
    /**
     * getCaloriecount is a getter for an ingredients calorie count. It
     * returns the calorie count as an integer.
     * 
     * @return int calorie count of ingredient
     */
    public int getCalorieCount(){
        return this.calorieCount;
    }
    
    /*
    /**
     * setCalories takes an integer and sets an ingredient's calorie count
     * to the input value.
     * 
     * @param int calories of ingredient to assign
     * @return Nothing
     *
    public void setCalories(int calorieValue){
        this.calorieCount = calorieValue;
    }
    
    /**
     * setCost sets the cost of an ingredient to the specified money object.
     * It creates a deep copy to avoid privacy leaks.
     * 
     * @param Money object to assign to ingredient
     * @return Nothing
     *
    public void setCost(Money costValue){
        this.cost = new Money(costValue);
    }*/
    
    /**
     * getCost returns a deepcopy of the cost of an ingredient
     * 
     * @return Money object which is the cost of an ingredient
     */
    public Money getCost(){
        return new Money(cost);
    }
    
    /*
    /**
     * setDescription will set the description variable of an ingredient.
     * 
     * @param String description of ingredient
     * @return Nothing
     *
    public void setDescription(String newDescription){
        this.description = newDescription;
    }*/
    
    /**
     * getDescription returns the description of an ingredient as a string
     * 
     * @return String description of item
     */
    public String getDescription(){
        return this.description;
    }
}
