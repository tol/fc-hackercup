package ro.tol.round1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("weak_typing_chapter_1_input.txt"))))) {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

			for (int i = 1; i <= t; ++i) {
				int size = in.nextInt();
				String s = in.next();
				char last='F';
				int r=0;
				for (char c:s.toCharArray()){
					switch (c) {
						case 'F':break;
						case 'X': {
							if(last=='O') {
								r++;
							}
							last='X';

							break;
						}
						case 'O': {
							if(last=='X') {
								r++;
							}
							last='O';

							break;
						}
					}

				}

				System.out.println("Case #" + i + ": " + r++);


			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
