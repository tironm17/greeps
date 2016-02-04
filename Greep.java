import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author Michael Tirone
 * @version 0.1
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!
    
    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }

    
    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
    }
    
   public void follsowSpit(){
       
    }
    

    /**
     * Do what a greep's gotta do.
     */
    public void act()
    {
        super.act();
        if (isAtEdge() || atWater()) { 
            turn(Greenfoot.getRandomNumber(45) + 45); 
        } 
        if (carryingTomato()) {
            if(atShip()) {
                dropTomato();
            }
            else {
                move();
                if(randomChance(50)){
                    turnHome();
                }
            }
        }
        else {
            spit("red");
            move();
            checkFood();
        
        }
    }

    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
       
        
        if(tomatoes != null) {
            loadTomato();
            
        }
    }
  


    
    public static String getAuthorName()
    {
        return "Michael Tirone";  // write your name here!
    }


    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if(carryingTomato())
            return "greep-with-food.png";
        else
            return "greep.png";
    }
}

