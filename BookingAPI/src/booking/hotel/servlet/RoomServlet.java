package booking.hotel.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import booking.hotel.classes.Reservation;
import booking.hotel.classes.Room;
import booking.hotel.classes.User;
import booking.hotel.data.Datastore;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String requestUrl = request.getRequestURI();
		int number = Integer.parseInt(requestUrl.substring("/BookingAPI/room/".length()));
		
		Room room = Datastore.getInstance().getRoom(number);
		
		if(room != null)
		{
			String json = "{\n";
			json += "\"number\": " + JSONObject.quote("" + room.getNumber()) + ",\n";
			json += "\"availability\": " + JSONObject.quote("" + room.isAvailable()) + ",\n";
			json += "\"reservation\": " + room.getReservation() + "\n";
			json += "}";
			response.getOutputStream().println(json);
		} else {
			response.getOutputStream().println("{}");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int number = Integer.parseInt(request.getParameter("roomNumber"));
		Datastore instance = Datastore.getInstance();
		if(request.getParameter("dateFrom") != null && request.getParameter("dateTo") != null) {
			String[] dateFromArray = request.getParameter("dateFrom").split("-");
			String[] dateToArray = request.getParameter("dateTo").split("-");
			LocalDate dateFrom = LocalDate.of(Integer.parseInt(dateFromArray[2]), Integer.parseInt(dateFromArray[0]), Integer.parseInt(dateFromArray[1]));
			LocalDate dateTo = LocalDate.of(Integer.parseInt(dateToArray[2]), Integer.parseInt(dateToArray[0]), Integer.parseInt(dateToArray[1]));
			long daysBetween = dateFrom.until(dateTo, ChronoUnit.DAYS);
			long daysInAdvance = LocalDate.now().until(dateFrom, ChronoUnit.DAYS);
			if(instance.getReservation(number) != null) {
				Reservation reservation = instance.getReservation(number);
				if(daysBetween <= 3 || daysInAdvance >= 30) {
					reservation.setDateFrom(dateFrom);
					reservation.setDateTo(dateTo);
					instance.putReservation(reservation);
				} else {
					throw new ServletException("Cannot reserve the room for more than 3 days or 30 days in advance");
				}
			} else {
				Room newRoom = new Room(number, false);
				User user = new User(request.getParameter("name"), request.getParameter("ID"));
				if(daysBetween <= 3 || daysInAdvance >= 30) {
					Reservation reservation = new Reservation(dateFrom, dateTo, newRoom, user);
					newRoom.setReservation(reservation);
					instance.putRoom(newRoom);
					instance.putReservation(reservation);
				} else {
					throw new ServletException("Cannot reserve the room for more than 3 days or 30 days in advance");
				}
			}
		} else {
			instance.removeReservation(number);
		}
		
	}
	
}
