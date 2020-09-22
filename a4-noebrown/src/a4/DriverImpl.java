package a4;

public class DriverImpl implements Driver {

	private String first;
	private String last;
	private int id;
	private Vehicle vehicle;

	public DriverImpl(String first, String last, int id, Vehicle vehicle) {
		if (first == null) {
			throw new RuntimeException("vehicle not provided");
		} else
			this.first = first;
		if (last  == null) {
			throw new RuntimeException("vehicle not provided");
		} else
		this.last = last;
		this.id = id;
		if (vehicle == null) {
			throw new RuntimeException("vehicle not provided");
		} else
		this.vehicle = vehicle;
	}

	public String getFirstName() {


			return first;
	}

	public String getLastName() {
			return last;
	}

	public String getFullName() {
			return first + " " + last;
	}

	public int getID() {
		return id;
	}

	public Vehicle getVehicle() {
		return this.vehicle;

	}

	public void setVehicle(Vehicle v) {
		if (v == null) {
			throw new RuntimeException("vehicle not provided");
		} else
			this.vehicle = v;
	}

}
