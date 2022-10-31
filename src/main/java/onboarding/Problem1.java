package onboarding;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) throws IllegalStateException {
    int answer = Integer.MAX_VALUE;
    try {
      if (isAllowedPagesCount(pobi) && isAllowedPagesCount(crong) &&
          isAllowedPage(pobi.get(0)) && isAllowedPage(pobi.get(1)) &&
          isAllowedPage(crong.get(0)) && isAllowedPage(crong.get(1)) &&
          isContinuousPage(pobi) && isContinuousPage(crong)) {
        int pobiPoint = Math.max(getMaxPlusNum(pobi), getMaxMultiplicationNum(pobi));
        int crongPoint = Math.max(getMaxPlusNum(crong), getMaxMultiplicationNum(crong));
        answer = gameResult(pobiPoint, crongPoint);
      }
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
      return -1;
    }
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

  public static boolean isAllowedPage(int page) throws IllegalStateException {
    if (page < 1 || page > 400) {
      throw new IllegalStateException("1~400 이내의 페이지를 펴주세요");
    } else {
      return true;
    }
  }

  public static boolean isAllowedPagesCount(List<Integer> pageList) throws IllegalStateException {
    if (pageList.size() != 2) {
      throw new IllegalStateException("2개의 페이지만 선택해주세요.");
    } else {
      return true;
    }
  }

  public static boolean isContinuousPage(List<Integer> pageList) throws IllegalStateException {
    if (pageList.get(1) - pageList.get(0) != 1) {
      throw new IllegalStateException("연속되는 페이지를 펴주세요.");
    } else {
      return true;
    }
  }

}
