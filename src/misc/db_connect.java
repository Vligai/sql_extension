/*Vladislav Ligai*/
package misc;

public class db_connect {
	/**
	 * Connects to the database
	 */
	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception exception) {
			System.out.println("Failed to Connect!");
			exception.printStackTrace();
		}
	}
}
