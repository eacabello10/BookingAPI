package booking.hotel.classes;

/**
 * Class that represents a room.
 * @author Eduardo
 * 
 */
public class Room {

	/**
	 * The number of the room
	 */
	private int number;
	
	/**
	 * The availability of the room
	 */
	private boolean available;
	
	/**
	 * A reservation created by an User for the room
	 */
	private Reservation reservation;
	
	/**
	 * Method that creates a room
	 * @param number, the room number
	 * @param available, the availability of the room
	 */
	public Room(int number, boolean available) {
		this.number = number;
		this.available = available;
	}

	/**
	 * Get the room number
	 * @return the number of the room
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Get the availability of the room
	 * @return true if the room is available, false if it's not
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Sets the room availability
	 * @param available, true if its available, false if it's not
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Returns the reservation for this room
	 * @return The reservation for the room
	 */
	public Reservation getReservation() {
		return reservation;
	}
	
	/**
	 * Sets the reservation for the room
	 * @param reservation, the room's reservation
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
}
