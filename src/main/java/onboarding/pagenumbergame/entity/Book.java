package onboarding.pagenumbergame.entity;

import java.util.ArrayList;
import java.util.List;
import onboarding.pagenumbergame.infra.util.BookNumberCheck;
import onboarding.pagenumbergame.infra.util.BookPositionCheck;
import onboarding.pagenumbergame.infra.util.BookSizeCheck;
import onboarding.pagenumbergame.infra.util.ConsoleOut;

public class Book {

  private List<Page> pages;

  private Book(List<Integer> pagesInt) {
    pages = new ArrayList<>();

    if (BookSizeCheck.check(pagesInt) && BookNumberCheck.check(pagesInt) && BookPositionCheck.check(
        pagesInt)) {
      settingBook(pagesInt);
    } else {
      settingWrongBook(pagesInt);
    }
  }

  private void settingWrongBook(List<Integer> pagesInt) {
    for (Integer page : pagesInt) {
      pages.add(Page.from(ConsoleOut.WRONG_EXCEPTION_NUMBER));
    }
  }

  private void settingBook(List<Integer> pagesInt) {
    for (Integer page : pagesInt) {
      pages.add(Page.from(page));
    }
  }

  public static Book of(List<Integer> pages) {
    return new Book(pages);
  }

  public List<Page> printPages() {
    return pages;
  }
}
