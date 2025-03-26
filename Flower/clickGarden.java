import ecs100.*;
import java.awt.Color;
/**
 * Clickgarden here object in arrays
 * create a garden with each object in an array
 * click on the flower to make it grow
 *
 * @fleur
 * @26/3
 */
public class clickGarden
{
        // fields
        private final int STARTX = 75;
        private final int YPOS = 100;
        private final int MAXFLOWERS = 5;
        
        private Flower[] flowerBed = new Flower[MAXFLOWERS]; // array of the flowers
    
        /**
         * Constructor for objects of class ClickGarden
         */
        public clickGarden()
        {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Random Grow", this::randomGrow);
        
        // set up the flowers, positions
        for (int i = 0; i < MAXFLOWERS; i++){
            //set every flower to a random color
            Color col = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
            flowerBed[i] = new Flower(STARTX * (i + 1), YPOS, 10, 50, col); // create the flower object
        }
            
        // draw flowers, for each flower
        for (Flower flower : flowerBed){
            flower.draw();
        }
            
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * random grow the flowers in the array
     */
    public void randomGrow(){
        for (int i = 0; i <10; i++){
            int randomFlower = (int)(Math.random() * MAXFLOWERS); // choose a random flower to grow
            flowerBed[randomFlower].grow(); // make a random flower grow
        }
    }
    /**
     * Select obj based on where the user clicks
     */
    
    private void doMouse(String action, double x, double y){
        if(action.equals("clicked")){
            //check the loc of the x and y against the loc of hte obj
            for (Flower flower : flowerBed)
            {
                if((x >= flower.getLeft()) &&(x <=flower.getRight()) &&
                (y >= flower.getTop()) && (y <= flower.getBottom())){
                    flower.grow();
                }
            }
        }
    }
    public static void main(String[] args){
        clickGarden obj = new clickGarden();
    }
}
