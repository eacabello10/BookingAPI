package booking.hotel.classes;

import java.time.LocalDate;

/**
 * Class that represents a reservation
 * @author usuario
 *
 */
public class Reservation {

	private LocalDate dateFrom;
	private LocalDate dateTo;
	private Room reservedRoom;
	private User user;
	
	public Reservation(LocalDate dateFrom, LocalDate dateTo, Room reservedRoom, User user) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.reservedRoom = reservedRoom;
		this.user = user;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public Room getReservedRoom() {
		return reservedRoom;
	}

	public void setReservedRoom(Room reservedRoom) {
		this.reservedRoom = reservedRoom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
