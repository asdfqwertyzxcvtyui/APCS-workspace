import info.gridworld.actor.Actor;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   @author  Period - TODO Your Period
   @author  Assignment - GridWorld Part 2, Exercise 2 - SpiralBugRunner

   @author  Sources - TODO list collaborators
 */
public class SpiralBugRunner
{
    public static void main( String[] args )
    {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(grid);
        SpiralBug bug1 = new SpiralBug(4);
        world.add(bug1);
        world.show();
        int n = 123;
        n = ((n / 100)*100)  + ((n % 10) * 10) + (((n % 100) - (n % 10)) / 10);
        System.out.println(n);
    }
}