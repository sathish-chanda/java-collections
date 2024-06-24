package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Application {

	public static void main(String[] args) {
		
		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);
		
		Collection<Room> rooms = new ArrayList<>(Arrays.asList(piccadilly, cambridge, westminister));

		/**
		 * There are mainly three ways to traverse through collections in java
		 * 		 1. Loops --> Trusted while and do while loops. forEach loop.
		 * 		 	a. for loop
		 * 		 	b. do-while loop
		 * 		 	c. while loop
		 * 		 	d. for-each loop
		 * 		 2. Iterables --> These are coming Iterable Interface which is parent of the Collection Interface.
		 * 		 	a. forEach(Consumer<T>)
		 * 		 	b. iterator() --> This object will have methods such as hasNext(), next(), remove(),forEachRemaining(Consumer<T> action)
		 * 		 	c. spliterator()
		 * 		 3. Streams --> These are added in the Collection Interface. Support functional style programming in java.
		 * 		 	a. stream()
		 * 		 	b. parallerStream()
		 */

		// Iterable Approach
		Iterator<Room> iterator = rooms.iterator();
		Room r;
		while(iterator.hasNext()){
			r = iterator.next();
			System.out.format("Room Name: %s\nRoom Type: %s\nRoom Capacity: %d\nRoom Rate: %.2f\n",r.getName(),r.getType(),r.getCapacity(),r.getRate());
		}

		// For Each loop approach
		for(Room room: rooms) {
			System.out.println(room.getName());
		}

		// Using streams.
		rooms.stream().forEach(System.out::println);
	}
}
