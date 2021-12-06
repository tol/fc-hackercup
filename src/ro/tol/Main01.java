package ro.tol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("consistency_chapter_1_input.txt"))))) {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= t; ++i) {
				String s = in.next();

				int noV = 0;
				int noC = 0;
				int maxV = 0;
				int maxC = 0;
				HashMap<Character, Integer> vCountMap = new HashMap<Character, Integer>();
				HashMap<Character, Integer> cCountMap = new HashMap<Character, Integer>();
				for (char ch : s.toCharArray()) {
					switch (ch) {
						case 'A':
						case 'E':
						case 'I':
						case 'O':
						case 'U':
							noV++;
							if (vCountMap.containsKey(ch)) {
								//If char 'c' is present in charCountMap, incrementing it's count by 1

								vCountMap.put(ch, vCountMap.get(ch) + 1);
							}
							else {
								//If char 'c' is not present in charCountMap,
								//putting 'c' into charCountMap with 1 as it's value

								vCountMap.put(ch, 1);
							}

							break;
						default:
							if (cCountMap.containsKey(ch)) {
								//If char 'c' is present in charCountMap, incrementing it's count by 1

								cCountMap.put(ch, cCountMap.get(ch) + 1);
							}
							else {
								//If char 'c' is not present in charCountMap,
								//putting 'c' into charCountMap with 1 as it's value

								cCountMap.put(ch, 1);
							}
							noC++;
					}

				}

				maxV = noV > 0 ? Collections.max(vCountMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getValue() : 0;
				maxC = noC > 0 ? Collections.max(cCountMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getValue() : 0;


				int tv = noV > 0 ? noC + 2 * (noV - maxV) : noC;
				int tc = noC > 0 ? noV + 2 * (noC - maxC) : noV;
				int mint = tc < tv ? tc : tv;
				System.out.println("Case #" + i + ": " + mint);
				//System.out.println(s);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
