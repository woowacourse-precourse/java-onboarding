package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

  static Converter converter = new Converter();

  public static List<Integer> solution(int money) {
    return converter.convert(money);
  }

  static class Converter {

    private final int[] currencies = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public List<Integer> convert(int money) {
      ArrayList<Integer> result = new ArrayList<>();
      for (int currency : currencies) {
        result.add(count(money, currency));
        money %= currency;
      }
      return result;
    }

    private int count(int money, int currency) {
      return money / currency;
    }
  }
}
