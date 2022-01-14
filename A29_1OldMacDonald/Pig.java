/**
   Implements the minimum requirements specified by the Animal interface
  
   @author  Aaron Shih
   @version 10/31/2021

   Period - 6
   Assignment - A29.1 - Old MacDonald

   Sources - Roger Frank
 */
class Pig implements Animal
{
   private String myType;
  private String mySound;
  
  /**
   *   Initializes a newly created Cow object so that it represents an Animal
   *   of the specified type that makes the specified sound.
   * 
   *   @param  type       the type of Pig
   *   @param  sound      the sound the Pig makes
   */
  public Pig(String type, String sound)
  {
    myType = type;
    mySound = sound;
  }
  /**
   * Returns sound of the animal
   * @return mySound
   */
  public String getSound()
  {
    return mySound;
  }
  /**
   * Returns type of animal
   * @return myType
   */
  public String getType()
  {
    return myType;
  }
}