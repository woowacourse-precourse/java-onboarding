package onboarding;

import static java.lang.Math.max;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (isInvalidBook(pobi) || isInvalidBook(crong)) {
      return -1;
    }
    int pobiScore = getScore(pobi);
    int crongScore = getScore(crong);
    return getWinner(pobiScore, crongScore);
  }

  private static boolean isInvalidBook(List<Integer> book) {
    if (isPageHasNull(book) ||
        isInvalidPageSize(book) ||
        isEvenLeftPageOrOddRightPage(book) ||
        isNotContinuousPages(book) ||
        isLeftPageBiggerThanRightPage(book)) {
      return true;
    }
    return false;
  }

  private static boolean isPageHasNull(List<Integer> book) {
    return book.get(0) == null || book.get(1) == null;
  }

  private static boolean isInvalidPageSize(List<Integer> book) {
    return 0 >= book.get(0) || book.get(0) > 400 ||
        0 >= book.get(1) || book.get(1) > 400;
  }

  private static boolean isEvenLeftPageOrOddRightPage(List<Integer> book) {
    return book.get(0) % 2 == 0 || book.get(1) % 2 == 1;
  }

  private static boolean isNotContinuousPages(List<Integer> book) {
    return Math.abs(book.get(0) - book.get(1)) != 1;
  }

  private static boolean isLeftPageBiggerThanRightPage(List<Integer> book) {
    return book.get(0) > book.get(1);
  }

  private static int getScore(List<Integer> book) {
    int leftPage = book.get(0);
    int rightPage = book.get(1);
    return max(
        max(getSumOfEachDigit(leftPage), getMultiplyOfEachDigit(leftPage)),
        max(getSumOfEachDigit(rightPage), getMultiplyOfEachDigit(rightPage))
    );
  }

  private static int getSumOfEachDigit(int number) {
    int result = 0;
    while (number != 0) {
      result += number % 10;
      number /= 10;
    }
    return result;
  }

  private static int getMultiplyOfEachDigit(int number) {
    int result = 1;
    while (number != 0) {
      result *= number % 10;
      number /= 10;
    }
    return result;
  }

  private static int getWinner(int pobiScore, int crongScore) {
    if (pobiScore > crongScore) {
      return 1;
    }
    if (pobiScore < crongScore) {
      return 2;
    }
    return 0;
  }
}