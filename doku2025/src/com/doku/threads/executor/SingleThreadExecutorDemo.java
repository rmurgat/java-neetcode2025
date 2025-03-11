package com.doku.threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {

	public static void main(String[] args) {
		ExecutorService service = null; 
		try{
			service = Executors.newSingleThreadExecutor();
			for(int i=0; i<5; i++) {
				service.execute(new Task(i));
			}
		} finally {
			  if (service != null) service.shutdown();
		}

	}
	
	static class Task implements Runnable {
		private final int taskId;
		
		public Task(int taskId) {
			this.taskId = taskId;
		}

		@Override
		public void run() {
			System.out.println("Task with Id " + this.taskId + " been executed by Thread " + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
	}

}
