
/**
   Class that prints out the sounds and types of each animal 
   as well as the name of the cows
  
   @author  Aaron Shih
   @version 11/1/2021

   Period - 6
   Assignment - A29.1 Old MacDonald
 */
public class Farm
{
   private Animal[] a = new Animal[3];

   /**
    * Default constructor that constructs the animal type, name, and sounds
    */
   public Farm()
   {      
      a[0] = new NamedCow("cow", "Elsie", "moo");
      a[1] = new Chick("chick", "cluckity cluck", "cheep");
      a[2] = new Pig("pig","oink oink");
   }
   /**
    * Method prints out the sounds of each animal and type
    * Prints out the type, name, and sound for a cow
    */
   public void animalSounds()
   {
      for (int i = 0; i < a.length; i++)
      {
         System.out.println(a[i].getType() + " goes " + a[i].getSound());
      }
      NamedCow named = (NamedCow)a[0];
      System.out.println( named.getType() + " is named " + named.getName() );
   }
}

