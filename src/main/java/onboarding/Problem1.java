package onboarding;

import java.util.List;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    return answer;
  }

  static class Valid {
    private static final int LENGTH = 2;
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static boolean validate(List<Integer> pages) {
      return isCorrectLength(pages) && isCorrectRange(pages) && isOddNumber(pages.get(0))
          && isEvenNumber(pages.get(1)) && isContinues(pages);
    }

    private static boolean isCorrectLength(List<Integer> pages) {
      return pages.size() == LENGTH;
    }

    private static boolean isCorrectRange(List<Integer> pages) {
      int leftPage = pages.get(0);
      int rightPage = pages.get(1);
      return START_PAGE <= leftPage && leftPage <= END_PAGE
          && START_PAGE <= rightPage && rightPage <= END_PAGE;
    }

    private static boolean isOddNumber(int page) {
      return page % 2 == 1;
    }

    private static boolean isEvenNumber(int page) {
      return page % 2 == 0;
    }

    private static boolean isContinues(List<Integer> pages) {
      return pages.get(1) - 1 == pages.get(0);
    }
  }
}