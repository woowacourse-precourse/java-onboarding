package onboarding.problem01.entity;

import onboarding.problem01.infra.util.ConsoleOut;

public class Page {

  private Integer page;

  private Page(Integer page) {
    this.page = page;
  }

  public static Page from(int page) {
    if (page < 1 || page > 400) {
      return new Page(ConsoleOut.WRONG_EXCEPTION_NUMBER);
    }
    return new Page(page);
  }

  public Integer pageValue() {
    if (plusPage() >= multiPage()) {
      return plusPage();
    }
    return multiPage();
  }

  private Integer plusPage() {
    int tempPage = page;
    int result = 0;
    while (tempPage != 0) {
      result += tempPage % 10;
      tempPage /= 10;
    }
    return result;
  }

  private Integer multiPage() {
    int tempPage = page;
    int result = 1;
    while (tempPage != 0) {
      result *= tempPage % 10;
      tempPage /= 10;
    }
    return result;
  }

  public boolean  currentPageMinus() {
    if (page == ConsoleOut.WRONG_EXCEPTION_NUMBER) {
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Page)) {
      return false;
    }

    Page page1 = (Page) o;

    return page != null ? page.equals(page1.page) : page1.page == null;
  }

  @Override
  public int hashCode() {
    return page != null ? page.hashCode() : 0;
  }
}
