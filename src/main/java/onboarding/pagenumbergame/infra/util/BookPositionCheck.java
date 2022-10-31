package onboarding.pagenumbergame.infra.util;

import java.util.List;

public class BookPositionCheck {

  public static boolean check(List<Integer> pagesInt) {
    if (isOdd(pagesInt) && isEven(pagesInt)) {
      return true;
    }
    return false;
  }

  private static boolean isEven(List<Integer> pagesInt) {
    return pagesInt.get(1) % 2 == 0;
  }

  private static boolean isOdd(List<Integer> pagesInt) {
    return pagesInt.get(0) % 2 != 0;
  }
}
