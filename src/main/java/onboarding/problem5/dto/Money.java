package onboarding.problem5.dto;

public class Money {
    private Integer value;

    private Money(Integer money) {
        this.value = money;
    }

    public static Money of(Integer money) {
        return new Money(money);
    }

    public Integer getMoney() {
        return value;
    }

    public void setMoney(Integer money) {
        this.value = money;
    }
}
