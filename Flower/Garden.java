import ecs100.*;
import java.awt.Color;
/**
 *dirver class for flowers
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Garden
{
    // fields
    private Flower f1 = new Flower(50, 100, 20, 20, Color.blue);
    

    /**
     * Constructor for objects of class Garden
     */
    public Garden()
    {
        UI.initialise();
        UI.addButton("Grow", this::growGarden);
        
    }

    /**
     * grows the flowers in the garden
     */
    
    private void growGarden()
    {
        f1.draw();
        
        f1.grow();
    }
}
