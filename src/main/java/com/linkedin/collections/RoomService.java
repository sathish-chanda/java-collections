package com.linkedin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class RoomService {

	public static void main(String[] x) {
		System.out.println("Hello World!");
	}
	// 1. Declare a Collection to store Room Inventory
	Collection<Room> inventory;

	public RoomService() {

	// 2. Initialize Collection and assign it to the Room Inventory
		inventory = new HashSet<>();
	}

	public Collection<Room> getInventory(){
		
	// 3. Return the Room Inventory
		// This will return the copy of the inventory. Changes on this returned inventory doesn't impact the original inventory.
		return new HashSet<>(inventory);
	}
	
	public void createRoom(String name, String type, int capacity, double rate) {
	
	// 4. Add a new Room to the Room Inventory using the provided parameters
		inventory.add(new Room(name,type,capacity,rate));

	}

	public void createRooms(Room[] rooms) {
	
	// 5. Add the Rooms provided in the Array to the Room Inventory
		// Adding all rooms at once instead of iterating through the array by using addAll(Collection<E> e) method.
		inventory.addAll(Arrays.asList(rooms));

	}
	
	public void removeRoom(Room room) {
		
	// 6. Remove the provided Room from the Room Inventory
		// removes the element based on the identity comparison, that is by checking the objects address if it same or different. Therefore equals() should be overwritten to do this operation based on the value.
		inventory.remove(room);

	}

}
