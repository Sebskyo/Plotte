package com.sebskyo.plotte;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		// Read numbers from input
		Options opts;
		if(args.length > 0) {
			try {
				opts = CliHandle.parse(args);
			}
			catch (Exception e) {
				System.out.println("An error occurred during cli option parsing, using defaults");
				System.out.println(e);
				opts = new Options(64, 64, false);
			}
		}
		else {
			opts = new Options(64, 64, false);
		}
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arrl = new ArrayList<>();
		boolean b = true;
		do {
			try {
				arrl.add(sc.nextInt());
			}
			catch (InputMismatchException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			catch (NoSuchElementException e) {
				b = false;
			}
		} while(b);
		int[] arr = new int[arrl.size()];
		for(int i = 0; i < arr.length; i++)
			arr[i] = arrl.get(i);

		// Create image
		Plot p = new Plot(opts.getWidth(), opts.getHeight(), opts.getIsColored());
		p.paint(arr);
		p.write();
	}
}
