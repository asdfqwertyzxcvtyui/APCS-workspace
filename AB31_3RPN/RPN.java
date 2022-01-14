import java.util.*;

/**
 * RPN Calculator
 *
 * @author Aaron Shih
 * @version 1/9/2021
 * @author Period: 6
 * @author Assignment: AB31RPN Calculator
 *
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner( console );
    }

    /**
     * Calls methods collectInput and compute
     */
    public void calculate()
    {
        collectInput();
        int result = compute();
    }
    /**
     * Collects userinput using scanner 
     * Stops when the user enters Q or q
     */
    public void collectInput() {
        String response = "";
        while (true) {
            response = scan.nextLine();
            if (null == response || response.length() == 0) {
                continue;
            }
            response = response.trim();
            if (response.equalsIgnoreCase("Q")) {
                break;
            }
            else {
                myQ.add(response);
            }
        }
    }
    /**
     * Computes the user input of integers and operators
     * Computes using polish notation
     * Adds userinput into a string
     * Prints the string
     * @return result
     */
    public int compute() {
        int result = 0;
        String statement = "";
        while (!myQ.isEmpty()) {
            String elem = myQ.poll();
            statement += elem + " ";
            Integer first;
            Integer second;
            switch(elem.charAt(0)) {
                case '+':
                    second = myStack.pop();
                    first = myStack.pop();
                    myStack.push(first + second);
                    break;
                case '-':
                    second = myStack.pop();
                    first = myStack.pop();
                    myStack.push(first - second);
                    break;
                case '*':
                    second = myStack.pop();
                    first = myStack.pop();
                    myStack.push(first * second);
                    break;
                case '/':
                    second = myStack.pop();
                    first = myStack.pop();
                    myStack.push(first / second);
                    break;
                default:
                    myStack.push(Integer.valueOf(elem));
                    break;
            }
        }
        result = myStack.pop();
        System.out.println(statement + "= " + result);
        return result;
    }
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}