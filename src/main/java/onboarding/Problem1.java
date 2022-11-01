package onboarding;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (isNotValidPages(pobi) || isNotValidPages(crong)) {
      return -1;
    }
    int pobiScore = getScore(pobi);
    int crongScore = getScore(crong);
    return getResult(pobiScore, crongScore);
  }

  static boolean isNotValidPages(List<Integer> pages) {
    return isOutOfRange(pages)
        || isNotTwoPages(pages)
        || isDiscontinuousPages(pages)
        || isEven(pages.get(0))
        || isOdd(pages.get(1))
        || isNotRightBiggerThenLeft(pages);
  }

  private static boolean isOutOfRange(List<Integer> pages) {
    return pages.get(0) <= 0 || pages.get(0) > 400
        || pages.get(1) <= 0 || pages.get(1) > 400;
  }

  private static boolean isNotRightBiggerThenLeft(List<Integer> pages) {
    return pages.get(1) <= pages.get(0);
  }

  private static boolean isOdd(Integer page) {
    return page % 2 == 1;
  }

  private static boolean isEven(Integer page) {
    return page % 2 == 0;
  }

  private static boolean isDiscontinuousPages(List<Integer> pages) {
    return abs(pages.get(0) - pages.get(1)) != 1;
  }

  private static boolean isNotTwoPages(List<Integer> pages) {
    return pages.size() != 2;
  }

  static int getResult(int pobiScore, int crongScore) {
    if (pobiScore > crongScore) {
      return 1;
    }
    if (pobiScore < crongScore) {
      return 2;
    }
    return 0;
  }

  private static int getScore(List<Integer> pages) {
    int leftPage = pages.get(0);
    int rightPage = pages.get(1);
    return max(getMaxValue(leftPage), getMaxValue(rightPage));
  }

  private static int getMaxValue(int page) {
    return max(getSumOfDigits(page), getProductOfDigits(page));
  }

  private static int getSumOfDigits(int number) {
    int result = 0;
    while (number != 0) {
      result += number % 10;
      number /= 10;
    }
    return result;
  }

  private static int getProductOfDigits(int number) {
    int result = 1;
    while (number != 0) {
      result *= number % 10;
      number /= 10;
    }
    return result;
  }
}