package onboarding.problem5;

import java.math.BigDecimal;

public class Asset {
	private int asset;

	public synchronized int getAsset() {
		return this.asset;
	}

	public synchronized void deposit(int money) {
		this.asset += money;
	}
}
