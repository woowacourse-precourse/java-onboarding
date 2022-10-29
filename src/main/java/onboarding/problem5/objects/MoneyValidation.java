package onboarding.problem5.objects;

public class MoneyValidation {

    private int money;

    public MoneyValidation(int money) {
        this.money = money;
        checkValid();
    }

    private void checkValid() {
        if (!(this.money >= 1 && this.money <= 1000000)) {
            throw new IllegalArgumentException("Money is Not Valid!!!");
        }
    }
}
