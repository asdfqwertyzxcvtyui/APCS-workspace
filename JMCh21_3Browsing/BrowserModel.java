import java.util.Stack;
/**
 * @author Aaron Shih
 * @version 1/17/2021
 * BrowserModel creates a browser
 * Broweses multiple lines of text in a file
 */
public class BrowserModel
{
    private BrowserView view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int topLine;
    /**
     * Contructs BrowserModel
     * @param myView current link being viewed
     */
    public BrowserModel(BrowserView myView) {
        topLine = 0;
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        myView.update(0);
        this.view = myView;
    
    }
    /**
     * Updates the view
     * Update topLine to previous link
     */
    public void back()
    {
        if (hasBack())
        {
            forwardStk.push(topLine);
            topLine = backStk.pop();
            view.update(topLine);
        }
    }
    /**
     * Moves the view to link before back
     * Move topLine to the linl before back
     */
    public void forward()
    {
        if (hasForward())
        {
            int temp = forwardStk.pop();
            backStk.push(topLine);
            topLine = temp;
            view.update(topLine);
        }
    }
    /**
     * Returns topLine to the first link of the file
     * 
     */
    public void home()
    {
        if (topLine != 0)
        {
            view.update(0);
            backStk.push(topLine);
            topLine = 0;
            forwardStk.removeAllElements();
        }
    }
    /**
     * Follows the link on a given line
     * @param n follows link on line n
     */
    public void followLink(int n)
    {
        view.update(n);
        backStk.push(topLine);
        topLine = n;
        forwardStk.clear();
    }
    /**
     * Checks if the stack has back
     * @return true if has back, false if not
     */
    public boolean hasBack()
    {
        if (backStk.size() == 1 && backStk.peek() == 0)
        {
            return false;
        }
        return !backStk.isEmpty();
    }
    /**
     * Checks if there is a foward
     * @return true if there is foward, false if not
     */
    public boolean hasForward()
    {
        return !forwardStk.isEmpty();
    }

    // The following are for test purposes only
    /**
     * Returns backStck
     * @return backStk
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }
    /**
     * Returns fowardStk
     * @return fowardStk
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }
    /**
     * Returns topLine
     * @return topLine
     */
    public int getTopLine()
    {
        return topLine;
    }
}

