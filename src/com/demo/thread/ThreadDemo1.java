package com.demo.thread;

/**
 * ���̵߳�ʵ�ַ���һ�� ���Ƽ�ʹ��
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
		System.out.println(name + "������....");
		for (int i = 0; i < 5; i++) {
			int temp = (int) (Math.random() * 10);
			System.out.println(name + "��ͣ" + temp + "ms" + System.currentTimeMillis());
			try {
				sleep(temp);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadDemo1 t1 = new ThreadDemo1("����1");
		ThreadDemo1 t2 = new ThreadDemo1("����2");
		t1.start();
		t2.start();
	}

	/**
	 * start()�����ĵ��ú󲢲�������ִ�ж��̴߳��룬����ʹ�ø��̱߳�Ϊ������̬��Runnable����ʲôʱ���������ɲ���ϵͳ�����ġ�
	 * �ӳ������еĽ�����Է��֣����̳߳���������ִ�С���ˣ�ֻ������ִ�еĴ�����б�Ҫ���Ϊ���̡߳�
	 * Thread.sleep()��������Ŀ���ǲ��õ�ǰ�̶߳��԰�ռ�ý�������ȡ��CPU��Դ��������һ��ʱ��������߳�ִ�еĻ��ᡣ
	 * ʵ�������еĶ��̴߳���ִ��˳���ǲ�ȷ���ģ�ÿ��ִ�еĽ����������ġ�
	 * start�����ظ����õĻ��������java.lang.IllegalThreadStateException�쳣��
	 */

	/**
	 * ����1������.... ����2������.... 
	 * ����2��ͣ3ms1520498352701 
	 * ����1��ͣ3ms1520498352701
	 * ����2��ͣ3ms1520498352705 
	 * ����1��ͣ0ms1520498352705 
	 * ����1��ͣ2ms1520498352705
	 * ����1��ͣ3ms1520498352707 
	 * ����2��ͣ0ms1520498352708 
	 * ����2��ͣ2ms1520498352708
	 * ����2��ͣ1ms1520498352710 
	 * ����1��ͣ7ms1520498352710
	 */
}
