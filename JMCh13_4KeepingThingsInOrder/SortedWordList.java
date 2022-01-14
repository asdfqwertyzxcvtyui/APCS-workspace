/**
 * Implements a sorted list of words
 * 
 * @author Aaron Shih
 * @version 11/25/2021
 * 
 * @author Period - 6
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 */
public class SortedWordList extends java.util.ArrayList<String> {
  /**
   * Creates an arraylist with default size 10
   */
  public SortedWordList() {
    super();
  }

  /**
   * Creates a given arraylist size
   * 
   * @param i Arraylist size
   */
  public SortedWordList(int i) {
    super(i);
  }

  /**
   * Redefines the set method to compare strings
   * If a string is not in alphebetical order
   * an IllegalArguementException is thrown
   * If conditions are met, set returns the set word at a specified index
   * 
   * @param i    Index of changed word
   * @param word Specified word to be changed
   * @return super.set(i, word);
   */
  public String set(int i, String word) throws IllegalArgumentException {
    if (i < 0 || i > size() || size() == 0) {
      throw new IllegalArgumentException("word =" + word + " i =" + i);
    }
    if (get(i).equals("") || word.equals("")) {
      return super.set(i, word);
    }
    if (i == 0 && word.compareTo(get(i + 1)) < 0) {
      return super.set(i, word);
    }
    if (i == size() - 1 && word.compareTo(get((size() - 2))) > 0) {
      return super.set(i, word);
    }
    if ((word.compareTo(get(i - 1)) < 0) || word.compareTo(get(i + 1)) > 0) {
      throw new IllegalArgumentException("word = " + word + " i = " + i);
    }
    return super.set(i, word);
  }

  /**
   * Determines if a object is contained in a arralist
   * 
   * @param word Checks if word is contained in a arraylist
   * @return indexOf(word) >= 0
   */
  public boolean contains(String word) {
    return indexOf(word) >= 0;
  }

  /**
   * Returns the location of a certain obeject in a arralist
   * Returns -1 if the object is not found
   * 
   * @param word Specified word to be found
   * @return target
   */
  public int indexOf(String word) {
    int left = 0;
    int right = size() - 1;
    for (int i = 0; i < size() / 2; i++) {
      int target = (left + right) / 2;
      if (word.compareTo(get(target)) == 0) {
        return target;
      } else if (word.compareTo(get(target)) < 0) {
        right = target;
      } else {
        left = target;
      }
    }
    return -1;
  }

  /**
   * Adds a specified String to the end of an arraylist
   * 
   * @param word
   * @return true if word is added. Otherwise false is returned
   */
  public boolean add(String word) {
    if (size() == 0) {
      add(0, word);
      return true;
    }
    if (contains(word)) {
      return false;
    } else {
      int left = 0;
      int right = size() - 1;
      for (int i = 0; i < size() / 2; i++) {
        int target = (left + right) / 2;
        if (word.compareTo(get(target)) > 0 && word.compareTo(get(target + 1)) < 0) {
          add(target + 1, word);
          return true;
        }
        if (word.compareTo(get(target)) < 0) {
          right = target;
        } else {
          left = target;
        }
      }
      if (word.compareTo(get(size() - 1)) > 0) {
        add(size(), word);
        return true;
      } else if (word.compareTo(get(0)) < 0) {
        add(0, word);
        return true;
      } else {
        return false;
      }
    }
  }

  /**
   * Adds a string at a specified index if it is in alphebetical order
   * If the word is not in alphabetical order, a IllegalArguementException is
   * thrown
   * 
   * @param i    Specified Index for string to be added
   * @param word Word to be added
   * @throws IllegalArgumentException
   */
  public void add(int i, String word) throws IllegalArgumentException {
    if (i == 0 && (size() == 0 || word.compareTo(get(0)) < 0)) {
      super.add(i, word);
      return;
    }
    if (i == size() && word.compareTo(get((size() - 1))) > 0) {
      super.add(i, word);
      return;
    }
    if ((i - 1) < 0 || i > size()) {
      throw new IllegalArgumentException("word = " + word + " i = " + i);
    }
    if ((!word.equals("")) && ((word.compareTo(get(i - 1)) < 0) || (word.compareTo(get(i)) > 0))) {
      throw new IllegalArgumentException("word = " + word + " i = " + i);
    }
    super.add(i, word);
  }

  /**
   * Merges two strings that are in alphabetical order
   * Strings that repeat are not merged together
   * 
   * @param additionalWords An arralist containing strings in alphabetical order
   */
  public void merge(SortedWordList additionalWords) {
    int lastIndex = size() - 1;
    int count = 1;
    for (int i = 0; i < additionalWords.size(); i++) {
      if (contains(additionalWords.get(i))) {
        additionalWords.remove(i);
        i--;
        continue;
      } else {
        add(size(), "");
      }
    }
    for (int i = additionalWords.size() - 1; i >= 0; i--) {
      for (int j = lastIndex; j >= 0; j--) {
        if (additionalWords.get(i).compareTo(get(j)) > 0) {
          set(size() - count, additionalWords.get(i));
          count++;
          break;
        } else {
          set(size() - count, get(j));
          set(j, "");
          if (lastIndex > 0) {
            lastIndex = j - 1;
          } else {
            j++;
          }
          count++;
        }
      }
    }
  }
}
