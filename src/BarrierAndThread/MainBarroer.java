package BarrierAndThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainBarroer {
	
	private MyThread [] _clients = new MyThread[2];
	private CyclicBarrier _barrier = new CyclicBarrier(_clients.length+1);


	public MyThread[] get_clients() {
		return _clients;
	}


	public void set_clients(MyThread[] _clients) {
		this._clients = _clients;
	}

	public CyclicBarrier get_barrier() {
		return _barrier;
	}


	public void set_barrier(CyclicBarrier _barrier) {
		this._barrier = _barrier;
	}


	public static void main(String[] args) {

		MainBarroer mb = new MainBarroer();
		MyThread [] _clientsTest = mb.get_clients();
		for (int i = 0; i < 2; i++) {
			_clientsTest[i] = new MyThread("MyThread_"+i, mb);
		}
		for (int i = 0; i < 2; i++) {
			_clientsTest[i].start();
		}
		
		System.out.println("Before mb.get_barrier().await() in Main");

		try {
			mb.get_barrier().await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
