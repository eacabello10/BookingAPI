package booking.hotel.data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import booking.hotel.classes.Reservation;
import booking.hotel.classes.Room;
import booking.hotel.classes.User;

/**
 * Example Datastore class that provides access to user data.
 * @author Eduardo
 *
 */
public class Datastore {

	//Map of rooms.
		private Map<Integer, Room> roomMap = new HashMap<>();
		private Map<Integer, Reservation> reservevationMap = new HashMap<>();
		
		private static Datastore instance = new Datastore();
		public static Datastore getInstance(){
			return instance;
		}

		//private constructor so people know to use the getInstance() function instead
		private Datastore(){
			//dummy data
			roomMap.put(50, new Room(50, true));
			roomMap.put(55, new Room(55,false));
			
			User user = new User("Test User", "4525");
			Reservation reservation = new Reservation(LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 7), roomMap.get(55), user);
			reservevationMap.put(55, reservation);
			roomMap.get(55).setReservation(reservation);
		}

		public Room getRoom(int number) {
			return roomMap.get(number);
		}

		public void putRoom(Room room) {
			roomMap.put(room.getNumber(), room);
		}
		
		public Reservation getReservation(int roomNumber) {
			return reservevationMap.get(roomNumber);
		}
		
		public void putReservation(Reservation reservation) {
			reservevationMap.put(reservation.getReservedRoom().getNumber(), reservation);
		}
		
		public void removeReservation(int roomNumber) {
			reservevationMap.remove(roomNumber);
			Room room = roomMap.get(roomNumber);
			room.setAvailable(true);
			room.setReservation(null);
			roomMap.put(roomNumber, room);
		}
}
