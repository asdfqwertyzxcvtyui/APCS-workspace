import java.util.ArrayList;

/**
 * This class creates an index for a random five text file
 * @author Aaron Shih
 * @version 11/16/2021
 */
public class DocumentIndex extends ArrayList<IndexEntry> {
    /** Creates an empty DocumentIndex with the default
     initial capacity.
    */
    public DocumentIndex() {
        super();
    }

    /** Creates an empty DocumentIndex with a given 
     * initial capacity.
     * @param initialCapacity the given size of a arraylist
     */
    public DocumentIndex(int initialCapacity) {
        super(initialCapacity);
    }

    /** If word is not yet in this DocumentIndex,
    * creates a new IndexEntry for word, and inserts
    * it into this list in alphabetical order;
    * adds num to this word's IndexEntry by calling
    * its add(num) method. 
    *   @param word the word that comes from a text file
    *   @param num the line number word is located from
    */
    public void addWord(String word, int num) {
        int index = foundOrInserted(word);
        get(index).add(num);
    }

    /** For each word in str, calls addWord(word, num).
     * @param num number of the line in a text file
     * @param str the current line of string from a text file
     */
    public void addAllWords(String str, int num) {
        if (str.trim().length() == 0) {
            return;
        }
        String[] myWords = str.split("\\W+");
        for (int i = 0; i < myWords.length; i++) {
            if (myWords[i] == null || myWords[i].length() == 0) {
                continue;
            }
            addWord(myWords[i].trim().toUpperCase(), num);
        }
    }

    /** Tries to find an EndexEntry with a given word in this
        DocumentIndex. If not found, inserts a new EndexEntry for
        word at the appropriate place (in lexicographical order).
        Returns the index of the found or inserted IndexEntry
        @param word given string of a text file
    */
    private int foundOrInserted(String word) {
        for (int i = 0; i < size(); i++) {
            if (word.equals(get(i).getWord())) {
                return i;
            }
            if (word.compareTo(get(i).getWord()) < 0) {
                IndexEntry elem = new IndexEntry(word);
                add(i, elem);
                return i;
            }
        }
        IndexEntry elem = new IndexEntry(word);
        add(elem);
        return size() - 1;
    }
}
