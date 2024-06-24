package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Application {

	public static void main(String[] args) {

		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room manchester = new Room("Manchester", "Suite", 5, 250.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Room victoria = new Room("Victoria", "Suite", 5, 225.00);
		
		Collection<Room> rooms = new ArrayList<>(Arrays.asList(cambridge, oxford, victoria, manchester));
		oxford.setPetFriendly(true);
		victoria.setPetFriendly(true);


		// This will raise concurrent modification exception. It can be triggered if we try to add or remove, change the collection inside of a loop.
//		for(Room room : rooms) {
//			if(room.isPetFriendly()) {
//				rooms.remove(room);
//			}
//		}
		/* Error message with the above code.
		Exception in thread "main" java.util.ConcurrentModificationException
			at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1043)
			at java.base/java.util.ArrayList$Itr.next(ArrayList.java:997)
			at com.linkedin.collections.Application.main(Application.java:23)
		 */

		// Approach 1: Removing element from a collection while iterating through the collection.
		Collection<Room> removeRooms = new ArrayList<>();
		for(Room room : rooms) {
			if(room.isPetFriendly()) {
				System.out.println("Removing element is added to the list " + room.getName());
				removeRooms.add(room);
				break;
			}
		}
		rooms.removeAll(removeRooms);

		// Approach 2: Using iterator.
		Iterator<Room> iterator = rooms.iterator();
		while(iterator.hasNext()){
			if(iterator.next().isPetFriendly()) {
				System.out.println("Removing element using iterator");
				iterator.remove();
			}
		}

		rooms.stream().forEach(room -> System.out.println(room.getName()));
		System.out.println(rooms);
		
	}
}
