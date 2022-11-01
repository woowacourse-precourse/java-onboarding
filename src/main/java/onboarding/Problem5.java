package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

  public static List<Integer> solution(int money) {
    List<Integer> answer = new ArrayList<Integer>();
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
