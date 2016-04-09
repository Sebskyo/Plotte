package com.sebskyo.plotte;

public class CliHandle {
	public static Options parse(String args[]) {
		if (args[0].equals("--help")) {
			System.out.println("plotte [options] [option arguments]\n" +
					"--help\tview this message\n" +
					"-c [true/false]\n\tset colored mode to either true or false\n" +
					"-d [width]x[height]\n\tset dimensions to width x height\n");
			System.exit(0);
		}
		String opts = args[0].replace("-", "");
		int width = 64, height = 64;
		boolean isColored = false;
		if (opts.contains("d")) {
			String arg = args[opts.indexOf("d") + 1];
			width = Integer.parseInt(arg.split("x")[0]);
			height = Integer.parseInt(arg.split("x")[1]);
		}
		if (opts.contains("c")) {
			String arg = args[opts.indexOf("c") + 1];
			isColored = Boolean.parseBoolean(arg);
		}
		return new Options(width, height, isColored);
	}
}
