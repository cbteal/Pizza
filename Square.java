
/**
 * The square class is a child class of a rectangle. It's a rectangle
 * that has 4 equal length sides. In other words the height equals the
 * width of the rectangle.
 * 
 * As with rectangle: side length (height/width) and area must be greater 
 * than zero
 * Also height must equal width, which must equal side length
 * 
 * @author Connor Teal
 * @version 2/7/17
 */
public class Square extends Rectangle implements Cloneable
{
    private double sideLength;
    
    /**
     * No SideLength Constructor
     * Creates a square with default side length -- 1
     * 
     * @param int x starting coordinate
     * @param int y starting coordinate
     */
    public Square(int x, int y){
        super(1,1);
    }
    
    /**
     * Sidelength paramater Constructor
     * Creates a square with given side length
     * 
     * @param int x starting coordinate
     * @param int y starting coordinate
     * @param double sideLength to set to
     */
    public Square(double sideLength){
        super(sideLength,sideLength);
    }
    
    /**
     * Clone method will return a deep copy of the calling Square
     * 
     * @return Square copy of the calling square
     */
    @Override
    public Square clone(){
        return new Square(sideLength);
    }
    
    /**
     * Private helper method to check and see if class invariant
     * specifications are being met.
     * 
     * @param double number to check
     * @return boolean if number is greater than zero
     * @throws exception if number less than or equal to zero
     */
    private boolean validSideLength(double toCheck) throws Exception{
        if(toCheck < 0){
            throw new Exception();
        }
        return true;
    }
    
    /**
     * Sets the side length of the square. Checks to make sure input
     * is valid. Will not set the length if input less than zero.
     * 
     * @param double sidelength to be set
     * @return Nothing
     */
    public void setSideLength(double sideLength){
        try{
            validSideLength(sideLength);
            this.sideLength = sideLength;
            super.setHeight(sideLength);
            super.setWidth(sideLength);
        }catch(Exception e){
            System.out.println("Sidelength must be greater than zero"); 
        }
    }
    
    /**
     * getSideLength will return the sidelength of the square
     * 
     * @return double side length of square
     */
    public double getSideLength(){
        return this.sideLength;
    }
    
    /**
     * setHeight overrides rectangle setheight to make sure class invariant
     * conditions are met. Height must equal width, which must equal side
     * length. This condition calls setSideLength and therefore all those
     * values to the passed value.
     * 
     * @param double height to be set
     */
    @Override
    public void setHeight(double height){
        setSideLength(height);;
    }
    
    /**
     * toString returns the name of the shape (Square) as a string
     * 
     * @return String name of shape
     */
    @Override
    public String toString(){
        return "Square";
    }
    
     /**
     * setWidth overrides rectangle setWidth to make sure class invariant
     * conditions are met. Height must equal width, which must equal side
     * length. This condition calls setSideLength and therefore all those
     * values to the passed value.
     * 
     * @param double width to be set
     */
    @Override
    public void setWidth(double width){
        setSideLength(width);
    }
    
    //TESTS
    public static void main(String[] args){
        Square a = new Square(5);
        Square b = new Square(2);
        Square c = b.clone();
        
        assert(b.equals(c));
        
        System.out.println(a.getArea());
        System.out.println(a.getHeight());
        System.out.println(a.getWidth());
        System.out.println(a.getSideLength());
    }
}
