package onboarding;

import java.util.*;

public class Problem5 {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  }
  public static List<Integer> solution(int money) {
    List<Integer> answer = new ArrayList<>();
    int moneyarr[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    for (int i = 0; i < moneyarr.length; i++) {
      answer.add(money / moneyarr[i]);
      money = money % moneyarr[i];
    }
    return answer;

    }
}
