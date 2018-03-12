package com.demo.thread;

/**
 * 多线程的实现方法二 
 * @author Administrator
 */
public class ThreadDemo2 implements Runnable {
	private String name;

	public ThreadDemo2(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + "运行中....");
		for (int i = 0; i < 5; i++) {
			int temp = (int) (Math.random() * 1000);
			System.out.println("正在运行的线程名称"+Thread.currentThread().getName() + name + "暂停" + temp + "ms" + System.currentTimeMillis());
			try {
				Thread.sleep(temp);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadDemo2("进程1"));
		t1.setName("进程1");
		t1.start();
		Thread t2 = new Thread(new ThreadDemo2("进程2"));
		t2.setName("进程2");
		t2.start();
	}

	/**
	 * Thread2类通过实现Runnable接口，使得该类有了多线程类的特征。run（）方法是多线程程序的一个约定。所有的多线程代码都在run方法里面
	 * 。Thread类实际上也是实现了Runnable接口的类。
	 * 在启动的多线程的时候，需要先通过Thread类的构造方法Thread(Runnable target)
	 * 构造出对象，然后调用Thread对象的start()方法来运行多线程代码。
	 * 实际上所有的多线程代码都是通过运行Thread的start()方法来运行的。因此，不管是扩展Thread类还是实现Runnable接口来实现多线程
	 * ，最终还是通过Thread的对象的API来控制线程的，熟悉Thread类的API是进行多线程编程的基础。
	 */
	
	
	/**
	 * 实现Runnable接口比继承Thread类所具有的优势：
	 * 1）：适合多个相同的程序代码的线程去处理同一个资源
	 * 2）：可以避免java中的单继承的限制
	 * 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
	 * 4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类
	 */
	
	/**
	 * 进程1运行中.... 
	 * 进程2运行中.... 
	 * 进程1暂停4ms1520499067230 
	 * 进程2暂停4ms1520499067230
	 * 进程2暂停7ms1520499067234 
	 * 进程1暂停4ms1520499067234 
	 * 进程1暂停0ms1520499067238
	 * 进程1暂停7ms1520499067238 
	 * 进程2暂停6ms1520499067241 
	 * 进程1暂停0ms1520499067245
	 * 进程2暂停5ms1520499067247 
	 * 进程2暂停6ms1520499067252
	 */
}
