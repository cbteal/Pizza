import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {
    private ArrayList<Pizza> inventory;

    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';

        Scanner foo = new Scanner(System.in);

        while(true) {
            displayAllPizzas();
            displayInstructions();

            //foo.nextChar() doesn't exist, so now what?
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                //todo:
                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                //todo:
                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                //todo:pizza eating code here
                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                //todo:
                break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                //todo:
                break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                //todo
                break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                //todo:
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                //todo:
                break;
                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }

    private void eatSomePizza(Scanner keys, Pizza targetPizza) {
        boolean isDone = false;
        while( !isDone ){
            Fraction eaten = getFractionConsumed(keys);
            try{
                targetPizza.eatSomePizza(eaten);
                isDone = true;
            }catch(PizzaException e){
                System.out.println(e.getMessage());
                System.out.println("Try again or type exit to end");
            }catch(Exception pizzaGone){
                inventory.remove(inventory.indexOf(targetPizza));
            }
        }
    }

    /**
     * getFractionConsumed will prompt the user for keyboard input to determine
     * the amount of pizza consumed. It takes a Scanner as input and returns a
     * fraction if the fraction is greater than or equal to zero and less than 
     * or equal to one
     * 
     * @param Scanner keyboard for input
     * @return Fraction of pizza ate
     * @Exception if fraction is less than zero
     */
    private Fraction getFractionConsumed(Scanner keys){
        boolean inputDone = false;
        FractionProcessor fp = null;
        while(inputDone = false){
            System.out.println("How much pizza did you consume?");
            try{
                fp = new FractionProcessor(keys.next());
                inputDone = true;
            }catch(Exception e){
                System.out.println("Enter a valid fraction");
            }
        }

        return new Fraction(fp.getNum(),fp.getDenom());
    }

    private void addRandomPizza() {
        //todo:    
    }

    private void displayAllPizzas() {
        for(int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i).toString());
        }
    }

    private void sortByPrice() {  
        for(int i = 0; i < inventory.size() - 1; i++){
            int lowVal = i;
            
            for(int j = i; j < inventory.size() - 1; j++){
                if(inventory.get(lowVal).compareTo(inventory.get(j)) < 0){
                    lowVal = j;
                }
            }
            
            inventory.swap(i,lowVal);
        }
    }

    private void sortBySize() {
        for(int i = 0; i < inventory.size() - 1; i++){
            int lowVal = i;
            
            for(int j = i; j < inventory.size() - 1; j++){
                if(inventory.get(lowVal).compareToBySize(inventory.get(j)) < 0){
                    lowVal = j;
                }
            }
            
            inventory.swap(i,lowVal);
        }
    }

    private void sortByCalories() {
        for(int i = 0; i < inventory.size() - 1; i++){
            int lowVal = i;
            
            for(int j = i; j < inventory.size() - 1; j++){
                if(inventory.get(lowVal).compareToByCalories(inventory.get(j)) < 0){
                    lowVal = j;
                }
            }
            
            inventory.swap(i,lowVal);
        }
    }

    private int binarySearchByCalories(int cals) {
        //todo:
        return -1;
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
