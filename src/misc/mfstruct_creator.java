/*Vladislav Ligai*/
package misc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * my_writer_creator as the name suggests generates my_writer.java file
 */
public class mfstruct_creator {
	/* 7 rows and max of 15 elements per row in the input file */
	public static String mf_input[][] = new String[7][15];

	public void generate_mfstruct() throws SQLException, FileNotFoundException, UnsupportedEncodingException {
		/* set usr, pwd and url to your postgres settings */
		String usr = "postgres";
		String pwd = "Moonrider2";
		String url = "jdbc:postgresql://localhost:5432/";
		ResultSet rs;
		/*write to this file*/
		PrintWriter my_writer = new PrintWriter("src/cs562/mfstruct.java", "UTF-8");
		/*set up the connection*/
		Connection my_connection = DriverManager.getConnection(url, usr, pwd);
		Statement stat = my_connection.createStatement();
		my_writer.println("package cs562;\npublic class mfstruct {\n");
		/*check the line 2 of input file*/
		if (mf_input[2][0] != "null" || mf_input[2].length != 1 ) {
			for (int i = 0; i < mf_input[2].length; i++) {
				/*The first null breaks out of the for loop*/
				if (mf_input[2][i].equals("null"))
					break;
				rs = stat.executeQuery("select data_type from information_schema.columns where column_name = '"
						+ mf_input[2][i] + "' and table_name='sales';");
				rs.next();
				/*chech if resulting set contains int in it*/
				if (rs.getString(1).contains("int"))
					my_writer.println("int" + " " + mf_input[2][i] + ";");
				else
					my_writer.println("String" + " " + mf_input[2][i] + ";");
			}
		}
		/*check the line 3 of input file*/
		if (mf_input[3].length != 1 || mf_input[3][0] != "null") {
			for (int i = 0; i < mf_input[3].length; i++) {
				if (mf_input[3][i].equals("null"))
					break;
				/*For future work add String option when in the third line of input*/
				my_writer.println("int" + " " + mf_input[3][i] + ";");
			}
		}
		/*close up the mfstruct*/
		my_writer.println("}");
		my_writer.close();
	}
}
