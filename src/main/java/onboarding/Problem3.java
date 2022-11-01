package onboarding;

import java.util.Arrays;
import java.util.List;

class Num {

  private int num;
  private static final int MINLIMIT = 1;
  private static final int MAXLIMIT = 10000;
  private static final List<Character> num369 = Arrays.asList('3', '6', '9');
  private static final String THREE = "3";
  private static final String SIX = "6";
  private static final String NINE = "9";

  Num(int num) {
    this.num = num;
  }

  void rangeValidityCheck() {
    if (num < MINLIMIT || num > MAXLIMIT) {
      throw new IllegalArgumentException("number over range (1~10000)");
    }
  }

  public int returnAnswer() {
    int ansCnt = 0;
    for (int i = 0; i <= num; i++) {
      ansCnt += contain369(i);
    }
    return ansCnt;
  }

  private int contain369(int index) {
    String curNum = index + "";
    int tmp = 0;
    if (curNum.contains(THREE) || curNum.contains(SIX) || curNum.contains(NINE)) {
      tmp += numOf369InString(curNum);
    }
    return tmp;
  }

  private int numOf369InString(String curNum) {
    int cnt = 0;
    for (int j = 0; j < curNum.length(); j++) {
      if (num369.contains(curNum.charAt(j))) {
        cnt++;
      }
    }
    return cnt;
  }
}

public class Problem3 {

  public static int solution(int number) {
    Num num = new Num(number);
    num.rangeValidityCheck();
    return num.returnAnswer();
  }
}
