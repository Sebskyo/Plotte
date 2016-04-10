package com.sebskyo.plotte;

/*
Options class contains information used by the Plot class
 */
public class Options {
	private int width, height;
	private boolean isColored, isInverted;

	public Options(int width, int height, boolean isColored, boolean isInverted) {
		this.width = width;
		this.height = height;
		this.isColored = isColored;

		this.isInverted = isInverted;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public boolean getIsColored() {
		return isColored;
	}
	public boolean getIsInverted() {
		return isInverted;
	}
}
