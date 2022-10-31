package onboarding;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;

    if (!isValidateBook(pobi) || !isValidateBook(crong)) {
      return -1;
    }

    int pobiScore = getScore(pobi);
    int crongScore = getScore(crong);
    answer = getResult(pobiScore, crongScore);
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

  public static int getScore(List<Integer> bookPages) {
    int leftPage = bookPages.get(0);
    int rightPage = bookPages.get(1);
    int leftPageScore = calculateMaxScoreByPage(leftPage);
    int rightPageScore = calculateMaxScoreByPage(rightPage);

    return Math.max(leftPageScore, rightPageScore);
  }

  public static int calculateMaxScoreByPage(int page) {
    int addition = calculateAddition(page);
    int multiplication = calculateMultiplication(page);
    return Math.max(addition, multiplication);
  }

  public static int calculateAddition(int page) {
    int result = 0;
    while (page > 0) {
      result += page % 10;
      page /= 10;
    }
    return result;
  }

  public static int calculateMultiplication(int page) {
    int result = page % 10;
    page /= 10;
    while (page > 0) {
      result *= page % 10;
      page /= 10;
    }
    return result;
  }

  public static int getResult(int pobi, int crong) {
    if (pobi > crong) {
      return 1;
    }
    if (pobi < crong) {
      return 2;
    }
    return 0;
  }
}