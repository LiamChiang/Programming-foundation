import java.util.Scanner;

public class FirstProgram {

   public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println("I will add two numbers for you");
		System.out.println("Enter two whole numbers on one line");
		int n1, n2; // <-- this is saying we'll have two integers
		Scanner keyboard = new Scanner(System.in);
		   // The statement above lets us read input from the keyboard.
		n1 = keyboard.nextInt();   // reads the first number
		n2 = keyboard.nextInt();   // reads the next number
		System.out.println("The sum of your numbers is:");
		System.out.println(n1+n2);
		keyboard.close();
   }

}
