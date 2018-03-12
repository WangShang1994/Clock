package com.cs;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Launch {

	public static void main(String[] args) {
		Launch a = new Launch();
		a.show();
	}

	private void show() {
		JFrame jFrame = new JFrame();
		jFrame.setUndecorated(true);
		jFrame.setBackground(new Color(0, 0, 0, 0));
		Number num0 = new Number();
		Number num1 = new Number();
		Number num2 = new Number();
		Number num3 = new Number();
		Number num4 = new Number();
		Number num5 = new Number();
		List<Number> nums = new ArrayList<>();
		List<Pixel> pixels = new ArrayList<>();
		nums.add(num0);
		nums.add(num1);
		nums.add(num2);
		nums.add(num3);
		nums.add(num4);
		nums.add(num5);
		Pixel p1 = new Pixel();
		p1.light();
		Pixel p2 = new Pixel();
		p2.light();
		Pixel p3 = new Pixel();
		p3.light();
		Pixel p4 = new Pixel();
		p4.light();
		pixels.add(p1);
		pixels.add(p2);
		pixels.add(p3);
		pixels.add(p4);
		p1.setBounds(130, 34, 10, 10);
		p2.setBounds(130, 58, 10, 10);
		p3.setBounds(270, 34, 10, 10);
		p4.setBounds(270, 58, 10, 10);
		jFrame.add(p1);
		jFrame.add(p2);
		jFrame.add(p3);
		jFrame.add(p4);
		boundsPixel(jFrame, num0.getAllPixels(), 10, 10, 10);
		boundsPixel(jFrame, num1.getAllPixels(), 70, 10, 10);
		boundsPixel(jFrame, num2.getAllPixels(), 150, 10, 10);
		boundsPixel(jFrame, num3.getAllPixels(), 210, 10, 10);
		boundsPixel(jFrame, num4.getAllPixels(), 290, 10, 10);
		boundsPixel(jFrame, num5.getAllPixels(), 350, 10, 10);
		Controller c0 = new Controller(0, num0);
		Controller c1 = new Controller(1, num1);
		Controller c2 = new Controller(2, num2);
		Controller c3 = new Controller(3, num3);
		Controller c4 = new Controller(4, num4);
		Controller c5 = new Controller(5, num5);
		c0.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		EventListener listener = new EventListener(nums,pixels);
		p2.addMouseListener(listener);
		jFrame.addMouseListener(listener);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(null);
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		jFrame.setSize(400, 100);
		jFrame.setLocation(1300, 10);
		jFrame.setAlwaysOnTop(true);

	}

	private void boundsPixel(JFrame f, Map<Integer, Pixel> pixels, int x, int y, int pixelSize) {
		int[] left = { 1, 5, 7, 9, 13, 15, 17 };
		for (int i = 0; i < left.length; i++) {
			pixels.get(left[i]).setBounds(x, y + (pixelSize * i) + (2 * i), pixelSize, pixelSize);
			f.add(pixels.get(left[i]));
		}
		int[] right = { 4, 6, 8, 12, 14, 16, 20 };
		for (int i = 0; i < right.length; i++) {
			pixels.get(right[i]).setBounds(x + (pixelSize * 3) + (2 * 3), y + (pixelSize * i) + (2 * i), pixelSize,
					pixelSize);
			f.add(pixels.get(right[i]));
		}
		int[] middle = { 2, 3, 10, 11, 18, 19 };
		for (int i : middle) {
			switch (i) {
			case 2:
				pixels.get(i).setBounds(x + pixelSize + 2, y, pixelSize, pixelSize);
				f.add(pixels.get(i));
				break;
			case 3:
				pixels.get(i).setBounds(x + (pixelSize * 2) + 4, y, pixelSize, pixelSize);
				f.add(pixels.get(i));
				break;
			case 10:
				pixels.get(i).setBounds(x + pixelSize + 2, y + (pixelSize * 3) + 6, pixelSize, pixelSize);
				f.add(pixels.get(i));
				break;
			case 11:
				pixels.get(i).setBounds(x + (pixelSize * 2) + 4, y + (pixelSize * 3) + 6, pixelSize, pixelSize);
				f.add(pixels.get(i));
				break;
			case 18:
				pixels.get(i).setBounds(x + pixelSize + 2, y + (pixelSize * 6) + 12, pixelSize, pixelSize);
				f.add(pixels.get(i));
				break;
			case 19:
				pixels.get(i).setBounds(x + (pixelSize * 2) + 4, y + (pixelSize * 6) + 12, pixelSize, pixelSize);
				f.add(pixels.get(i));
				break;
			}
		}

	}

}

class EventListener implements MouseListener {
	List<Number> nums = new ArrayList<>();
	List<Pixel> pixels = new ArrayList<>();
	List<Color> colors = new ArrayList<>();
	Color currentColor;
	public EventListener(List<Number> nums, List<Pixel> pixels) {
		this.nums = nums;
		this.pixels = pixels;
		this.currentColor = pixels.get(0).getBackground();
		Color[] cs = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW,Color.WHITE};
		for(Color c : cs){
			colors.add(c);
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int index = colors.indexOf(currentColor);
		if(index==colors.size()-1){
			index=0;
		}
			for (Number n : nums) {
				n.changeColor(colors.get(index+1));
			}
			for (Pixel p : pixels) {
				p.changleColor(colors.get(index+1));
			}
			currentColor = colors.get(index+1);
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {

	}

}
