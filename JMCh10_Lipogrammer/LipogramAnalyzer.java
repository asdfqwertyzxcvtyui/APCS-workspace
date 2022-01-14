/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - TODO list collaborators
 */
public class LipogramAnalyzer {
    private String text;

    /**
     * Constructor: Saves the text string
     * 
     * @param text String to analyze
     */
    public LipogramAnalyzer(String text) {
        this.text = text.toLowerCase();
    }

    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark(char letter) {
        String s2 = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != letter) {
                s2 = s2 + text.substring(i, i + 1);
            } else {
                s2 = s2 + "#";
            }
        }
        return s2;
    }

    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once; there
     * are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith(char letter) {
        String result = "";
        String firstItem = null;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!((text.charAt(i) >= ' ' && text.charAt(i) <= '/') || (text.charAt(i) == '@' || text.charAt(i) == '^'
                    || text.charAt(i) == '?' || text.charAt(i) == '='))) {
                if (c == letter) {
                    String extract = extractWord(i);
                    if (extract != null) {
                        if (result.equals("")) {
                            firstItem = extract;
                            result = extract + '\n'; 
                        } else if (extract.equals(firstItem) == true) {
                            // NO-OP
                        } else if (result.contains('\n' + extract + '\n') == false) {  
                            result = result + extract + '\n'; 
                        }
                    }
                } 
            }
        }
        return result;
    }

    // made public for test purposes
    /*
     * Returns the word that contains character at pos excluding any punctuation or
     * whitespace.
     * 
     * @param pos location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord(int pos) {
        int right = pos;
        int left = pos;
        int rightCount = 0;
        int leftCount = 0;
        Boolean a = true;
        Boolean b = true;
        if ((text.charAt(pos) >= ' ' && text.charAt(pos) <= '/') || text.charAt(pos) == '@' || text.charAt(pos) == '^'
                || text.charAt(pos) == '?' || text.charAt(pos) == '=' || text.charAt(pos) == '\n') {
            return null;
        }
        while (a == true && right < text.length()) {
            if ((text.charAt(right) >= ' ' && text.charAt(right) <= '/') || text.charAt(right) == '@'
                    || text.charAt(right) == '^' || text.charAt(right) == '?' || text.charAt(right) == '='
                    || text.charAt(right) == '\n') {
                rightCount = right;
                a = false;
            }
            right++;
        }
        if (a == true) {
            rightCount = text.length();
        }

        while (b == true && left >= 0) {
            if ((text.charAt(left) >= ' ' && text.charAt(left) <= '/') || text.charAt(left) == '@'
                    || text.charAt(left) == '^' || text.charAt(left) == '?' || text.charAt(left) == '='
                    || text.charAt(left) == '\n') {
                leftCount = left + 1;
                b = false;
            }
            if (b == true) {
                left--;
            }
        }
        return text.substring(leftCount, rightCount);
    }
}
