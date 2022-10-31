package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    answer = getWinnerResult(pobi, crong);
    return answer;
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
