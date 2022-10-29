package onboarding.billcounter;

import java.util.ArrayList;
import java.util.List;

public class BillCounter {

	private int money;

	public BillCounter(int money) {
		this.money = money;
	}

	public int getBillsOf(final BillUnit billUnit) {
		return money / billUnit.getMoney();
	}

	public List<Integer> getBills() {
		List<Integer> bills = new ArrayList<>();

		for (BillUnit billUnit : BillUnit.values()) {
			int numberOfBills = getBillsOf(billUnit);
			bills.add(numberOfBills);
			this.money = numberOfBills != 0
				? money - (numberOfBills * billUnit.getMoney())
				: money;
		}
		return bills;
	}
}
