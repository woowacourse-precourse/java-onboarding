package onboarding;

import java.util.Arrays;
import java.util.List;

class NumberFroPro3 {

  private final static int FIRST_NUMBER = 1;
  private final static int LAST_NUMBER = 10000;

  private int number;

  public NumberFroPro3(int number) {
    validateNumber(number);
    this.number = number;
  }

  public void validateNumber(int number) {
    if (FIRST_NUMBER > number || number > LAST_NUMBER) {
      throw new IllegalArgumentException(
          "number는 " + FIRST_NUMBER + "이상 " + LAST_NUMBER + "이하의 정수여야 합니다.");
    }
  }

  public int countWithNum() {
    CountForPro3 countClass = new CountForPro3();
    while (number > 0) {
      countClass.check369(number + "");
      number--;
    }
    return countClass.getCount();
  }
}

class CountForPro3 {

  private static final List<Character> num369 = Arrays.asList('3', '6', '9');
  private int count;

  public CountForPro3() {
    this.count = 0;
  }

  public void check369(String numStr) {
    for (int i = 0; i < numStr.length(); i++) {
      if (num369.contains(numStr.charAt(i))) {
        count++;
      }
    }
  }

  public int getCount() {
    return count;
  }
}

public class Problem3 {

  public static int solution(int number) {
    NumberFroPro3 numberClass = new NumberFroPro3(number);
    return numberClass.countWithNum();
  }
}
