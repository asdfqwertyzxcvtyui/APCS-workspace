import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Color;

/**
 * Jumper tests:.
 * test01 - jumper next to edge of grid - should turn
 * test02 - jumper from edge of grid - should turn
 * test03 - Tests the jumper only once
 * test04 - Tests the jumper to jump twice
 * test05 - Changes direction of the jumper, then jumps fowards twice
 * test06 - Turns the bug twice before jumping over a rock
 * test07 - Tests the bug when it is spawned at the corner of the grid
 *
 * @author Aaron, Suvan
 * @version 10/31/2021
 *
 * @author Period: 6
 * @author Assignment - GridWorld Part 3 Jumper
 *
 */
public class JUJumperTest {
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;
    private ActorWorld world;
    private Jumper jumper1;
    private Jumper jumper2;

    /**
     * Invoked before each test to instantiate the objects used for every test.
     */
    @Before
    public void initialize() {
        grid = new BoundedGrid<Actor>(8, 8);
        world = new ActorWorld(grid);
        jumper1 = new Jumper(Color.BLUE);
        jumper2 = new Jumper();
    }

    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn() {
        Location loc = new Location(0, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn() {
        Location loc = new Location(1, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test03 - Tests the jumper only once
     */
    @Test
    public void test03() {
        Location loc = new Location(3, 3);
        world.add(loc, jumper2);
        jumper2.act();

        assertTrue(testOccupied(new Location(1, 3), jumper2, Location.NORTH));
    }

    /**
     * test04 - Test the Jumper to jump twice
     */
    @Test
    public void test04() {
        Location loc = new Location(5, 3);
        world.add(loc, jumper1);
        Flower flower1 = new Flower();
        loc = new Location(3, 3);
        world.add(loc, flower1);
        jumper1.act();
        assertTrue(testOccupied(new Location(5, 3), jumper1, Location.NORTHEAST));
    }

    /**
     * test05 - Changes directionn of the Jumper then jumps fowards twice
     */
    @Test
    public void test05() {
        Location loc = new Location(0, 3);
        world.add(loc, jumper1);
        jumper1.act();
        jumper1.act();
        jumper1.act();

        assertTrue(testOccupied(new Location(0, 5), jumper1, Location.EAST));
    }

    /**
     * test06 - Turns the bug twice before jumping over a rock
     */
    @Test
    public void test06() {
        Location loc = new Location(0, 3);
        world.add(new Location(0, 4), new Rock());
        world.add(loc, jumper1);
        jumper1.act();
        jumper1.act();
        jumper1.act();
        assertTrue(testOccupied(new Location(0, 5), jumper1, Location.EAST));
    }

    /**
     * test07 - Tests the Jumper when its spawned in the corner of the grid
     */
    @Test
    public void test07() {
        Location loc = new Location(0, 0);
        world.add(loc, jumper1);
        jumper1.act();
        jumper1.act();
        jumper1.act();
        assertTrue(testOccupied(new Location(0, 2), jumper1, Location.EAST));

    }

    /**
     * test08 - Tests the Jumper when its spawned in the corner of the grid
     */
    @Test
    public void test08() {
        Location loc = new Location(3, 3);
        world.add(loc, jumper1);
        jumper1.act();
        assertTrue(testOccupied(new Location(1, 3), jumper1, Location.NORTH));

    }

    /**
     * test09 - Tests the Jumper when its spawned in the corner of the grid
     */
    @Test
    public void test09() {
        Location loc = new Location(5, 3);
        world.add(loc, jumper1);
        jumper1.act();
        jumper1.act();
        assertTrue(testOccupied(new Location(1, 3), jumper1, Location.NORTH));

    }

    /**
     * test10 - Tests the Jumper when its spawned in the corner of the grid
     */
    @Test
    public void test10() {
        Location loc = new Location(7, 3);
        world.add(loc, jumper1);
        Rock rock = new Rock();
        loc = new Location(5, 3);
        world.add(loc, rock);
        jumper1.act();
        jumper1.act();
        assertTrue(testOccupied(new Location(5, 5), jumper1, Location.NORTHEAST));
    }

    /**
     * Test helper method to test for empty location.
     *
     * @param loc null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty(Location loc) {
        Actor empty = grid.get(loc);
        assertNull("<<<<< " + loc + " should be empty. >>>>>", empty);

        return true;
    }

    /**
     * Test helper method to test that object is in a location, and has a consistent
     * loc, and direction dir.
     *
     * @param loc location that should be occupied
     * @param a   actor that should be in location loc
     * @param dir direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied(Location loc, Actor a, int dir) {
        Actor found = grid.get(loc);
        assertSame("<<<<< " + loc + " should contain the actor. >>>>>", a, found);
        assertEquals("<<<<< Loc should be " + loc + " >>>>>", loc, found.getLocation());
        assertEquals("<<<<< Dir should be " + dir + " >>>>>", dir, found.getDirection());

        return true;
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("JUJumperTest");
    }
}