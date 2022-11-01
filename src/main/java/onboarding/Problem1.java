package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (!(testExceptions(pobi) && testExceptions(crong))) {
      return -1;
    }
    int pobiScore = calculateScore(pobi);
    int crongScore = calculateScore(crong);
    if (pobiScore > crongScore) {
      return 1;
    } else if (pobiScore < crongScore) {
      return 2;
    } else if (pobiScore == crongScore) {
      return 0;
    }
    return -1;
  }

  private static int calculateScore(List<Integer> pages) {
    int leftPage = pages.get(0);
    int rightPage = pages.get(1);
    int valueOfLeftPage = valueOfPage(leftPage);
    int valueOfRightPage = valueOfPage(rightPage);
    int score = max(valueOfLeftPage, valueOfRightPage);
    return score;
  }

  private static int valueOfPage(int page) {
    List<Integer> pageDigits = new ArrayList<>();
    while (page > 0) {
      pageDigits.add(page % 10);
      page /= 10;
    }
    int sumPageNumbers = sumDigits(pageDigits);
    int multiplyPageNumbers = multiplyDigits(pageDigits);
    int maxValue = max(sumPageNumbers, multiplyPageNumbers);
    return maxValue;
  }

  private static int sumDigits(List<Integer> pageDigits) {
    int sumOfDigits = 0;
    for (int digit : pageDigits) {
      sumOfDigits += digit;
    }
    return sumOfDigits;
  }

  private static int multiplyDigits(List<Integer> pageDigits) {
    int multiplyOfDigits = 1;
    for (int digit : pageDigits) {
      multiplyOfDigits *= digit;
    }
    return multiplyOfDigits;
  }

  private static boolean testExceptions(List<Integer> pages) {
    int leftPage = pages.get(0);
    int rightPage = pages.get(1);
    if ((leftPage + 1) != rightPage) {
      return false;
    }
    if (leftPage < 1 || leftPage >= 400) {
      return false;
    }
    if (rightPage <= 1 || rightPage > 400) {
      return false;
    }
    if ((leftPage % 2) != 1) {
      return false;
    }
    if ((rightPage % 2) != 0) {
      return false;
    }
    return true;
  }
}
