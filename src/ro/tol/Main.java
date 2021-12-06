package ro.tol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("consistency_chapter_1_input.txt"))))) {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			/**
			 * 7
			 * ABC
			 * 2
			 * BA
			 * CA
			 * ABC
			 * 2
			 * AB
			 * AC
			 */
			for (int i = 1; i <= t; ++i) {
				String s = in.next();
				int noc=in.nextInt();

				Set<Character> dests=new HashSet<>();
				for (int j=0;j<noc;j++){
					String pair=in.next();
					dests.add(pair.charAt(1));
				}


			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
