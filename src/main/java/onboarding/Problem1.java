package onboarding;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    return answer;
  }

  private static int getMaxPlusNum(List<Integer> pageList) {
    int returnNum = 0;
    for (Integer pageNum : pageList) {
      int temp = 0;
      String pageNumString = String.valueOf(pageNum);
      for (int i = 0; i < pageNumString.length(); i++) {
        temp += pageNumString.charAt(i) - '0';
      }
      if (temp >= returnNum) {
        returnNum = temp;
      }
    }
    return returnNum;
  }

  private static int getMaxMultiplicationNum(List<Integer> pageList) {
    int returnNum = 0;
    for (Integer pageNum : pageList) {
      int temp = 1;
      String pageNumString = String.valueOf(pageNum);
      for (int i = 0; i < pageNumString.length(); i++) {
        temp *= pageNumString.charAt(i) - '0';
      }
      if (temp >= returnNum) {
        returnNum = temp;
      }
    }
    return returnNum;
  }

  private static int gameResult(int pobiPoint, int crongPoint) {
    if (pobiPoint > crongPoint) {
      return 1;
    } else if (pobiPoint < crongPoint) {
      return 2;
    } else {
      return 0;
    }
  }
}
