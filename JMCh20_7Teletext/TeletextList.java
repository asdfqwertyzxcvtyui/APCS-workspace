// Implements the list of messages for teletext

import java.awt.Graphics;
/**
 * Class TeletextList creates a list of strings
 * allows the user to add and delete strings
 * @author Aaron Shih
 * @version 1/7/2021
 */
public class TeletextList
{
    private ListNode2<String> heading;
    private ListNode2<String> topNode;

    /**
     * Creates a circular list of headlines. First creates a circular list
     * with one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings
     * from headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines  Strings to add to circular list
     */
    public TeletextList(String[] headlines)
    {
        ListNode2 before = new ListNode2<String>("", null, null);
        heading = new ListNode2<String>("Today's headlines:", before, null);
        before.setNext(heading);
        ListNode2 after = new ListNode2<String>("", heading, null);
        heading.setNext(after);
        ListNode2 prev = after;
        for (int i = 0; i < headlines.length; i++) {
            addAfter(prev, headlines[i]);
            prev = prev.getNext();
        }
        prev.setNext(before);
        before.setPrevious(prev);
        topNode = heading;
    }

    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg  String to add to headlines list
     */
    public void insert(String msg)
    {
        ListNode2 prev = heading.getNext();
        ListNode2 nxt = heading.getNext().getNext();
        ListNode2 item = new ListNode2<String>(msg, prev, nxt);
        nxt.setPrevious(item);
        prev.setNext(item);
    }

    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        ListNode2 temp = topNode.getNext();
        if ((temp == null) || (temp == heading)) {
            return;
        }
        if (temp.getValue().equals("")) {
            return;
        }
        ListNode2 prev = temp.getPrevious();
        ListNode2 nxt = temp.getNext();
        nxt.setPrevious(prev);
        prev.setNext(nxt);
    }

    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }

    /**
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     * @param node node to be aadded behind
     * @param msg String to be added to the linkedlist
     * @return newNode
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = 
            new ListNode2<String>(msg, node.getPrevious(), node);
        node.getPrevious().setNext(newNode);
        node.setPrevious(newNode);
        return newNode;
    }

    /**
     * Adds a new node with msg to the headlines list after a given node.
     * Returns a referenece to the added node.
     * @param node node to be added after the headlines
     * @param msg String messagee added to the linkedlist
     * @return item
     */
    private ListNode2<String> addAfter(ListNode2<String> node, String msg)
    {
        ListNode2 item = new ListNode2<String>(msg, node, node.getNext());
        if (node.getNext() == null) {
            node.setNext(item);
        }
        node.getNext().setPrevious(item);
        node.setNext(item);
        return item; 
    
    }
    /**
     * Removes a given node from the list.
     * @param node node to be removed from the list
     */
    private void remove(ListNode2<String> node)
    {
        ListNode2 nxt = node.getNext();
        ListNode2 prev = node.getPrevious();
        nxt.setPrevious(prev);
        prev.setNext(nxt);
    }

    /**
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * @param x x coordinate
     * @param y y coordinaate
     * @param g Graphics
     * @param lineHeight Height of the lines
     * @param nLines number of lines
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }

    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node.getNext() != heading;
              node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
