package onboarding;

import java.util.List;

class Problem1 {

  static Valid valid = new Valid();
  static Calculation calculation = new Calculation();
  static Result result = new Result();

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (valid.validate(pobi) && valid.validate(crong)) {
      return result.chooseWinner(calculation.getMaxPoint(pobi), calculation.getMaxPoint(crong));
    }
    return Result.EXCEPTION;
  }

  static class Valid {

    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public boolean validate(List<Integer> pages) {
      return isExistPage(pages) && isCorrectRange(pages) && isOddNumber(pages.get(0))
          && isEvenNumber(pages.get(1)) && isContinues(pages);
    }

    private boolean isExistPage(List<Integer> pages) {
      return pages.get(0) != null && pages.get(1) != null;
    }

    private boolean isCorrectRange(List<Integer> pages) {
      int leftPage = pages.get(0);
      int rightPage = pages.get(1);
      return START_PAGE <= leftPage && leftPage <= END_PAGE
          && START_PAGE <= rightPage && rightPage <= END_PAGE;
    }

    private boolean isOddNumber(int page) {
      return page % 2 == 1;
    }

    private boolean isEvenNumber(int page) {
      return page % 2 == 0;
    }

    private boolean isContinues(List<Integer> pages) {
      return pages.get(1) - 1 == pages.get(0);
    }
  }

  static class Calculation {

    public int getMaxPoint(List<Integer> pages) {
      int plusMaxPoint = Math.max(plus(pages.get(0)), plus(pages.get(1)));
      int multipleMaxPoint = Math.max(multiple(pages.get(0)), multiple(pages.get(1)));
      return Math.max(plusMaxPoint, multipleMaxPoint);
    }

    private int plus(int page) {
      int result = 0;
      while (page != 0) {
        result += page % 10;
        page /= 10;
      }
      return result;
    }

    private int multiple(int page) {
      int result = 1;
      while (page != 0) {
        result *= page % 10;
        page /= 10;
      }
      return result;
    }
  }

  static class Result {

    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public int chooseWinner(int pobiPoint, int crongPoint) {
      if (pobiPoint > crongPoint) {
        return 1;
      }
      if (pobiPoint < crongPoint) {
        return 2;
      }
      return DRAW;
    }
  }
}