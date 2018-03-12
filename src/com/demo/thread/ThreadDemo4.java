package com.demo.thread;
/**
 * synchronized的使用
 * 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。
 * @author Administrator
 */
public class ThreadDemo4 implements Runnable {

	private Integer count;

	public ThreadDemo4() {
		count = 0;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
	      if (threadName.equals("A")) {
	    	  synchronizedMethod();
	      } else if (threadName.equals("B")) {
	    	  unsynchronizedMethod();
	      }
	}

	public void synchronizedMethod() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println("同步方法" + Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void unsynchronizedMethod() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("非同步方法" + Thread.currentThread().getName() + " count:" + count);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo4 th = new ThreadDemo4();
		Thread t1 = new Thread(th,"A");
		Thread t2 = new Thread(th,"B");
		t1.start();
		t2.start();
	}

	/**
	 * 同步方法A:0 
	 * 非同步方法B count:1 
	 * 非同步方法B count:1 
	 * 同步方法A:1 
	 * 非同步方法B count:2 
	 * 同步方法A:2
	 * 同步方法A:3 
	 * 非同步方法B count:4 
	 * 同步方法A:4 
	 * 非同步方法B count:5
	 */
}
