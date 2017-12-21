/*Vladislav Ligai*/
package cs562;

import java.sql.SQLException;
import misc.db_connect;

public class generated {
	/*main method*/
	public static void main(String[] args)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException, SQLException {
			/*declaring variables*/
		int max = 500;
		int i = 0;
		int ii = 0;
		int counter1 = 0;
		int counter2 = 0;
		String my_input[][] = new String[7][15];
		mfstruct mf_struct[] = mfstruct_gen.my_struct;
		db_connect post_connect = new db_connect();
		/*generated code - array with input*/

String arr_str;
arr_str = "1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null";
my_input[1]=arr_str.split("\\s*,\\s*");
arr_str = "cust, prod, day, month, year, state, quant, null, null, null, null, null, null, null, null, null, null, null, null, null";
my_input[2]=arr_str.split("\\s*,\\s*");
arr_str = "sum_0_quant, count_0_quant, max_1_quant, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null";
my_input[3]=arr_str.split("\\s*,\\s*");
arr_str = "(mf_struct[i].cust).equals(r.cust), (mf_struct[i].cust).equals(r.cust), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null";
my_input[4]=arr_str.split("\\s*,\\s*");
arr_str = "null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null";
my_input[5]=arr_str.split("\\s*,\\s*");
arr_str = "null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null";
my_input[6]=arr_str.split("\\s*,\\s*");
	/*end generated code*/
	System.out.println("Connecting...");
		post_connect.connect();
		System.out.println("Successfully Connected to DB!");
		rows r = new rows();
		System.out.println("Fetching Data...");
		System.out.println("-----------------------------");
		for (;counter1 < max; counter1++){
			//System.out.println("test36");
			r = fetch_from_db.get_row();
			/*generated code */
			/* end generated code */
			if (mf_struct[0] == null)
				mfstruct_gen.mfstruct_insert(r, 0, 0);
			else {
				for (i = 0; i < max; i++) {
					if (mf_struct[i] == null) {
						mfstruct_gen.mfstruct_insert(r, i, 0);
						i = max+1;
						break;
					}
					/* generated code */
if((mf_struct[i].cust).equals(r.cust)){
break;
}
					/* end generated code */
					}
					if(i!=max+1)
						mfstruct_gen.update_mfstruct(r,i,0);
				}
			}
		while (counter2 <= Integer.parseInt(my_input[1][0])) {
			fetch_from_db.my_start = true;
			for (ii = 0; ii < max; ii++) {
				r = fetch_from_db.get_row();
				for (i = 0; i < max; i++) {
					if (mf_struct[i] == null)
						break;
						/* generated code */
if((counter2==1) &&((mf_struct[i].cust).equals(r.cust))){
mfstruct_gen.update_mfstruct(r,i,counter2);
}
					/* end generated code */
					}
			}
			counter2++;
		}
			i = 0;
			while (i < max) {
				if(mf_struct[i]==null)
					break;
				if(my_input[5][0].equals("null")){
				/* generated code */

						
try{
System.out.println(mf_struct[i].cust+" "+ mf_struct[i].max_1_quant + " "+  mf_struct[i].prod+ " "+  mf_struct[i].year);
}catch (Exception e){ System.out.println(e.getMessage());}}else{
if(true){

try{
System.out.println(mf_struct[i].cust+" "+ mf_struct[i].max_1_quant + " "+  mf_struct[i].prod+ " "+  mf_struct[i].year);
}catch (Exception e){ System.out.println(e.getMessage());}}}i++;}}}
