import java.util.Random;
/**
 * The Pizza class represents a Pizza. It's composed of ingredient objects,
 * the price is a money object, the shape a shape object, and the remaining
 * pizza is a fraction object. These are all characteristics of a real
 * pizza.
 * 
 * Class Invariants
 * A pizza must have a cost greater than or equal to zero.
 * A pizza must be made of something (Ingredients)
 * A pizza must have a calorie count greater than zero.
 * A pizza must have a shape
 * A pizza must have greater than 0 and 1 remaining (fraction of)
 * 
 * @author Connor Teal
 * @version March 2017
 */
public class Pizza implements PizzaComparable
{
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private int totalCalories;
    private Money totalPrice;
    private Shape shape;
    private Fraction pizzaRemaining;

    public Pizza(){
        this.totalPrice = new Money();
        this.pizzaRemaining = new Fraction();
        Random rand = new Random();
        int base = rand.nextInt(2);
        int cheese = rand.nextInt(2);
        int meat = rand.nextInt(3);
        int vegetable = rand.nextInt(3);
        int shape = rand.nextInt(2);

        switch(shape){
            case 0: setShape(new Circle(1));
            break;
            case 1: setShape(new Square(1));
            break;
            default: setShape(new Circle(1));
            break;
        }
        switch(base){
            case 0: addIngredient(new Marinara());
            break;
            case 1: addIngredient(new Alfredo());
            break;
            default: addIngredient(new Marinara());
            break;
        }
        switch(cheese){
            case 0: addIngredient(new Goat());
            break;
            case 1: addIngredient(new Mozzarella());
            break;
            default: addIngredient(new Mozzarella());
            break;
        }
        switch(meat){
            case 0: addIngredient(new Sausage());
            break;
            case 1: addIngredient(new Pepperoni());
            break;
            case 2: //No meat
            break;
            default: addIngredient(new Sausage());
            break;
        }
        switch(vegetable){
            case 0: addIngredient(new Olive());
            break;
            case 1: addIngredient(new Pepper());
            break;
            case 2: //No Veggies
            break;
            default: addIngredient(new Pepper());
            break;
        }
    }

    /**
     * compareToByCalories compares two pizza objects on the basis of 
     * calories.Returns an integer than indicates the relationship; -1 for less than argument,
     * 0 for equals argument, and 1 for greater than argument.
     * 
     * @param Object pizza to compare with
     * @return int describing relationship -1 for less than, 0 for equal,
     * 1 for greater than
     * @RuntimeException if object not instance of Pizza
     */
    public int compareToByCalories(Object other){
        if(other instanceof Pizza == false){
            throw new IllegalArgumentException("Must be pizza object");
        }
        Pizza otherPizza = (Pizza) other;
        return this.totalCalories - otherPizza.totalCalories;
    }

    /**
     * compareToBySize compares two pizza objects on the basis of size.
     * It uses the compareTo from the Fraction class to do this. Returns an
     * integer than indicates the relationship; -1 for less than argument,
     * 0 for equals argument, and 1 for greater than argument.
     * 
     * @param Object pizza to compare with
     * @return int describing relationship -1 for less than, 0 for equal,
     * 1 for greater than
     * @RuntimeException if object not instance of Pizza
     */
    public int compareToBySize(Object other){
        if(other instanceof Pizza == false){
            throw new IllegalArgumentException("Must be pizza object");
        }
        Pizza otherPizza = (Pizza) other;
        return this.pizzaRemaining.compareTo(otherPizza.pizzaRemaining);
    }

    /**
     * default compareTo compares two pizza objects on the basis of price.
     * It uses the compareTo from the Money class to do this. Returns an
     * integer than indicates the relationship; -1 for less than argument,
     * 0 for equals argument, and 1 for greater than argument.
     * 
     * @param Object pizza to compare with
     * @return int describing relationship -1 for less than, 0 for equal,
     * 1 for greater than
     * @RuntimeException if object not instance of Pizza
     */
    public int compareTo(Object other){
        if(other instanceof Pizza == false){
            throw new IllegalArgumentException("Must be pizza object");
        }
        Pizza otherPizza = (Pizza) other;
        return this.totalPrice.compareTo(otherPizza.totalPrice);
    }

    /**
     * Returns a deep copy of fraction representing the pizza remaining.
     * 
     * @return Fraction of pizza remaining
     */
    public Fraction getRemaining(){
        return new Fraction(this.pizzaRemaining);
    }

    /**
     * Sets the pizza remaining to the given fraction. Must be greater
     * than or equal to zero.
     * 
     * @param Fraction to set pizza remaining
     * @return Nothing
     * @RuntimeException if fraction isn't positive or is null
     */
    public void setRemainig(Fraction f){
        if(f.isPositive() == false || f == null){
            throw new IllegalArgumentException("Pizza can't have less" +
                "than 0 remaining.");
        }
        this.pizzaRemaining = new Fraction(f);
    }

