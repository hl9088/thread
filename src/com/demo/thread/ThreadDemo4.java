package com.demo.thread;
/**
 * synchronized��ʹ��
 * ��һ���̷߳��ʶ����һ��synchronized(this)ͬ�������ʱ����һ���߳���Ȼ���Է��ʸö����еķ�synchronized(this)ͬ������顣
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
					System.out.println("ͬ������" + Thread.currentThread().getName() + ":" + (count++));
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
				System.out.println("��ͬ������" + Thread.currentThread().getName() + " count:" + count);
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
	 * ͬ������A:0 
	 * ��ͬ������B count:1 
	 * ��ͬ������B count:1 
	 * ͬ������A:1 
	 * ��ͬ������B count:2 
	 * ͬ������A:2
	 * ͬ������A:3 
	 * ��ͬ������B count:4 
	 * ͬ������A:4 
	 * ��ͬ������B count:5
	 */
}
