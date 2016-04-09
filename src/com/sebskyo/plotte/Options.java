package com.sebskyo.plotte;

public class Options {
	private int width, height;
	private boolean isColored;
	public Options(int width, int height, boolean isColored) {
		this.width = width;
		this.height = height;
		this.isColored = isColored;
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
}
