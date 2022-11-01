import java.util.List;

class PlayerPro1 {

  public final int score;

  public PlayerPro1(int left, int right) {
    PagePro1 page = new PagePro1(left, right);
    score = page.getScore();
  }

  public int getScore() {
    return this.score;
  }

}

class PagePro1 {

  public static final int MIN_PAGE_NUMBER = 1;
  public static final int MAX_PAGE_NUMBER = 400;

  private final int pageScore;

  public PagePro1(int left, int right) {
    ScorePro1 score = new ScorePro1(left, right);
    this.pageScore = score.getScore();
  }

  public static boolean isValidatePage(int left, int right) {
    return (right - left) != 1 || left <= MIN_PAGE_NUMBER || right >= MAX_PAGE_NUMBER;
  }

  public int getScore() {
    return this.pageScore;
  }
}

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (pobi.size() != 2 || crong.size() != 2 ||
        PagePro1.isValidatePage(pobi.get(0), pobi.get(1)) ||
        PagePro1.isValidatePage(crong.get(0), crong.get(1))) {
      return -1;
    }
    return ScorePro1.compareScore(new PlayerPro1(pobi.get(0), pobi.get(1)).getScore(),
        new PlayerPro1(crong.get(0), crong.get(1)).getScore());
  }
}