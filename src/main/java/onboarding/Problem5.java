package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

  private static final List<Integer> banknotesAndCoins = List.of(
      50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
  );


  public static List<Integer> solution(int money) {
    List<Integer> answer = new ArrayList<>();
    for (Integer banknoteOrCoin : banknotesAndCoins) {
      answer.add(money / banknoteOrCoin);
      money %= banknoteOrCoin;
    }
    return answer;
  }
}
