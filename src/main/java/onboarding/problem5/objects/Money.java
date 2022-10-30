package onboarding.problem5.objects;

public class Money {

    private int money;
    private MoneyUnitCounter moneyUnitCounter;

    public Money(int money, MoneyUnitCounter moneyUnitCounter) {
        MoneyValidation validation = new MoneyValidation(money);
        this.money = money;
        this.moneyUnitCounter = moneyUnitCounter;
    }

    public MoneyUnitCounter getMoneyUnitCounter() {
        return moneyUnitCounter;
    }

    public int getMoney() {
        return money;
    }
}
