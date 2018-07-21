public class Taximeter
{
	public final long INITIAL_CHARGE = 3;
	public final long rate = 2; // dollars per km
	
	private long timeElapsed;
	private double fare; // final fare
	private String displayed; 
	private double kmTravelled;
	private boolean isTrip;

	public Taximeter()	{
		reset();
	}

	public void reset() {
		timeElapsed = 0;
		fare = 0.0;
		kmTravelled = 0;
		displayed = "" + INITIAL_CHARGE;
		isTrip = false;
	}

	public void beginTrip() {
		fare = INITIAL_CHARGE;
		isTrip = true;
	}
	public void endTrip() {
		isTrip = false;	
	}
		
	// every second
	// input: km/h
	public void update(double speed) 
	{
		timeElapsed += 1;

		kmTravelled += speed / 3600.0;
		calcFare(speed);

		displayed = "" + ((long)(fare * 100.0)) / 100.0;
	}
	public void calcFare(double speed) {
		// how many km done in one second?
		//double km = speed / 3600.0;
		
		// increase fare by km done * rate
		fare = fare + (double)(kmTravelled * rate);
	}

	public String display() {
		displayed = "XYZ Taxi : " + displayed;
		return displayed.trim();
	}

	public void pushButton() {
		endTrip();
	}

}

