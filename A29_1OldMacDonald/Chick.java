
/**
   Implements the minimum requirements specified by the Animal interface
  
   @author  Aaron Shih
   @version 10/31/2021

   Period - 6
   Assignment - A29.1 - Old MacDonald

   Sources - Roger Frank
 */
import java.util.Random;

class Chick implements Animal {
   private String myType;
   private String mySound1;
   private String mySound2;


   /**
    * Initializes a newly created Cow object so that it represents an Animal of the
    * specified type that makes the specified sound.
    * 
    * @param type  the type of Chick
    * @param sound the sound the Chick makes
    */
   public Chick(String type, String sound) {
      myType = type;
      mySound1 = sound;
      mySound2 = sound;
   }
   /**
    * Constructor sets the type of the chick
    * @param type type of animal
    * @param sound1 first sound the animal makes
    * @param sound2 second sound the animal makes
    */
   public Chick(String type, String sound1, String sound2) {
      myType = type;
      mySound1 = sound1;
      mySound2 = sound2;
      
   }
   /**
    * Randomly choose one of the two sounds to be the sound of the chick
    * Return the sound of the animal
    * @Return mySound
    */
   public String getSound() {
      Random rd = new Random();
      if (rd.nextBoolean()) {
         return mySound1;
      }
      else {
         return mySound2;
      }
   }
   /**
    * Returns the type off the animal
    * @return myType
    */
   public String getType() {
      return myType;
   }
}