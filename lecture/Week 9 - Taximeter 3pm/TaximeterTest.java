import java.util.Random;

public class TaximeterTest
{
	public static void runTest( int testnum, boolean result ) {

		System.out.print("Test #" + testnum + " ");
		if ( result )
		{
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	public static boolean compareFare( double expected, double actual )
	{
        if ( Math.abs( actual - expected ) < 0.01 )
        //if ( (actual - expected ) == 0.00 )
        {
            return true;
        } else {
            System.out.println(" expected: " + expected);
            System.out.println(" actual:   " + actual);
            return false;
        }
	}

	public static boolean test1() {
		Taximeter tm = new Taximeter();
		tm.startTrip();
		tm.endTrip();
		double fare = tm.getFare();

		return compareFare(3.0, fare);
	}


	// test2 no trip, expected 0
	public static boolean test2() {
		double expected = 0.0;
		Taximeter tm = new Taximeter();
		double fare = tm.getFare();

		return compareFare(expected, fare);
	}


	// test3 1 second 60km/h expected 3.033... 
	public static boolean test3() {
		// could round to 5 cents?
		double expected = 3.03;

		Taximeter tm = new Taximeter();
		tm.startTrip();
		tm.update(60);
		tm.endTrip();
		double fare = tm.getFare();

		return compareFare(expected, fare);
	}

	public static boolean testVariousSpeed(double expected, double[] speeds) {

		Taximeter tm = new Taximeter();
		tm.startTrip();


		int i = 0;
		while ( i < speeds.length )
		{
			tm.update( speeds[i] );
			i++;
		}
		tm.endTrip();

		double fare = tm.getFare();
		
		return compareFare(expected, fare);
	}

	// generate an array of n random values in the range [begin,end]
	public static double[] getRandData(int n, double begin, double end) {
			
		double[] num = new double[n];

		Random rand = new Random();

		int i = 0;
		while (i < n) 
		{
			// [0,1]
			double rdouble = rand.nextDouble();
			// [0, 1] -> trivial
			// [0, 2] -> multiply range
			// [4, 5] -> shift to start at 4
			//
			// [begin,end]
			rdouble = rdouble * (end - begin) + begin;
			
			num[i] = rdouble;			
			i++;
		}
		
		return num;
	}

	public static boolean testNeg() {
		Taximeter tm = new Taximeter();
		tm.startTrip();
		tm.update(-100); // how?
		tm.endTrip();
		return compareFare(3.0, tm.getFare());
	}

	public static void main(String[] a) {
		int testnum = 1;

		runTest( testnum++, test1() ); 
		runTest( testnum++, test2() ); 
		runTest( testnum++, test3() ); 
		
		double[] speeds = new double [] { 2, 8, 16, 20, 22, 20, 17, 9, 4, 1 };
		runTest( testnum++, testVariousSpeed(7.5, speeds) ); 
		speeds = new double [] {  8, 16, 17, 9, 4, 1, 0, 2, 4, 5, 7, 10, 5, 0 };
		runTest( testnum++, testVariousSpeed(15.3, speeds) ); 
		runTest( testnum++, testNeg());
		double[] rspeeds = getRandData(1000, -100, 0);
		runTest( testnum++, testVariousSpeed(3.0, rspeeds  ) ); 
	}


}
