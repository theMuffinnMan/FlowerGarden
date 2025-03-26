import ecs100.*;
import java.awt.Color;
/**
 * Write a description of class Flower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flower
{
    // fields
    private double flowerX = -100;
    private double flowerY = -100;
    
    private int flowerSize; //flower size
    private int flowerHeight; // flower height
    
    private Color color;
    
    private double left;
    private double top;
    private double bottom;
    

    /**
     * Constructor for objects of class Flower
     */
    public Flower(double x, double y, int size, int stem, Color col)
    {
        this.flowerX = x;
        this.flowerY = y;
        this.flowerSize = size;
        this.flowerHeight = stem;
        this.color = col;
        
        //set top, left, bottom
        this.setTop();
        this.setLeft();
        this.setBottom();
    }

    /**
     * set top
     *
     * @
     */
    public void setTop()
    {
        this.top = this.flowerY - this.flowerSize/2.0;
    }
    /**
     * top getter
     */
    public double getTop(){
        return this.top;
    }
    
    /**
     * set left
     */
    public void setLeft()
    {
        this.left = this.flowerX - this.flowerSize/2.0;
    }
    /**
     * left getter
     */
    public double getLeft(){
        return this.left;
    }
    
    /**
     * set bottom
     */
    public void setBottom()
    {
        this.bottom = this.flowerY + this.flowerSize/2.0;
    }
    /**
     * bottom getter
     */
    public double getBottom(){
        return this.bottom;
    }
    
    /**
     * right getter
     */
    public double getRight(){
        return this.left + this.flowerSize;
    }
    
    public void draw()
    {
        //draw stem
        UI.setColor(Color.green);
        UI.setLineWidth(2);
        UI.drawLine(this.flowerX, this.flowerY, this.flowerX, this.flowerY + this.flowerHeight);
        
        
        //draw the flower
        UI.setColor(this.color);
        UI.fillOval(this.left, this.top, this.flowerSize, this.flowerSize);
        UI.sleep(500); // wait
        
    }
    
    /**
     * Erase a rect around the current obj
     */
    public void erase()
    {
        final int BUFFER = 1;
        
        //draw a rect to erase the flower
        UI.eraseRect(this.left, this.top, this.flowerSize+BUFFER, this.bottom+BUFFER);
    }
    
    /**
     * mkae the flower grow
     */
    public void grow()
    {
        //Erase the whole thing
        this.erase();
        
        //increase the size of the flower
        
        this.flowerY -=10;//increasing the height
        this.flowerSize += 10; // increasing the size of teh bulb
        
        this.setTop();
        this.setLeft();
        
        //draw the flower again
        this.draw();
    }
}
