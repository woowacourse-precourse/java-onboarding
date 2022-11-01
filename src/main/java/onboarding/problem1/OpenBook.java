package onboarding.problem1;

import java.util.List;

public class OpenBook {
  private final int MIN_PAGE = 1;
  private final int MAX_PAGE = 400;
  private int leftPage;
  private int rightPage;

  public OpenBook(int leftPage, int rightPage) {
    this.leftPage = leftPage;
    this.rightPage = rightPage;
  }

  public static OpenBook fromList(List<Integer> page) {
    return new OpenBook(page.get(0), page.get(1));
  }

  public int getLeftPage() {
    return leftPage;
  }

  public int getRightPage() {
    return rightPage;
  }

  public void validate() {
    if (supportBookPages() && hasLeftRightPage() && hasFollowingPage()) {
      return;
    }
    throw new IllegalArgumentException("잘못된 페이지 형식입니다.");
  }

  private boolean supportBookPages() {
    return supportsBookPage(leftPage) && supportsBookPage(rightPage);
  }

  private boolean supportsBookPage(int page) {
    return page >= MIN_PAGE && page <= MAX_PAGE;
  }

  private boolean hasLeftRightPage() {
    return isLeftPage() && isRightPage();
  }

  private boolean hasFollowingPage() {
    return leftPage + 1 == rightPage;
  }

  private boolean isLeftPage() {
    return leftPage % 2 == 1;
  }

  private boolean isRightPage() {
    return rightPage % 2 == 0;
  }
}
