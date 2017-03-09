import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * ------ LAB CLASS -------
 * 
 * A circle is a subclass of the Shape class. It has an x.y coordinate position
 * and a radius. A circle must have a radius that is greater than zero and
 * it's area must be greater than zero. This class will serve to represent a
 * circle for our graphics display.
 * 
 * @author Connor Teal
 * @version 2/7/17
 */
public class Circle extends Shape implements Cloneable
{
    private double radius;
    
    /**
     * No Radius Constructor
     * Default radius of 1
     * 
     * @param int x coordinate
     * @param int y coordinate
     */
    public Circle(){
        this.radius = 1;
    }
    
    /**
     * clone method creates a deep copy (clone) of the casting Circle.
     * 
     * @Return Circle clone of calling circle
     */
    public Circle clone(){
        return new Circle(radius);
    }
    
    /**
     * Radius Constructor
     * 
     * @param int x coordinate
     * @param int y coordinate
     * @param double radius
     */
    public Circle(double radius){
        this.setRadius(radius);
    }
    
    /**
     * Copy Constructor
     * 
     * @param Circle to be copied
     */
    public Circle(Circle other){
        this.radius = other.radius;
    }
    
    /**
     * Calculates and Returns Area PI * R^2
     * 
     * @return double Area of Circle
     */
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    /**
     * isRadiusValid checks to see if the radius is greater than zero
     * 
     * @param double radius to check
     * @return boolean true if greater than zero
     * @throws exception when radius less than or equal to zero
     */
    private boolean isRadiusValid(double radius) throws Exception{
        if(radius <= 0){
            throw new Exception("Radius must be greater than Zero");
        }
        return true;
    }
    
    /**
     * setRadius sets the radius
     * 
     * @param double radius to be set to
     * @return Nothing
     */
    public void setRadius(double radius){
        try{
            isRadiusValid(radius);
            this.radius = radius;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * getRadius returns the radius
     * 
     * @return double radius of circle
     */
    public double getRadius(){
        return this.radius;
    }
    
    /**
     * Draw Function provided by Rob Nash and altered by Connor
     * Teal. This will draw the circle using Java's built in packages
     * for displaying shapes to a GUI.
     * 
     * @param Graphic g
     * @return Nothing
     */
    public void draw( Graphics g) {
        int Density = 1; //set the number of circles to draw
        Graphics2D g2d = (Graphics2D) g;
        
        final int x = getX();
        final int y = getY();
        
        g2d.setColor( Color.GREEN);
        
        int xOffset = 0;
        int yOffset = 0;
        
        for( int i = 0; i < Density; i++) {
            xOffset = (int) (Math.random()*radius);
            yOffset = (int) (Math.random()*radius);
            g2d.draw( new Ellipse2D.Double(x + xOffset, y + yOffset, radius, radius));
        }
    }
    
    /**
     * Equals will compare a given circle to the calling circle to test for
     * equality and return true if equal.
     * 
     * @param Circle to compare to
     * @return boolean true if equal
     */
    public boolean equals(Circle other){
        if(this.getX() == other.getX() && this.getY() == other.getY() &&
        this.getRadius() == other.getRadius()){
            return true;
        }
        return false;
    }
    
    /**
     * toString returns the name of the shape (Circle) as a string
     * 
     * @return String name of shape
     */
    @Override
    public String toString(){
        return "Circle";
    }
    
    public static void main(String[] args){
        Circle a = new Circle(1);
        Circle b = new Circle(2);
        Circle c = new Circle(b);
        Circle d = c.clone();
        
        //GetRadius Method
        assert(c.getRadius() == b.getRadius());
        assert(a.getRadius() == 1.0);
        
        //Equals Method
        assert(a.equals(a));
        assert(b.equals(c));
        assert(c.equals(b));
        assert(d.equals(c));
        
        //SetRadius
        a.setRadius(-5);
        assert(a.getRadius() == 1.0): "radius should be unchanged";
        
        a.setRadius(2.0);
        assert(a.getRadius() == 2.0);
        assert(a.equals(b));
        
        b.setRadius(3.0);
        assert(!b.equals(a));
        assert(!c.equals(b));
        
        //Area
        assert(a.getArea() < b.getArea());
        assert(a.getArea() > 0);
        assert(b.getArea() > 0);
        assert(c.getArea() > 0);
        assert(a.getArea() == c.getArea());
        
    }
}
