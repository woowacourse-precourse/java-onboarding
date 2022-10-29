package onboarding;

import java.util.ArrayList;
import java.util.List;

class ExchangeMoneyPro5 {

  public static final int MIN_MONEY = 1;
  public static final int MAX_MONEY = 1_000_000;

  private final int money;

  public ExchangeMoneyPro5(int money) {
    validateMoney(money);
    this.money = money;
  }

  public void validateMoney(int money) {
    if (money < MIN_MONEY || money > MAX_MONEY) {
      throw new IllegalArgumentException(
          "Please enter a word between " + MIN_MONEY + " and " + MAX_MONEY + " in length."
      );
    }
  }

  public List<Integer> divideMoney() {
    List<Integer> answer = new ArrayList<>();
    int money = this.money;
    answer.add(money / 50000);
    money %= 50000;
    answer.add(money / 10000);
    money %= 10000;
    answer.add(money / 5000);
    money %= 5000;
    answer.add(money / 1000);
    money %= 1000;
    answer.add(money / 500);
    money %= 500;
    answer.add(money / 100);
    money %= 100;
    answer.add(money / 50);
    money %= 50;
    answer.add(money / 10);
    money %= 10;
    answer.add(money);
    return answer;
  }
}

public class Problem5 {

  public static List<Integer> solution(int money) {
    ExchangeMoneyPro5 exchanger = new ExchangeMoneyPro5(money);
    return exchanger.divideMoney();
  }
}
