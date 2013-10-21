package csc301.ultrasound.model;


/**
 * Represents a single user. Responsible for high level functions specifically pertaining
 * to one user. Contains an instance of
 * model.Library, which is the user's library.
 * 
 * @author Katie Lo
 */
public class User {
	// Constructors
	/**
	 *User constructor. Creates a User object when supplied with an email, password and name.
	 *
	 * @param email		the desired email to be associated with this user
	 * @param password	the desired password to be associated with this user
	 * @param name		the desired name to be associated with this user
	 */
//	public User(String email, String password, String name) {
//		this.email = email;
//		this.password = password;
//		this.name = name;
//	}
	/**
	 *User constructor. Creates a User object when supplied with an email, password but no name.
	 *
	 * @param email		the desired email to be associated with this user
	 * @param password	the desired password to be associated with this user
	 */
//	public User(String email, String password) {
//		this.email = email;
//		this.password = password;
//	}
	/**
	 *User constructor. Creates a User object when supplied with an email, password but no name.
	 *
	 * @param email		the desired email to be associated with this user
	 * @param password	the desired password to be associated with this user
	 */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	/**
	 *User constructor. Creates a User object when supplied with an email, password but no name.
	 *
	 * @param email		the desired email to be associated with this user
	 * @param password	the desired password to be associated with this user
	 * @param type	    the desired type to be associated with this user
	 */
	public User(String name, String password, int type) {
		this.name = name;
		this.password = password;
		this.type = type;
	}
	/**
	 *User constructor. Creates a User object when supplied with an email, but no password and name.
	 *
	 * @param email		the desired email to be associated with this user
	 */
	public User(String email) {
		this.email = email;
	}
	
	// Interface
	/**
	 * Check if two users have same emails associated with their accounts.
	 * 
	 * @param other	the other use to compare this user's email with
	 * @return true	if the users have equal IDs, false otherwise
	 */
	public boolean hasEqualIds(User that) {
		return this.email.equals(that.email);
	}

	// Getters and setters
	/**
	 *Getter method. Returns the email of this user.
	 *
	 * @return	the email associated with this user
	 */
	public String getId() {
		return email;
	}
	/**
	 *Getter method. Returns the password of this user.
	 *
	 * @return	the password associated with this user.
	 */
	public String getCredential() {
		return password;
	}
	/**
	 *Getter method. Returns the name of the user.
	 *
	 * @return	the name associated with the user.
	 */
	public String getName() {
		return name;
	}
	/**
	 *Setter method. Sets the type of the user.
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	
	/**
	 *Getter method. Gets the type of the user.
	 *
	 * @return	the type associated with the user.
	 */
	public int getType() {
		return this.type;
	}
	
	// Member variables
	private String email;
	private String password;
	private String name;
	private int type;
	private static final int SUPERUSER = 0;
	private static final int MANAGER = 1;
	private static final int NORMAL = 2;


	public static void main(String[] args) {
	}

}
