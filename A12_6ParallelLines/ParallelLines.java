import java.awt.*;
import java.time.OffsetDateTime;

import javax.swing.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.
  
   @author  TODO Your Name
   @version TODO Date

   Period - TODO Your Period
   Assignment - A12.6 - ParallelLines

   Sources - TODO list collaborators
 */
public class ParallelLines extends JPanel
{
  // TODO Your Instance Variables Here
    
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    
    int width = getWidth();    
    int height = getHeight();
    
    drawIllusion(g, width, height);
  }

  /**
     TODO Write your method description here.
     @param g
     @param width
     @param height
     @param size
   */
  public void drawIllusion(Graphics g, int width, int height)
  {
    int header = 25;
    int border = 20;
    int w = (width - (2 * border)) / (7 * 2);
    int h = (height - (2 * header)) / 8;
    int delta = (w / 8);
    int offset = 0;
    int count = 0;
    for (int row = 0; row < 8; row++) {
      if (count == 2) {
        delta = delta * (-1);
        count = 1;
      } else {
        count = count + 1;
      }
      for (int col = 0; col < 7; col++) {
          g.fillRect(border + offset + col * 2 * w, header + (row * h),  w, h);
      }
      offset = offset + delta;
      g.drawLine(border - 10, h * (row + 1) + header, w * (2 * 7) - border + 15, h * (row + 1) + header);
  }

}
  

  public static void main(String[] args)
  {
    JFrame w = new JFrame("ParallelLines");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ParallelLines panel = new ParallelLines();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
