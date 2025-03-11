package com.doku.threads.sync;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		Worker worker = new Worker(5, 0);

		Thread producer = new Thread(() -> {
			try {
				worker.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread consumer = new Thread(() -> {
			try {
				worker.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		producer.start();
		consumer.start();
	}

	static class Worker {
		private int sequence = 0;
		private final Integer _FULL;
		private final Integer _EMPTY;
		private final List<Integer> container;
		private final Object lock = new Object();

		public Worker(Integer top, Integer bottom) {
			super();
			this._FULL = top;
			this._EMPTY = bottom;
			this.container = new ArrayList<>();
		}

		public void produce() throws InterruptedException {
			synchronized (lock) {
				while (true) {
					if (container.size() == _FULL) {
						System.out.println("Container full, waiting for items to be removed...");
						lock.wait();
					} else {
						System.out.println(sequence + " Added to the container");
						container.add(sequence++);
						lock.notify();
					}
					Thread.sleep(500);
				}
			}
		}

		public void consumer() throws InterruptedException {
			synchronized (lock) {
				while (true) {
					if (container.size() == _EMPTY) {
						System.out.println("Container empty, waiting for add items...");
						lock.wait();
					} else {
						System.out.println(container.remove(0) + " removed from the container");
						lock.notify();
					}
					Thread.sleep(500);
				}
			}
		}

	}

}
