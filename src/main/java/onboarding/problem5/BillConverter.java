package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class BillConverter {
	private List<Integer> numberOfBills = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));

	private int calculateNumberOfBills(UnitsOfBill unitsOfBill, int money) {
		int numberOfBills = money / unitsOfBill.getAmountOfMoney();
		int change = money % unitsOfBill.getAmountOfMoney();

		this.numberOfBills.set(unitsOfBill.ordinal(), numberOfBills);

		return change;
	}

}
