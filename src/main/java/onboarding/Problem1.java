package onboarding;

import java.util.List;

class Problem1 {

  private static final int POBI_WIN = 1;
  private static final int CRONG_WIN = 2;
  private static final int DRAW = 0;
  private static final int EXCEPTION = -1;
  private static final int LEFT_PAGE = 0;
  private static final int RIGHT_PAGE = 1;
  private static final int FIRST_PAGE = 0;
  private static final int LAST_PAGE = 400;

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;

    if(findPageException(pobi,crong)) return EXCEPTION;

    return answer = Winner(pobi,crong);
  }

  private static boolean findPageException(List<Integer> pobi, List<Integer> crong) {
    if (pobi.get(LEFT_PAGE) < FIRST_PAGE || pobi.get(RIGHT_PAGE) > LAST_PAGE
            || crong.get(LEFT_PAGE) < FIRST_PAGE || crong.get(RIGHT_PAGE) > LAST_PAGE) {
      return true;
    }
    if ((pobi.get(RIGHT_PAGE) - pobi.get(LEFT_PAGE)) != 1 || (crong.get(RIGHT_PAGE) - crong.get(LEFT_PAGE)) != 1) {
      return true;
    }
    return false;
  }

  private static int Winner (List<Integer> pobi, List<Integer> crong){

    int pobi_Score = compareScore(pobi);
    int crong_Score = compareScore(crong);
    int result = Integer.MAX_VALUE;

    if(pobi_Score>crong_Score)
      result = POBI_WIN;
    else if(pobi_Score==crong_Score)
      result = DRAW;
    else
      result = CRONG_WIN;

    return result;
  }

  private static int compareScore(List<Integer> page){
    int LeftPage_Score = getPageBestScore(page.get(LEFT_PAGE));
    int RightPage_Score = getPageBestScore(page.get(RIGHT_PAGE));
    return Math.max(LeftPage_Score,RightPage_Score);
  }

  private static int getPageBestScore(int bookpage){
    return Math.max(getPlusScore(bookpage),getMultiplyScore(bookpage));
  }

  private static int getPlusScore(int bookpage){
    int plusScore = 0;
    while(bookpage !=0) {
      plusScore += bookpage % 10;
      bookpage = bookpage / 10;
    }
    return plusScore;
  }

  private static int getMultiplyScore(int bookpage) {
    int multiplyScore = 1;
    while(bookpage !=0) {
      multiplyScore *= bookpage % 10;
      bookpage = bookpage / 10;
    }
    return multiplyScore;
  }

}

