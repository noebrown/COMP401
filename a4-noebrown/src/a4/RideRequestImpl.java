package a4;

public class RideRequestImpl implements RideRequest {
	
	private Position clientPosition;
	private Position destination;
	private boolean rideComplete;
	private CompletedRide completeTheRide;
	
	public RideRequestImpl(Position clientPosition, Position destination) {
		if (clientPosition == null) {
			throw new RuntimeException("Something");
		} else
		this.clientPosition = clientPosition;
		if (destination == null) {
			throw new RuntimeException("Something");
		} else
		this.destination = destination;

		this.rideComplete = false;
		
	}


	public Position getClientPosition() {
		return clientPosition;
	}


	public Position getDestination() {
		return destination;
	}


	public boolean getIsComplete() {
		return rideComplete;
	}


	public CompletedRide complete(Driver driver) {
		
		if (driver == null) {
			throw new RuntimeException("Something");
		}
		if (!this.rideComplete) {			
			this.rideComplete = true;
			this.completeTheRide = new CompletedRideImpl(this, driver);
			driver.getVehicle().moveToPosition(this.getClientPosition());
			driver.getVehicle().moveToPosition(this.getDestination());
			return this.completeTheRide;
		
		}
		
		return completeTheRide; //completed ride object;
	}


	public int getRideTime() {
		int ridetime = this.clientPosition.getManhattanDistanceTo(this.destination);
		return ridetime;
	}
}
