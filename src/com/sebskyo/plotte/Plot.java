package com.sebskyo.plotte;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
Plot class contains options and functions for painting and writing the image.
An instance of Plot is an image, since the class extends BufferedImage,
as such it functions as a sort of specialised image class.
 */
public class Plot extends BufferedImage {
	private Graphics2D g;
	Options opts;

	public Plot(Options opts) {
		super(opts.getWidth(), opts.getHeight(), TYPE_INT_RGB);
		this.opts = opts;
		g = createGraphics();
	}

	public void paint(int[] arr) {
		// Inverted colours
		if(opts.getIsInverted()) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.BLACK);
		}

		// Finding needed variables
		float sep = (float) getWidth()/arr.length; // Used for column separation and width
		int max = 0;
		for(int i : arr)
			max = i > max ? i : max;

		// Column drawing loop
		for(int i = 0; i < arr.length; i++) {
			float p = (float)arr[i]/max; // Percentage of max, used for actual height in pixels
			// For coloured images
			if(opts.getIsColored())
				g.setColor(new Color((int)Math.floor((float)arr[i]/max*255), 255-(int)Math.floor((float)arr[i]/max*255), 0));
			// Actual drawing of a column
			g.fillRect((int)(i * sep + sep/4), getHeight()-(int) (p * getHeight()), (int)(sep/2), (int) (p * getHeight()));
		}
	}

	public void write() {
		// Mostly error handling here
		try {
			ImageIO.write(this, "png", System.out); // Yes, it's that simple
		}
		catch (IOException e) {
			System.out.println("An I/O error occurred, printing stacktrace and aborting: ");
			e.printStackTrace();
			System.exit(-3);
		}
		catch (Exception e) {
			System.out.println("An unknown error occurred while writing image data, printing stacktrace and aborting: ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
