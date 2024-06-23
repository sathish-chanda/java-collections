package com.linkedin.collections;

import java.util.Objects;

public class Room {

	private String name;

	private String type;

	private int capacity;

	private double rate;

	public Room(String name, String type, int capacity, double rate) {
		this.name = name;
		this.type = type;
		this.capacity = capacity;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Room(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	// By default, if we are not overwriting this method. The equals() from Object class's comparison is based on the memory location of the objects which is identity based.
	// We have to overwrite this method so that comparison becomes values based.
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Room room = (Room) o;
		return capacity == room.capacity && Double.compare(rate, room.rate) == 0 && Objects.equals(name, room.name) && Objects.equals(type, room.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, type, capacity, rate);
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", type=" + type + ", capacity=" + capacity + ", rate=" + rate + "]";
	}

}
