package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Application {

	public static void main(String[] args) {

		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room manchester = new Room("Manchester", "Suite", 5, 250.00);
		Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Room victoria = new Room("Victoria", "Suite", 5, 225.00);
		Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);

		Collection<Room> rooms = new ArrayList<>(Arrays.asList(piccadilly, cambridge, westminister));
		
		for(Room room : rooms) {
			
			if(room.getType().equals("Suite")) {
				rooms.remove(room);
			}
			
		}
		
		System.out.println(rooms);
		
	}
}
