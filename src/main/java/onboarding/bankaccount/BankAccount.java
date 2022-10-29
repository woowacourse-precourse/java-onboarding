package onboarding.bankaccount;

public class BankAccount {

	private final int money;

	public BankAccount(int money) {
		this.money = money;
	}

	public int getBillsOf(final BankUnit bankUnit) {
		return money / bankUnit.getMoney();
	}
}
