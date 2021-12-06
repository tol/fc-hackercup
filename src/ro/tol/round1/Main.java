package ro.tol.round1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("test1.txt"))))) {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

			for (int i = 1; i <= t; ++i) {
				int size = in.nextInt();
				String s = in.next();
				char last='N';
				int lastIndex=0;
				int r=0;
				int k=0;
				int lastscore=0;
				int count=0;
				for (char c:s.toCharArray()) {
					switch (c) {
						case 'F':{
							r+=lastscore;
							break;

						}
						case 'X': {
							if (last == 'O') {
								//r+=((k+1)*(k))/2- ((k-lastIndex+1)*(k-lastIndex+2))/2;
								//r+=lastIndex+size-k;
								//r+=lastIndex;

								count++;
								lastscore=lastIndex+lastscore*count;


							}else{
								r+=lastscore;
							}
							last = 'X';
							lastIndex=k;
							break;
						}
						case 'O': {
							if (last == 'X') {
								//r+=((k+1)*(k))/2- ((k-lastIndex+1)*(k-lastIndex+2))/2;
								//r+=lastIndex+size-k;
								//r+=lastIndex;
								count++;
								lastscore=lastIndex+lastscore*count;

							}else{
								r+=lastscore;
							}
							last = 'O';
							lastIndex=k;
							break;
						}
					}




					k++;
				}

				System.out.println("Case #" + i + ": " + r);

			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
