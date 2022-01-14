
public class DieTest
{
  public static void main(String[] args)
  {
    Die die1 = new Die();
    Die die2 = new Die();
    die1.roll();
    System.out.println(die1.getNumDots());
    die2.roll();
    System.out.println(die2.getNumDots());
  }
}
