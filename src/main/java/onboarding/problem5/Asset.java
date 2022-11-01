package onboarding.problem5;

import java.math.BigDecimal;

public class Asset {
	private int asset;
	private boolean isLocked = false;

	public int getAsset() {
		return this.asset;
	}

	public void deposit(int money) {
		this.asset += money;
	}

	public void withdraw(int money) {
		this.asset -= money;
	}

	public synchronized void lock() {
		try {
			while (isLocked) {
				wait();
			}
			isLocked = true;
		} catch (InterruptedException e) {

		}
	}

	public synchronized void unlock(){
		isLocked = false;
		notify();
	}

}