    /**
     * Returns the total calories in the pizza with consideration to the
     * amount of pizza remaining.
     * 
     * @return int number of calories in remaining pizza
     */
    public int getCalories(){
        return this.totalCalories;
    }

    /**
     * Returns a copy of the money object that represents the cost of the
     * pizza. This is determined by the ingredients. Returns a deep copy of
     * the money object.
     * 
     * @return Money object representing cost of pizza
     */
    public Money getCost(){
        return new Money(this.totalPrice);
    }

    /**
     * getRemainingArea will return the area of pizza remaining based on 
     * the pizza's shape and amount of pizza remaining.
     * 
     * @return double area of pizza remaining
     */
    public double getRemainingArea(){
        return this.shape.getArea() * 
        this.pizzaRemaining.getDoubleValue();
    }

    /**
     * setShape will set the shape of the pizza to the given Shape object
     * 
     * @param Shape object to set pizza shape to
     * @return Nothing
     */
    public void setShape(Shape s){
        this.shape = (Shape) s.clone();
    }

    /**
     * getShape will return the pizza's shape (as an object)
     * 
     * @return Shape object of pizza
     */
    public Shape getShape(){
        return (Shape) this.shape.clone();
    }

    /**
     * addIngredient takes an ingredient object and adds an it to the
     * pizza's ingredient list.
     * 
     * @param Ingredient to add
     * @return Nothing
     */
    public void addIngredient(Ingredient ingredientToAdd){
        if(ingredientToAdd == null){
            throw new PizzaException("Null Ingredient");
        }  
        totalPrice.add(ingredientToAdd.getCost());
        totalCalories += ingredientToAdd.getCalorieCount();
        ingredients.add(ingredientToAdd);
    }

    /**
     * eatSomePizza will remove the amount of pizza eaten from the 
     * amount of pizza remaining.
     * 
     * @param Fraction of pizza eaten
     * @throws PizzaException when all pizza is eaten
     * @throws Exception when pizza would result in negative remainder
     */
    public void eatSomePizza(Fraction fractionEaten) throws
    PizzaException, Exception{
        if(fractionEaten.isPositive() == false){
            throw new IllegalArgumentException("Fraction eaten must" +
                " be positive");
        }
        int denomRemain = pizzaRemaining.getDenom();
        int numRemain = pizzaRemaining.getNum();

        int denomEaten = fractionEaten.getDenom();
        int numEaten = fractionEaten.getNum();

        //Multiply to achieve common denominator
        numRemain *= denomEaten;
        numEaten *= denomRemain;
        denomRemain *= denomEaten;
        
        //Subtract numerators
        numRemain -= numEaten;

        if(numRemain == 0){ //if the pizza is consumed
            throw new Exception("Pizza is consumed");
        }else if( numRemain < 0 ){ //trying to eat more than remaining
            throw new PizzaException("Eaten can't be greater than remaining");
        }else{ //otherwise there is enough pizza for eaten value
            this.pizzaRemaining = new Fraction(numRemain,denomRemain);
        }
    }

    /**
     * toString will return a string of the instance variables of a pizza,
     * including; price, ingredients, calories, and pizza remaining.
     * 
     * @return String list of pizza properties
     */
    @Override
    public String toString(){
        String retVal = "\n";
        retVal += "======================================" + "\n";
        retVal += "Price: " + totalPrice.toString() + "\n";
        retVal += "Ingredients" + "\n\n";
        retVal += ingredients.toString() + "\n";
        retVal += "Calories: " + totalCalories + "\n";
        retVal += "Pizza Remaining: " + pizzaRemaining.toString() + "\n";
        retVal += "Shape: " + shape.toString() + "\n";
        retVal += "======================================";
        retVal += "\n\n";
        return retVal;
    }

    public static void main(String[] args){
        Pizza one = new Pizza();
        Pizza two = new Pizza();

        System.out.println("Pizza One");
        System.out.println(one.toString());

        System.out.println("Pizza Two");
        System.out.println(two.toString());

        try{
            one.eatSomePizza(new Fraction(1,5));
        }catch(PizzaException e){
            System.out.println(e.getMessage());
        }catch(Exception neg){
            System.out.println(neg.getMessage());
        }
        System.out.println(one.getRemaining().toString());
        System.out.println(one.shape.getArea());
        System.out.println(one.getRemaining().getDoubleValue());
        System.out.println(one.getRemainingArea());
        System.out.println(one.compareTo(two));
        System.out.println(one.compareToBySize(two));
        System.out.println(one.compareToByCalories(two));
    }
}
