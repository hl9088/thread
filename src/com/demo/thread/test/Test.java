package com.demo.thread.test;

public class Test implements Runnable{
	
	private Object prev;
	private Object now;
	
	public Test(Object prev, Object now){
		this.prev = prev;
		this.now = now;
	}
	
	@Override
	public void run() {
		for (int i=0; i < 10; i++) {
			synchronized (prev) {
				synchronized (now) {
					System.out.print(Thread.currentThread().getName());
					now.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		Thread t1 = new Thread(new Test(c, a), "A");
		Thread t2 = new Thread(new Test(a, b), "B");
		Thread t3 = new Thread(new Test(b, c), "C");
		
		t1.start();
		Thread.sleep(100);
		t2.start();
		Thread.sleep(100);
		t3.start();
		Thread.sleep(5000);
	}
}
