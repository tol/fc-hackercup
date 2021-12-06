package ro.tol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("xs_and_os_input.txt"))))) {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= t; ++i) {
				int  n = in.nextInt();
				int [][] table=new int [n][n];
				for (int j=0;j<n;j++) {
					String s=in.next();
					for (int k = 0; k < n; k++) {
						switch (s.charAt(k)) {
							case 'X':{table[j][k]=1;break;}

							case 'O':{table[j][k]=2;break;}
							case '.':{table[j][k]=0;break;}
						}

					}
				}
				int[] cols=new int[n];
				int[] rows=new int[n];

				for (int j=0;j<n;j++){
					cols[j]=0;
					rows[j]=0;
					for (int k = 0; k < n; k++) {
						if (table[j][k]==2) rows[j]=-1;
						if (table[k][j]==2) cols[j]=-1;
						if (table[j][k]==0 && rows[j]!=-1) {
							rows[j]++;
						}
						if (table[k][j]==0 && cols[j]!=-1) {
							cols[j]++;
						}

					}
				}

				int min=Integer.MAX_VALUE;
				int countmin=0;
				for (int j=0;j<n;j++){
					if (cols[j]==min && cols[j]!=-1) {
						countmin++;
					} else {

						if (cols[j] < min && cols[j] != -1) {
							min = cols[j];
							countmin = 1;
						}
					}
					if (rows[j]==min && rows[j]!=-1) {
						countmin++;
					} else {
						if (rows[j] < min && rows[j] != -1) {
							min = rows[j];
							countmin = 1;
						}
					}

				}
				//eliminate duplicates from  solution
				int dup=0;
				if (min==1){
					for (int j=0;j<n;j++){
						if (rows[j]==min){
							for (int k = 0; k < n; k++) {
								if (cols[k]==min){
									//for (int d = 0; d < n; d++){
										if (table[j][k]==0){
											dup++;
											break;
										}
									//}
								}
							}
						}
					}
				}

				System.out.println("Case #" + i + ": " +(min<Integer.MAX_VALUE? min+" "+(countmin-dup):"Impossible"));
				//System.out.println(s);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
