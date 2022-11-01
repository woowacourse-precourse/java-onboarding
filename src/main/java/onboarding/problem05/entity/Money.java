package onboarding.problem05.entity;

import onboarding.problem05.infra.exception.MoneyOutOfValueException;

public class Money {

  private int money;

  private Money(int money) {
    if (money < 1 || money > 1000000) {
      throw new MoneyOutOfValueException();
    }
    this.money = money;
  }

  public static Money from(int money) {
    return new Money(money);
  }
}
