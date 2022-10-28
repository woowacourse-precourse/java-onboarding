package onboarding.problem5;

import java.util.ArrayList;


public class MoneyCounter {
    private int bill;

    public MoneyCounter(int bill) {
        this.bill = bill;
    }

    private void calculateCount(ArrayList<Integer> answer) {
        int currentBill = bill;

        for (Money unitMoney : Money.values()) {
            answer.add(unitMoney.countIn(currentBill));
            currentBill -= unitMoney.usedBill(currentBill);
        }
    }
}
