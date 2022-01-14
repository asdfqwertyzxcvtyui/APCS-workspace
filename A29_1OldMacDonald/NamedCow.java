/**
   Implements the minimum requirements specified by the Animal interface
  
   @author  Aaron Shih
   @version 10/31/2021

   Period - 6
   Assignment - A29.1 - Old MacDonald

   Sources - Roger Frank
 */
class NamedCow extends Cow
{
   private String name;
  
  /**
      Initializes a newly created Cow object so that it represents an Animal
      of the specified type that makes the specified sound.
    
      @param  name      the name of Cow
      @param  sound      the sound the Cow makes
   */
  public NamedCow(String name, String sound)
  {
    super("cow", sound);
    this.name = name;
  }

  /**
      Initializes a newly created Cow object so that it represents an Animal
      of the specified type that makes the specified sound.
    
      @param  name      the name of Cow
      @param  type       the type of the cow
      @param  sound      the sound the Cow makes
   */
  public NamedCow(String type, String name, String sound)
  {
    super(type, sound);
    this.name = name;
  }
  /**
   * Returns the name of the animal
   * @return name
   */
  public String getName()
  {
    return name;
  }
}

