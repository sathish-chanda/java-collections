package com.linkedin.collections;

import java.util.HashSet;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
		
		Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Room oxfordDuplicate = new Room("Oxford", "Suite", 5, 225.0);
		Room victoria = new Room("Victoria", "Suite", 5, 225.00);

		// Working with sets.
		// Sets doesn't allow duplicate elements.
		// Duplicates prevented by constructors and add methods.
		// Two additional methods
		// of() in Java 9
		// copyOf() in Java 10 are added for immutable sets.

		// Set Types
		// Set (Interface)
		// 	a. SortedSet (Interface) <-- NavigableSet (Interface) <--- TreeSet (implementation) [Note: Elements must implement Comparable interface or we have to provide the comparator operator to determine the ordering]
		//  b. HashSet (implementation) <-- LinkedHashSet (implementation)

		// HashSet :: insertion order is not maintained. where as linkedHashSet will maintain the insertion order.
		Set<Room> rooms = new HashSet<>();
		rooms.add(piccadilly);
		rooms.add(oxford);
		rooms.add(oxford);
		rooms.add(oxfordDuplicate);

		rooms.stream()
				.forEach(room -> System.out.println(room.getName()));

		// This is the unmodifiable set which can be used ThreadSafety or performance.
		Set<Room> unmodifiableSet = Set.of(piccadilly,oxford);
//		unmodifiableSet.add(victoria);
		/*
		Exception in thread "main" java.lang.UnsupportedOperationException
			at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:72)
			at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:76)
			at com.linkedin.collections.Application.main(Application.java:40)
		 */

		Set<Room> unmodifibleCopy = Set.copyOf(rooms);
//		unmodifibleCopy.add(victoria);
		/*
			Exception in thread "main" java.lang.UnsupportedOperationException
				at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:72)
				at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:76)
				at com.linkedin.collections.Application.main(Application.java:48)
		 */
	}
}
