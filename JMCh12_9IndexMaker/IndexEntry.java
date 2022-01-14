import java.util.ArrayList;
/**
 * Class that creates a line of indexes from a given word
 * @author Aaron Shih
 * @version 11/16/2021
 */
public class IndexEntry {
    private String word;
    private ArrayList<Integer> numsList;

    /**Constructs an IndexEntry for a given word
    (converted to upper case); sets numsList
    to an empty ArrayList.
    @param word the given string in a text file
    */
    public IndexEntry(String word) {
        this.word = word.toUpperCase();
        numsList = new ArrayList<>();
    }

    /** Returns the word of this IndexEntry object.
     * @return word 
    */
    public String getWord() {
        return word;
    }

    /** If num is not already in the list, adds num
    at the end of this IndexEntry's list
    of numbers.
    @param num the given line number in  text file
    */
    public void add(int num) {
        if (!numsList.contains(Integer.valueOf(num))) {
            numsList.add(Integer.valueOf(num));
        }

    }

    /**Converts this IndexEntry into a string in the
    following format: the word followed by a space, followed by
    numbers separated by a comma and a space.
    @return returns obeject in string
    */
    public String toString() {
        String result = "";
        if (numsList.size() > 0) {
            for (int i = 0; i < numsList.size(); i++) {
                result = result + numsList.get(i);
                if (i < numsList.size() - 1) {
                    result = result + ", ";
                }
            }
            return this.getWord() + " " + result;
        } 
        else {
            return this.getWord();
        }
    }
}
