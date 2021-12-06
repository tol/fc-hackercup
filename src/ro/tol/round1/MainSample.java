package ro.tol.round1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainSample {

	public static void main(String[] args) {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("consistency_chapter_1_input.txt"))))) {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

			for (int i = 1; i <= t; ++i) {
				String s = in.next();
				int noc=in.nextInt();


				System.out.println("Case #" + i + ": " + "test");

			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
