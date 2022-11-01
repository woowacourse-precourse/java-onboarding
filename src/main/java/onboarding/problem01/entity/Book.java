package onboarding.problem01.entity;

import java.util.ArrayList;
import java.util.List;
import onboarding.problem01.infra.util.BookNumberCheck;
import onboarding.problem01.infra.util.BookPositionCheck;
import onboarding.problem01.infra.util.BookSizeCheck;
import onboarding.problem01.infra.util.ConsoleOut;

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

  public static Book of(List<Integer> pages) {
    return new Book(pages);
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

  public List<Page> printPages() {
    return pages;
  }

  public boolean isNotBook() {
    for (Page page : pages) {
      if (page.currentPageMinus()) {
        return true;
      }
    }
    return false;
  }

  public Integer gameValue() {
    int leftValue = pages.get(0).pageValue();
    int rightValue = pages.get(1).pageValue();
    if (leftValue > rightValue) {
      return leftValue;
    }
    return rightValue;
  }
}
