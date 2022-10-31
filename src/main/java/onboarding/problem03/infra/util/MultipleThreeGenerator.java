package onboarding.problem03.infra.util;

import java.util.ArrayList;
import java.util.List;

public class MultipleThreeGenerator {

  /*
  * 숫자를 받아와 자릿수대로 배열을 만든 후 List에 저장
  * */
  public static int countScore(int number) {
    List<Integer> integers = new ArrayList<>();
    int count = 0;
    fillList(number, integers);
    return resultValueCount(integers, count);
  }

  private static void fillList(int number, List<Integer> integers) {
    while (number != 0) {
      integers.add(number % 10);
      number /= 10;
    }
  }

  private static int resultValueCount(List<Integer> integers, int count) {
    for (Integer integer : integers) {
      if (integer == 0) {
        continue;
      }
      if (integer % 3 == 0) {
        count += 1;
      }
    }
    return count;
  }

}
