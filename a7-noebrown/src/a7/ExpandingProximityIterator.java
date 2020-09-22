package a7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {
	private Iterator<Driver> driver_iterator;
	private Iterable<Driver> driver__pool;
	private Position client__position;
	private int expansion__step;
	private Driver next__driver;
	private int count;
	private int count_2;
	private int c_ring;
	
	public ExpandingProximityIterator(Iterable<Driver> driver_pool, Position client_position, int expansion_step) {
		driver_iterator = driver_pool.iterator();
		client__position = client_position;
		expansion__step = expansion_step;
		driver__pool = driver_pool;
		next__driver = null;
		c_ring = 0;

		while (driver_iterator.hasNext()) {
			count += 1;
			driver_iterator.next();

		}

		driver_iterator = driver_pool.iterator();
	}

	
	@Override
	public boolean hasNext() {
		if (next__driver != null) {
			return true;
		}

		if (count_2 >= count) {
			return false;
		}

		while (true) {
			while (driver_iterator.hasNext()) {
				Driver iterator_next_driver = driver_iterator.next();
				if (c_ring == 0) {
					if ((client__position.getManhattanDistanceTo(iterator_next_driver.getVehicle().getPosition())) >= 0
							&& client__position
									.getManhattanDistanceTo(iterator_next_driver.getVehicle().getPosition()) <= 1) {
						next__driver = iterator_next_driver;
						return true;
					}
				} else if ((client__position.getManhattanDistanceTo(
						iterator_next_driver.getVehicle().getPosition())) > 1 + (c_ring - 1) * expansion__step
						&& client__position.getManhattanDistanceTo(iterator_next_driver.getVehicle().getPosition()) <= 1
								+ c_ring * expansion__step) {
					next__driver = iterator_next_driver;
					return true;
				}
			}
			c_ring += 1;
			driver_iterator = driver__pool.iterator();
		}
	}

	
	@Override
	public Driver next() {

		if (!hasNext()) {
			throw new NoSuchElementException("No next driver in range");
		}
		Driver result = next__driver;
		next__driver = null;
		count_2 += 1;
		return result;
	}
}