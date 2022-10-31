package onboarding.problem01.infra.util;

import java.util.List;

public class BookNumberCheck {

  public static boolean check(List<Integer> pagesInt) {
    int result = pagesInt.get(1) - pagesInt.get(0);
    if (result == ConsoleOut.PAGE_INTERVAL) {
      return true;
    }
    return false;
  }

}
