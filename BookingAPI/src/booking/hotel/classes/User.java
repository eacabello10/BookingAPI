package booking.hotel.classes;

/**
 * Class that represents a User
 * @author Eduardo
 *
 */
public class User {

	/**
	 * The user name
	 */
	private String name;
	
	/**
	 * The user ID
	 */
	private String ID;
	
	/**
	 * Constructor class for User
	 * @param name, the user name
	 * @param ID, the user ID
	 */
	public User(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}

	/**
	 * Method that returns the user name
	 * @return the user name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method that sets the user name
	 * @param name, name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that returns the user ID
	 * @return the user ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Method that sets the user ID
	 * @param iD the user ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	
}
