package onboarding;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;

    if (!isValidateBook(pobi) || !isValidateBook(crong)) {
      return -1;
    }
    return answer;
  }

  private static boolean isValidateBook(List<Integer> bookPages) {
    int leftPage = bookPages.get(0);
    int rightPage = bookPages.get(1);
    int minPage = Math.min(leftPage, rightPage);
    int maxPage = Math.max(leftPage, rightPage);

    return parityCheck(leftPage, rightPage) && lengthCheck(minPage, maxPage);
  }

  private static boolean lengthCheck(int minPage, int maxPage) {
    if (minPage < 1) {
      return false;
    }
    if (maxPage > 400) {
      return false;
    }
    if (maxPage - minPage > 1) {
      return false;
    }
    return true;
  }

  private static boolean parityCheck(int leftPage, int rightPage) {
    if (leftPage % 2 == 0) {
      return false;
    }
    if (rightPage % 2 != 0) {
      return false;
    }
    return true;
  }

}