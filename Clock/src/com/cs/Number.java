package com.cs;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number {

	private Map<Integer, Pixel> pixels = new HashMap<>();

	private Map<Integer, List<Integer>> showIndex = new HashMap<>();

	private final int[] top = new int[] { 1, 2, 3, 4 };
	private final int[] middle = new int[] { 9, 10, 11, 12 };
	private final int[] bottom = new int[] { 17, 18, 19, 20 };
	private final int[] left_1 = new int[] { 5, 7 };
	private final int[] left_2 = new int[] { 13, 15 };
	private final int[] right_1 = new int[] { 6, 8 };
	private final int[] right_2 = new int[] { 14, 16 };

	public Number() {
		for (int i = 1; i <= 20; i++) {
			pixels.put(i, new Pixel());
		}
		showIndex.put(0, mergeArrays(this.top, this.left_1, this.right_1, this.left_2, this.right_2, this.bottom,
				new int[] { 9, 12 }));
		showIndex.put(1, mergeArrays(this.right_1, this.right_2, new int[] { 4, 12, 20 }));
		showIndex.put(2, mergeArrays(this.top, this.middle, this.bottom, this.right_1, this.left_2));
		showIndex.put(3, mergeArrays(this.top, this.middle, this.bottom, this.right_1, this.right_2));
		showIndex.put(4, mergeArrays(this.left_1, this.right_1, this.right_2, this.middle, new int[] { 1, 4, 20 }));
		showIndex.put(5, mergeArrays(this.top, this.middle, this.bottom, this.left_1, this.right_2));
		showIndex.put(6, mergeArrays(this.top, this.middle, this.bottom, this.left_1, this.left_2, this.right_2));
		showIndex.put(7, mergeArrays(this.top, this.right_1, this.right_2, new int[] { 12, 20 }));
		showIndex.put(8,
				mergeArrays(this.top, this.middle, this.bottom, this.left_1, this.left_2, this.right_1, this.right_2));
		showIndex.put(9, mergeArrays(this.top, this.middle, this.bottom, this.left_1, this.right_1, this.right_2));
	}

	private static List<Integer> mergeArrays(int[]... arrs) {
		List<Integer> rsList = new ArrayList<>();
		for (int[] a : arrs) {
			for (int i : a) {
				rsList.add(i);
			}
		}
		Collections.sort(rsList);
		return rsList;
	}

	public Map<Integer, Pixel> getAllPixels() {
		return pixels;
	}
	
	public void changeColor(Color c){
		for (int i = 1; i <= 20; i++) {
			pixels.get(i).changleColor(c);
		}
	}

	public void display(int num) {
		for (int i = 1; i <= 20; i++) {
			pixels.get(i).dark();
		}
		for (int i : showIndex.get(num)) {
			pixels.get(i).light();
		}

	}

}
