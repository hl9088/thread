package com.demo.thread;
/**
 * synchronized的使用
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞。
 * @author Administrator
 */
public class ThreadDemo3 implements Runnable{

	private Integer count;
	
	public ThreadDemo3() {
		count=0;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName()+ ":" + count++);
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo3 th = new ThreadDemo3();
		// 两个不同的线程 访问同一对象的同步代码块时， 只能待其中一个线程结束访问后，另一个线程才能访问；
		Thread t1 = new Thread(th,"线程1");
		Thread t2 = new Thread(th,"线程2");
		//如果是两个不同线程 访问非同一对象的同步代码块时，则不受影响，两个可以同时访问
		//Thread t1 = new Thread(new ThreadDemo3(),"线程1");
		//Thread t2 = new Thread(new ThreadDemo3(),"线程2");
		t1.start();
		t2.start();
	}
}
