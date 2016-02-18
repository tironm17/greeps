import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author Michael Tirone
 * @version 0.1
 */
public class Greep extends Creature
{
   
 
    public Greep()
    {
        this(null);
    }

    public Greep(Ship ship)
    {
        super(ship);
    }
     
    public void act()
    {
        super.act();
        if (isAtEdge() || atWater()) { 
                turn(Greenfoot.getRandomNumber(45) + 40);
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
        // c heck whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if(tomatoes != null) {
            loadTomato();
            totheCenter();
            
            }
    
    }
    public void totheCenter() //turn torwards the center
    {
        turnTowards(getOneIntersectingObject(TomatoPile.class).getX(),getOneIntersectingObject(TomatoPile.class).getY());
       move();
    }
    
    public void stopatPile(){
        if(!seePaint("purple")){ //if it see paint doesnt move
            move();
        }
     
    }
    
    public void aroundCrap(){ //Made into method
         if(randomChance(50)){
                    turnHome();
                    
                }
    }
          
    public static String getAuthorName()
    {
        return "DAYO DAYO MIKE ";  // write your name here!
    }
    
    public String getCurrentImage()
    {
        if(carryingTomato())
            return "greep-with-food.png";
        else
            return "greep.png";
    }
}

