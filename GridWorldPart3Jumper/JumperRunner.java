import java.awt.Color;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Aaron, Suvan
 *  @version 10/29/2021
 *  @author  Period: 6
 *  @author  Assignment: GridWorld_Part3_Jumper
 *
 */

/**
 * Class that tests the Jumper class
 */
public class JumperRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        Jumper jill = new Jumper();
        Location jillloc = new Location(1,3);
        world.add(jillloc, jill);
        Jumper alice = new Jumper(Color.GREEN);
        Location aliceLoc = new Location(3, 3);
        world.add(aliceLoc, alice);
        Jumper bob = new Jumper(Color.PINK);
        Location bobeLoc = new Location(5, 3);
        world.add(bobeLoc, bob);
        Jumper bill = new Jumper(Color.BLUE);
        Location billloc = new Location(7, 3);
        world.add(billloc, bill);
        Location rockLoc = new Location(5, 5);
        world.add(rockLoc, new Rock());
        world.show();
        Location flowerLoc = new Location(6,6);
        world.add(flowerLoc, new Flower());
    }
}