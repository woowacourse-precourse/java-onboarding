package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    if (!(validatePage(pobi) && validatePage(crong))) {
      return -1;
    }
    answer = getWinnerResult(pobi, crong);
    return answer;
  }

  public static boolean validatePage(List<Integer> page) {
    if (!validateOddAndEven(page)) {
      return false;
    }
    if (!validateRange(page.get(0))) {
      return false;
    }
    if (!validateRange(page.get(1))) {
      return false;
    }
    return true;
  }

  private static boolean validateOddAndEven(List<Integer> page) {
    boolean isFirstNumOdd = isOdd(page.get(0));
    boolean isSecondNumEven = isEven(page.get(1));

    return isFirstNumOdd && isSecondNumEven && validateOrder(page);
  }

  public static boolean isOdd(int num) {
    return num % 2 == 1;
  }

  public static boolean isEven(int num) {
    return num % 2 == 0;
  }

  private static boolean validateRange(int num) {
    return num > 1 && num < 400;
  }

  private static boolean validateOrder(List<Integer> page) {
    return (page.get(0) + 1) == page.get(1);
  }

  public static int getWinnerResult(List<Integer> pobi, List<Integer> crong) {
    int pobiScore = getScoreWithDigits(pobi.get(0));
    int crongScore = getScoreWithDigits(crong.get(0));
    if (pobiScore > crongScore) {
      return 1;
    }
    if (pobiScore < crongScore) {
      return 2;
    }
    return 0;
  }

  public static int getScoreWithDigits(Integer page) {
    List<Integer> digitList = getDigitListByPageList(page);
    int sum = 0;
    int duplicate = 1;

    for (int digit : digitList) {
      sum += digit;
      duplicate *= digit;
    }
    return Math.max(sum, duplicate);
  }

  public static List<Integer> getDigitListByPageList(Integer page) {
    List<Integer> digitList = new ArrayList<>();
    while (page > 0) {
      digitList.add(page % 10);
      page /= 10;
    }
    return digitList;
  }
}
