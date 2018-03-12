package com.cs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller extends Thread{
	
	int index;
	Number num;
	
	public Controller(int index,Number num){
		this.index = index;
		this.num = num;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				getOutputNum();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void getOutputNum(){
		this.num.display(Integer.valueOf(new SimpleDateFormat("hhmmss").format(new Date()).split("")[this.index]));
	}
	
}
