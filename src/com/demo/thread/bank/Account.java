package com.demo.thread.bank;
/**
 * 账户类
 * @author Administrator
 */

public class Account {
	// 存款金额
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
			System.out.println(Thread.currentThread().getName() + "账户余额不足");
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
