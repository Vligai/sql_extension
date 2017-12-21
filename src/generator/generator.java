/*Vladislav Ligai*/
package generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import misc.db_connect;
import misc.mfstruct_creator;
import misc.reader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class generator {
	/*main method of the java generator*/
	public static void main(String[] args)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException, SQLException, IOException {
		/*declaring variables*/
		String input_file[][] = reader.my_input;
		String input[][] = mfstruct_creator.mf_input;
		mfstruct_creator emfstruct = new mfstruct_creator();
		reader my_reader = new reader();
		db_connect post_connect = new db_connect();
		PrintWriter generated = new PrintWriter("src/cs562/generated.java", "UTF-8");
		String arr_str;
		my_reader.read_file();
		/* get the snippet1.txt */
		/* write snippet1.txt to generated java */
		generated.println(new String(Files.readAllBytes(Paths.get("code_snippets/snippet1.txt")), StandardCharsets.UTF_8));
		/*array of the input*/
		for (int i = 0; i < 7; i++) {
			arr_str = Arrays.toString(input_file[i]);
			arr_str = arr_str.substring(1, arr_str.length() - 1);
			if (i != 0) {
				generated.println("arr_str = \"" + arr_str + "\";");
				generated.println("my_input[" + i + "]=arr_str.split(\"\\\\s*,\\\\s*\");");
			}
			input[i] = arr_str.split("\\s*,\\s*");
		}
		/*connect to db*/
		System.out.println("Connecting...");
		post_connect.connect();
		System.out.println("Successfully Connected to DB!");
		System.out.println("Generating mfstruct.java...");
		/*create mfstruct*/
		emfstruct.generate_mfstruct();
		System.out.println("Generating generated.java...");
		/* get the snippet2.txt */
		/* write snippet2.txt to generated java */
		generated.println(
				new String(Files.readAllBytes(Paths.get("code_snippets/snippet2.txt")), StandardCharsets.UTF_8));

		/* check for where condition */
		if (!input[6][0].equals("null"))
			generated.println("if(!(" + input[6][0] + ")){\ncontinue;\n}");
		generated.println(
				new String(Files.readAllBytes(Paths.get("code_snippets/snippet3.txt")), StandardCharsets.UTF_8));

		generated.println("if(" + input[4][0] + "){\nbreak;\n}");
		generated.println(
				new String(Files.readAllBytes(Paths.get("code_snippets/snippet4.txt")), StandardCharsets.UTF_8));
		/* such that condition */
		if (!input[6][0].equals("null"))
			generated.println("if(!(" + input[6][0] + ")){\ncontinue;\n}");
		for (int ii = 1; ii <= Integer.parseInt(input[1][0]); ii++)
			generated.println("if((counter2==" + ii + ") &&(" + input[4][ii].replaceAll("\\\\", "")
					+ ")){\nmfstruct_gen.update_mfstruct(r,i,counter2);\n}");
		generated.println(
				new String(Files.readAllBytes(Paths.get("code_snippets/snippet5.txt")), StandardCharsets.UTF_8));
		generated.println("try{\nSystem.out.println(" + input[0][0] + ");");
		generated.println("}catch (Exception e){ System.out.println(e.getMessage());}}else{");
		/* check for having condition */
		if (!input[5][0].equals("null"))
			generated.println("if(" + input[5][0] + "){\n");
		else
			generated.println("if(true){\n");	
		/*insert the rest of the generated file*/
		generated.println("try{\nSystem.out.println(" + input[0][0] + ");");
		generated.println("}catch (Exception e){ System.out.println(e.getMessage());}}}i++;}}}");
		generated.close();
		System.out.println("Done!");
	}
}