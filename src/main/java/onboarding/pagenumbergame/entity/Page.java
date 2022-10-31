package onboarding.pagenumbergame.entity;

import onboarding.pagenumbergame.infra.util.ConsoleOut;

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
