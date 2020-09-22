package a7;

import java.util.*;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {
	private List<Iterable<Driver>> driver__pools;
	private List<Iterator<Driver>> driver__pools__iterators;
	private int c_Index;
	private int next__Index;
	private int list__size;
	private Driver next__Driver;
	private boolean count__Up;
	
	public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driver_pools) {
		this.driver__pools = driver_pools;
		this.driver__pools__iterators = new ArrayList<Iterator<Driver>>();
		for (Iterable<Driver> i : driver_pools) {
				if (driver_pools == null) {
					throw new IllegalArgumentException("Null");
				}
				this.driver__pools__iterators.add(i.iterator());
		}
		if (driver_pools == null) {
			throw new IllegalArgumentException("Null");
		}
		this.c_Index = 0;
		this.list__size = driver__pools__iterators.size();
		this.next__Driver = null;
		this.count__Up = true;	
	}
	

	@Override
	public boolean hasNext() {
		boolean flag = true;
		boolean reachedTwice = false;
		
		if (next__Driver != null) {
			return true;
		}
		int flag_index = c_Index;
		
		while (flag) {
			if (driver__pools__iterators.isEmpty()) {
				return false;
			}
			while (count__Up) {
				while (c_Index < list__size) {
					if (driver__pools__iterators.get(c_Index).hasNext()) {
						next__Driver = driver__pools__iterators.get(c_Index).next();
						c_Index++;
						return true;
					}
					c_Index++;
					if(c_Index == flag_index) {
						if (reachedTwice) {
							flag = false;
						}
						reachedTwice = true;
					}
				}
				count__Up = false;
				c_Index --;
			}
			
			while (!(count__Up)) {
				while (c_Index >= 0) {
					if (driver__pools__iterators.get(c_Index).hasNext()) {
						next__Driver = driver__pools__iterators.get(c_Index).next();
						c_Index--;
						return true;
					}
					c_Index--;
					if(c_Index == flag_index) {
						if (reachedTwice) {
							flag = false;
						}
						reachedTwice = true;
					}
				}
				count__Up = true;
				c_Index ++;
			}
		}
		
		return false;
	}
	
	
	@Override
	public Driver next() {
		if (!(hasNext())) {
			throw new NoSuchElementException ("No drivers left");
		} 
		Driver d = next__Driver;
		next__Driver = null;
		return d;
	}
}
