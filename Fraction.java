/**
 * The Fraction class represents a mathematical integer fraction. The methods 
 * available to this class are equals, isValidFraction, toReducedForm, and
 * getGreatestCommonDenominator. Instance variables include numerator and
 * denominator.
 * 
 * Connor Teal
 */
public class Fraction implements Comparable
{
    private final int denom;
    private final int num;

    public Fraction(){
        this.denom = 1;
        this.num = 1;
    }

    /**
     * Copy constructor will make a deep copy of the fraction class passed
     * as an argument.
     * 
     * @param Fraction to copy
     * @return Nothing
     */
    public Fraction(Fraction f){
        this.denom = f.denom;
        this.num = f.num;
    }

    /**
     * Constructor for the Fraction class. Will construct the class with given
     * numerator and denominator.
     *
     * Takes two integers (num,denom)
     * No return
     */
    public Fraction(int num, int denom){
        if(isValidFraction(denom)){
            int reducedNum = setFractionNum(num,denom);
            int reducedDenom = setFractionDenom(num,denom);
            this.num = switchSignsNum(reducedNum,reducedDenom);
            this.denom = switchSignsDenom(reducedNum,reducedDenom);
        }
        else{
            throw new IllegalArgumentException("Can't divide by zero");
        }
    }

    /**
     * compareTo will compare two Fractions to determine the relationship and
     * return a negative integer if less than, zero if equal, and positive int
     * if greater than the Fraction passed as an argument.
     * 
     * @param Object fraction to compare to
     * @return int negative if less than, zero if equal, positive if greater
     * than
     */
    public int compareTo(Object other){
        if(other instanceof Fraction == false){
            throw new IllegalArgumentException();
        }
        Fraction otherFraction = (Fraction) other;
        if(this.getDoubleValue() < otherFraction.getDoubleValue()){
            return -1;
        }
        if(this.getDoubleValue() > otherFraction.getDoubleValue()){
            return 1;
        }
        return 0;
    }

    /**
     * Returns a double value of the fraction. Note that because of double
     * behavior, we can lose precision in the conversion.
     * 
     * @return double value of fraction
     */
    public double getDoubleValue(){
        return (double) this.getNum() / this.getDenom();
    }

    /**
     * equals method will compare a fraction to another fraction, determining if
     * they're equal. It compares their instance variables (numerator & 
     * denominator)
     * 
     * Takes Fraction object
     * Returns Boolean (True if equal)
     */
    public boolean equals(Fraction that){

        if(this.num == that.num && this.denom == that.denom){
            return true;
        }

        return false;
    }

    /**
     * isPositive will check to see if the fraction is positive by converting it
     * to a double value and seeing if it's less than zero in which case it returns
     * false.
     * 
     * @return boolean true if positive
     */
    public boolean isPositive(){
        double fractionValue = (double) this.num / this.denom;
        return fractionValue < 0 ? false : true;
    }

    /**
     * isValidFraction makes sure that the denominator is non-zero.
     * 
     * Takes integer (denominator)
     * Returns boolean (true if non-zero)
     */
    private boolean isValidFraction(int denom){
        if(denom != 0){
            return true;
        }

        return false;
    }

    /**
     * toString will return a string of the fraction in the format,
     * "Num/Denom".
     * 
     * @returns String of fraction value
     */
    @Override
    public String toString(){
        return this.num + "/" + this.denom;
    }

    /*
    /**
     * Method used to set the numerator of a fraction.
     * 
     * Takes int
     * No return
     *
    public void setNum(int num){
    this.num = num;
    }

    /**
     * Method used to set the denominator of a fraction.
     * 
     * Takes int
     * No return
     *
    public void setDenom(int denom){
    this.denom = denom;
    }*/

    /**
     * Method used to get the numerator of a fraction.
     * 
     * No Args
     * Returns int numerator
     */
    public int getNum(){
        return this.num;
    }

    /**
     * Method used to get the denominator of a fraction.
     * 
     * No Args
     * Returns int denominator
     */
    public int getDenom(){
        return this.denom;
    }

    /**
     * Method used to transform the fraction into it's reduced form.
     * 
     * No args
     * Returns Fraction Object in reduced form
     */
    public Fraction toReducedForm(){
        int divisor = getGreatestCommonDenominator();
        return new Fraction(this.num / divisor, this.denom / divisor);
    }

    /**
     * Method for calculating the greatest common denominator of two numbers.
     * This uses the Euclidean Algorithm which can be found using google. I
     * specifically used https://www.math.rutgers.edu/~greenfie/gs2004/euclid.html
     * 
     * Takes two integers as input
     * Returns integer (greatest common denominator)
     */
    private int greatestCommonDenominator(int x, int y){
        if(y == 0){
            return x;
        }
        if(x == 0){
            return y;
        }

        int remainder = x % y;

        return greatestCommonDenominator(y, remainder);
    }

    /**
     * getGreatestCommonDenominator returns the greatest common denominator of a Fraction.
     * 
     * No Args
     * Returns greatestCommonDenominator
     */
    public int getGreatestCommonDenominator(){
        return greatestCommonDenominator(this.num,this.denom);
    }

    /**
     * setFraction serves the purpose of setting the numerator and denominator at the same time.
     * 
     * Two integer arguments (num,denom)
     * No return
     */
    private int setFractionNum(int num, int denom){
        int divisor = greatestCommonDenominator(num,denom);
        int newNum = num / divisor;
        return newNum;
    }

    /**
     * setFraction serves the purpose of setting the numerator and denominator at the same time.
     * 
     * Two integer arguments (num,denom)
     * No return
     */
    private int setFractionDenom(int num, int denom){
        int divisor = greatestCommonDenominator(num,denom);
        int newDenom = denom / divisor;
        return denom;
    }

    /**
     * switchSigns is designed to check for two cases. One is that the denominator is
     * exclusively negative, and one that is when both numerator and denominator are 
     * negative. In either case it flips their signs so that the negative sign is in front
     * of the numerator, or they cancel out.
     * 
     * No args
     * No Returns
     */
    private int switchSignsNum(int num, int denom){
        if(num >= 0 && denom < 0){
            num *= -1;
            denom *= -1;
        }
        if(num < 0 && denom < 0){
            num *= -1;
            denom *= -1;
        }
        return num;
    }

    /**
     * switchSigns is designed to check for two cases. One is that the denominator is
     * exclusively negative, and one that is when both numerator and denominator are 
     * negative. In either case it flips their signs so that the negative sign is in front
     * of the numerator, or they cancel out.
     * 
     * No args
     * Returns proper sign for numerator
     */
    private int switchSignsDenom(int num, int denom){
        if(num >= 0 && denom < 0){
            num *= -1;
            denom *= -1;
        }
        if(num < 0 && denom < 0){
            num *= -1;
            denom *= -1;
        }
        return denom;
    }
}
