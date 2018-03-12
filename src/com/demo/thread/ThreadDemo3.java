package com.demo.thread;
/**
 * synchronized��ʹ��
 * һ���̷߳���һ�������е�synchronized(this)ͬ�������ʱ��������ͼ���ʸö�����߳̽���������
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
		// ������ͬ���߳� ����ͬһ�����ͬ�������ʱ�� ֻ�ܴ�����һ���߳̽������ʺ���һ���̲߳��ܷ��ʣ�
		Thread t1 = new Thread(th,"����1");
		Thread t2 = new Thread(th,"����2");
		//�����������ͬ�߳� ���ʷ�ͬһ�����ͬ�������ʱ������Ӱ�죬��������ͬʱ����
		//Thread t1 = new Thread(new ThreadDemo3(),"����1");
		//Thread t2 = new Thread(new ThreadDemo3(),"����2");
		t1.start();
		t2.start();
	}
}
