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
    //test
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
                    turn(180);
                }
                else {
                    move();
                   aroundCrap();
                }
            }
            else {
                
                checkFood(); 
                stopatPile();
            }
            
    }
 
    
    
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if(tomatoes != null) {
            loadTomato();
            spit("purple");
        }
    } 
    public void stopatPile(){
        if(!seePaint("purple")){
            move();
        }
    }
    
    
    public void aroundCrap(){ //Made into method
         if(randomChance(50)){
                    turnHome();
                }
    }
    
    public void StopGreeps(){
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        
            
            
        }
    
    
    public static String getAuthorName()
    {
        return "Michael Tironey";  // write your name here!
    }
    
    public String getCurrentImage()
    {
        if(carryingTomato())
            return "greep-with-food.png";
        else
            return "greep.png";
    }
}

