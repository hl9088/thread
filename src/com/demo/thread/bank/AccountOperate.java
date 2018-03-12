package com.demo.thread.bank;

public class AccountOperate implements Runnable {

	private Account account;
	private float in;
	private float out;
	
	public AccountOperate(Account account, float in, float out) {
		this.account = account;
		this.in = in;
		this.out = out;
	}
	
	@Override
	public void run() {
		synchronized (account) {
			try {
				Thread.sleep(10);
				account.deposit(in);
				account.withdraw(out);
				System.out.println(Thread.currentThread().getName() + "ÕË»§Óà¶îÎª£º"+account.getBalance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Account a = new Account(10000);
		AccountOperate ao = new AccountOperate(a,1000,5000);
		
		final int THREAD_NUM = 5;
		Thread threads[] = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i ++) {
		   threads[i] = new Thread(ao, "Thread" + i);
		   threads[i].start();
		}
	}
}
