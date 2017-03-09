import java.io.Serializable;

/**
 * The money class represents a dollar and cent value. It has two instance
 * variables int Dollars and int Cents. The objects are mutable and are
 * accessible via setters and getter methods. 
 * 
 * Class Invariants:
 * Cents must be greater and 0 and less than 99
 * Dollars Must be greater than 0
 * 
 * @author Connor Teal
 */
public class Money implements Comparable, Cloneable, Serializable{
    private int cents, dollars;

    //Class Invariants: 0 <= cents <= 99
    //                  0 <= dollars

    /**
     * No Argument Constructor
     * Defaults to 0 Dollars and 0 Cents
     * @param None
     * @return Nothing
     */
    public Money(){
        this.cents = 0;
        this.dollars = 0;
    }

    /**
     * Clone will act as a castable copy construcor that returns a copy
     * (deep copy) of the object that calls it.
     * 
     * @return Object Money copy of the casting object
     */
    public Money clone(){
        return new Money(this.dollars,this.cents);
    }

    /**
     * compareTo is the method that is created to implement the
     * comparable interface. It will compare two Money objects in terms of
     * total amount, including dollars and cents, then return
     * an integer to indicate their relationship. A -1 indicates the
     * calling object is less than the argument, a zero means equal, 
     * and a +1 indicates the calling object is greater than the argument.
     * 
     * @param Object Money to compare to
     * @return int indicates relationship
     */
    @Override
    public int compareTo(Object other){
        if(other instanceof Money == false){
            throw new IllegalArgumentException();
        }
        Money otherMoney = (Money) other;
        if(this.dollars > otherMoney.dollars){
            return 1;
        }
        if(this.dollars == otherMoney.dollars){
            if(this.cents > otherMoney.cents){
                return 1;
            }else if(this.cents < otherMoney.cents){
                return -1;
            }
            return 0;
        }     
        return -1;
    }

    /**
     * Copy Constructor
     * Copies an object to prevent privacy leaks
     * @param Object money is the object to be copied
     */
    public Money(Money other){
        this.cents = other.cents;
        this.dollars = other.dollars;
    }

    /**
     * Dollar Constructor
     * Creates an object with a dollar value assigned via parameter
     * @param int dol is the dollar value
     */
    public Money(int dol){
        this.cents = 0;
        try{
            setDollars(dol);
        }catch(Exception e){
            System.out.println(e.getMessage());
            new Money();
        }
    }

    /**
     * Cent/Dollar Constructor
     * Creates and object with dollar and cent value assigned via
     * parameter
     * @param int dol is the dollar value
     * @param int cent is the cent value
     */
    public Money(int dol, int cent){
        try{
            this.setDollars(dol);
            this.setCents(cent);
        }catch(Exception e){
            System.out.println(e.getMessage());
            new Money();
        }
    }

    /**
     * checkCentRange will verify that the cents are within class
     * invariant range
     * @param int cents is the cents value to check
     * @return boolean true if valid
     */
    private boolean checkCentRange(int cents) throws Exception{
        if(cents < 0 || cents > 99){
            throw new Exception("Cent's must be within " + 
                "range 0 and 99.");
        }
        return true;
    }

    /**
     * checkDollarRange will verify that dollars are within class
     * invariant range
     * @param int dol is the dollar value to check
     * @return boolean true if valid
     */
    private boolean checkDollarRange(int dol) throws Exception{
        if(dol < 0){
            throw new Exception("Dollar value must be " + 
                "positive.");
        }
        return true;
    }

    /**
     * getCents returns the cent value
     * @return int Cents value
     */
    public int getCents(){
        Money temp = new Money(this);
        return temp.cents;
    }

    /**
     * getDollars returns the dollar value
     * @return int dollars value
     */
    public int getDollars(){
        Money temp = new Money(this);
        return temp.dollars;
    }

    /*
    /**
     * setDollars sets dollar Value
     * @param int dollars value to be set
     * @return Nothing
     */
    public void setDollars(int dol){
        try{
            this.checkDollarRange(dol);
            this.dollars = dol;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * setCents sets cents value
     * @param int cents value to be set
     * @return nothing
     */
    public void setCents(int cents){
        try{
            this.checkCentRange(cents);
            this.cents = cents;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * get Money returns the double value $x.xx
     * @return double value of money
     */
    public double getMoney(){
        Money temp = new Money(this);
        double retVal = (double) (dollars * 100);
        retVal += cents;

        return retVal / 100;
    }

    /**
     * setMoney sets both dollars and cents
     * @param int dollar value to set
     * @param int cents value to set
     */
    public void setMoney(int dollar, int cents){
        try{
            this.checkCentRange(cents);
            this.checkDollarRange(dollar);
            this.cents = cents;
            this.dollars = dollar;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    
    }

    /**
     * add will add argument to dollar value
     * @param int dol value to be added
     */
    public void add(int dol){
        try{
            checkDollarRange(dol);
            setDollars(this.getDollars() + dol);
        }catch(Exception e){
            System.out.println("You can't enter a negative " + 
                "dollar value.");
        }
    }

    /**
     * add will add argument to dollar and cent value
     * @param int dol value to be added
     * @param int cents value to be added
     */
    public void add(int dol, int cents){
        try{
            checkDollarRange(dol);
            checkCentRange(cents);
            setDollars(this.getDollars() + dol);
            //We have to account for sum of cents being > 99
            if(this.getCents() + cents > 99){
                int dollars = (this.getCents() + cents) / 100;
                int centRemainder = (this.getCents() + cents) % 100;
                this.add(dollars);
                this.setCents(centRemainder);
            }else{
                setCents(this.getCents() + cents);
            }
        }catch(Exception e){
            System.out.println("You can't enter a negative " + 
                "dollar/cent value.");
        }
    }

    /**
     * add will add another money objects value to it's current
     * value
     * @param Money object to add
     * @return Nothing
     */
    public void add(Money that){
        this.add(that.getDollars(), that.getCents());
    }

    /**
     * Equals will compare the money object to another money
     * object passed to it for equality.
     * @param Money object to compare with
     * @return boolean true if equal
     */
    public boolean equals(Money that){
        if(this.cents == that.cents && this.dollars ==
        that.dollars){
            return true;
        }
        return false;
    }

    /**
     * toString will return the contents of the object to
     * in a String formatted like, "$X.XX"
     * @return String total value
     */
    @Override
    public String toString(){
        return "$" + this.getMoney();
    }

    /*
    public static void main(String[] args){
    Money a = new Money();
    Money b = new Money(-1);
    a.setMoney(-13,1);
    System.out.println(a.getMoney());
    a.add(-1);
    System.out.println(a.getMoney());
    a.add(-1,-53);
    }*/
}
