package questions;

import java.util.concurrent.atomic.AtomicInteger;

import org.jgroups.protocols.jzookeeper.zabNRW100WriteRatioAsync.Credit;

public class Clients {
	private Credit credits = new Credit(0);
	
	public void startSend() throws Throwable {

		// create sender (threads) to send requests
		for(int i=0; i < invokers.length; i++){
			invokers[i]=new Invoker(channel, requestToSendForEachInv, credits);
		}

		for(Invoker invoker: invokers)
			invoker.start();

		for(Invoker invoker: invokers) {
			invoker.join();
		}

	}

	/*
	 * Here I receive a replay. I need to check if the outstanding requests 
	 * less than 100, if so notify all invokers.
	 */
	public void receive(Message msg) {

		synchronized (this) {
			synchronized(credits){
				if (credits.decAndGet()<100){
					credits.notify();
				}
			}
		}

	}

	//Sender to send write Request
	private class Invoker extends Thread {

		public void run() {
			while(true) {

				for (int i = 0; i < toSend; i++) {
					//What is wrong with below code?
					synchronized (credits) {
						if(credits.incAndGet()>=100){
							credits.wait();
						}
					}
					channel.send(message);
				}

			}
		}

		public static void main(String[] args) {
			Clients client = new Clients();
			client.startSend();
		}

	}

}