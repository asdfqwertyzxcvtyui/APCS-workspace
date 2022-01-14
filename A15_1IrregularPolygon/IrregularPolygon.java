import java.awt.Color;
import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

/**
 * Irregular Polygon creates different polygons 
 * with different coordinates from an arraylist
 * Irregular Polygon can returns the perimeter and area of the given polygons
 *
 * @author  Aaron Shih
 * @version 11/5/2021
 *
 * @author  Period - 6
 * @author  Assignment - Irregular Polygon
 * 
 */
public class IrregularPolygon
{
    private DrawingTool pen; // = new DrawingTool(new SketchPad(300, 300, 0));
    private ArrayList<Point2D.Double> myPolygon;

    //constuctors
    /**
     * Constructs the array list to mypolygon
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods
    /**
     * Adds a coordinate to the arraylist mypolygon
     * @param aPoint Coordinate (x,y)
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add(aPoint);
    }
    /**
     * Calculates the perimeter of a polgon
     * @return result 
     */
    public double perimeter()
    {
        double result = 0.0;
        Point2D.Double aPoint;
        Point2D.Double bPoint;
        if (myPolygon.size() < 3) {
            return result;
        }
        for (int i = 0; i < myPolygon.size(); i++) {
            aPoint = myPolygon.get(i % myPolygon.size());
            bPoint = myPolygon.get((i + 1) % myPolygon.size());
            result += aPoint.distance(bPoint);
        }
        return result;  
    }
    /**
     * Calculates the area of a polygon
     * @return result
     */
    public double area()
    {
        double result = 0.0;
        if (myPolygon.size() < 3) {
            return result;
        }
        Point2D.Double aPoint;
        Point2D.Double bPoint;
        for (int i = 0; i < myPolygon.size(); i++) {
            aPoint = myPolygon.get(i % myPolygon.size());
            bPoint = myPolygon.get((i + 1) % myPolygon.size());
            result += (aPoint.getX() * bPoint.getY());
            result -= (aPoint.getY() * bPoint.getX());
        }
        result = Math.abs(0.5 * result);
        return result;
    }
    /**
     * draws the polgon using the coordinates from a arralist myPolygon
     */
    public void draw()
    {
        Point2D.Double aPoint;
        pen.setColor(Color.BLUE);
        for (int i = 0; i < myPolygon.size(); i++) {
            if (i == 0) {
                if (pen.isDown()) {
                    pen.up();
                }
                aPoint = myPolygon.get(0);
                pen.move(aPoint.getX(), aPoint.getY());
                pen.down();
            }
            aPoint = myPolygon.get((i + 1) % myPolygon.size());
            pen.move(aPoint.getX(), aPoint.getY());
        }
    }
}
