/**
   Main class that tests the sounds, types, and names of the animals
  
   @author  Aaron Shih
   @version 10/31/2021

   Period - 6
   Assignment - A29.1 - Old MacDonald

   Sources - Roger Frank
 */
class OldMacDonald
{
   /**
    * Calls on the type and sound for a cow animal
    * Creates a farm obeject
    * then calls the farm to test the sounds, type, an names of a animal
    * @param args Main function
    */
   public static void main(String[] args)
   {
      Cow c = new Cow("cow", "moo");
      System.out.println( c.getType() + " goes " + c.getSound() );
      Farm f = new Farm();
      f.animalSounds();
   }
}
