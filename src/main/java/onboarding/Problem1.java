package onboarding;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    return answer;
  }

  private static int plusNum(int num) {
    int returnNum = 0;
    String pageNum = String.valueOf(num);
    for (int i = 0; i < pageNum.length(); i++) {
      returnNum += pageNum.charAt(i) - '0';
    }
    return returnNum;
  }
}
