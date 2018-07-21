import java.io.PrintWriter;

public class Taximeter
{
	public final double INITIAL_CHARGE = 3.0;
	public final double RATE = 2.0;
	
	private double fare;
	private boolean isTrip;

	public Taximeter() {
	}

	public void startTrip() {
		fare = INITIAL_CHARGE;
		isTrip = true;
	}

	// pre: called each second
	// pre: speed is in km/h
	public void update(double speed) {
		
		if (isTrip && speed > 0) {
			// km moved in one second
			double chargeSecond = speed / 3600.0; 

			// $ for the km travelled
			chargeSecond = chargeSecond * RATE;
	
			fare = fare + chargeSecond;
		}
	}
	
	public void endTrip() {
		isTrip = false;
	}

	public double getFare() {
		return fare;
	}

	public void pressButton() {
		endTrip();
		display();
	}

	public String display() {
		String disp = "" + fare;
		return disp;
	}
	public void display(PrintWriter out) {
		out.print("" + fare);
	}


}
