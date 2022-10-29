package onboarding;

import static java.lang.Math.max;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (isInvalidBook(pobi) || isInvalidBook(crong)) {
      return -1;
    }
  }

  private static boolean isInvalidBook(List<Integer> book) {
    if (isInvalidBookSize(book) ||
        isNotContinuousPages(book) ||
        isLeftPageBiggerThanRightPage(book)) {
      return true;
    }
    return false;
  }

  private static boolean isInvalidBookSize(List<Integer> book) {
    return book.size() != 2;
  }

  private static boolean isNotContinuousPages(List<Integer> book) {
    return Math.abs(book.get(0) - book.get(1)) != 1;
  }

  private static boolean isLeftPageBiggerThanRightPage(List<Integer> book) {
    return book.get(0) > book.get(1);
  }
}