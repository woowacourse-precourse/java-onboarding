package onboarding.pagenumbergame.entity;

import java.util.ArrayList;
import java.util.List;
import onboarding.pagenumbergame.infra.util.ConsoleOut;

public class Book {

  private List<Page> pages;

  private Book(List<Integer> pagesInt) {
    pages = new ArrayList<>();
    if (bookSizeCheck(pagesInt)) {
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

  private boolean bookSizeCheck(List<Integer> pagesInt) {
    if (pagesInt.size() == ConsoleOut.PAGE_SIZE) {
      return true;
    }
    return false;
  }

  public static Book of(List<Integer> pages) {
    return new Book(pages);
  }

  public List<Page> printPages() {
    return pages;
  }
}
