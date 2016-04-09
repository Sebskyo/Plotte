package com.sebskyo.plotte;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Random;

public class Plot extends BufferedImage {
	private Graphics2D g;
	private Random r;
	private boolean isColored;

	public Plot(int width, int height, boolean isColored) {
		super(width, height, TYPE_INT_RGB);
		this.isColored = isColored;
		g = createGraphics();
		r = new Random();
	}

	public void paint(int[] arr) {
		float sep = (float) getWidth()/arr.length;
		int max = 0;
		for(int i : arr)
			max = i > max ? i : max;
		for(int i = 0; i < arr.length; i++) {
			float p = (float)arr[i]/max;
			if(isColored)
				g.setColor(new Color((int)Math.floor((float)arr[i]/max*255), 255-(int)Math.floor((float)arr[i]/max*255), 0));
			g.fillRect((int)(i * sep + sep/4), getHeight()-(int) (p * getHeight()), (int)(sep/2), (int) (p * getHeight()));
		}
	}

	public void write() {
		try {
			ImageIO.write(this, "png", System.out);
		}
		catch (IOException e) {
			System.out.println("An I/O error occurred: " + e);
		}
		catch (Exception e) {
			System.out.println("An unknown error occurred: " + e);
		}
	}
}
