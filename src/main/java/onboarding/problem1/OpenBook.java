package onboarding.problem1;

import java.util.List;

public class OpenBook {
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
    if (includeFirstOrLastPage() || !isBothSidesOfPage() || !isCorrectPage()) {
      throw new IllegalArgumentException("잘못된 페이지 형식입니다.");
    }
  }

  private boolean includeFirstOrLastPage() {
    return leftPage == 1 || rightPage == 400;
  }
  private boolean isCorrectPage() {
    return isLeftPage() && isRightPage();
  }

  private boolean isBothSidesOfPage() {
    return leftPage + 1 == rightPage;
  }
  private boolean isLeftPage() {
    return leftPage % 2 == 1;
  }
  private boolean isRightPage() {
    return rightPage % 2 == 0;
  }
}
