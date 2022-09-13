package booking.hotel.client;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONObject;

/**
 * A sample API client to test the API with user input through console
 * @author Eduardo
 *
 */
public class APIClient {
	
	/**
	 * The main method that reads the user input
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to our hotel");
		System.out.println("Do you want to check available rooms or reserve a room?");
		System.out.println("Type 'check', 'reserve', 'modify' or 'cancel' now:");
		String checkOrReserve = scanner.nextLine();
		if("check".equalsIgnoreCase(checkOrReserve)) {
			System.out.println("Which room do you want to check?");
			System.out.println("Type a room number now:");
			String roomNumber = scanner.nextLine();
			
			String jsonString = getRoomAvailability(roomNumber);
			JSONObject jsonObject = new JSONObject(jsonString);
			
			boolean isAvailable = jsonObject.getBoolean("availability");
			if(isAvailable) {
				System.out.println("The room number " + roomNumber + " is currently available to be reserved");
			} else {
				System.out.println("The room number " + roomNumber + " is currently not available to be reserved");
			}
			
		} else if("reserve".equals(checkOrReserve)) {
			System.out.println("Which room do you want to reserve?");
			System.out.println("Type a room number now:");
			String roomNumber = scanner.nextLine();
			
			System.out.println("Please enter your name:");
			String name = scanner.nextLine();
			
			System.out.println("Please enter your ID:");
			String ID = scanner.nextLine();
			
			System.out.println("Please enter the beggining date of your reserve in the following format 'month-day-year':");
			String dateFrom = scanner.nextLine();
			
			System.out.println("Please enter the end date of your reserve in the following format 'month-day-year':");
			String dateTo = scanner.nextLine();
			
			System.out.println("Creating your room reservation...");
			setRoomReservation(roomNumber, name, ID, dateFrom, dateTo);
			
			System.out.println("Your reservation was created succesfully!");
			System.out.println("Here is the information of your reservation:");
			System.out.println("Reserved room is: " + roomNumber);
			System.out.println("From " + dateFrom);
			System.out.println("To " + dateTo);
			System.out.println("For " + name + " with ID: " + ID);
		} else if("modify".equals(checkOrReserve)) {
			System.out.println("Type the room number you reserved:");
			String roomNumber = scanner.nextLine();
			
			System.out.println("Please enter the beggining date of your reserve in the following format 'month-day-year':");
			String dateFrom = scanner.nextLine();
			
			System.out.println("Please enter the end date of your reserve in the following format 'month-day-year':");
			String dateTo = scanner.nextLine();
			
			System.out.println("Modifying your room reservation...");
			setRoomReservation(roomNumber, null, null, dateFrom, dateTo);
			
			System.out.println("Your reservation was modified succesfully!");
		} else if("cancel".equals(checkOrReserve)) {
			System.out.println("Type the room number you reserved:");
			String roomNumber = scanner.nextLine();
			
			System.out.println("Modifying your room reservation...");
			setRoomReservation(roomNumber, null, null, null, null);
			
			System.out.println("Your reservation was canceled succesfully!");
		}
		
		scanner.close();
		System.out.println("Thanks for using our services.");
	}
	
	/**
	 * Method that returns the room availability
	 * @param roomNumber, The room number that's being checked for availability
	 * @return The room's information with the availability, true if available, false if not
	 * @throws IOException, throws an IOException if there was a problem reading the user input
	 */
	public static String getRoomAvailability(String roomNumber) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8081/BookingAPI/room/" + roomNumber).openConnection();
		
		connection.setRequestMethod("GET");
		
		int responseCode = connection.getResponseCode();
		if(responseCode == 200) {
			String response = "";
			Scanner scanner = new Scanner(connection.getInputStream());
			while(scanner.hasNextLine()){
				response += scanner.nextLine();
				response += "\n";
			}
			scanner.close();

			return response;
		}
		
		return null;
	}
	
	/**
	 * Method that sets the room reservation, modifies it or cancels it
	 * @param roomNumber, the number of the room
	 * @param name, name of the user
	 * @param ID, ID of the user
	 * @param dateFrom, beggingin date of reservation
	 * @param dateTo, ending date of reservation
	 * @throws IOException, throws an exception if there is an issue with user input
	 */
	public static void setRoomReservation(String roomNumber, String name, String ID,  String dateFrom, String dateTo) throws IOException{
		HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8081/BookingAPI/room/" + roomNumber).openConnection();

		connection.setRequestMethod("POST");
		String postData = "roomNumber=" + roomNumber;
		if(name != null && ID != null && dateFrom != null && dateTo != null) {
			postData += "&name=" + URLEncoder.encode(name, "UTF-8");
			postData += "&ID=" + URLEncoder.encode(ID, "UTF-8");
			postData += "&dateFrom=" + URLEncoder.encode(dateFrom, "UTF-8");
			postData += "&dateTo=" + URLEncoder.encode(dateTo, "UTF-8");
		}
		
		connection.setDoOutput(true);
	    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
	    wr.write(postData);
	    wr.flush();
	    
	    int responseCode = connection.getResponseCode();
		if(responseCode == 200){
			System.out.println("POST was successful.");
		}
		else if(responseCode == 401){
			System.out.println("Somehting went wrong with room reservation.");
		}
	}

}
