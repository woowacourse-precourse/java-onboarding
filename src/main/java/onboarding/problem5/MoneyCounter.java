package onboarding.problem5;

public class MoneyCounter {
    private int bill;

    public MoneyCounter(int bill) {
        this.bill =bill;
    }

    private int countBy(int unitMoney) {
        return bill / unitMoney;
    }
}
