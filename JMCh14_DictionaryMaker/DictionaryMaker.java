import java.util.Scanner;
import java.io.*;

/**
   Writes the number of strings that are inbetween a set minumum and maximum length

   @author  Aaron Shih
   @version 11/19/2021

   @author Period - 6
   @author Assignment - JM Ch14 - DictionaryMaker
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;
    public static Scanner fileIn;       //public for test purposes
    public static PrintWriter fileOut;  //public for test purposes

    public static void main(String[] args) throws IOException
    {
        Scanner kboard = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter input file name: ");
        String fileName = kboard.nextLine();
        openInputFile(fileName);
        if (fileIn == null)
        {
            System.out.println("*** Can't open " + fileName + " ***");
            return;
        }

        createOutputFile("JMCh14_DictionaryMaker/RamblecsDictionary.java");
        if (fileOut == null)
        {
            fileIn.close();
            System.out.println("*** Can't create RamblecsDictionary.java ***");
            return;
        }

        int count = copyWords();
        System.out.println("Done: " + count + " words.");

        fileIn.close();
        fileOut.close();
    }

    /**
     *  Opens a file fileName (in the current folder)
     *  and places a reference to it into fileIn
     */ 
    public static void openInputFile(String fileName)
    {
        try {
            File file = new File(fileName);
            fileIn = new Scanner(file);
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    /**
     *  Creates a new file fileName (in the current folder)
     *  and places a reference to it into fileOut
     */ 
    public static void createOutputFile(String fileName)
    {
        try {
            File file = new File(fileName);
            fileOut = new PrintWriter(file);
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    /**
     *  Reads all words from fileIn, selects the words that have
     *  from MINLENGTH to MAXLENGTH letters, converts them
     *  into upper case and writes the words into fileOut in
     *  Java syntax
     *  
     *  @return number of words processed
     */ 
    public static int copyWords()
    {
        int count = 0;
        if (fileIn == null) {
            return count;
        }
        String header = "public class RamblecsDictionary\n" + 
                        "{\n"  + 
                        "\tpublic String words[] =\n" +
                        "\t{\n";
        fileOut.write(header);
        while (fileIn.hasNext()) {
           String word = fileIn.next();
           if (word.length() >= MINLENGTH && word.length() <= MAXLENGTH) {
                fileOut.write("\t\t\"" + word.toUpperCase() + "\",\n");
                count++;
           }
        }
        String tail = "\t};" + 
                      "\n}";
        fileOut.write(tail);
        return count;
    }
}

