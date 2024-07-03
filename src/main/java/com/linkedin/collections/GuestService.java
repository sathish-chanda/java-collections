package com.linkedin.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */
//		return guests.stream()
//				.filter(guest -> guest.getPreferredRooms().size() > 0 && guest.getPreferredRooms().get(0).equals(room))
//				.collect(Collectors.toList());

		return guests.stream()
				.filter(guest -> guest.getPreferredRooms().indexOf(room) == 0)
				.collect(Collectors.toList());

	}

	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		if(guest.isLoyaltyProgramMember()){
			int idx = 0;
			while(idx != checkinList.size() && checkinList.get(idx).isLoyaltyProgramMember()) {
				idx++;
			}
			checkinList.add(idx,guest);
		} else{
			checkinList.add(guest);
		}

	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */ 
		int idx1 = checkinList.indexOf(guest1);
		int idx2 = checkinList.indexOf(guest2);

		checkinList.remove(idx1);
		checkinList.add(idx1,guest2);

		checkinList.remove(idx2);
		checkinList.add(idx2,guest1);

	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
