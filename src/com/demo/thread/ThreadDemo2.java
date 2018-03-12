package com.demo.thread;

/**
 * ���̵߳�ʵ�ַ����� 
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
		System.out.println(name + "������....");
		for (int i = 0; i < 5; i++) {
			int temp = (int) (Math.random() * 1000);
			System.out.println("�������е��߳�����"+Thread.currentThread().getName() + name + "��ͣ" + temp + "ms" + System.currentTimeMillis());
			try {
				Thread.sleep(temp);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadDemo2("����1"));
		t1.setName("����1");
		t1.start();
		Thread t2 = new Thread(new ThreadDemo2("����2"));
		t2.setName("����2");
		t2.start();
	}

	/**
	 * Thread2��ͨ��ʵ��Runnable�ӿڣ�ʹ�ø������˶��߳����������run���������Ƕ��̳߳����һ��Լ�������еĶ��̴߳��붼��run��������
	 * ��Thread��ʵ����Ҳ��ʵ����Runnable�ӿڵ��ࡣ
	 * �������Ķ��̵߳�ʱ����Ҫ��ͨ��Thread��Ĺ��췽��Thread(Runnable target)
	 * ���������Ȼ�����Thread�����start()���������ж��̴߳��롣
	 * ʵ�������еĶ��̴߳��붼��ͨ������Thread��start()���������еġ���ˣ���������չThread�໹��ʵ��Runnable�ӿ���ʵ�ֶ��߳�
	 * �����ջ���ͨ��Thread�Ķ����API�������̵߳ģ���ϤThread���API�ǽ��ж��̱߳�̵Ļ�����
	 */
	
	
	/**
	 * ʵ��Runnable�ӿڱȼ̳�Thread�������е����ƣ�
	 * 1�����ʺ϶����ͬ�ĳ��������߳�ȥ����ͬһ����Դ
	 * 2�������Ա���java�еĵ��̳е�����
	 * 3�������ӳ���Ľ�׳�ԣ�������Ա�����̹߳�����������ݶ���
	 * 4�����̳߳�ֻ�ܷ���ʵ��Runable��callable���̣߳�����ֱ�ӷ���̳�Thread����
	 */
	
	/**
	 * ����1������.... 
	 * ����2������.... 
	 * ����1��ͣ4ms1520499067230 
	 * ����2��ͣ4ms1520499067230
	 * ����2��ͣ7ms1520499067234 
	 * ����1��ͣ4ms1520499067234 
	 * ����1��ͣ0ms1520499067238
	 * ����1��ͣ7ms1520499067238 
	 * ����2��ͣ6ms1520499067241 
	 * ����1��ͣ0ms1520499067245
	 * ����2��ͣ5ms1520499067247 
	 * ����2��ͣ6ms1520499067252
	 */
}
