package com.doku.threads.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadPriorityExample {
	
	public static void printingProperties() {
		System.out.println("... Printing thread properties: ");
		System.out.println("thread id: " + Thread.currentThread().getId());
		System.out.println("thread name: " + Thread.currentThread().getName());
		System.out.println("thread priority: " + Thread.currentThread().getPriority());
	}
	
	public static void settingThreadPriority() {
		List<Thread> list = new ArrayList<>();
		list.add(new UserThread("one",Thread.MIN_PRIORITY));
		list.add(new UserThread("two",Thread.NORM_PRIORITY));
		list.add(new UserThread("three",Thread.NORM_PRIORITY));
		list.add(new UserThread("four",Thread.NORM_PRIORITY));
		list.add(new UserThread("five",Thread.NORM_PRIORITY));
		list.add(new UserThread("six",Thread.NORM_PRIORITY));
		list.add(new UserThread("seven",Thread.NORM_PRIORITY));
		list.add(new UserThread("eight",Thread.NORM_PRIORITY));
		list.add(new UserThread("nine",Thread.NORM_PRIORITY));
		list.add(new UserThread("ten",Thread.MAX_PRIORITY));
		list.forEach(Thread::start);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ MAIN MENU ]");
		System.out.println(" 1. print properties thread");
		System.out.println(" 2. setting priority to thread");
		int opc = scan.nextInt();
		switch(opc) {
			case 1: printingProperties();
				break;
			case 2: settingThreadPriority();
				break;
			default:
					System.out.println("***not available option***");
		}
		scan.close();
	}
}

class UserThread extends Thread  {
	
	public UserThread(String name, int priority) {
		this.setPriority(priority);
		this.setName(name);
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" ...hi thread[id:"+this.getPriority()+",name:"+this.getName()+"]");
	}
	
}
