package booking.hotel.classes;

/**
 * Class that represents a User
 * @author Eduardo
 *
 */
public class User {

	private String name;
	private String ID;
	
	public User(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
}
