package com.demo.thread;

/**
 * 多线程的实现方法一： 不推荐使用
 * @author Administrator
 */
public class ThreadDemo1 extends Thread {
	private String name;

	public ThreadDemo1(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + "运行中....");
		for (int i = 0; i < 5; i++) {
			int temp = (int) (Math.random() * 10);
			System.out.println(name + "暂停" + temp + "ms" + System.currentTimeMillis());
			try {
				sleep(temp);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadDemo1 t1 = new ThreadDemo1("进程1");
		ThreadDemo1 t2 = new ThreadDemo1("进程2");
		t1.start();
		t2.start();
	}

	/**
	 * start()方法的调用后并不是立即执行多线程代码，而是使得该线程变为可运行态（Runnable），什么时候运行是由操作系统决定的。
	 * 从程序运行的结果可以发现，多线程程序是乱序执行。因此，只有乱序执行的代码才有必要设计为多线程。
	 * Thread.sleep()方法调用目的是不让当前线程独自霸占该进程所获取的CPU资源，以留出一定时间给其他线程执行的机会。
	 * 实际上所有的多线程代码执行顺序都是不确定的，每次执行的结果都是随机的。
	 * start方法重复调用的话，会出现java.lang.IllegalThreadStateException异常。
	 */

	/**
	 * 进程1运行中.... 进程2运行中.... 
	 * 进程2暂停3ms1520498352701 
	 * 进程1暂停3ms1520498352701
	 * 进程2暂停3ms1520498352705 
	 * 进程1暂停0ms1520498352705 
	 * 进程1暂停2ms1520498352705
	 * 进程1暂停3ms1520498352707 
	 * 进程2暂停0ms1520498352708 
	 * 进程2暂停2ms1520498352708
	 * 进程2暂停1ms1520498352710 
	 * 进程1暂停7ms1520498352710
	 */
}
