/*Vladislav Ligai*/
package cs562;

import java.lang.reflect.Field;

public class mfstruct_gen {
	/*
	 * add a customer from DB to mfstruct
	 */

	public static mfstruct my_struct[] = new mfstruct[500];

	public static void update_mfstruct(rows r, int counter, int gv)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		for (Field field : my_struct[counter].getClass().getDeclaredFields()) {
			String field_str = field.toString();
			String[] splitline = field_str.split("\\s*_\\s*");
			/* for now update all when doing sum/count/min/max */
			/* update mf_struct with sum */
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("sum")) {
				Field temp = field;
				for (Field field2 : r.getClass().getDeclaredFields()) {
					/*convert field2 to string in order to use equals*/
					String field_str2 = "" + field2.getName();
					if (splitline[2].equals(field_str2)) {
						temp = field2;
						break;
					}
				}
				int tmp = Integer.valueOf(field.get(my_struct[counter]).toString());
				int tmp2 = Integer.valueOf(temp.get(r).toString());
				/*summing*/
				field.set(my_struct[counter], tmp + tmp2);
				// System.out.println("Test30 "+(tmp + tmp2));
				/*improve this in the future work*/
				if ((field_str.toString()).contains("cs562.mfstruct.quant"))
					field.set(my_struct[counter], r.quant);
				if (field_str.contains("cust"))
					field.set(my_struct[counter], r.cust);
				if (field_str.contains("prod"))
					field.set(my_struct[counter], r.prod);
				if (field_str.contains("day"))
					field.set(my_struct[counter], r.day);
				if (field_str.contains("month"))
					field.set(my_struct[counter], r.month);
				if (field_str.contains("year"))
					field.set(my_struct[counter], r.year);
				if (field_str.contains("state"))
					field.set(my_struct[counter], r.state);
			}
			/* update mf_struct with count */
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("count")) {
				field.set(my_struct[counter], Integer.valueOf(field.get(my_struct[counter]).toString()) + 1);
				if ((field_str.toString()).contains("cs562.mfstruct.quant"))
					field.set(my_struct[counter], r.quant);
				if (field_str.contains("cust"))
					field.set(my_struct[counter], r.cust);
				if (field_str.contains("prod"))
					field.set(my_struct[counter], r.prod);
				if (field_str.contains("day"))
					field.set(my_struct[counter], r.day);
				if (field_str.contains("month"))
					field.set(my_struct[counter], r.month);
				if (field_str.contains("year"))
					field.set(my_struct[counter], r.year);
				if (field_str.contains("state"))
					field.set(my_struct[counter], r.state);
			}
			/* update mf_struct with min */
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("min")) {
				Field temp = field;
				for (Field field2 : r.getClass().getDeclaredFields()) {
					/*convert field2 to string in order to use equals*/
					String field_str2 = "" + field2.getName();
					if (splitline[2].equals(field_str2)) {
						temp = field2;
						break;
					}
				}
				int tmp = Integer.valueOf(field.get(my_struct[counter]).toString());
				int tmp2 = Integer.valueOf(temp.get(r).toString());
				if (tmp > tmp2) {
					field.set(my_struct[counter], tmp2);
					if ((field_str.toString()).contains("cs562.mfstruct.quant"))
						field.set(my_struct[counter], r.quant);
					if (field_str.contains("cust"))
						field.set(my_struct[counter], r.cust);
					if (field_str.contains("prod"))
						field.set(my_struct[counter], r.prod);
					if (field_str.contains("day"))
						field.set(my_struct[counter], r.day);
					if (field_str.contains("month"))
						field.set(my_struct[counter], r.month);
					if (field_str.contains("year"))
						field.set(my_struct[counter], r.year);
					if (field_str.contains("state"))
						field.set(my_struct[counter], r.state);
				}
			}
			/* update mf_struct with max */
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("max")) {
				Field temp = field;
				for (Field field2 : r.getClass().getDeclaredFields()) {
					String field_str2 = "" + field2.getName();
					if (splitline[2].equals(field_str2)) {
						temp = field2;
						break;
					}
				}
				int tmp = Integer.valueOf(field.get(my_struct[counter]).toString());
				
				int tmp2 = Integer.valueOf(temp.get(r).toString());
				if (tmp < tmp2) {
					field.set(my_struct[counter], tmp2);
					if ((field_str.toString()).contains("cs562.mfstruct.quant"))
						field.set(my_struct[counter], r.quant);
					if (field_str.contains("cust"))
						field.set(my_struct[counter], r.cust);
					if (field_str.contains("prod"))
						field.set(my_struct[counter], r.prod);
					if (field_str.contains("day"))
						field.set(my_struct[counter], r.day);
					if (field_str.contains("month"))
						field.set(my_struct[counter], r.month);
					if (field_str.contains("year"))
						field.set(my_struct[counter], r.year);
					if (field_str.contains("state"))
						field.set(my_struct[counter], r.state);
				}
			}
		}
		/*
		for (Field field : my_struct[counter].getClass().getDeclaredFields()) {
			System.out.println(field.getName());
			System.out.println(my_struct[counter].month);
		}
		*/
	}
	/*
	 * updates mfstruct with a customer
	 */
	public static void mfstruct_insert(rows r, int counter, int gv)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		mfstruct tmp_str = new mfstruct();
		for (Field field : tmp_str.getClass().getDeclaredFields()) {
			String field_str = field.toString();
			String[] splitline = field_str.split("\\s*_\\s*");
			/*sum*/
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("sum")) {
				Field temp = field;
				for (Field field2 : r.getClass().getDeclaredFields()) {
					String field_str2 = "" + field2.getName();
					if (splitline[2].equals(field_str2)) {
						temp = field2;
						break;
					}
				}
				int tmp = Integer.valueOf(temp.get(r).toString());
				field.set(tmp_str, tmp);
			}
			/*count*/
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("count"))
				field.set(tmp_str, Integer.valueOf(field.get(tmp_str).toString()) + 1);
			/*min*/
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("min")) {
				Field temp = field;
				for (Field field2 : r.getClass().getDeclaredFields()) {
					String field_str2 = "" + field2.getName();
					if (splitline[2].equals(field_str2)) {
						temp = field2;
						break;
					}
				}
				int tmp = Integer.valueOf(field.get(tmp_str).toString());
				int tmp2 = Integer.valueOf(temp.get(r).toString());
				if (tmp > tmp2)
					field.set(tmp_str, tmp2);
			}
			/*max*/
			if (field_str.contains(Integer.toString(gv)) && field_str.contains("max")) {
				Field temp = field;
				for (Field field2 : r.getClass().getDeclaredFields()) {
					String field_str2 = "" + field2.getName();
					if (splitline[2].equals(field_str2)) {
						temp = field2;
						break;
					}
				}
				int tmp = Integer.valueOf(field.get(tmp_str).toString());
				int tmp2 = Integer.valueOf(temp.get(r).toString());
				if (tmp < tmp2)
					field.set(tmp_str, tmp2);
			}
			/*rest of them*/
			//System.out.println(field_str.toString());
			if ((field_str.toString()).contains("cs562.mfstruct.quant"))
				field.set(tmp_str, r.quant);
			if (field_str.contains("cust"))
				field.set(tmp_str, r.cust);
			if (field_str.contains("prod"))
				field.set(tmp_str, r.prod);
			if (field_str.contains("day"))
				field.set(tmp_str, r.day);
			if (field_str.contains("month"))
				field.set(tmp_str, r.month);
			if (field_str.contains("year"))
				field.set(tmp_str, r.year);
			if (field_str.contains("state"))
				field.set(tmp_str, r.state);
		}
		/*
		for (Field field : tmp_str.getClass().getDeclaredFields()) {
			System.out.println(field.getName());
			System.out.println(tmp_str.day);
		}
		*/
		my_struct[counter] = tmp_str;
	}

}
