package onboarding.problem01.infra.util;

import java.util.List;

public class BookPositionCheck {

  public static boolean check(List<Integer> pagesInt) {
    if (isOdd(pagesInt.get(0)) && isEven(pagesInt.get(1))) {
      return true;
    }
    return false;
  }

  private static boolean isEven(Integer pagesInt) {
    return (pagesInt % 2) == 0;
  }

  private static boolean isOdd(Integer pagesInt) {
    return (pagesInt % 2) != 0;
  }
}
