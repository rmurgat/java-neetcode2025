package com.doku.threads.basic;

public class DaemonUserThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread daemon = new Thread(new DaemonHemlper());
		Thread userthread = new Thread(new UserThreadHelper());
		daemon.setDaemon(true);
		
		daemon.start();
		userthread.start();
		
	}

}

class DaemonHemlper implements Runnable {

	@Override
	public void run() {
		int count = 0;
		while (count<500) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			System.out.println("Daemon helper running...");
		}
		
	}
	
}


class UserThreadHelper implements Runnable {

	@Override
	public void run() {
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("User thread done with execution");
		
	}
	
}