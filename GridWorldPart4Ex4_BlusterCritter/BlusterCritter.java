import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;

/**
 *  Class creates a critter than can change color
 * Color changes base off the number of actors near the critter
 *  it represents, and how to use it.
 *
 *  @author  Aaron Shih
 *  @version 11/17/2021
 *  @author  Period: 6
 *  @author  Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 */
public class BlusterCritter extends Critter
{
    private int c;
    /**
     * Constructs the courage of critter 
     * @param c courage value of the critter
     */
    public BlusterCritter( int c )
    {
        this.c = c;
    }

    /**
     * Finds the number of actors near the critter
     * <br />
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location l = getLocation();
        int row = l.getRow();
        int col = l.getCol();
        for (int i = row - 2; i <= row + 2; i++) {
            for (int j = col - 2; j <= col + 2; j++) {
                Location currentLoc = new Location(i, j);
                if (!gr.isValid(currentLoc)) {
                    continue;
                }
                if (col == i && row == j) {
                    continue;
                }
                Actor scoutActor = gr.get(currentLoc);
                if (scoutActor  instanceof Actor) {
                    actors.add(scoutActor);
                }
            }
        }
        return actors;
    }

    /**
     * Determines whether the critter has more courage 
     * If the critter has more courage it lightens
     * If the critter has less courage it darkens
     * <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        if (actors.size() >= c) {
            darken();
        }
        else {
            lighten();
        }
    }

    /**
     * brightens color of critter
     */
    private void darken()
    {
        Color color = getColor();
        color = color.darker();
        setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
    }

    /**
     * Lightens color of critter
     */
    private void lighten()
    {
        Color color = getColor();
        color = color.brighter();
        setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
    }
}
