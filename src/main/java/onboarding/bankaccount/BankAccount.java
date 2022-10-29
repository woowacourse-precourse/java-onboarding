package onboarding.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	private int money;

	public BankAccount(int money) {
		this.money = money;
	}

	public int getBillsOf(final BankUnit bankUnit) {
		return money / bankUnit.getMoney();
	}

	public List<Integer> getBills() {
		List<Integer> bills = new ArrayList<>();

		for (BankUnit billUnit : BankUnit.values()) {
			int numberOfBills = getBillsOf(billUnit);
			bills.add(numberOfBills);
			this.money = numberOfBills != 0
				? money - (numberOfBills * billUnit.getMoney())
				: money;
		}
		return bills;
	}
}
