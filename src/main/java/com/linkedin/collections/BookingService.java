package com.linkedin.collections;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

	private Map<Room, Guest> bookings = new HashMap<>();

	public boolean book(Room room, Guest guest) {

		/*
		 * 1. The provided Guest is placed in the bookings Map and
		 * associated with the provided room, only if no other guest
		 * is associated with the room.
		 * 
		 * Returns a boolean that indicates if the Guest was
		 * successfully placed in the room.
		 */

		/*
		     HashMap stores the data as key value pairs.
		     Key must have hashcode() and equals() method.

		     Whenever the put() method is invoked.

		     1. First its Key's hash code is computed.
		     2. Then this hash value is mapped to an index.
		     3. A new node with key,value and hashcode will be added at the index in the map. if there is collision with hashcode and index. The new data will be added as a linked list.

		     When get() method is called and there are more number nodes at index with same hashcode then equals() method will be used to retrieve the correct node.
		 */

		/*
			new HashMap<String,Integer>().put("A",1);

			"A".hashcode() = 200 --> index = 1

			put("Z",20)
			"Z".hashcode() = 200 --> index = 1

				idx
					+------------------------------------------+
					|
				0	|
					|
					+------------------------------------------+
					|	Node				Node
					|	key:"A"				Key:"Z"
				1	|	val: 1		 --->	val:20
					|	hashcode:200		hashcode:200
					+------------------------------------------+
					|
				2	|
					|
					+------------------------------------------+

		 */

		return bookings.putIfAbsent(room,guest) == null;

	}

	public double totalRevenue() {
		
		/*
		 * 2. Returns a double that totals the rate of each Room booked
		 * in the bookings Map.
		 */
		double totalRevenue = 0.0;
		for(Map.Entry<Room,Guest> booking : bookings.entrySet()){
			totalRevenue += booking.getKey().getRate();
		}
		return totalRevenue;
	}
	
	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
