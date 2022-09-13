package booking.hotel.classes;

import java.time.LocalDate;

/**
 * Class that represents a reservation
 * @author Eduardo
 *
 */
public class Reservation {

	/**
	 * Starting date of the reservation
	 */
	private LocalDate dateFrom;
	
	/**
	 * Ending date of the reservation
	 */
	private LocalDate dateTo;
	
	/**
	 * The room to be reserved
	 */
	private Room reservedRoom;
	
	/**
	 * The user that reserves the room
	 */
	private User user;
	
	/**
	 * Constructor method for a Reservation
	 * @param dateFrom, starting date
	 * @param dateTo, ending date
	 * @param reservedRoom, the reserved room
	 * @param user, the user that creates a reservation
	 */
	public Reservation(LocalDate dateFrom, LocalDate dateTo, Room reservedRoom, User user) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.reservedRoom = reservedRoom;
		this.user = user;
	}

	/**
	 * Returns the starting date of the reservation
	 * @return the starting date of the reservation
	 */
	public LocalDate getDateFrom() {
		return dateFrom;
	}

	/**
	 * Sets the starting date of the reservation
	 * @param dateFrom the new starting date
	 */
	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 * Returns the ending date of the reservation
	 * @return the ending date of the reservation
	 */
	public LocalDate getDateTo() {
		return dateTo;
	}

	/**
	 * Sets the ending date of the reservation
	 * @param dateTo, the new ending date
	 */
	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 * Returns the reserved room
	 * @return the reserved room
	 */
	public Room getReservedRoom() {
		return reservedRoom;
	}

	/**
	 * Sets the reserved room by the user
	 * @param reservedRoom the reserved room
	 */
	public void setReservedRoom(Room reservedRoom) {
		this.reservedRoom = reservedRoom;
	}

	/**
	 * Returns the user that created the reservation
	 * @return the user that created the reservation
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user that created the reservation
	 * @param user the user that created the reservation
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
