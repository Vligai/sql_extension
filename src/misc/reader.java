/*Vladislav Ligai*/
package misc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class reader {
	/* 7 rows and max of 15 elements per row in the input file */
	public static String my_input[][] = new String[7][15];

	/*
	 * Read from prompt Use this when input.txt is missing Basic input stream reader
	 */
	public static void read_prompt() throws IOException {
		try {
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader my_br = new BufferedReader(input);
			String line = null;
			int i = 0;
			/* read 7 lines of input */
			for (i = 0; i < 7; i++) {
				System.out.print("Prompt: ");
				line = my_br.readLine();
				/* split line */
				String[] splitline = line.split("\\s*,\\s*");
				for (int j = 0; j < splitline.length; j++)
					my_input[i][j] = splitline[j];
			}
			my_br.close();
			/* catch some missmatch/exception errors */
		} catch (InputMismatchException ex) {
			System.out.println("Something Went wrong when trying to read promt.");
		} catch (IOException ex) {
			System.out.println("Something Went wrong when trying to read promt.");
		}
	}

	/*
	 * Read from file Done same way as reading from prompt, but taking each line
	 * from the input file
	 */
	public void read_file() throws IOException {
		String line = null;
		int i = 0;
		try {
			FileReader file = new FileReader("input/input.txt");
			BufferedReader my_br = new BufferedReader(file);
			/* read the input file of 7 lines */
			for (i = 0; i < 7; i++) {
				line = my_br.readLine();
				String[] splitline = line.split("\\s*,\\s*");
				for (int j = 0; j < splitline.length; j++)
					my_input[i][j] = splitline[j];
			}
			my_br.close();
			/* if input.txt cannot be opened use the read_prompt() */
		} catch (FileNotFoundException ex) {
			read_prompt();
		} catch (IOException ex) {
			read_prompt();
		}
	}
}
