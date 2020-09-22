package a4;

	
public class VehicleImpl implements Vehicle {
	
	private String make;
	private String model;
	private String plate;
	private int mileage;
	private Position position;
	
	public VehicleImpl(String make, String model, String plate, Position position) {
		if (make == null) {
			throw new RuntimeException("vehicle not provided");
		} else
		this.make = make;
		
		if (model == null) {
			throw new RuntimeException("vehicle not provided");
		} else
		this.model = model;

		if (plate == null) {
			throw new RuntimeException("vehicle not provided");
		} else
		this.plate = plate;
		
		if (position == null) {
			throw new RuntimeException("vehicle not provided");
		} else
		this.position = position;
		this.mileage = 0;
	}

	
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getPlate() {
		return plate;
	}

	public int getMileage() {
		return mileage;
	}

	public Position getPosition() {
			return position;
	}

	public void moveToPosition(Position p) {
		if (p == null) {
			throw new RuntimeException("vehicle not provided");
		} else
		this.mileage += position.getManhattanDistanceTo(p);
		position = p;
	}

}
