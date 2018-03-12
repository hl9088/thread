package com.demo.thread.bank;
/**
 * �˻���
 * @author Administrator
 */

public class Account {
	// �����
	private float balance;
	
	public Account(float balance){
		this.balance = balance;
	}
	
	public void deposit(float in){
		balance += in;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void withdraw(float out){
		float temp = balance - out;
		if(temp<0){
			System.out.println(Thread.currentThread().getName() + "�˻�����");
		}else{
			balance -= out;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public float getBalance(){
		return balance;
	}
}
