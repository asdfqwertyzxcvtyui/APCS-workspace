import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;

/**
 * EraseObject reads a file
 * Changes the coordinates from empty to black colored tiles
 * Changes black tiles to white tiles
 *
 *  @author  Aaron Shih
 *  @version 11/17/2021
 *  @author Period: 6
 *  @author Assignment: AB24_1EraseObject_GridWorld
 *
 */
public class EraseObject extends World<Tile>
{
    private static final Color IMGOBJ_COLOR = Color.BLACK;
    private static final Color ERASE_COLOR = Color.WHITE;
    
    /**
     * Constructs a default 20x20 grid containing black tiles
     * at the locations given in the file "digital.txt".
     */
    public EraseObject()
    {
        this( new BoundedGrid<Tile>( 20, 20 ), "digital.txt" );
    }

    /**
     * Constructs an EraseObject World with the provided grid. Populates
     * the world with black tile objects at the locations given in the 
     * specified file (fName).
     * 
     * @param bg    bounded grid used by this World
     * @param fName name of file containing location information for
     *               tile placement in this World
     */
    public EraseObject( BoundedGrid<Tile> bg, String fName )
    {
        setGrid( bg );
        getData( fName );

        setMessage( "Click on the object to be erased" );
    }

    /**
     * Overrides <code>info.gridworld.world.World&lt;Tile&lt;.locationClicked</code>
     * This method is called when the user clicks on a location in the WorldFrame.
     * Invokes the recursive erase procedure on the clicked location.
     * 
     * @param loc the grid location that the user selected
     * @return true - the world consumes the click
     */
    public boolean locationClicked( Location loc )
    {
        Grid<Tile> gr = getGrid();

        setMessage( "Tile clicked at " + loc );
        erase( gr, loc.getRow(), loc.getCol());

        return true;
    }

    /**
     *  Loads the data from the specified file containing tile locations
     *  into the this grid.
     *  
     *  The first entry in the provided text file is the number of pairs
     *  that follow (i.e., 55). Each subsequent line contains a pair of
     *  integers, separated by a blank space. Each pair is a row and column
     *  coordinate that specifies the location of a black tile in the
     *  starting grid.
     *  
     *  @param fName name of file containing tile locations
     */
    private void getData( String fName )
    {
        try {
            File file = new File(fName);
            Scanner scanner = new Scanner(file);
            int max = Integer.parseInt(scanner.nextLine());
            int count = 0;
            while(count < max) {
                String line = scanner.nextLine();
                String[] pairs = line.split(" ");
                int row = Integer.parseInt(pairs[0]);
                int col = Integer.parseInt(pairs[1]);
                Location loc = new Location(row, col);
                getGrid().put(loc, new Tile(IMGOBJ_COLOR));
                count++;
            }
        } 
        catch (NullPointerException ex) {
           System.out.println(ex);
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        catch (NoSuchElementException ex) {
            System.out.println(ex);
        }
        catch (IllegalStateException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Recursively changes the color of a series of adjacent tiles (erases)
     * starting at the given coordinates if this coordinate is part of
     * the object. The method should erase the entire object (remove black).
     *
     * @param gr     grid containing sequences of adjacent tiles
     * @param row    row coordinate to begin erasure
     * @param col    column coordinate to begin erasure
     */
    private void erase( Grid<Tile> gr, int row, int col )
    {
        Location loc = new Location(row, col);
        if (!gr.isValid(loc) || getGrid().get(loc) == null || getGrid().get(loc).getColor() == ERASE_COLOR) {
            return;
        }
        else {
            getGrid().get(loc).setColor(ERASE_COLOR);
        }
        erase(gr, row - 1, col); // go up
        erase(gr, row + 1, col); // go down
        erase(gr, row, col - 1); // go left
        erase(gr, row, col + 1); // go right
    }
    /**
     * Main function that tests the EraseObject
     * @param args input parameter to main function
     */
    public static void main( String[] args )
    {
        //new EraseObject().show();
        BoundedGrid<Tile> grid = new BoundedGrid<Tile>( 20, 20 );
        EraseObject eo = new EraseObject(grid, "G:/My Drive/APCS workspace/AB24EraseObject/digital.txt");
        eo.show();
    }
}
