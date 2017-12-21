/*Vladislav Ligai*/
package cs562;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import misc.db_connect;

public class fetch_from_db {
	public static boolean my_start = true;
	public static ResultSet res_set;

	/*
	 * Gets a row from the database and puts it into rows
	 */
	public static rows get_row() throws SQLException {
		rows r = new rows();
		/* change usr, pwd and url to your postgres */
		String usr = "postgres";
		String pwd = "Moonrider2";
		String url = "jdbc:postgresql://localhost:5432/";
		db_connect post_connect = new db_connect();
		/* get rows into the Result set */
		if (my_start) {
			/*set up connection*/
			post_connect.connect();
			Connection con = DriverManager.getConnection(url, usr, pwd);
			Statement st = con.createStatement();
			String ret = "select * from sales";
			res_set = st.executeQuery(ret);
			my_start = false;
		}
		/* populate rows */
		if (res_set.next()) {
			r.cust = res_set.getString(1);
			r.prod = res_set.getString(2);
			r.day = res_set.getInt(3);
			r.month = res_set.getInt(4);
			r.year = res_set.getInt(5);
			r.state = res_set.getString(6);
			r.quant = res_set.getInt(7);
		}
		return r;
	}

}
