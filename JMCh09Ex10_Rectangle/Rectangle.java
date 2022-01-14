/**
 * Create Rectangle class per instructions in lab.
 *
 * @author TODO
 * @version TODO
 * @author Period: TODO
 * @author Assignment: JMCh09Ex10_Rectangle
 */
public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int w, int h) {
        height = h;
        width = w;
        if (width == 0 || height == 0) {
            throw new IllegalArgumentException(
                "Rectangle construction error: value is too small to build rectangle");
        }
    }
    public Rectangle( int square) {
        width = square;
        height = square;
        if (square == 0) {                                                  
            throw new IllegalArgumentException(
                "Rectangle construction error: value is too small to build rectangle");
        }
    }
    public Rectangle() {
        width = 1;
        height = 1;
    }
    public boolean isSquare() {
        if ( width == height) {
            return true;
        }
        return false;
    }
    public void quadratize() {
        int area = width * height;
        width = (int)Math.round(Math.sqrt(area));
        height =  (int)Math.round(Math.sqrt(area));
        System.out.println(height + "" + width);
    }
    public String toString()
    {
        return width + " x " + height; }
    }

