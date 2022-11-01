package onboarding.problem01.infra.util;

import java.util.List;

public class BookSizeCheck {

  public static boolean check(List<Integer> pagesInt) {
    if (pagesInt.size() == ConsoleOut.PAGE_SIZE) {
      return true;
    }
    return false;
  }

}
