package a4;

public class CompletedRideImpl implements CompletedRide {

	private RideRequest request;
	private Driver driver;
	private Position driverpos;
	
	public CompletedRideImpl(RideRequest request, Driver driver) {
		if (request == null) {
			throw new RuntimeException("no driven given");
		}
		if (driver == null) {
			throw new RuntimeException("no driven given");
		}

		this.request = request;
		this.driver = driver; 
		this.driverpos = driver.getVehicle().getPosition();
		
	}
	
	public RideRequest getRequest() {
		return request;
	}

	public Driver getDriver() {
		return driver;
	}

	public int getWaitTime() {
		// TODO Auto-generated method stub
		int waitTime = this.driverpos.getManhattanDistanceTo(this.getRequest().getClientPosition());
		return waitTime;
	}

	public int getTotalTime() {
		return (this.getWaitTime()) + (this.getRequest().getRideTime());
	}

	public double getCost() {
		double cost = ((0.5 * this.getRequest().getRideTime() + (0.1* this.getWaitTime())));
		return cost;
	}

	public double getPrice() {
		
		double price = 0;
		if (this.getWaitTime() < 25) {
			price = (2.5 * this.getRequest().getRideTime());
		}
		if (this.getWaitTime() >= 25) {
			price = (2 * this.getRequest().getRideTime());
		}
		if (this.getWaitTime() >= 50) {
			price = this.getRequest().getRideTime();
		}
		if (this.getWaitTime() >= 100) {
			price = (0.5 * this.getRequest().getRideTime());
			
		}
		return price;
	}
	
	public double getProfit() {
		double profit = this.getPrice()-this.getCost();
		return profit;
	}
	

}
