package BarrierAndThread;

import java.util.concurrent.BrokenBarrierException;

public class MyThread extends Thread{
	private MainBarroer mbb;
	public MyThread(String name, MainBarroer mbb) {
		super(name);
		this.mbb = mbb;
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		try {
			mbb.get_barrier().await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			System.out.println(this.getName()+" intrrupted by "+ e.getMessage());;
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(this.getName()+" Printed");
		}
		
	}

	
}
