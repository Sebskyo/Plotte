package com.sebskyo.plotte;

/*
CliHandle parses the arguments given to it
 */
public class CliHandle {
	public static Options parse(String args[]) {
		// Standard info arguments
		if(args[0].equals("--help")) {
			System.out.println("plotte [options]\n\n" +
					"--help\tview this message\n\n" +
					"--version\tshow version\n\n" +
					"-c\n\tif flag is set, columns are coloured\n\n" +
					"-i\n\tif flag is set, background and foreground colours are inverted\n\t(if -c is also set, columns are coloured instead of inverted)\n\n" +
					"-d [width]x[height]\n\tset dimensions to width x height\n");
			System.exit(0);
		}
		if(args[0].equals("--version")) {
			System.out.println("1.0");
			System.exit(0);
		}

		// Actual parsing
		// Setting used variables
		String opts = args[0].replace("-", "");
		int width = 256, height = 256;
		boolean isColored, isInverted;

		// Parse image size
		if(opts.contains("d")) {
			String arg = args[1];
			width = Integer.parseInt(arg.split("x")[0]);
			height = Integer.parseInt(arg.split("x")[1]);
		}

		// Parse colour options
		isColored = opts.contains("c");
		isInverted = opts.contains("i");

		return new Options(width, height, isColored, isInverted);
	}
}
