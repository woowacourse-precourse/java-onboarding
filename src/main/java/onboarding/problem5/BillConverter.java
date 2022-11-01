package onboarding.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BillConverter {
	private List<Integer> numberOfBills = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));

	public List<Integer> convertIntoBills(int money) {
		List<UnitsOfBill> unitsOfBills = new ArrayList<>(Arrays.asList(UnitsOfBill.values()));
		int inputMoney = money;

		for (UnitsOfBill oneUnit : unitsOfBills) {
			if (inputMoney >= oneUnit.getAmountOfMoney()) {
				inputMoney = calculateNumberOfBills(oneUnit, inputMoney);
			}
		}

		return numberOfBills;
	}

	private int calculateNumberOfBills(UnitsOfBill unitsOfBill, int money) {
		int numberOfBills = money / unitsOfBill.getAmountOfMoney();
		int change = money % unitsOfBill.getAmountOfMoney();

		this.numberOfBills.set(unitsOfBill.ordinal(), numberOfBills);

		return change;
	}

}
