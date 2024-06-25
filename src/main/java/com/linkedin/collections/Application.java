package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {

		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room manchester = new Room("Manchester", "Suite", 5, 250.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Room victoria = new Room("Victoria", "Suite", 5, 225.00);

		Collection<Room> rooms = new ArrayList<>(Arrays.asList(cambridge, oxford, victoria, manchester));
		oxford.setPetFriendly(true);
		victoria.setPetFriendly(true);

		System.out.println("Traversing collection using simple for loop.");
		for(Room room : rooms) {
			if(room.isPetFriendly()) {
				System.out.println(room.getName());
			}
		}

		System.out.println("\n\nTraversing collections using streams. These are just like pipelines.");
		// Functional interfaces.
		rooms.stream() // stream or start of the pipeline.
				.filter(new Predicate<Room>() { // anonymous class
					@Override
					public boolean test(Room room) {
						System.out.format("Testing %s with result %b\n",room.getName(),room.isPetFriendly());
						return room.isPetFriendly();
					}
				}).forEach(new Consumer<Room>() {
					@Override
					public void accept(Room room) {
						System.out.println(room.getName());
					}
				});

		System.out.println("\n\nStreams and Lambda expressions");
		// Lambda expressions. Lambda is a function that only has parameters, arrow and body. Method name and return type are unnecessary.
		rooms.stream() // stream or start of the pipeline.
				.filter( room -> room.isPetFriendly())
				.forEach( room -> System.out.println(room.getName()));


		System.out.println("\n\nStreams and Lambda expressions - shorter form using class method.");
		// Lambda expressions. Lambda is a function that only has parameters, arrow and body. Method name and return type are unnecessary.
		rooms.stream() // stream or start of the pipeline.
				.filter(Room::isPetFriendly)
				.forEach( room -> System.out.println(room.getName()));

		// More Stream operations
		Collection<Room> petFriendlyRooms = new ArrayList<>();

		rooms.stream()
				.filter(room -> room.isPetFriendly())
				.forEach(room -> petFriendlyRooms.add(room));
		System.out.println("\nPetfriendlyRoom Elements");
		petFriendlyRooms.stream()
				.forEach(room -> System.out.println(room.getName()));

		Collection<Room> animalFriendlyRooms = rooms.stream()
				.filter(room -> room.isPetFriendly())
				.collect(Collectors.toList());

		System.out.println(animalFriendlyRooms);
		// Using map operator which will only pass the Name to next pipeline.
		animalFriendlyRooms.stream()
				.map(r -> r.getName())
				.forEach(System.out::println);

		// Using mapToDuble.
		double total = animalFriendlyRooms.stream()
				.mapToDouble(r -> r.getRate())
				.sum();

		System.out.println("Total = " + total);
	}
}









