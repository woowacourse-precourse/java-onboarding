package onboarding.problem05.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import onboarding.problem05.infra.exception.MoneyOutOfValueException;

public class Money {

  private int money;
  private List<Integer> moneyClassification = new ArrayList<>();

  private Money(int money) {
    if (money < 1 || money > 1000000) {
      throw new MoneyOutOfValueException();
    }
    Integer[] coins = new Integer[9];
    moneyClassification = Arrays.asList(coins);
    this.money = money;
  }

  public static Money from(int money) {
    return new Money(money);
  }

  public List<Integer> processing() {
    while (money != 0) {
      if (money / 50000 != 0) {
        moneyClassification.set(0, money / 50000);
        money %= 50000;
      } else if (money / 10000 != 0) {
        moneyClassification.set(1, money / 10000);
        money %= 10000;
      } else if (money / 5000 != 0) {
        moneyClassification.set(2, money / 5000);
        money %= 5000;
      } else if (money / 1000 != 0) {
        moneyClassification.set(3, money / 1000);
        money %= 1000;
      } else if (money / 500 != 0) {
        moneyClassification.set(4, money / 500);
        money %= 500;
      } else if (money / 100 != 0) {
        moneyClassification.set(5, money / 100);
        money %= 100;
      } else if (money / 50 != 0) {
        moneyClassification.set(6, money / 50);
        money %= 50;
      } else if (money / 10 != 0) {
        moneyClassification.set(7, money / 10);
        money %= 10;
      } else {
        moneyClassification.set(8, money / 1);
        break;
      }
    }
    for (int i = 0; i < moneyClassification.size(); i++) {
      if (moneyClassification.get(i) == null) {
        moneyClassification.set(i, 0);
      }
    }
    return moneyClassification;
  }
}
