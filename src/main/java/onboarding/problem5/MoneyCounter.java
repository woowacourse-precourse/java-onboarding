package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;


public class MoneyCounter {
    private int bill;

    public MoneyCounter(int bill) {
        this.bill = bill;
    }

    public List<Integer> count() {
        ArrayList<Integer> answer = new ArrayList<>();

        calculateCount(answer);

        return answer;
    }


    private void calculateCount(ArrayList<Integer> answer) {
        int currentBill = bill;

        for (Money unitMoney : Money.values()) {
            answer.add(unitMoney.countIn(currentBill));
            currentBill -= unitMoney.usedBill(currentBill);
        }
    }
}
