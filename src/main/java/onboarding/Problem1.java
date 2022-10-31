package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    return answer;
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
