import java.util.Scanner;
public class test {
   public static void main(String[] args) {
      System.out.println("Enter your height in metres: ");
      test height; // this is DECLARING the variable; 
      Scanner keyboard = new Scanner(System.in);
      height = keyboard.nexttest(); // ASSIGNING the variable 
      System.out.println("You entered " + height + "m.");
      System.out.println("If you were 10% bigger you'd be " 
          + (height*1.1) + "m.");
      keyboard.close();
   }
}