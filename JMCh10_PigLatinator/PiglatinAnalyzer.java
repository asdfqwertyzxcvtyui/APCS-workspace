import java.util.Scanner;

/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class PiglatinAnalyzer {
    private String text;

    // Constructor: saves the text string
    public PiglatinAnalyzer(String text) {
        this.text = text;
    }

    /**
     * Converts a string to it piglatin form according to the following rules: a. If
     * there are no vowels in englishWord, then pigLatinWord is just englishWord +
     * "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u', and their uppercase
     * counterparts.) b. Else, if englishWord begins with a vowel, then pigLatinWord
     * is just englishWord + "yay". c. Otherwise (if englishWord has a vowel in it
     * and yet doesn't start with a vowel), then pigLatinWord is end + start + "ay",
     * where end and start are defined as follows: 1. Let start be all of
     * englishWord up to (but not including) its first vowel. 2. Let end be all of
     * englishWord from its first vowel on. 3. But, if englishWord is capitalized,
     * then capitalize end and "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin() {
        String phraseToTranslate = text;
        String translation = "";
        String word = "";
        for (int i = 0; i < phraseToTranslate.length(); i++) {
            char c = phraseToTranslate.charAt(i);
            if (' ' == c || '.' == c || ',' == c || '?' == c || '!' == c || ';' == c || ':' == c || '-' == c || '"' == c
                    || '(' == c || ')' == c || '\n' == c) {
                if (!word.isEmpty()) {
                    translation = translation + wordToPigLatin(word);
                    word = "";
                }
                translation = translation + c;
            } else {
                word = word + c;
            }
        }
        if (!word.isEmpty()) {
            translation = translation + wordToPigLatin(word);
            word = "";
        }

        return translation;
    }

    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord) {
        String pigLatinWord = "";
        int index1 = englishWord.toLowerCase().indexOf("a");
        int min = index1;
        
        int index2 = englishWord.toLowerCase().indexOf("e");
        if (index2 > 0 && (index2 < min || min < 0)) {
            min = index2;
        }
        int index3 = englishWord.toLowerCase().indexOf("i");
        if (index3 > 0 && (index3 < min || min < 0)) {
            min = index3;
        }
        int index4 = englishWord.toLowerCase().indexOf("o");
        if (index4 > 0 && (index4 < min || min < 0)) {
            min = index4;
        }
        int index5 = englishWord.toLowerCase().indexOf("u");
        if (index5 > 0 && (index5 < min || min < 0)) {
            min = index5;
        }

        if (index1 == -1 && index2 == -1 && index3 == -1 && index4 == -1 && index5 == -1) {
            pigLatinWord = englishWord + "ay";
        } else if (index1 == 0 || index2 == 0 || index3 == 0 || index4 == 0 || index5 == 0) {
            pigLatinWord = englishWord + "yay";
        } else {
            String start = englishWord.substring(0, min);
            String end = englishWord.substring(min);
            if (Character.isUpperCase(start.charAt(0)) == true) {
                char first = Character.toUpperCase(end.charAt(0));
                end = first + end.substring(1);
                start = Character.toLowerCase(start.charAt(0)) + start.substring(1);
            }
            pigLatinWord = end + start + "ay";
        }

        return pigLatinWord;
    }

    // TODO add additional helper methods
}
