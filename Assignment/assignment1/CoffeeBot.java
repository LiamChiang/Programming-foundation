import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		if (n < 0 && m < 0) {
			System.out.println("Negative supply chain. System terminating.");
			return;
		}
		if (n < 0) {
			System.out.println("Negative supply chain. System terminating.");
			return;
		}
		if (m < 0) {
			System.out.println("Negative supply chain. System terminating.");
			return;
		}
		if (args.length == 0) {
			System.out.println("No arguments. System terminating.");
			return;
		}
		if (args.length == 1) {
			System.out.println("Not enough arguments.System terminating.");
			return;
		}
		if (args.length == 3) {
			System.out.println("Too many arguments. System terminating.");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.print("Hello, What is your name?");
		String n1 = in.nextLine();
		String n2;
		while (true) {
			System.out.print("Would you like to order some coffee, " + n1 + "?" + " " + "(y/n)");
			n2 = in.next(); // n2 = y or n
			if (n2.equals("y")) {
				System.out.println("Great! Let's get started.");
				break;
			} else if (n2.equals("n")) {
				System.out.println("Come back next time" + " " + n1);
				return;
			}
			System.out.println("Invalid response. Try again.");
		}
		System.out.println("               ");
		System.out.println("Order selection");
		System.out.println("---------------");
		System.out.println("               ");
		System.out.println("               ");
		System.out.println("There is " + n + " coffee cup in stock and each costs $2.00.");
		System.out.println("There is " + m + " coffee shot in stock and each costs $1.00.");
		System.out.print("How many cups of coffee would you like?");
		int cups = in.nextInt();
		if (cups == 0) {
			System.out.println("No cups, no coffee. Goodbye.");
		} else if (cups < 0) {
			System.out.println("Does not compute. System terminating.");
		} else if (cups > n) {
			System.out.println("Not enough stock. Come back later.");
		}
		

	}
}
