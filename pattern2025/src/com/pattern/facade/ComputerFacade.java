package com.pattern.facade;

public class ComputerFacade {
	private CPU cpu;
	private Memory mem;
	private HardDrive hd;
	
	public ComputerFacade() {
		cpu = new CPU();
		mem = new Memory();
		hd = new HardDrive();
	}
	
	public void start() {
		System.out.println("[Starting Computer]");
		cpu.freeze();
		mem.load();
		hd.read();
		cpu.jump();
		cpu.execute();
	}
}
