import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author Aaron Shih, Suvan
 * @version 20/29/2021
 * @author Period: 6
 * @author Assignment: GridWorld_Part3_Jumper
 * 
 */
public class Jumper extends Bug implements Edible {
    /**
     * Defalut constructor sets the color of the Jumper to red
     */
    public Jumper() {
        setColor(Color.RED);
    }

    /**
     * Constructs a bug of a given color.
     * 
     * @param bugColor the color for this bug
     */
    public Jumper(Color bugColor) {
        setColor(bugColor);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act() {
        if (canMove()) {
            move();
        } 
        else {
            turn();
        }
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn() {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Move the jumper forward two steps.
     * occupied.
     */
    public void move() {
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        next = next.getAdjacentLocation(getDirection());
        moveTo(next);
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * 
     * @return true if this bug can move.
     */
    public boolean canMove() {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        /*if (!gr.isValid(next)) {
            return false;
        }*/
        next = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(next)) {
            return false;
        }
        Actor neighbor = gr.get(next);
        /*if (neighbor instanceof Edible){
            return true;
        }
        else if(neighbor == null) {
            return true;
        }
        else
        {
            return false;
        }*/
        return (neighbor == null) || (neighbor instanceof Edible);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor

    }
}