import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import java.awt.Color;
import info.gridworld.actor.Rock;

public class RandomBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        RandomBug bug1 = new RandomBug(Color.BLUE);
        world.add(new Rock());
        world.add(new Bug());
        world.add((bug1));
      
        world.show();
    }
}

