package com.cs;


import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		Test a = new Test();
		a.test();
	}
	
	private void test(){
		JFrame f = new JFrame();
		Pixel p = new Pixel();
		DonaldTest s = new DonaldTest(p);
		s.start();
		p.setBounds(0, 0, 20, 30);
		f.setLayout(null);
		f.setSize(100, 100);
		f.add(p);
		f.setVisible(true);
	}

}

class DonaldTest extends Thread {
	Pixel p;
	
	public DonaldTest(Pixel p){
		this.p = p;
	}
	@Override
	public void run(){
		while(true){
			this.p.light();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.p.dark();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
