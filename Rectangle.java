import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * ------ LAB CLASS ------
 * 
 * A rectangle is a subclass of Shape. It has an x.y coordinate position,
 * and a width and height. The shape is 2 dimensional. A rectangle must
 * have 2 sets of equal length sides (width and height). Those sides must
 * have a length greater than zero. Therefore the area must also be greater
 * than zero.
 * 
 * 
 * @author Connor Teal
 */
public class Rectangle extends Shape implements Cloneable
{
    // instance variables - replace the example below with your own
    private double width;
    private double height;
    
    /**
     * A positon only Constructor takes a coordinate positon and creates
     * a rectangle with height one and width one
     * 
     * @param int x coordinate
     * @param int y coordinate
     */
    public Rectangle(){
        this.width = 1.0;
        this.height = 1.0;
    }

    /**
     * Position, Height, and Width Constructor
     * Creates a rectangle at (x,y) with a given height and width
     * 
     * @param int x,y coordinates for location
     * @param double width to set
     * @param double height to set
     */
    public Rectangle(double width, double height){
        setWidth(width);
        setHeight(height);
    }
    
    /**
     * Helper method to verify that the class invariant condition that
     * each side must be greater than zero
     * 
     * @param double value to check
     * @throws exception if value less than or equal to zero
     * @return true if greater than zero
     */
    private boolean heightWidthValid(double toCheck) throws Exception{
        if(toCheck <= 0){
            throw new Exception();
        }
        return true;
    }
    
    /**
     * Copy Constructor takes a rectangle as argument and returns a new copy
     * of the object
     * 
     * @param Rectanlge to be copied
     */
    public Rectangle(Rectangle other){
        this.width = other.width;
        this.height = other.height;
    }
    
    /**
     * setWidth will set the width of the rectangle
     * Checks to make sure input greater than zero 
     * 
     * @param double width
     * @return Nothing
     */
    public void setWidth(double width){
        try{
            heightWidthValid(width);
            this.width = width;
        }catch(Exception e){
            System.out.println("The width must be greater than zero");
        }          
    }
    
    /**
     * set Height sets the height of the triangle
     * Checks to make sure input greater than zero
     * 
     * @param double height to set to
     * @return Nothing
     */
    public void setHeight(double height){
        try{
            heightWidthValid(height);
            this.height = height;
        }catch(Exception e){
            System.out.println("The height must be greater than zero");
        }      
    }
    
    /**
     * returns width of triangle
     * 
     * @return double width of rectangle
     */
    public double getWidth(){
        return this.width;
    }
    
    /** 
     * returns height
     * 
     * @return double rectangle height
     */
    public double getHeight(){
        return this.height;
    }
    
    /** 
     * Returns the area of the rectangle base * height
     * 
     * @return double Area of rectangle
     */
    public double getArea(){
        return width * height;
    }
    
    /**
     * Equals will compare a given Rectangle to the calling Rectangle
     * to test for equality and return true if equal.
     * 
     * @param Rectangle to compare to
     * @return boolean true if equal
     */
    public boolean equals(Rectangle other){
        if(this.getX() == other.getX() && this.getY() == other.getY() 
        && this.getWidth() == other.getWidth() && this.getHeight() == 
        other.getHeight()){
            return true;
        }
        return false;
    }
    
    /**
     * Method provided by Rob Nash and altered by Connor Teal. This builds
     * the graphical representation of the rectangle using java's awt, swing,
     * and graphics packages.
     * 
     * @param Graphic g
     */
    public void draw( Graphics g) {
        int Density = 1; //Can change the number of rectangles to draw
        Graphics2D g2d = (Graphics2D) g;
        
        final int x = getX();
        final int y = getY();
        
        g2d.setColor( Color.BLACK ); //Set color of rectangle to black
        
        int xOffset = 0;
        int yOffset = 0;
        
        //Create one rectangle
        for( int i = 0; i < Density; i++) {
            xOffset = (int) (Math.random()*width);
            yOffset = (int) (Math.random()*height);
            g2d.draw(new Rectangle2D.Double( x + xOffset, y + yOffset,
            width + xOffset, height + yOffset));
        }
    
    }
    
    /**
     * clone returns a deep copy of the Rectangle calling the method
     * 
     * @return Rectangle copy of calling rectangle
     */
    public Rectangle clone(){
        return new Rectangle(width,height);
    }
    
    public static void main(String[] args){
        Rectangle a = new Rectangle(1,1);
        Rectangle b = new Rectangle(2,2);
        Rectangle c = new Rectangle(b);

        //GetWidth Method
        assert(c.getWidth() == b.getWidth());
        assert(a.getWidth() == 1.0);
        assert(c.getWidth() == 2.0);
        
        //GetHeight Method
        assert(c.getHeight() == b.getHeight());
        assert(a.getHeight() == 1.0);
        assert(c.getHeight() == 2.0);
        assert(b.getHeight() == 2.0);

        //Equals Method
        assert(a.equals(a));
        assert(b.equals(c));
        assert(c.equals(b));
        assert(!a.equals(b));
        
        //SetWidth Method
        a.setWidth(-1);
        assert(a.getWidth() == 1.0);
        a.setWidth(2.0);
        assert(a.getWidth() == 2.0);
        assert(a.getWidth() == b.getWidth());
        
        //SetHeight Method
        a.setHeight(-1);
        assert(a.getHeight() == 1.0);
        a.setHeight(3.0);
        assert(a.getHeight() == 3.0);
        assert(a.getHeight() != b.getHeight());
        
        //Area
        assert(a.getArea() > b.getArea());
        assert(a.getArea() > 0);
        assert(b.getArea() > 0);
        assert(c.getArea() > 0);
        assert(b.getArea() == c.getArea());
    }
}
