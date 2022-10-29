package onboarding;

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
    return (right - left) != 1 || left < MIN_PAGE_NUMBER || right > MAX_PAGE_NUMBER;
  }

  public int getScore() {
    return this.pageScore;
  }
}

class ScorePro1 {

  private final int score;

  public ScorePro1(int left, int right) {
    this.score = makeScore(left, right);
  }

  public int getScore() {
    return this.score;
  }

  public static int findMaxScore(int page) {
    int max = 0;
    int sum = 0;
    int multi = 1;
    int tmp1 = page;
    int tmp2 = page;
    while (tmp1 > 0) {
      sum += tmp1 % 10;
      tmp1 /= 10;
    }
    while (tmp2 > 0) {
      multi *= tmp2 % 10;
      tmp2 /= 10;
    }
    return Math.max(sum, multi);
  }

  public int makeScore(int left, int right) {
    return Math.max(findMaxScore(left), findMaxScore(right));
  }

  public static int compareScore(int a, int b) {
    int answer = 0;
    if (a > b) {
      answer = 1;
    } else if (a < b) {
      answer = 2;
    }
    return answer;
  }
}

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (PagePro1.isValidatePage(pobi.get(0), pobi.get(1)) ||
        PagePro1.isValidatePage(crong.get(0), crong.get(1))) {
      return -1;
    }
    PlayerPro1 pobiMan = new PlayerPro1(pobi.get(0), pobi.get(1));
    PlayerPro1 crongMan = new PlayerPro1(crong.get(0), crong.get(1));
    return ScorePro1.compareScore(pobiMan.getScore(), crongMan.getScore());
  }
}