package onboarding.billcounter;

import java.util.ArrayList;
import java.util.List;

public class BillCounter {

	private int money;

	public BillCounter(int money) {
		this.money = money;
	}

	public List<Integer> getBills() {
		List<Integer> bills = new ArrayList<>();

		for (BillUnit billUnit : BillUnit.values()) {
			int numberOfBills = getNumberOfBills(billUnit);
			bills.add(numberOfBills);
			money -= (numberOfBills * billUnit.getMoney());
		}
		return bills;
	}

	int getNumberOfBills(final BillUnit billUnit) {
		return money / billUnit.getMoney();
	}
}
