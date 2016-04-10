package com.sebskyo.plotte;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;


/*
Plotte plots numbers and outputs raw image data.
For more information and license, visit https://github.com/sebskyo/plotte

Exit codes:
 0 | All good
-1 | Unknown error
-2 | Wrong input
-3 | I/O error
-4 | Parsing error
 */
public class Main {
	public static void main(String args[]) {
		// Parse arguments
		Options opts = new Options(256, 256, false, false);
		if(args.length > 0) {
			try {
				opts = CliHandle.parse(args);
			}
			catch (Exception e) {
				System.out.println("An error occurred during cli option parsing, printing stacktrace and aborting.");
				e.printStackTrace();
				System.exit(-4);
			}
		}

		// Read data from stdin
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arrl = new ArrayList<>();
		boolean b = true;
		do {
			try {
				arrl.add(sc.nextInt());
			}
			catch (InputMismatchException e) {
				e.printStackTrace();
				System.exit(-2);
			}
			catch (NoSuchElementException e) {
				b = false;
			}
		} while(b);
		int[] arr = new int[arrl.size()];
		for(int i = 0; i < arr.length; i++)
			arr[i] = arrl.get(i);

		// Create, generate and output image
		Plot p = new Plot(opts);
		p.paint(arr);
		p.write();
	}
}
