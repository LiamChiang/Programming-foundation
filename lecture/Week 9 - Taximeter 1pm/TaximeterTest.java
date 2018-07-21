public class TaximeterTest
{
	public static String errors;

	public static boolean compareDisplay(String expected, String actual) {
		if (actual.equals(expected)) {
			return true;
		}
	
		errors = "";
		errors += "expected len: " + expected.length() + "\n";
		errors += "actual len: " + actual.length() + "\n";

		for (int i = 0; i < expected.length(); i++ ) {
			errors += "."+expected.charAt(i)+".";
		}
		errors += "\n";
		for (int i = 0; i < actual.length(); i++ ) {
			errors += "."+actual.charAt(i)+".";	
		}
		errors += "\n";
			
		return false;
	}

	public static boolean testInit()
	{
		// test 1
		String expected = "XYZ Taxi : 3";
		Taximeter tm = new Taximeter();
		String disp = tm.display();

		return compareDisplay(expected, disp);
	}
	public static boolean testNegative()
	{
		String expected = "XYZ Taxi : 3";
		Taximeter tm = new Taximeter();
		String actual = tm.display();

		tm.beginTrip();
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.update(-100);
		tm.endTrip();

		return compareDisplay(expected, actual);
	}


	public static boolean test100_1second() {
		String expected = "XYZ Taxi : 3.05";
		
		Taximeter tm = new Taximeter();
		tm.beginTrip();

		tm.update(100);

		tm.endTrip();

		String actual = tm.display();
		
		return compareDisplay(expected, actual);
	}

	public static boolean testGetInOut() {
		String expected = "XYZ Taxi : 3.0";
		Taximeter tm = new Taximeter();
	
		tm.beginTrip();
		tm.update(0);
		tm.endTrip();
		
		String actual = tm.display();
		return compareDisplay(expected, actual);
	}

	public static boolean testSpeedUpSlowDown(String expected, int[] speeds)
	{
		Taximeter tm = new Taximeter();

		tm.beginTrip();	

		int i = 0;
		while (i < speeds.length) 
		{
			tm.update(speeds[i]);
			i++;
		}
		
		tm.endTrip();	

		String actual = tm.display();
		return compareDisplay(expected, actual);
	}


	public static void runTest( int testNum, boolean result ) {
		System.out.print("Test: " + testNum + " ");
		if (result)  {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
			System.out.println(errors);
		}
	}

	public static void main(String[] a) 
	{
		int testNum = 1;
		runTest( testNum++, testInit() );
		runTest( testNum++, test100_1second() );
		
		String expected = "50,000";
		int[] speeds = { 1, 4, 14, 25, 30, 30, 20, 10, 4, 1};
		runTest( testNum++, testSpeedUpSlowDown(expected, speeds) );
		speeds = new int[] {1, 2, 3, 4};
		runTest( testNum++, testSpeedUpSlowDown("XYZ Taxi : 7.50", speeds));

		runTest( testNum++, testNegative() );
		
		//System.out.println ( String.format("%.2f", 5.324324));
		
//		runTest( testBeginTrip() );
//		runTest( testSimpleTrip() );
//		runTest( testNegativeSpeed() );
	}
}

